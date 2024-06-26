package com.project.cashRich.security.userDetailsServiceDB;

import com.project.cashRich.model.User;
import com.project.cashRich.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.project.cashRich.security.userDetailsServiceDB.cashRichUserDetails.buildUserDetails;

/**
 * @author Nehal Ansari
 */
@Service
@RequiredArgsConstructor
public class cashRichUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return buildUserDetails(user);
    }
}
