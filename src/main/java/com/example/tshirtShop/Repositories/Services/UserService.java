package com.example.tshirtShop.Repositories.Services;

import com.example.tshirtShop.Entities.User;
import com.example.tshirtShop.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        @Autowired
        private PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User getUserByEmail(String email) {
            User user = userRepository.findUserByEmail(email);
            return user;
        }

        public User createUser(User userDTO) {

            User user = new User();

            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            user.setEmail(userDTO.getEmail());

            return userRepository.save(user);
        }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    }
