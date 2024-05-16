package com.project.cashRich.services;

import com.project.cashRich.exception.UserAlreadyExistsException;
import com.project.cashRich.exception.UserNotFoundException;
import com.project.cashRich.model.User;
import com.project.cashRich.repository.UserRepository;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/**
 * @author Nehal Ansari
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> getOneId(Long Id) {
        if(!userRepository.existsById(Id)){
            throw new UsernameNotFoundException("Not Found");
        }
        return userRepository.findById(Id);
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail() + " Email already exists");
        }
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UserAlreadyExistsException(user.getUsername() + " User name already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(String email) {
        User theUser = getUser(email);
        if (theUser != null){
            userRepository.deleteByEmail(email);
        }

    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public User UpdateUser(Long Id, User user) {
        return userRepository.findById(Id)
                .map(st -> {
            st.setFirstName(user.getFirstName());
            st.setEmail(user.getEmail());
            st.setLastName(user.getLastName());
            st.setPassword(user.getPassword());
            st.setUsername(user.getUsername());
            st.setMobile(user.getMobile());
            return userRepository.save(st);
        }).orElseThrow(() -> new UserNotFoundException("Sorry, User couldn't found !! "));

    }


}
