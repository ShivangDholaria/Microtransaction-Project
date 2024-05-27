package dev.transacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.transacts.entity.Currencies;

public interface CurrencyRepository extends JpaRepository<Currencies, String> {
}
