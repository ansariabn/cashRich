package com.project.cashRich.controller;

// UserController.java
import com.project.cashRich.model.Api3dParty;
import com.project.cashRich.model.User;
import com.project.cashRich.repository.UserRepository;
import com.project.cashRich.services.Api3dService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Nehal Ansari
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {


    private final Api3dService apiService;

    @GetMapping("/make-api-request")
    public ResponseEntity<?> makeApiRequest(@RequestParam String symbol) {
        Api3dParty api3dParty = apiService.consumeApi(symbol);

        return ResponseEntity.ok(api3dParty);
//        if (userDetails == null) {
//            Long userId = getUserIdFromUserDetails(userDetails); // Implement this method to get user ID
//            return ResponseEntity.ok("API request made and stored in DB");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
//        }
    }

//    private Long getUserIdFromUserDetails(UserDetails userDetails) {
//        String username = userDetails.getUsername();
//        User user = userRepository.findByUsername(username).orElseThrow(()->new IllegalArgumentException("User not found with username: " + username));
//            return user.getId();
//
//
//    }
}
