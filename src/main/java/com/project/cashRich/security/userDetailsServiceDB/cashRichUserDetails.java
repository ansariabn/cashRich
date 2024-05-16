package com.project.cashRich.security.userDetailsServiceDB;

import com.project.cashRich.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nehal Ansari
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cashRichUserDetails implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private Collection<GrantedAuthority> authorities;
//    public static cashRichUserDetails buildUserDetails(User user) {
//        List<GrantedAuthority> authorities = user.getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//        return new cashRichUserDetails(
//                user.getId(),
//                user.getUsername(),
//                user.getPassword(),
//                authorities);
//
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
