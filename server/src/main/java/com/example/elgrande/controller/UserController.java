package com.example.elgrande.controller;


import com.example.elgrande.forms.LoginForm;
import com.example.elgrande.forms.RegisterForm;
import com.example.elgrande.forms.UserForm;
//import com.example.elgrande.forms.loginForm;
import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Meal;
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
    public  ResponseEntity<String> createUser(@RequestBody RegisterForm request){
        //sprawdzam, czy jest użytkownik: admin i role: ADMIN i USER, jeśli nie to dodaje je do DB.
        if(roleService.findRoleByName("ROLE_ADMIN") == null){
            roleService.insertRole(new Role("ROLE_ADMIN"));
            roleService.insertRole(new Role("ROLE_USER"));
            userService.insertUser(new UserEntity("admin", passwordEncoder.encode("pass"), request.email()));
            userService.addRoleToUser("admin", "ROLE_ADMIN");
            userService.addRoleToUser("admin", "ROLE_USER");
        }
        UserEntity user= new UserEntity(request.username(), passwordEncoder.encode(request.password()), request.email());
        userService.insertUser(user);
        userService.addRoleToUser(request.username(), "ROLE_USER");
        return new ResponseEntity<>("User " + user.getUsername() + " successfully registered", HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getUsername(),userService.getUserByUsername(userDetails.getUsername()) ,roles));
    }

    @PatchMapping("/user/formDone")
//    public ResponseEntity<String> getForm(@RequestParam int userId, @RequestBody UserForm userForm){
    public ResponseEntity<String> getForm( @RequestBody UserForm userForm, @RequestParam int userId){
        try {
            System.out.println("");
            mainService.setUserTrainingInfo(userForm, userId);
            mainService.giveUserFirstTrainingPlan(userId);
            return ResponseEntity.ok("User information set successfully");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error setting user information");
        }
    }
    @PatchMapping("/user/trainingDone")
    public UserEntity trainingDone(@RequestParam int userId,  @RequestParam (required = false) Integer trainingId) {
            userService.trainingDone(userId);
            mainService.levelUp(userId);
            mainService.deleteTrainingFromUser(trainingId,userId);
            return mainService.getPropperUser(userId, 7, 2.5, 1);
    }


    @GetMapping("/training/provideNextTraining")
    public Training provideTraining(@RequestParam int userId){
        mainService.giveUserAnotherTrainingPlan(userId);
        UserEntity user = mainService.getPropperUser(userId,7,2.5, 1);
        return mainService.getNextTrainingFromUser(user);
    }

    @GetMapping("/training/getTrainingFromUser")
    public Training provideTraining(@RequestParam int userId, @RequestParam int trainingId){
        mainService.giveUserAnotherTrainingPlan(userId);
        return mainService.getTrainingFormUser(trainingId,userId);
    }

    @GetMapping("/diet/getDietsWithCalories")
    public List<Diet> provideDiets(@RequestParam int userId){
        return mainService.getAllDietsChanged(userId);
    }

    @GetMapping("/diet/getDietWithCalories")
    public Diet suggestDiet(@RequestParam int userId) { return mainService.getDietChanged(userId);}

    @PutMapping ("/user/setDiet")
    public Diet setDiet(@RequestParam int userId,@RequestParam int dietId) {return mainService.setDiet(userId, dietId);}

    @GetMapping("/user/getUserInfo")
    public UserEntity getUserInfo(@RequestParam int userId) {
        UserEntity user = mainService.getPropperUser(userId,7,2.5, 1);
        return user;
    }

    @GetMapping("/user/getUserInfoByName")
    public UserEntity getUserInfo(@RequestParam String name) {
        UserEntity user = userService.getUserByUsername(name);
        return user;
    }

    @PostMapping("/user/userData")
    public String submitFormData(@RequestBody UserEntity userData) {
        System.out.println("Received form data: " + userData);
        return "Form data received successfully!";
    }
}