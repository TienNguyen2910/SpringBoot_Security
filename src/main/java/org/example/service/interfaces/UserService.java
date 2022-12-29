package org.example.service.interfaces;

import org.example.models.User;
import org.example.service.dto.UserDTO;
import org.springframework.stereotype.Service;


import java.util.Optional;

public interface UserService {
    public void saveUser(UserDTO userDTO);
    public Optional<User> findUserByEmail(String email);
}
