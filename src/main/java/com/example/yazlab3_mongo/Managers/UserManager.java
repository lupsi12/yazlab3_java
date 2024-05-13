package com.example.yazlab3_mongo.Managers;

import com.example.yazlab3_mongo.Repository.UserRepo;
import com.example.yazlab3_mongo.Requests.UserCreateRequest;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.Services.SequenceGeneratorService;
import com.example.yazlab3_mongo.Services.UserService;
import com.example.yazlab3_mongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserManager implements UserService {
    private UserRepo userRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserResponse> getAllUsers(Optional<String> email, Optional<String> password) {
        List<User> userList = null;
        if(email.isPresent() && password.isPresent()){
            userList = userRepo.findByEmailAndPassword(email.get(), password.get());
        } else if (email.isPresent()) {
            userList = userRepo.findByEmail(email.get());
        } else userList = userRepo.findAll();
        return userList.stream().map(p -> new UserResponse(p)).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        UserResponse userResponse = new UserResponse(user);
        return userResponse;
    }

    @Override
    public User addUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setId(sequenceGeneratorService.getSquenceNumber(userCreateRequest.SEQUENCE_NAME));
        user.setUsername(userCreateRequest.getUsername());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
        user.setInterests(userCreateRequest.getInterests());
        user.setFasttext(userCreateRequest.getFasttext());
        return userRepo.save(user);
    }

    @Override
    public ResponseEntity<?> partialUpdateUser(Long id, Map<String, Object> updates) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Güncelleme yapılacak alanları al
        updates.forEach((key, value) -> {
            switch (key) {
                case "interests":
                    user.setInterests((String) value);
                    break;
                case "fasttext":
                    user.setFasttext((String) value);
                    break;
                // Diğer alanlar için gerekli işlemleri yapın
            }
        });

        // Değişiklikleri kaydet
        userRepo.save(user);

        return ResponseEntity.ok(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepo.deleteAll();
    }
}
