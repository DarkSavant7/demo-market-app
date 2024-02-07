package org.example.demomarketapp.repository;

import org.example.demomarketapp.dto.UserInformationDto;
import org.example.demomarketapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);

//    @Query("select new org.example.demomarketapp.dto.UserInformationDto(" +
//            "u.id, u.phone, u.email, u.firstName, u.lastName) from User u where u.enabled = true")
//    List<UserInformationDto> findAllUserWhereEnableTrue();
}
