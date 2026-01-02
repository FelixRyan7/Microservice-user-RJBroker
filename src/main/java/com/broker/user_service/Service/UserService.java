package com.broker.user_service.Service;

import com.broker.user_service.DTOs.RegisterRequest;
import com.broker.user_service.DTOs.UserDTO;
import com.broker.user_service.model.User;
import com.broker.user_service.model.UserPermission;
import com.broker.user_service.repository.UserPermissionRepository;
import com.broker.user_service.repository.UserRepository;
import com.broker.user_service.utils.ProductPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO register(String username, String email, String password){
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email ya registrado");
        }
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Usuario ya existe");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        User savedUser = userRepository.save(user);
        assignDefaultPermissions(user);

        UserDTO userDtoResponse = new UserDTO(savedUser.getUsername(), savedUser.getEmail());

        return userDtoResponse;
    }

    private void assignDefaultPermissions(User user) {
        List<ProductPermission> defaults = List.of(ProductPermission.STOCKS, ProductPermission.ETFS);
        for (ProductPermission perm : defaults) {
            UserPermission up = new UserPermission();
            up.setUser(user);
            up.setPermission(perm);
            userPermissionRepository.save(up);
        }
    }
}
