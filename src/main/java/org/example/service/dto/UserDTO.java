package org.example.service.dto;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userid;
    @NotEmpty
    private String username;
    @NotEmpty(message = "Email should npt be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    private String role;
}
