package au.balaji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.balaji.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
