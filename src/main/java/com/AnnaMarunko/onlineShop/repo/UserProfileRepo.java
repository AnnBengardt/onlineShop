package com.AnnaMarunko.onlineShop.repo;

import com.AnnaMarunko.onlineShop.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
}
