package dev.transacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.transacts.entity.Currencies;

@Repository
public interface CurrencyRepository extends JpaRepository<Currencies, String> {
}
