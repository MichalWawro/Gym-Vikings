package com.example.elgrande.controller;


import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.forms.UserForm;
//import com.example.elgrande.forms.loginForm;
import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.payload.JwtResponse;
import com.example.elgrande.model.role.Role;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.security.jwt.JwtUtils;
import com.example.elgrande.service.MainService;
import com.example.elgrande.service.role_service.RoleService;
import com.example.elgrande.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final MainService mainService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(UserService userService, MainService mainService, RoleService roleService,
                          PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userService = userService;
        this.mainService = mainService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/user/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterForm registerForm) {
        //sprawdzam, czy jest użytkownik: admin i role: ADMIN i USER, jeśli nie to dodaje je do DB.
        if(roleService.findRoleByName("ADMIN") == null){
            roleService.insertRole(new Role("ROLE_ADMIN"));
            roleService.insertRole(new Role("ROLE_USER"));
            userService.insertUser(new UserEntity("admin", passwordEncoder.encode("pass"), "admin@gmail.com"));
            userService.addRoleToUser("admin", "ROLE_ADMIN");
            userService.addRoleToUser("admin", "ROLE_USER");
        }
        try {
            UserEntity user= new UserEntity(registerForm.username(), passwordEncoder.encode(registerForm.password()), registerForm.email());
            userService.insertUser(user);
            userService.addRoleToUser(registerForm.username(), "ROLE_USER");
            return new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error registering user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/login")
//    public UserEntity login(@RequestBody LoginForm loginForm){
//        return userService.login(loginForm);
//    }
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getUsername(), roles));
    }



    @PatchMapping("/user/formDone")
    public ResponseEntity<String> getForm(@RequestParam int userId, @RequestBody UserForm userForm){
            try {
            mainService.setUserInfo(userForm, userId);
            mainService.updateTrainingPlan(userId, 25);
            return ResponseEntity.ok("User information set successfully");
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., log and return an error response)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error setting user information");
        }
    }
    @PutMapping("/user/trainingDone")
    public UserEntity trainingDone(@RequestParam int userId) {
        try {
            userService.trainingDone(userId);

            mainService.updateTrainingPlan(userId, 25);
            return mainService.getPropperUser(userId, 10, 2.5);
            //return ResponseEntity.ok("Training done successfully");
        } catch (Exception e) {
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   // .body("Error processing training done request: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/user/suggestDiets")
    public List<Diet> suggestDiet(@RequestParam int userId){
        return mainService.suggestDiet(userId);
    }

    @GetMapping("/training/provideNextTraining")
    public Training provideTraining(@RequestParam int userId){
        UserEntity user = mainService.getPropperUser(userId,10,2.5);
        return mainService.getOneTrainingFromUser(user);
    }

    @GetMapping("/user/getUserInfo")
    public UserEntity getUserInfo(@RequestParam int userId) {
        UserEntity user = mainService.getPropperUser(userId,10,2.5);
        return user;
    }
    @PostMapping("/user/userData")
    public String submitFormData(@RequestBody UserEntity userData) {
        System.out.println("Received form data: " + userData);
        return "Form data received successfully!";
    }
}