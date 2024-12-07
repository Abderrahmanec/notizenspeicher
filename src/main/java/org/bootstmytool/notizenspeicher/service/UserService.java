package org.bootstmytool.notizenspeicher.service;

import org.bootstmytool.notizenspeicher.model.User;

import org.bootstmytool.notizenspeicher.dto.UserDTO;
import org.bootstmytool.notizenspeicher.model.User;
import org.bootstmytool.notizenspeicher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword()); // Achtung: Passwort-Hashing implementieren
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Benutzer nicht gefunden"));
    }
}
