package org.example.demomarketapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  private Long id;
  private String phone;
  @NotNull(message = "Password shouldn't be null")
  @Size(min = 6, max = 50, message = "Password should be not null and from 6 to 50 symbols")
  private String password;
  private String email;
  @NotNull(message = "First name shouldn't be null")
  @Size(min = 3, max = 50, message = "First name should be not null and from 3 to 50 symbols")
  private String firstName;
  @NotNull(message = "Last name shouldn't be null")
  @Size(min = 3, max = 50, message = "Last name should be not null and from 3 to 50 symbols")
  private String lastName;
  private List<String> roles;
}
