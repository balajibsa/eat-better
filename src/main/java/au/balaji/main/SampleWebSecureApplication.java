/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package au.balaji.main;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import au.balaji.entity.Reservation;
import au.balaji.repository.ReservationRepository;

@SpringBootApplication
@Controller
@EntityScan(basePackages = { "au.balaji.entity" })
@EnableJpaRepositories(basePackages = { "au.balaji.repository" })
public class SampleWebSecureApplication extends WebMvcConfigurerAdapter {

	@Autowired
	ReservationRepository reservationRepository;

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		return "index-organic";
	}

	@RequestMapping("index-organic.html")
	public String foo() {
		return "index-organic";
	}

	@RequestMapping("about-organic.html")
	public String about() {
		return "about-organic";
	}

	@RequestMapping("blog-organic.html")
	public String blog() {
		return "blog-organic";
	}

	@RequestMapping("reservation-organic.html")
	public String reservation(Model model) {
		model.addAttribute("reservation", new Reservation());
		return "reservation-organic";
	}

	@RequestMapping("sendReservation")
	public String sendReservation(@ModelAttribute Reservation reservation, Model model) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(reservation.toString());
		System.out.println();
		System.out.println();
		System.out.println();
		reservationRepository.save(reservation);
		model.addAttribute("reservation", new Reservation());
		return "reservation-organic";
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(SampleWebSecureApplication.class).run(args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(enquiryFormPopulator());
	}

	@Bean
	public HandlerInterceptor enquiryFormPopulator() {
		return new EnquiryFormPopulator();
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login")
					.failureUrl("/login?error").permitAll().and().logout().permitAll();
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER").and()
					.withUser("user").password("user").roles("USER");
		}

	}

}
