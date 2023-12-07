package com.example.elgrande.service.user_service;

import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }


    public UserEntity login(LoginForm loginForm){
        List<UserEntity> users = getAllUsers();
        UserEntity userToReturn = new UserEntity();
        for (UserEntity user:
             users) {
            if(user.getUsername() == loginForm.name() && user.getPassword() == loginForm.password()){
                userToReturn = user;
            }
        }
        return userToReturn;
    }


    public UserEntity getUserById(int id){
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        System.out.println("didnt get user");
        return null;
    }

    public void trainingDone(int id){
        UserEntity user = getUserById(id);

        int amountOfTrainings = user.getAmountOfTrainingsDone();
        user.setAmountOfTrainingsDone(amountOfTrainings + 1);
        userRepository.save(user);
    }

    public UserEntity registerUser(RegisterForm registerForm){
        UserEntity user = new UserEntity();
        user.setUsername(registerForm.name());
        user.setPassword(registerForm.password());
        user.setEmail(registerForm.email());
        saveUser(user);
        return user;
    }

}
