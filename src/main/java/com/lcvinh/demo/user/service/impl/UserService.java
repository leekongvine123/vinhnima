package com.lcvinh.demo.user.service.impl;
import com.lcvinh.demo.user.dto.Request.UserLoginRequest;
import com.lcvinh.demo.user.dto.Request.UserRegisterRequest;
import com.lcvinh.demo.user.dto.Role;
import com.lcvinh.demo.user.entity.User;
import com.lcvinh.demo.user.repository.UserRepository;
import com.lcvinh.demo.user.service.UserMapper;
import com.lcvinh.demo.utils.Password;
import com.lcvinh.demo.utils.JwtService;
import com.lcvinh.demo.user.service.IUserService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;

@Stateless
public class UserService implements IUserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    public void register(UserRegisterRequest request) {
        // Hash the password before saving it to the database
        String hashedPassword = Password.hashPassword(request.getPassword());

        User user = userMapper.toEntity(request);

        // Persist the new user to the database
        userRepository.save(user);
    }

    @Override
    public String login(UserLoginRequest request) {
        try {
            // Find the user by email
            User user = userRepository.findByEmail(request.getEmail());

            // Check if the password matches
            if (Password.checkPassword(request.getPassword(), user.getPassword())) {
                // Generate JWT token
                return JwtService.generateToken(user.getEmail(), user.getRole());
            } else {
                throw new IllegalArgumentException("Invalid credentials");
            }

        } catch (NoResultException e) {
            throw new IllegalArgumentException("User not found");
        }
    }
}
