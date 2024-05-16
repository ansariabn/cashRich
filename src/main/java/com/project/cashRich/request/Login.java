package com.project.cashRich.request;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Nehal Ansari
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @NotNull
    @Size(min = 4, max = 15, message = "Username must be between 4 and 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username can only contain letters and digits")
    private String username;

    @NotNull
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).+$", message = "Password must include at least 1 upper case letter, 1 lower case letter, 1 digit, and 1 special character")
    private String password;


}
