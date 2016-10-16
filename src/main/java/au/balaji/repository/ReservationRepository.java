package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.balaji.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
