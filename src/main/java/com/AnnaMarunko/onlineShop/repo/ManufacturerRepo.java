package com.AnnaMarunko.onlineShop.repo;

import com.AnnaMarunko.onlineShop.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}
