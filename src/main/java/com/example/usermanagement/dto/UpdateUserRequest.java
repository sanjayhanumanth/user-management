package com.example.usermanagement.dto;

import com.example.usermanagement.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Request payload to update an existing user")
public class UpdateUserRequest {

    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Schema(description = "New username", example = "john_updated")
    private String username;

    @Email(message = "Invalid email format")
    @Schema(description = "New email", example = "john_updated@example.com")
    private String email;

    @Schema(description = "New first name", example = "Johnny")
    private String firstName;

    @Schema(description = "New last name", example = "Doe")
    private String lastName;

    @Schema(description = "New role", example = "MANAGER")
    private Role role;

    @Schema(description = "Active status", example = "true")
    private Boolean active;
}
