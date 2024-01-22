package org.example.demomarketapp.service;

import static org.example.demomarketapp.service.RoleService.USER_ROLE_ID;

import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.demomarketapp.dto.UserDto;
import org.example.demomarketapp.model.User;
import org.example.demomarketapp.model.Role;
import org.example.demomarketapp.repository.UserRepository;
import org.springframework.stereotype.Service;

//@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainUserService implements UserService {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MainUserService.class);
  UserRepository userRepository;
  RoleService roleService;

  @Override
  @Transactional
  public UserDto create(UserDto dto) {
    if (userRepository.existsByEmail(dto.getEmail())) {
      throw new IllegalArgumentException("User with this login already exists");
    }
    var user = User.builder()
        .enabled(true)
        .lastName(dto.getLastName())
        .phone(dto.getPhone())
        .firstName(dto.getFirstName())
        .email(dto.getEmail())
        .roles(List.of(roleService.getReference(USER_ROLE_ID)))
        .password(dto.getPassword()) //TODO encode
        .build();

    log.info("Creating new user");
    return fromEntity(userRepository.save(user));
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.findUserByEmail(email).orElseThrow();
  }

  private UserDto fromEntity(User user) {
    var roles = user.getRoles().stream()
        .map(Role::getName)
        .toList();
    return UserDto.builder()
        .id(user.getId())
        .lastName(user.getLastName())
        .phone(user.getPhone())
        .firstName(user.getFirstName())
        .email(user.getEmail())
        .roles(roles)
        .build();
  }
}
