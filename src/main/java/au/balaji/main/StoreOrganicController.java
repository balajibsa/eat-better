package au.balaji.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import au.balaji.entity.Currency;
import au.balaji.entity.Image;
import au.balaji.entity.Message;
import au.balaji.entity.Product;
import au.balaji.entity.Time;
import au.balaji.repository.MessageRepository;
import au.balaji.repository.ProductRepository;
import au.balaji.repository.TimeRepository;
import au.balaji.vo.ShoppingCartDetails;

@Controller
public class StoreOrganicController {

	@Autowired
	TimeRepository timeRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	MessageRepository messageRepository;

	@RequestMapping("store-organic.html")
	public String store(Model model) {
		ShoppingCartDetails cart = getShoppingCartDetails();
		model.addAttribute("shoppingCartDetails", cart);
		model.addAttribute("products", getProducts());
		return "store-organic";
	}

	@RequestMapping("addToCart")
	public String store(@RequestParam(name = "productId") Integer productId, Model model) {
		ShoppingCartDetails cart = getShoppingCartDetails();
		List<Product> products = getProducts();
		cart.getProducts().add(products.get(productId));
		model.addAttribute("shoppingCartDetails", cart);
		model.addAttribute("products", getProducts());

		return "store-organic";
	}

	@RequestMapping("menu-organic.html")
	public String menu(Model model) {
		model.addAttribute("foods", getFoods());
		model.addAttribute("foodTimings", getFoodTiming());
		model.addAttribute("foodTimingImages", getFoodTimingImages());
		return "menu-organic";
	}

	@RequestMapping("sendMessage")
	public String sendMessage(@ModelAttribute Message message, Model model) {
		messageRepository.save(message);
		model.addAttribute("foods", getFoods());
		model.addAttribute("foodTimings", getFoodTiming());
		model.addAttribute("foodTimingImages", getFoodTimingImages());
		return "menu-organic";
	}

	private Map<String, String> getFoodTiming() {

		List<Time> times = timeRepository.findAll();
		final Map<String, String> foods = new LinkedHashMap<>();
		times.stream().forEach((time) -> {
			foods.put(time.getName(), time.getDays() + time.getTime());
		});

		return foods;
	}

	private Map<String, String> getFoodTimingImages() {
		List<Time> times = timeRepository.findAll();
		final Map<String, String> foods = new LinkedHashMap<>();
		times.stream().forEach((time) -> {
			foods.put(time.getName(), time.getImage().getUri());
		});

		return foods;
	}

	private Map<String, List<Product>> getFoods() {

		List<Product> myFoods = productRepository.findAll();

		List<Time> times = timeRepository.findAll();

		final Map<String, List<Product>> foods = new LinkedHashMap<>();

		times.stream().forEach((time) -> {
			foods.put(time.getName(), new ArrayList<>());
		});

		myFoods.stream().forEach((product) -> {
			product.getProducttimes().stream().forEach((producttime) -> {
				foods.get(producttime.getTime().getName()).add(product);
			});

		});

		return foods;
	}

	private List<Product> getProducts() {
		return productRepository.findAll();
	}

	private ShoppingCartDetails getShoppingCartDetails() {
		ShoppingCartDetails cart = new ShoppingCartDetails();
		List<Product> products = new ArrayList<Product>();
		Product p = new Product();
		p.setName("Black Pasta with Meat");
		p.setPrice(new BigDecimal("27"));
		Image img = new Image();
		img.setUri("gallery20.jpg");
		Currency c = new Currency();
		c.setCode("$");
		p.setImage(img);
		p.setCurrency(c);
		// p.setCurrency(currency);("$");
		// p.setImageUri("gallery20.jpg");
		products.add(p);

		Product p1 = new Product();
		p1.setName("Spring Fruit Salad");
		p1.setPrice(new BigDecimal("27"));
		p1.setCurrency(c);
		p1.setImage(img);
		products.add(p1);

		cart.setProducts(products);

		for (Product pr : products) {
			cart.setTotalPrice(pr.getPrice().add(cart.getTotalPrice()));
		}
		return cart;

	}

}
