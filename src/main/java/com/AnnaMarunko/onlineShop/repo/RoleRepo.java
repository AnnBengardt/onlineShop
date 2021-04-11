package com.AnnaMarunko.onlineShop.repo;

import com.AnnaMarunko.onlineShop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}

