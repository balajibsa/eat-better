package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
