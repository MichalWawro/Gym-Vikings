package com.example.elgrande.data;

import com.example.elgrande.model.diet.Diet;
import com.example.elgrande.model.diet.Ingredient;
import com.example.elgrande.model.diet.Meal;
import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.enums.enums_diet.DietType;
import com.example.elgrande.model.enums.enums_diet.FoodType;
import com.example.elgrande.model.enums.enums_training.Body;
import com.example.elgrande.model.enums.enums_training.Type;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import com.example.elgrande.model.user.User;
import com.example.elgrande.repository.UserRepository;
import com.example.elgrande.service.diet_service.DietRepository;
import com.example.elgrande.service.diet_service.DietService;
import com.example.elgrande.service.diet_service.IngredientRepository;
import com.example.elgrande.service.diet_service.MealRepository;
import com.example.elgrande.service.training_service.ExerciseRepository;
import com.example.elgrande.service.training_service.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private TrainingRepository trainingRepository;
    private ExerciseRepository exerciseRepository;
    private DietRepository dietRepository;
    private MealRepository mealRepository;
    private IngredientRepository ingredientRepository;
@Autowired
    public DataInitializer(UserRepository userRepository, TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, DietRepository dietRepository, MealRepository mealRepository, IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.dietRepository = dietRepository;
        this.mealRepository = mealRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

// public Diet(String dietName, List<Meal> mealsArray, FoodType foodType, DietType dietType)
// public Meal(String mealName, FoodType foodType, List<Ingredient> ingredients, List<Integer> gramsPerIngredient,  String perpInstructions)

        //Diets -----------------------------------------------------------------------------------------------------------------
//
//        Ingredient egg = new Ingredient("egg", 150);
//        Ingredient ham = new Ingredient("ham", 200);
//
//        Meal meal1 = new Meal("meal1", FoodType.NORMAL, List.of(egg, ham), List.of(210, 110), "no instructions");
//        Meal meal2 = new Meal("meal2", FoodType.NORMAL, List.of(egg, ham), List.of(220, 120), "no instructions");
//        Meal meal3 = new Meal("meal3", FoodType.NORMAL, List.of(egg, ham), List.of(230, 130), "no instructions");
//        Meal meal4 = new Meal("meal4", FoodType.NORMAL, List.of(egg, ham), List.of(240, 140), "no instructions");
//        Meal meal5 = new Meal("meal5", FoodType.NORMAL, List.of(egg, ham), List.of(250, 150), "no instructions");
//        Meal meal6 = new Meal("meal6", FoodType.NORMAL, List.of(egg, ham), List.of(260, 160), "no instructions");
//        Meal meal7 = new Meal("meal7", FoodType.NORMAL, List.of(egg, ham), List.of(270, 170), "no instructions");
//
//        Diet diet1 = new Diet("diet1", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, DietType.STAYING);
//        Diet diet2 = new Diet("diet2", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, DietType.STAYING);
//        Diet diet3 = new Diet("diet3", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, DietType.STAYING);
//
//        ingredientRepository.saveAll(List.of(egg, ham));
//        mealRepository.saveAll(List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7));
//        dietRepository.saveAll(List.of(diet1, diet2, diet3));
//
//            //Users -----------------------------------------------------------------------------------------------------------------
//        User user1 = new User("User1", "password1", "MALE@gmail.com");
//        User user2 = new User("User2", "password2", "FEMALE@gmail.com");
//        User user3 = new User("User3", "password3", "MALE2@gmail.com");
//
//        userRepository.saveAll(List.of(user1, user2, user3));
//
//       User user1 = new User("User1", "password1", "MALE",24,70, 170, Level.BEGINNER,24);
//       User user2 = new User("User2", "password2", "FEMALE",26,75, 175, Level.INTERMEDIATE, 10);
//       User user3 = new User("User3", "password3", "MALE",30,80, 180, Level.PROFESSIONAL,5);
//       User user4 = new User("User4", "password4", "FEMALE",34,85, 185, Level.ELITE,4);
//       User user5 = new User("User5", "password5", "MALE",44,90, 190, Level.EXPERT,0);
//
//       Exercise squats = new Exercise("Squats", Level.BEGINNER, Type.WEIGHTS,4,10,100);
//       Exercise running = new Exercise("Running", Level.EXPERT, Type.CARDIO, 1, 30, 0); // 0.0 for no weight
//       Exercise pushUps = new Exercise("Push-Ups", Level.BEGINNER, Type.WEIGHTS, 3, 15, 0);
//       Exercise deadlifts = new Exercise("Deadlifts", Level.INTERMEDIATE, Type.WEIGHTS, 3, 6, 225);
//       Exercise yoga = new Exercise("Yoga", Level.EXPERT, Type.CALISCENICKS, 1, 60, 0);
//
//       Training t1 = new Training("xd", Body.BICEPS,Level.BEGINNER);
//       Training t2 = new Training("tako",Body.CHEST,Level.INTERMEDIATE);
//       Training t3 = new Training("XDX", Body.BACK,Level.EXPERT);
//
//        userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
//        exerciseRepository.saveAll(List.of(squats,running,pushUps,deadlifts));
//        trainingRepository.saveAll(List.of(t1,t2,t3));
//
//        User user1 = new User("User1", "password1", "MALE",24,70, 170, UserLevel.BEGINNER);
//        User user2 = new User("User2", "password2", "FEMALE",26,75, 175, UserLevel.INTERMEDIATE);
//        User user3 = new User("User3", "password3", "MALE",30,80, 180, UserLevel.PROFESSIONAL);
//        User user4 = new User("User4", "password4", "FEMALE",34,85, 185, UserLevel.ELITE);
//        User user5 = new User("User5", "password5", "MALE",44,90, 190, UserLevel.EXPERT);
//
//        //Exercises-----------------------------------------------------------------------------------------------------------------
//        Exercise barDipBeginner = new Exercise("Bar Dip", Type.CALISTHENICS, Body.CHEST, 5, 0, 3);
//        Exercise barDipIntermediate = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 10, 0, 3);
//        Exercise barDipAdvanced = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 15, 0, 3);
//        Exercise barDipElite = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 25, 0, 4);
//        Exercise barDipExpert = new Exercise("Bar Dip", Type.CALISTHENICS, Body.TRICEPS, 30, 0, 4);
//
//        Exercise benchPressBeginner = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 10, 60, 3);
//        Exercise benchPressIntermediate = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 10, 80, 3);
//        Exercise benchPressAdvanced = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 5, 100, 4);
//        Exercise benchPressElite = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 8, 140, 4);
//        Exercise benchPressExpert = new Exercise("Bench Press", Type.WEIGHTS, Body.CHEST, 10, 180, 3);
//
//        Exercise cableChestPressBeginner = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 8, 15, 3);
//        Exercise cableChestPressIntermediate = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 10, 45, 3);
//        Exercise cableChestPressAdvanced = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 10, 70, 4);
//        Exercise cableChestPressElite = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 12, 100, 4);
//        Exercise cableChestPressExpert = new Exercise("Cable Chest Press", Type.WEIGHTS, Body.CHEST, 15, 120, 5);
//
//        Exercise dumbbellChestPressBeginner = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 5, 20, 3);
//        Exercise dumbbellChestPressIntermediate = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 8, 30, 4);
//        Exercise dumbbellChestPressAdvanced = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 10, 50, 4);
//        Exercise dumbbellChestPressElite = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 10, 60, 4);
//        Exercise dumbbellChestPressExpert = new Exercise("Dumbbell Chest Press", Type.WEIGHTS, Body.CHEST, 10, 80, 5);
//
//        Exercise dumbbellChestFlyBeginner = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 8, 20, 3);
//        Exercise dumbbellChestFlyIntermediate = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 10, 25, 4);
//        Exercise dumbbellChestFlyAdvanced = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 12, 30, 4);
//        Exercise dumbbellChestFlyElite = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 12, 35, 5);
//        Exercise dumbbellChestFlyExpert = new Exercise("Dumbbell Chest Fly", Type.WEIGHTS, Body.CHEST, 15, 40, 5);
//
//        Exercise pushUpBeginner = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 5, 0, 3);
//        Exercise pushUpIntermediate = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 10, 0, 3);
//        Exercise pushUpAdvanced = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 15, 0, 4);
//        Exercise pushUpElite = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 25, 0, 4);
//        Exercise pushUpExpert = new Exercise("Push-Up", Type.CALISTHENICS, Body.CHEST, 35, 0, 5);
//
//        Exercise inclineBenchPressBeginner = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 8, 40, 3);
//        Exercise inclineBenchPressIntermediate = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 10, 60,3);
//        Exercise inclineBenchPressAdvanced = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 10, 80, 3);
//        Exercise inclineBenchPressElite = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 15, 100, 4);
//        Exercise inclineBenchPressExpert = new Exercise("Incline Bench Press", Type.WEIGHTS, Body.CHEST, 15, 140, 4);
//
//        Exercise barbellFrontRaiseBeginner = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 5, 20, 3);
//        Exercise barbellFrontRaiseIntermediate = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 8, 25, 3);
//        Exercise barbellFrontRaiseAdvanced = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 10, 30, 3);
//        Exercise barbellFrontRaiseElite = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 10, 35, 4);
//        Exercise barbellFrontRaiseExpert = new Exercise("Barbell Front Raise", Type.WEIGHTS, Body.SHOULDER, 10, 40, 4);
//
//        Training training = new Training("Chest Day!",Level.ELITE);
//
//        Exercise exercise1 = new Exercise("Push-ups",Level.INTERMEDIATE, Type.CALISTHENICS, Body.CHEST, 15, 0, 3);
//        Exercise exercise2 = new Exercise("Squats",Level.BEGINNER, Type.WEIGHTS, Body.LEGS, 12, 50, 4);
//        Exercise exercise3 = new Exercise("Running",Level.BEGINNER, Type.CARDIO, Body.LEGS, 0, 0, 0);
//
//
//        Training training1 = new Training("Beginner Full Body", Level.BEGINNER, Body.CHEST);
//        Training training2 = new Training("Intermediate Upper Body", Level.INTERMEDIATE, Body.BACK);
//        Training training3 = new Training("Advanced Legs", Level.PROFESSIONAL, Body.LEGS);
//
//        //userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
//        exerciseRepository.saveAll(List.of(exercise1,exercise2,exercise3));
//        trainingRepository.saveAll(List.of(training1,training2,training3));

//Proper Ingredients Database

//Proper Meals Database
        //Meso
        Ingredient beefStrips = new Ingredient("Beef Strips", 250);
        Ingredient chickenBreast = new Ingredient("Chicken Breast", 165);
        Ingredient chickenStrips = new Ingredient("Chicken Strips", 239);
        Ingredient eggs = new Ingredient("Eggs", 155);
        Ingredient grilledChickenStrips = new Ingredient("Grilled Chicken Strips", 300);
        Ingredient grilledShrimp = new Ingredient("Grilled Shrimp", 154);
        Ingredient groundBeef = new Ingredient("Ground Beef", 330);
        Ingredient groundTurkey = new Ingredient("Ground Turkey", 203);
        Ingredient gyroMeat = new Ingredient("Gyro Meat", 209);
        Ingredient hardBoiledEggs = new Ingredient("Hard-Boiled Eggs", 155);
        Ingredient pork = new Ingredient("Pork", 242);
        Ingredient pulledPork = new Ingredient("Pulled Pork", 167);
        Ingredient salmonFillet = new Ingredient("Salmon Fillet", 334);
        Ingredient shrimp = new Ingredient("Shrimp", 99);
        Ingredient tuna = new Ingredient("Tuna", 132);
        Ingredient turkeySlices = new Ingredient("Turkey Slices", 189);
        //Nabiał
        Ingredient cheddarCheese = new Ingredient("Cheddar Cheese", 402);
        Ingredient fetaCheese = new Ingredient("Feta Cheese", 263);
        Ingredient mozzarellaCheese = new Ingredient("Mozzarella Cheese", 248);
        Ingredient parmesanCheese = new Ingredient("Parmesan Cheese", 431);
        Ingredient ricottaCheese = new Ingredient("Ricotta Cheese", 174);
        Ingredient tofu = new Ingredient("Tofu", 76);
        //Warzywa
        Ingredient avocado = new Ingredient("Avocado", 160);
        Ingredient basil = new Ingredient("Basil", 23);
        Ingredient blackBeans = new Ingredient("Black Beans", 132);
        Ingredient broccoli = new Ingredient("Broccoli", 34);
        Ingredient carrots = new Ingredient("Carrots", 41);
        Ingredient celery = new Ingredient("Celery", 8);
        Ingredient cherryTomatoes = new Ingredient("Cherry Tomatoes", 18);
        Ingredient chickpeas = new Ingredient("Chickpeas", 364);
        Ingredient coleslaw = new Ingredient("Coleslaw", 152);
        Ingredient corn = new Ingredient("Corn", 86);
        Ingredient cucumber = new Ingredient("Cucumber", 16);
        Ingredient eggplantSlices = new Ingredient("Eggplant Slices", 25);
        Ingredient freshBasil = new Ingredient("Fresh Basil", 22);
        Ingredient garlic = new Ingredient("Garlic", 150);
        Ingredient ginger = new Ingredient("Ginger", 80);
        Ingredient greenBeans = new Ingredient("Green Beans", 31);
        Ingredient kalamataOlives = new Ingredient("Kalamata Olives", 88);
        Ingredient kale  = new Ingredient("Kale ", 50);
        Ingredient lemon = new Ingredient("Lemon", 29);
        Ingredient lentils = new Ingredient("Lentils", 353);
        Ingredient lettuce = new Ingredient("Lettuce", 15);
        Ingredient lime = new Ingredient("Lime", 30);
        Ingredient mixedGreens = new Ingredient("Mixed Greens", 9);
        Ingredient mushrooms = new Ingredient("Mushrooms", 22);
        Ingredient onion = new Ingredient("Onion", 40);
        Ingredient parsley = new Ingredient("Parsley", 36);
        Ingredient pickles = new Ingredient("Pickles", 11);
        Ingredient pineappleChunks = new Ingredient("Pineapple Chunks", 50);
        Ingredient potatoes = new Ingredient("Potatoes", 313);
        Ingredient redBellPeppers = new Ingredient("Red Bell Peppers", 31);
        Ingredient redOnion = new Ingredient("Red Onion", 42);
        Ingredient romaineLettuce = new Ingredient("Romaine Lettuce", 17);
        Ingredient scallions = new Ingredient("Scallions", 32);
        Ingredient snowPeas = new Ingredient("Snow Peas", 67);
        Ingredient spinach = new Ingredient("Spinach", 23);
        Ingredient sweetPotatoes = new Ingredient("Sweet Potatoes", 86);
        Ingredient tomatoes = new Ingredient("Tomatoes", 19);
        Ingredient zucchini = new Ingredient("Zucchini", 17);
        //Zapychacze
        Ingredient arborioRice = new Ingredient("Arborio Rice", 130);
        Ingredient brownRice = new Ingredient("Brown Rice", 111);
        Ingredient fettuccinePasta = new Ingredient("Fettuccine Pasta", 99);
        Ingredient flourTortillas = new Ingredient("Flour Tortillas", 287);
        Ingredient hamburgerBun = new Ingredient("Hamburger Bun", 150);
        Ingredient jasmineRice = new Ingredient("Jasmine Rice", 170);
        Ingredient lasagnaPasta = new Ingredient("Lasagna Pasta", 354);
        Ingredient linguinePasta = new Ingredient("Linguine Pasta", 353);
        Ingredient pennePasta = new Ingredient("Penne Pasta", 157);
        Ingredient pitaBread = new Ingredient("Pita Bread", 275);
        Ingredient quinoa = new Ingredient("Quinoa", 370);
        Ingredient spaghettiPasta = new Ingredient("Spaghetti Pasta", 158);
        Ingredient sushiRice = new Ingredient("Sushi Rice", 139);
        Ingredient tagiatellePasta = new Ingredient("Tagiatelle Pasta", 288);
        Ingredient wholeWheatWrap = new Ingredient("Whole Wheat Wrap", 263);
        //Sosy
        Ingredient alfredoSauce = new Ingredient("Alfredo Sauce", 410);
        Ingredient BBQSauce = new Ingredient("BBQ Sauce",172 );
        Ingredient caesarDressing = new Ingredient("Caesar Dressing", 269);
        Ingredient marinaraSauce= new Ingredient("Marinara Sauce", 51);
        Ingredient pestoSauce = new Ingredient("Pesto Sauce", 534);
        Ingredient salsa = new Ingredient("Salsa", 36);
        Ingredient teriyakiSauce = new Ingredient("Teriyaki Sauce", 84);
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce", 29);
        Ingredient tzatzikiSauce = new Ingredient("Tzatziki Sauce", 85);
        //Dodatki
        Ingredient balsamicGlaze = new Ingredient("Balsamic Glaze", 88);
        Ingredient chickenBroth = new Ingredient("Chicken Broth", 267);
        Ingredient coconutMilk = new Ingredient("Coconut Milk", 230);
        Ingredient croutons = new Ingredient("Croutons", 465);
        Ingredient curryPowder = new Ingredient("Curry Powder", 325);
        Ingredient vegetableBroth = new Ingredient("Vegetable Broth", 11);
        Ingredient oliveOil = new Ingredient("Olive Oil", 884);
        Ingredient pineNuts = new Ingredient("Pine Nuts", 673);
        Ingredient soySauce = new Ingredient("Soy Sauce", 53);
        Ingredient tacoSeasoning = new Ingredient("Taco Seasoning", 292);
        Ingredient whiteWine = new Ingredient("White Wine", 82);

//        Ingredient  = new Ingredient("", );

// 1. Spaghetti Bolognese
        Meal spaghettiBolognese = new Meal("Spaghetti Bolognese", FoodType.NORMAL, List.of(groundBeef, tomatoSauce, spaghettiPasta, onion, garlic),
                List.of(250, 200, 150, 50, 10), "1. Cook spaghetti according to package instructions.\n" +
                "2. In a pan, brown ground beef with chopped onions and garlic.\n" +
                "3. Add tomato sauce to the beef mixture and let it simmer.\n" +
                "4. Serve the Bolognese sauce over the cooked spaghetti.");

// 2. Vegetarian Stir-Fry
        Meal vegetarianStirFry = new Meal("Vegetarian Stir-Fry", FoodType.VEGAN, List.of(tofu, broccoli, redBellPeppers, carrots, soySauce),
                List.of(200, 150, 100, 75, 20), "1. Press tofu to remove excess water and cut into cubes.\n" +
                "2. Stir-fry tofu, broccoli, bell peppers, and carrots in a wok.\n" +
                "3. Add soy sauce and toss until well-cooked.\n" +
                "4. Serve over rice or noodles.");

// 3. Salmon Quinoa Bowl
        Meal salmonQuinoaBowl = new Meal("Salmon Quinoa Bowl", FoodType.VEGETARIAN, List.of(salmonFillet, quinoa, avocado, kale, lemon),
                List.of(180, 100, 80, 50, 10), "1. Grill salmon fillet until cooked through.\n" +
                "2. Cook quinoa according to package instructions.\n" +
                "3. Assemble the bowl with quinoa, grilled salmon, sliced avocado, and kale.\n" +
                "4. Squeeze lemon juice over the bowl before serving.");

// 4. Caprese Salad
        Meal capreseSalad = new Meal("Caprese Salad", FoodType.VEGETARIAN, List.of(mozzarellaCheese, tomatoes, freshBasil, balsamicGlaze, oliveOil),
                List.of(150, 100, 30, 20, 15), "1. Slice fresh mozzarella, tomatoes, and arrange on a plate.\n" +
                "2. Sprinkle fresh basil over the mozzarella and tomatoes.\n" +
                "3. Drizzle balsamic glaze and olive oil on top.\n" +
                "4. Season with salt and pepper to taste.");

// 5. Chicken Caesar Wrap
        Meal chickenCaesarWrap = new Meal("Chicken Caesar Wrap", FoodType.NORMAL, List.of(grilledChickenStrips, romaineLettuce, parmesanCheese, caesarDressing, wholeWheatWrap),
                List.of(200, 100, 50, 30, 50), "1. Grill chicken strips until fully cooked.\n" +
                "2. In a bowl, mix Romaine lettuce, Parmesan cheese, and Caesar dressing.\n" +
                "3. Lay out a whole wheat wrap, add the lettuce mixture, and top with grilled chicken.\n" +
                "4. Roll up the wrap and secure with a toothpick.");

// 6. Shrimp and Broccoli Alfredo
        Meal shrimpBroccoliAlfredo = new Meal("Shrimp and Broccoli Alfredo", FoodType.VEGETARIAN, List.of(shrimp, broccoli, fettuccinePasta, alfredoSauce, parmesanCheese),
                List.of(250, 150, 120, 100, 30), "1. Cook fettuccine pasta according to package instructions.\n" +
                "2. In a pan, sauté shrimp and broccoli until shrimp is pink and broccoli is tender.\n" +
                "3. Add Alfredo sauce and cooked pasta to the pan, toss until well coated.\n" +
                "4. Sprinkle Parmesan cheese on top before serving.");

// 7. Mushroom Risotto
        Meal mushroomRisotto = new Meal("Mushroom Risotto", FoodType.NORMAL, List.of(arborioRice, mushrooms, chickenBroth, whiteWine, parmesanCheese),
                List.of(200, 150, 250, 50, 40), "1. Sauté mushrooms in a pan until browned.\n" +
                "2. In a separate pot, cook Arborio rice in chicken broth.\n" +
                "3. Add sautéed mushrooms and white wine to the rice, stirring until creamy.\n" +
                "4. Finish by stirring in grated Parmesan cheese.");

// 7.1. Mushroom Risotto
        Meal vegetarianMushroomRisotto = new Meal("Vegetarian Mushroom Risotto", FoodType.VEGETARIAN, List.of(arborioRice, mushrooms, vegetableBroth, whiteWine, parmesanCheese),
                List.of(200, 150, 250, 50, 40), "1. Sauté mushrooms in a pan until browned.\n" +
                "2. In a separate pot, cook Arborio rice in vegetable broth.\n" +
                "3. Add sautéed mushrooms and white wine to the rice, stirring until creamy.\n" +
                "4. Finish by stirring in grated Parmesan cheese.");

// 8. Taco Salad
        Meal tacoSalad = new Meal("Taco Salad", FoodType.NORMAL, List.of(groundTurkey, lettuce, cherryTomatoes, blackBeans,cheddarCheese),
                List.of(200, 100, 75, 50, 40), "1. Cook ground turkey in a skillet until fully browned.\n" +
                "2. In a large bowl, combine cooked turkey, lettuce, cherry tomatoes, black beans, and shredded cheddar cheese.\n" +
                "3. Toss with your favorite dressing and top with crushed tortilla chips.");

// 9. Veggie Omelette
        Meal veggieOmelette = new Meal("Veggie Omelette", FoodType.VEGETARIAN, List.of(eggs, redBellPeppers, spinach, tomatoes, fetaCheese),
                List.of(3, 100, 50, 50, 30), "1. Whisk eggs in a bowl and season with salt and pepper.\n" +
                "2. In a non-stick skillet, sauté bell peppers, spinach, and tomatoes.\n" +
                "3. Pour the whisked eggs over the veggies and cook until set.\n" +
                "4. Fold the omelette in half and serve with crumbled feta cheese.");

// 10. Beef and Vegetable Stir-Fry
        Meal beefVegetableStirFry = new Meal("Beef and Vegetable Stir-Fry", FoodType.NORMAL, List.of(beefStrips, broccoli, snowPeas, carrots, ginger),
                List.of(250, 100, 75, 50, 10), "1. Sauté beef strips in a wok until browned.\n" +
                "2. Add broccoli, snow peas, carrots, and ginger, stir-frying until vegetables are tender.\n" +
                "3. Pour soy sauce over the stir-fry and toss until well-coated.\n" +
                "4. Serve over rice.");

// 11. Caesar Salad with Grilled Shrimp
        Meal caesarSaladGrilledShrimp = new Meal("Caesar Salad with Grilled Shrimp", FoodType.VEGETARIAN, List.of(grilledShrimp, romaineLettuce, croutons, caesarDressing, parmesanCheese),
                List.of(200, 100, 50, 30, 20), "1. Grill shrimp until pink and fully cooked.\n" +
                "2. In a large bowl, mix Romaine lettuce, croutons, Parmesan cheese, and Caesar dressing.\n" +
                "3. Top the salad with grilled shrimp.\n" +
                "4. Toss the salad and serve.");

// 12. Pesto Pasta with Cherry Tomatoes
        Meal pestoPastaCherryTomatoes = new Meal("Pesto Pasta with Cherry Tomatoes", FoodType.VEGETARIAN, List.of(pestoSauce, cherryTomatoes, pennePasta, pineNuts, parmesanCheese),
                List.of(100, 150, 120, 30, 25), "1. Cook penne pasta according to package instructions.\n" +
        "2. In a blender, combine pesto sauce, cherry tomatoes, and pine nuts.\n" +
                "3. Toss the cooked pasta in the pesto mixture.\n" +
                "4. Sprinkle grated Parmesan cheese on top before serving.");

// 13. Hawaiian Chicken Skewers
        Meal hawaiianChickenSkewers = new Meal("Hawaiian Chicken Skewers", FoodType.NORMAL, List.of(chickenBreast, pineappleChunks, redBellPeppers, redOnion, teriyakiSauce),
                List.of(200, 100, 75, 50, 30), "1. Thread chicken, pineapple chunks, bell peppers, and red onion onto skewers.\n" +
                "2. Grill skewers until chicken is fully cooked.\n" +
                "3. Baste with teriyaki marinade during grilling.\n" +
                "4. Serve skewers over rice.");

// 14. Sweet Potato and Black Bean Bowl
        Meal sweetPotatoBlackBeanBowl = new Meal("Sweet Potato and Black Bean Bowl", FoodType.VEGAN, List.of(sweetPotatoes, blackBeans, corn, avocado, lime),
                List.of(150, 100, 75, 50, 10), "1. Roast sweet potatoes until tender.\n" +
                "2. Mix roasted sweet potatoes with black beans, corn, and diced avocado.\n" +
                "3. Squeeze lime juice over the bowl before serving.\n" +
                "4. Season with salt and pepper to taste.");

// 15. Lentil Soup
        Meal lentilSoup = new Meal("Lentil Soup", FoodType.VEGAN, List.of(lentils, carrots, celery, onion, vegetableBroth),
                List.of(200, 75, 50, 50, 300), "1. Rinse lentils and cook them in vegetable broth.\n" +
                "2. Sauté carrots, celery, and onions in a pot until softened.\n" +
                "3. Add sautéed vegetables to the lentils and simmer until flavors meld.\n" +
                "4. Season with salt and pepper to taste.");

// 16. BBQ Pulled Pork Sandwich
        Meal bbqPulledPorkSandwich = new Meal("BBQ Pulled Pork Sandwich", FoodType.NORMAL, List.of(pulledPork, BBQSauce, coleslaw, hamburgerBun, pickles),
                List.of(200, 50, 75, 50, 10),"1. Slow-cook pulled pork in BBQ sauce until tender.\n" +
                "2. Assemble the sandwich with pulled pork, coleslaw, and pickles.\n" +
                "3. Serve the sandwich on a toasted hamburger bun.");
// 17. Greek Gyro Wrap
        Meal greekGyroWrap = new Meal("Greek Gyro Wrap", FoodType.NORMAL, List.of(gyroMeat, tzatzikiSauce, tomatoes, redOnion, pitaBread),
                List.of(200, 50, 50, 30, 50), "1. Cook gyro meat until fully cooked.\n" +
                "2. In a pita bread, layer gyro meat, Tzatziki sauce, diced tomatoes, and red onion.\n" +
                "3. Roll up the wrap and secure with a toothpick.\n" +
                "4. Serve with additional Tzatziki sauce for dipping.");

// 18. Teriyaki Salmon Bowl
        Meal teriyakiSalmonBowl = new Meal("Teriyaki Salmon Bowl", FoodType.VEGETARIAN, List.of(salmonFillet, brownRice, broccoli, carrots, teriyakiSauce),
                List.of(180, 100, 75, 50, 30), "1. Grill salmon fillet until fully cooked.\n" +
                "2. Cook brown rice according to package instructions.\n" +
                "3. Steam broccoli and carrots.\n" +
                "4. Assemble the bowl with rice, grilled salmon, and steamed vegetables.\n" +
                "5. Drizzle teriyaki sauce over the bowl.");

// 19. Mediterranean Quinoa Salad
        Meal mediterraneanQuinoaSalad = new Meal("Mediterranean Quinoa Salad", FoodType.VEGETARIAN, List.of(quinoa, cherryTomatoes, cucumber, kalamataOlives, fetaCheese),
                List.of(100, 75, 50, 30, 40), "1. Cook quinoa according to package instructions.\n" +
                "2. In a bowl, mix cooked quinoa with cherry tomatoes, cucumber, Kalamata olives, and feta cheese.\n" +
                "3. Toss the salad and serve chilled.");

// 20. Chickpea Curry
        Meal chickpeaCurry = new Meal("Chickpea Curry", FoodType.VEGAN, List.of(chickpeas, coconutMilk, spinach, tomatoes, curryPowder),
                List.of(200, 150, 75, 50, 10), "1. Sauté chickpeas in coconut milk.\n" +
                "2. Add spinach, tomatoes, and curry powder to the chickpea mixture.\n" +
                "3. Simmer until spinach is wilted.\n" +
                "4. Serve over rice.");

// 21. Tuna Nicoise Salad
        Meal tunaNicoiseSalad = new Meal("Tuna Nicoise Salad", FoodType.VEGETARIAN, List.of(tuna, mixedGreens, potatoes, greenBeans, hardBoiledEggs),
                List.of(150, 100, 75, 50, 2), "1. In a bowl, combine mixed greens, canned tuna, boiled potatoes, and green beans.\n" +
                "2. Top the salad with hard-boiled eggs.\n" +
                "3. Serve with your favorite dressing.");

// 22. Pork Fried Rice
        Meal porkFriedRice = new Meal("Pork Fried Rice", FoodType.NORMAL, List.of(pork, jasmineRice, snowPeas, carrots, scallions, soySauce),
                List.of(200, 150, 75, 50, 20), "1. Cook diced pork in a wok until browned.\n" +
                "2. Add jasmine rice, peas, carrots, and scallions to the wok.\n" +
                "3. Stir-fry the ingredients and add soy sauce for flavor.\n" +
                "4. Serve hot.");

// 23. Chicken Fajitas
        Meal chickenFajitas = new Meal("Chicken Fajitas", FoodType.NORMAL, List.of(chickenStrips, redBellPeppers, onion, flourTortillas, salsa),
                List.of(200, 100, 75, 50, 30), "1. Sauté chicken strips in a skillet until fully cooked.\n" +
                "2. Add sliced bell peppers and onions to the skillet.\n" +
                "3. Warm flour tortillas in the oven.\n" +
                "4. Assemble fajitas with the chicken and vegetable mixture.\n" +
                "5. Serve with salsa.");

// 24. Eggplant Parmesan
        Meal eggplantParmesan = new Meal("Eggplant Parmesan", FoodType.VEGETARIAN, List.of(eggplantSlices, marinaraSauce, mozzarellaCheese, parmesanCheese, basil),
                List.of(200, 150, 100, 50, 10), "1. Bread eggplant slices and bake until golden brown.\n" +
                "2. In a baking dish, layer marinara sauce, eggplant slices, mozzarella cheese, and Parmesan cheese.\n" +
                "3. Bake until the cheese is melted and bubbly.\n" +
                "4. Garnish with fresh basil before serving.");

// 25. Beef Tacos
        Meal beefTacos = new Meal("Beef Tacos", FoodType.NORMAL, List.of(groundBeef, tacoSeasoning, lettuce, tomatoes, cheddarCheese),
                List.of(200, 25, 75, 50, 40), "1. Brown ground beef in a skillet and season with taco seasoning.\n" +
                "2. In taco shells, layer the seasoned beef, lettuce, tomatoes, and shredded cheddar cheese.\n" +
                "3. Serve with your favorite taco toppings.");

// 26. Shrimp Scampi
        Meal shrimpScampi = new Meal("Shrimp Scampi", FoodType.VEGETARIAN, List.of(shrimp, linguinePasta, garlic, lemon, parsley),
                List.of(250, 120, 20, 30, 10), "1. Cook linguine pasta according to package instructions.\n" +
                "2. Sauté shrimp in garlic and lemon until fully cooked.\n" +
                "3. Toss the cooked pasta with the shrimp mixture.\n" +
                "4. Garnish with chopped parsley before serving.");

// 27. Sushi Bowl
        Meal sushiBowl = new Meal("Sushi Bowl", FoodType.VEGETARIAN, List.of(sushiRice, salmonFillet, avocado, cucumber, soySauce),
                List.of(150, 100, 75, 50, 20), "1. Cook sushi rice according to package instructions.\n" +
                "2. Assemble the bowl with sushi rice, sliced salmon, avocado, and cucumber.\n" +
                "3. Drizzle soy sauce over the bowl before serving.");

// 28. Vegetable Lasagna
        Meal vegetableLasagna = new Meal("Vegetable Lasagna", FoodType.VEGETARIAN, List.of(lasagnaPasta, marinaraSauce, zucchini, ricottaCheese, mozzarellaCheese),
                List.of(150, 100, 75, 50, 40), "1. Cook lasagna noodles according to package instructions.\n" +
                "2. In a baking dish, layer marinara sauce, lasagna noodles, zucchini, ricotta cheese, and mozzarella cheese.\n" +
                "3. Repeat the layers and bake until bubbly and golden brown.\n" +
                "4. Let it cool before serving.");

// 29. Turkey and Avocado Wrap
        Meal turkeyAvocadoWrap = new Meal("Turkey and Avocado Wrap", FoodType.NORMAL, List.of(turkeySlices, avocado, lettuce, tomatoes, wholeWheatWrap),
                List.of(150, 75, 50, 30, 50), "1. Layer turkey slices, avocado, lettuce, and tomato on a whole wheat wrap.\n" +
                "2. Roll up the wrap and secure with a toothpick.\n" +
                "3. Slice in half and serve.");

// 30. Chicken Noodle Soup
        Meal chickenNoodleSoup = new Meal("Chicken Noodle Soup", FoodType.NORMAL, List.of(chickenBreast, tagiatellePasta, carrots, celery, chickenBroth),
                List.of(200, 100, 75, 50, 300), "1. Poach chicken breast in chicken broth until fully cooked.\n" +
                "2. Add egg noodles, carrots, celery, and onions to the pot.\n" +
                "3. Simmer until the noodles are tender.\n" +
                "4. Season with salt and pepper to taste.");

//        Diet diet1 = new Diet("diet1", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.VEGAN, "Dieta blebleble");
//        Diet diet2 = new Diet("diet2", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.NORMAL, "Dieta blebleble");
//        Diet diet3 = new Diet("diet3", List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7), FoodType.VEGETARIAN, "Dieta blebleble");
    }
}
