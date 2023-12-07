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
    public ResponseEntity<String> createUser(@RequestBody RegisterForm registerForm) {
        //sprawdzam, czy jest użytkownik: admin i role: ADMIN i USER, jeśli nie to dodaje je do DB.
        if(roleService.findRoleByName("ROLE_ADMIN") == null){
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

        mainService.giveUserAnotherTrainingPlan(userService.getUserByUsername(userDetails.getUsername()).getId());

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getUsername(), userService.getUserByUsername(userDetails.getUsername()), roles));
    }

    @PostMapping("/user/formDone")
//    public ResponseEntity<String> getForm(@RequestParam int userId, @RequestBody UserForm userForm){
    public ResponseEntity<String> getForm( @RequestBody UserEntity userData){
        try {
            UserForm userForm =new UserForm(userData.getGender(),userData.getAge(),userData.getWeight(),userData.getHeight(),userData.getAllergies());
            System.out.println("");
    //      mainService.setUserTrainingInfo(userForm, userId);
    //      mainService.updateFirstPlan(userId);
            mainService.setUserTrainingInfo(userForm, userData.getId());
            mainService.updateFirstPlan(userData.getId());

            return ResponseEntity.ok("User information set successfully");
        } catch (Exception e) {
            // Handle exceptions appropriately (e.g., log and return an error response)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error setting user information");
        }
    }
    @PutMapping("/user/trainingDone")
    public UserEntity trainingDone(@RequestParam int userId, @RequestParam int trainingId) {
        try {
            userService.trainingDone(userId);
            mainService.levelUp(userId);
            mainService.deleteTrainingFromUser(trainingId,userId);
            return mainService.getPropperUser(userId, 7, 2.5);
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
        UserEntity user = mainService.getPropperUser(userId,7,2.5);
        return mainService.getNextTrainingFromUser(user);
    }

    @GetMapping("/training/getTrainingFromUser")
    public Training provideTraining(@RequestParam int userId, @RequestParam int trainingId){
        return mainService.getTrainingFormUser(trainingId,userId);
    }

    @GetMapping("/diet/getDietsFromUser")
    public List<Diet> provideDiets(@RequestParam int userId){
        return mainService.getDietsFormUser(userId);
    }

    @GetMapping("/diet/provideNextMeal")
    public Meal provideNextMeal(@RequestParam int userId){ return mainService.getNextMealFromUserDiet(userId); }

    @GetMapping("/diet/suggestDiet")
    public List<Diet> suggestDiet(@RequestParam int userId) { return mainService.suggestDiet(userId);}

    @PatchMapping ("/user/setDiet")
    public void setDiet(@RequestParam int userId, int dietId) {mainService.setDiet(userId, dietId);}

    @GetMapping("/user/getUserInfo")
    public UserEntity getUserInfo(@RequestParam int userId) {
        UserEntity user = mainService.getPropperUser(userId,7,2.5);
        return user;
    }
    @PostMapping("/user/userData")
    public String submitFormData(@RequestBody UserEntity userData) {
        System.out.println("Received form data: " + userData);
        return "Form data received successfully!";
    }
}