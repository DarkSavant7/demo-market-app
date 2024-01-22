package org.example.demomarketapp.repository;

import java.util.Optional;
import org.example.demomarketapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserByEmail(String email);
  Boolean existsByEmail(String email);
}
