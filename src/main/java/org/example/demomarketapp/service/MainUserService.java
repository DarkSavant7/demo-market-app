package org.example.demomarketapp.service;

import static org.example.demomarketapp.service.RoleService.USER_ROLE_ID;

import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.example.demomarketapp.dto.UserDto;
import org.example.demomarketapp.dto.UserInformationDto;
import org.example.demomarketapp.model.Role;
import org.example.demomarketapp.model.User;
import org.example.demomarketapp.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MainUserService implements UserService, UserDetailsService {

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(
      MainUserService.class);

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
//        .lastName(dto.getLastName())
//        .phone(dto.getPhone())
//        .firstName(dto.getFirstName())
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

  @Override
  public List<UserInformationDto> getAllEnableUsers() {
//    return userRepository.findAllUserWhereEnableTrue();
    return null;//@todo
  }

  private UserDto fromEntity(User user) {
    var roles = user.getRoles().stream()
        .map(Role::getName)
        .toList();
    return UserDto.builder()
        .id(user.getId())
//        .lastName(user.getLastName())
//        .phone(user.getPhone())
//        .firstName(user.getFirstName())
        .email(user.getEmail())
        .roles(roles)
        .build();
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findUserByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(),
        mapRolesToAuthorities(user.getRoles()));
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).toList();
  }
}
