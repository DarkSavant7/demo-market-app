package org.example.demomarketapp.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.demomarketapp.dto.UserInformationDto;
import org.example.demomarketapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User Controller", description = "User controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Return List users where enable is true")
    @GetMapping("/available")
    public List<UserInformationDto> getAllEnableUsers() {
        return userService.getAllEnableUsers();
    }
}
