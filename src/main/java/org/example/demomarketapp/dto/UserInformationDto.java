package org.example.demomarketapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;


@Tag(name = "User information", description = "Simple description")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationDto {

    @Schema(description = "Unique id")
    private Long id;

    @Schema(description = "Phones")
    private String phone;

    private String email;

    private String firstName;

    private String lastName;
}
