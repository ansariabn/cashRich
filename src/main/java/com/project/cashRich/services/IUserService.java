package com.project.cashRich.services;

import com.project.cashRich.model.User;

import java.util.List;
import java.util.Optional;
/**
 * @author Nehal Ansari
 */
public interface IUserService {
    // additional methods Implement
    Optional<User> getOneId(Long Id);
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);

    User UpdateUser(Long Id, User user);

}
