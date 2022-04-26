package com.acamus.disney.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    
    private String id;

    @NotBlank(message = "the firstName field cannot be empty")
    @NotNull(message = "field firstName cannot be null")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "The firstName cannot contain numbers or characters other than letters")
    @Size(min = 2, max = 25, message = "The length of the firstName must be between 2 to 25 characters.")
    private String firstName;

    @NotBlank(message = "the lastName field cannot be empty")
    @NotNull(message = "field lastName cannot be null")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "The lastName cannot contain numbers or characters other than letters")
    @Size(min = 2, max = 25, message = "The length of the lastName must be between 2 to 25 characters.")
    private String lastName;

    @Email(message = "Must be a properly formatted email address.")
    @NotEmpty(message = "The field must not be empty.")
    private String email;

    @Size(min=8,message="Min 8 characters in password")
    @NotEmpty(message = "The field must not be empty.")
    private String password;
}
