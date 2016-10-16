package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
