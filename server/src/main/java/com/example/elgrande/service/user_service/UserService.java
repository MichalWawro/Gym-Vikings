package com.example.elgrande.service.user_service;

import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.model.role.Role;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.repository.RoleRepository;
import com.example.elgrande.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
            if(user.getUsername() == loginForm.username() && user.getPassword() == loginForm.password()){
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

    public void registerUser(RegisterForm registerForm){
        UserEntity user = new UserEntity();
        user.setUsername(registerForm.username());
        user.setPassword(registerForm.password());
        user.setEmail(registerForm.email());
    }

    public void insertUser(UserEntity user) {
        userRepository.save(user);
    }

    public void addRoleToUser(String username, String roleName){
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        Optional<Role> roleOptional = roleRepository.findByRoleName(roleName);
        if(userOptional.isPresent() && roleOptional.isPresent()){
            UserEntity user = userOptional.get();
            Role role = roleOptional.get();
            Set<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}
