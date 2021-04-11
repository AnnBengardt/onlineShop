package com.AnnaMarunko.onlineShop.repo;

import com.AnnaMarunko.onlineShop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}