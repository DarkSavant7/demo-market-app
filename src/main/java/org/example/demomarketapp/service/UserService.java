package org.example.demomarketapp.service;

import org.example.demomarketapp.dto.UserDto;
import org.example.demomarketapp.dto.UserInformationDto;
import org.example.demomarketapp.model.User;

import java.util.List;

public interface UserService {
   UserDto create(UserDto dto);
   User getByEmail(String email);
   List<UserInformationDto> getAllEnableUsers();
}
