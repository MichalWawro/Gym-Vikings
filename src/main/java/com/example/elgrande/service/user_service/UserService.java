package com.example.elgrande.service.user_service;

import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.User;
import com.example.elgrande.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User login(LoginForm loginForm){
        List<User> users = getAllUsers();
        User userToReturn = new User();
        for (User user:
             users) {
            if(user.getName() == loginForm.name() && user.getPassword() == loginForm.password()){
                userToReturn = user;
            }
        }
        return userToReturn;
    }


    public User getUserById(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        System.out.println("didnt get user");
        return null;
    }

    public void trainingDone(int id){
        User user = getUserById(id);

        int amountOfTrainings = user.getAmountOfTrainingsDone();
        user.setAmountOfTrainingsDone(amountOfTrainings + 1);
        userRepository.save(user);
    }

    public void registerUser(RegisterForm registerForm){
        User user = new User();
        user.setName(registerForm.name());
        user.setPassword(registerForm.password());
        user.setEmail(registerForm.email());
    }

}
