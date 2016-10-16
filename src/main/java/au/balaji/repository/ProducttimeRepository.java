package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Producttime;

@Repository
public interface ProducttimeRepository extends JpaRepository<Producttime, Integer> {

}
