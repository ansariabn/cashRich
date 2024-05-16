package com.project.cashRich.controller;

import com.project.cashRich.exception.UserAlreadyExistsException;
import com.project.cashRich.model.User;
import com.project.cashRich.request.Login;
import com.project.cashRich.security.userDetailsServiceDB.cashRichUserDetails;
import com.project.cashRich.services.IUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nehal Ansari
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final IUserService userService;
    private final AuthenticationManager authenticationManager;

    @PutMapping("/update/{id}")
    public User UpdateUser(@RequestBody User user, @PathVariable Long id){
        return userService.UpdateUser(id, user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody Login request){
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        cashRichUserDetails userDetails = (cashRichUserDetails) authentication.getPrincipal();



        return ResponseEntity.ok("User " + userDetails.getUsername() + " logged in successfully!");
    }


}
