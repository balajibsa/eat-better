package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Productcategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Productcategory, Integer> {

}
