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
import jakarta.persistence.criteria.CriteriaBuilder;
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

/*
//Proper Diet Database
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
        Ingredient sirloinSteak = new Ingredient("Sirloin Steak", 244);
        Ingredient porkRibs = new Ingredient("Pork Ribs", 361);
        Ingredient porkShoulder = new Ingredient("Pork Shoulder", 269);
        Ingredient baconStrips = new Ingredient("Bacon Strips", 477);
        Ingredient lambChops = new Ingredient("Lamb Chops", 294);
        Ingredient chickenWings = new Ingredient("Chicken Wings", 203);
        //Nabiał
        Ingredient cheddarCheese = new Ingredient("Cheddar Cheese", 402);
        Ingredient fetaCheese = new Ingredient("Feta Cheese", 263);
        Ingredient mozzarellaCheese = new Ingredient("Mozzarella Cheese", 248);
        Ingredient parmesanCheese = new Ingredient("Parmesan Cheese", 431);
        Ingredient ricottaCheese = new Ingredient("Ricotta Cheese", 174);
        Ingredient tofu = new Ingredient("Tofu", 76);
        Ingredient butter = new Ingredient("Butter", 717);
        Ingredient sourCream = new Ingredient("SourCream", 193);
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
        Ingredient kale = new Ingredient("Kale ", 50);
        Ingredient lemon = new Ingredient("Lemon", 29);
        Ingredient lentils = new Ingredient("Lentils", 353);
        Ingredient lettuce = new Ingredient("Lettuce", 15);
        Ingredient lime = new Ingredient("Lime", 30);
        Ingredient mixedGreens = new Ingredient("Mixed Greens", 9);
        Ingredient mushrooms = new Ingredient("Mushrooms", 22);
        Ingredient onion = new Ingredient("Onion", 40);
        Ingredient orange = new Ingredient("Orange", 47);
        Ingredient parsley = new Ingredient("Parsley", 36);
        Ingredient pickles = new Ingredient("Pickles", 11);
        Ingredient pineappleChunks = new Ingredient("Pineapple Chunks", 50);
        Ingredient potatoes = new Ingredient("Potatoes", 313);
        Ingredient redBellPeppers = new Ingredient("Red Bell Peppers", 31);
        Ingredient redOnion = new Ingredient("Red Onion", 42);
        Ingredient romaineLettuce = new Ingredient("Romaine Lettuce", 17);
        Ingredient rosemary = new Ingredient("Rosemary", 131);
        Ingredient scallions = new Ingredient("Scallions", 32);
        Ingredient snowPeas = new Ingredient("Snow Peas", 67);
        Ingredient spinach = new Ingredient("Spinach", 23);
        Ingredient sweetPotatoes = new Ingredient("Sweet Potatoes", 86);
        Ingredient tomatoes = new Ingredient("Tomatoes", 19);
        Ingredient zucchini = new Ingredient("Zucchini", 17);
        //Zapychacze
        Ingredient arborioRice = new Ingredient("Arborio Rice", 130);
        Ingredient brownRice = new Ingredient("Brown Rice", 111);
        Ingredient cornTortillas = new Ingredient("Corn Tortillas", 218);
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
        Ingredient tagliatellePasta = new Ingredient("Tagliatelle Pasta", 288);
        Ingredient wholeWheatWrap = new Ingredient("Whole Wheat Wrap", 263);
        //Sosy
        Ingredient alfredoSauce = new Ingredient("Alfredo Sauce", 410);
        Ingredient BBQSauce = new Ingredient("BBQ Sauce", 172);
        Ingredient caesarDressing = new Ingredient("Caesar Dressing", 269);
        Ingredient dijonMustard = new Ingredient("Dijon Mustard", 66);
        Ingredient hotSauce = new Ingredient("Hot Sauce", 11);
        Ingredient marinaraSauce = new Ingredient("Marinara Sauce", 51);
        Ingredient pestoSauce = new Ingredient("Pesto Sauce", 534);
        Ingredient salsa = new Ingredient("Salsa", 36);
        Ingredient teriyakiSauce = new Ingredient("Teriyaki Sauce", 84);
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce", 29);
        Ingredient tzatzikiSauce = new Ingredient("Tzatziki Sauce", 85);
        //Dodatki
        Ingredient balsamicGlaze = new Ingredient("Balsamic Glaze", 88);
        Ingredient brownSugar = new Ingredient("Brown Sugar", 380);
        Ingredient breadCrumbs = new Ingredient("Bread Crumbs", 395);
        Ingredient cayennePepper = new Ingredient("Cayenne Pepper", 318);
        Ingredient chickenBroth = new Ingredient("Chicken Broth", 267);
        Ingredient chiliPowder = new Ingredient("Chili Powder", 282);
        Ingredient coconutMilk = new Ingredient("Coconut Milk", 230);
        Ingredient croutons = new Ingredient("Croutons", 465);
        Ingredient cumin = new Ingredient("Cumin", 375);
        Ingredient curryPowder = new Ingredient("Curry Powder", 325);
        Ingredient freshMint = new Ingredient("Fresh Mint", 58);
        Ingredient garlicPowder = new Ingredient("Garlic Powder", 331);
        Ingredient vegetableBroth = new Ingredient("Vegetable Broth", 11);
        Ingredient mixedHerbs = new Ingredient("Mixed Herbs", 303);
        Ingredient oliveOil = new Ingredient("Olive Oil", 884);
        Ingredient paprika = new Ingredient("Paprika", 282);
        Ingredient pineNuts = new Ingredient("Pine Nuts", 673);
        Ingredient soySauce = new Ingredient("Soy Sauce", 53);
        Ingredient tacoSeasoning = new Ingredient("Taco Seasoning", 292);
        Ingredient whiteWine = new Ingredient("White Wine", 82);

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
        Meal tacoSalad = new Meal("Taco Salad", FoodType.NORMAL, List.of(groundTurkey, lettuce, cherryTomatoes, blackBeans, cheddarCheese),
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
                List.of(200, 50, 75, 50, 10), "1. Slow-cook pulled pork in BBQ sauce until tender.\n" +
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
                List.of(200, 150, 40, 40, 50, 20), "1. Cook diced pork in a wok until browned.\n" +
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
        Meal chickenNoodleSoup = new Meal("Chicken Noodle Soup", FoodType.NORMAL, List.of(chickenBreast, tagliatellePasta, carrots, celery, chickenBroth),
                List.of(200, 100, 75, 50, 300), "1. Poach chicken breast in chicken broth until fully cooked.\n" +
                "2. Add egg noodles, carrots, celery, and onions to the pot.\n" +
                "3. Simmer until the noodles are tender.\n" +
                "4. Season with salt and pepper to taste.");

// 31. Steak with Garlic Butter
        Meal steakWithGarlicButter = new Meal("Steak with Garlic Butter", FoodType.CARNIVORE, List.of(sirloinSteak, garlic, butter, rosemary),
                List.of(250, 15, 50, 14), "1. Season the sirloin steak with salt and pepper.\n" +
                "2. Grill the steak to your preferred doneness.\n" +
                "3. In a pan, melt butter and sauté minced garlic until fragrant.\n" +
                "4. Add rosemary to the garlic butter and baste the grilled steak with the mixture.");

// 32. BBQ Ribs
        Meal bbqRibs = new Meal("BBQ Ribs", FoodType.CARNIVORE, List.of(porkRibs, BBQSauce, brownSugar, paprika, garlicPowder),
                List.of(1000, 240, 60, 14, 6), "1. Preheat the oven to 275°F (135°C).\n" +
                "2. Mix brown sugar, paprika, and garlic powder to create a dry rub.\n" +
                "3. Rub the mixture over the pork ribs.\n" +
                "4. Place ribs in the oven and bake for 2.5 to 3 hours.\n" +
                "5. Brush the ribs with BBQ sauce during the last 30 minutes of cooking.");

// 33. Grilled Chicken Breast with Lemon Herb Marinade
        Meal grilledChickenBreast = new Meal("Grilled Chicken Breast with Lemon Herb Marinade", FoodType.CARNIVORE, List.of(chickenBreast, lemon, oliveOil, garlic, mixedHerbs),
                List.of(2, 1, 60, 10, 14), "1. Marinate chicken breasts in a mixture of lemon juice, olive oil, minced garlic, and mixed herbs for at least 30 minutes.\n" +
                "2. Grill the chicken breasts until fully cooked.\n" +
                "3. Serve with additional lemon wedges and herbs for garnish.");

// 34. Beef Stir-Fry with Vegetables
        Meal beefStirFry = new Meal("Beef Stir-Fry with Vegetables", FoodType.CARNIVORE, List.of(beefStrips, broccoli, redBellPeppers, soySauce, ginger),
                List.of(300, 400, 2, 60, 14), "1. Stir-fry beef strips in a hot pan until browned.\n" +
                "2. Add sliced broccoli, bell peppers, and minced ginger to the pan.\n" +
                "3. Pour soy sauce over the ingredients and stir-fry until vegetables are tender.\n" +
                "4. Adjust seasoning if necessary.");

// 35. Carnitas Tacos
        Meal carnitasTacos = new Meal("Carnitas Tacos", FoodType.CARNIVORE, List.of(porkShoulder, cumin, chiliPowder, orange, cornTortillas),
                List.of(1000, 14, 14, 60, 110), "1. Cut pork shoulder into chunks and season with cumin, chili powder, and salt.\n" +
                "2. Place seasoned pork in a slow cooker, add orange juice, and cook on low for 6-8 hours.\n" +
                "3. Shred the cooked pork and assemble tacos with your favorite toppings.");

// 36. Lamb Chops with Mint Sauce
        Meal lambChopsWithMint = new Meal("Lamb Chops with Mint Sauce", FoodType.CARNIVORE, List.of(lambChops, freshMint, garlic, oliveOil, lemon),
                List.of(500, 120, 10, 60, 28), "1. Season lamb chops with salt, pepper, and minced garlic.\n" +
                "2. Grill lamb chops to your desired doneness.\n" +
                "3. Mix fresh mint, minced garlic, olive oil, and lemon juice to create a mint sauce.\n" +
                "4. Serve lamb chops with the mint sauce drizzled on top.");

// 37. Chicken Parmesan
        Meal chickenParmesan = new Meal("Chicken Parmesan", FoodType.CARNIVORE, List.of(chickenBreast, marinaraSauce, mozzarellaCheese, parmesanCheese, breadCrumbs),
                List.of(400, 480, 240, 120, 240), "1. Preheat the oven to 375°F (190°C).\n" +
                "2. Bread chicken breasts with breadcrumbs.\n" +
                "3. Bake the breaded chicken in the oven until cooked through.\n" +
                "4. Top each chicken breast with marinara sauce and shredded mozzarella.\n" +
                "5. Bake until the cheese is melted and bubbly.\n" +
                "6. Garnish with grated Parmesan and fresh basil before serving.");

// 38. Bacon-Wrapped Shrimp Skewers
        Meal baconWrappedShrimp = new Meal("Bacon-Wrapped Shrimp Skewers", FoodType.CARNIVORE, List.of(shrimp, baconStrips, garlicPowder, paprika),
                List.of(500, 250, 6, 6), "1. Preheat the grill or oven to medium-high heat.\n" +
                "2. Season shrimp with garlic powder and paprika.\n" +
                "3. Wrap each shrimp with a strip of bacon and thread onto skewers.\n" +
                "4. Grill or bake until the bacon is crispy and the shrimp is cooked through.\n" +
                "5. Brush with olive oil before serving.");

// 39. Beef and Mushroom Stroganoff
        Meal beefStroganoff = new Meal("Beef and Mushroom Stroganoff", FoodType.CARNIVORE, List.of(sirloinSteak, mushrooms, onion, sourCream, dijonMustard),
                List.of(400, 250, 170, 240, 28), "1. In a pan, sauté thinly sliced beef until browned.\n" +
                "2. Remove beef from the pan and sauté sliced mushrooms and diced onions.\n" +
                "3. Deglaze the pan with sour cream and add Dijon mustard.\n" +
                "4. Return the cooked beef to the pan and simmer until heated through.\n" +
                "5. Serve over egg noodles or rice.");

// 40. Spicy Grilled Chicken Wings
        Meal spicyChickenWings = new Meal("Spicy Grilled Chicken Wings", FoodType.CARNIVORE, List.of(chickenWings, hotSauce, butter, garlicPowder, cayennePepper),
                List.of(1000, 120, 60, 6, 3), "1. Preheat the grill to medium-high heat.\n" +
                "2. Toss chicken wings in a mixture of melted butter, hot sauce, garlic powder, and cayenne pepper.\n" +
                "3. Grill the chicken wings until crispy and fully cooked.\n" +
                "4. Serve with your favorite dipping sauce.");

        Diet dietNormal = new Diet("Basic diet", List.of(
                spaghettiBolognese, chickenCaesarWrap, mushroomRisotto, beefVegetableStirFry, hawaiianChickenSkewers, tunaNicoiseSalad, chickenFajitas, sushiBowl, turkeyAvocadoWrap, chickenNoodleSoup),
                FoodType.NORMAL, "High in meat carnivorous diet!", List.of());
        Diet dietCarnivorous = new Diet("Sigma Carnivore", List.of(
                chickenNoodleSoup, steakWithGarlicButter, bbqRibs, grilledChickenBreast, beefStirFry, carnitasTacos, lambChopsWithMint, chickenParmesan, baconWrappedShrimp, beefStroganoff, spicyChickenWings),
                FoodType.CARNIVORE, "Normal diet with a perfect mix of meat and vegetables.",   List.of());
        Diet dietSemiCarni = new Diet("Semi Carnivore", List.of(
                mushroomRisotto, tacoSalad, bbqPulledPorkSandwich, greekGyroWrap, porkFriedRice, beefTacos, sushiBowl, bbqRibs, spicyChickenWings, beefStirFry),
                FoodType.NORMAL, "High on vegetables diet with a bit of meat.", List.of());
        Diet dietVeganAbsolutely = new Diet("Absolutely Vegan",List.of(
                sweetPotatoBlackBeanBowl, lentilSoup, chickpeaCurry),
                FoodType.VEGAN, "Try Vegan Diet, with no animal products.", List.of());
        Diet dietVegetarianSea = new Diet("Vegetarian diet with sea food", List.of(
                salmonQuinoaBowl, shrimpBroccoliAlfredo, vegetarianMushroomRisotto, caesarSaladGrilledShrimp, teriyakiSalmonBowl, tunaNicoiseSalad, shrimpScampi, sushiBowl),
                FoodType.VEGETARIAN, "Normal Vegetarian Diet with a bit of sea food and animal producet products", List.of());
        Diet dietVegetarianNoMeat = new Diet("No meat or fish Vegan diet", List.of(
                vegetarianStirFry, capreseSalad, vegetarianMushroomRisotto, veggieOmelette, pestoPastaCherryTomatoes, mediterraneanQuinoaSalad, chickpeaCurry, eggplantParmesan, vegetableLasagna),
                FoodType.VEGETARIAN, "Vegan diet with absolutely no meat or fish", List.of());

        ingredientRepository.saveAll(List.of(beefStrips, chickenBreast, chickenStrips, eggs, grilledChickenStrips, grilledShrimp, groundBeef,
                groundTurkey, gyroMeat, hardBoiledEggs, pork, pulledPork, salmonFillet, shrimp, tuna, turkeySlices, sirloinSteak,
                porkRibs, porkShoulder, baconStrips, lambChops, chickenWings, cheddarCheese, fetaCheese, mozzarellaCheese, parmesanCheese,
                ricottaCheese, tofu, butter, sourCream, avocado, basil, blackBeans, broccoli, carrots, celery, cherryTomatoes, chickpeas,
                coleslaw, corn, cucumber, eggplantSlices, freshBasil, garlic, ginger, greenBeans, kalamataOlives, kale, lemon, lentils,
                lettuce, lime, mixedGreens, mushrooms, onion, orange, parsley, pickles, pineappleChunks, potatoes, redBellPeppers, redOnion,
                romaineLettuce, rosemary, scallions, snowPeas, spinach, sweetPotatoes, tomatoes, zucchini, arborioRice, brownRice, cornTortillas,
                fettuccinePasta, flourTortillas, hamburgerBun, jasmineRice, lasagnaPasta, linguinePasta, pennePasta, pitaBread, quinoa,
                spaghettiPasta, sushiRice, tagliatellePasta, wholeWheatWrap, alfredoSauce, BBQSauce, caesarDressing, dijonMustard, hotSauce,
                marinaraSauce, pestoSauce, salsa, teriyakiSauce, tomatoSauce, tzatzikiSauce, balsamicGlaze, brownSugar, breadCrumbs, cayennePepper,
                chickenBroth, chiliPowder, coconutMilk, croutons, cumin, curryPowder, freshMint, garlicPowder, vegetableBroth, mixedHerbs, oliveOil,
                paprika, pineNuts, soySauce, tacoSeasoning, whiteWine));

        mealRepository.saveAll(List.of(spaghettiBolognese, vegetarianStirFry, salmonQuinoaBowl, capreseSalad, chickenCaesarWrap, shrimpBroccoliAlfredo, mushroomRisotto,
                vegetarianMushroomRisotto, tacoSalad, veggieOmelette, beefVegetableStirFry, caesarSaladGrilledShrimp, pestoPastaCherryTomatoes,
                hawaiianChickenSkewers, sweetPotatoBlackBeanBowl, lentilSoup, bbqPulledPorkSandwich, greekGyroWrap, teriyakiSalmonBowl,
                mediterraneanQuinoaSalad, chickpeaCurry, tunaNicoiseSalad, porkFriedRice, chickenFajitas, eggplantParmesan, beefTacos, shrimpScampi,
                sushiBowl, vegetableLasagna, turkeyAvocadoWrap, chickenNoodleSoup, steakWithGarlicButter, bbqRibs, grilledChickenBreast, beefStirFry,
                carnitasTacos, lambChopsWithMint, chickenParmesan, baconWrappedShrimp, beefStroganoff, spicyChickenWings));

        dietRepository.saveAll(List.of(dietNormal, dietCarnivorous, dietSemiCarni, dietVeganAbsolutely, dietVegetarianSea, dietVegetarianNoMeat));
*/
    }
}
