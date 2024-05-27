package com.project.cashRich.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Nehal Ansari
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 4, max = 15, message = "Username must be between 4 and 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username can only contain letters and digits")
    private String username;

//    @NotNull
//    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
//    @Pattern(
//            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,10}$",
//            message = "Password must include at least 1 upper case letter, 1 lower case letter, 1 digit, and 1 special character"
//    )
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email(message = "Email should be valid")
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobile;

//    @OneToOne(fetch=FetchType.LAZY , mappedBy = "user")
//    private Api3dParty account;




}
