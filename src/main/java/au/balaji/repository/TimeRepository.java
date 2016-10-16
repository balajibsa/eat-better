package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

}
