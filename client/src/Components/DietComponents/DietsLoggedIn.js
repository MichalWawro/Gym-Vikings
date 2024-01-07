import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import viking_eat from '../../assets/viking-eat.jpg';

const DietsLoggedIn = ({ user }) => {
    const [readyToLoad, setReady] = useState(false);
    const [userDiet, setUserDiet] = useState(null);
    const [randomMealNumber, setRandomMealNumber] = useState(0);
    const [allDiets, setAllDiets] = useState(null);
    const [allMeals, setAllMeals] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchDiets();
        fetchMeals();
        console.log('use effect')
        if (user) {
            fetchUserDiet();
        } else {
            setReady(true);
        }
    }, []);

    function fetchUserDiet() {
        fetch(`http://localhost:8080/diet/getDietWithCalories?userId=${user.id}`)
            .then((res) => {
                if (!res.ok) {
                    throw new Error(`HTTP error! Status: ${res.status}`);
                }
                return res.text();
            })
            .then((data) => {
                try {

                    if (!data) {
                        setUserDiet(null);
                        setReady(true);
                    } else {
                        const parsedData = JSON.parse(data);
                        console.log(user.id);
                        console.log(parsedData);
                        setUserDiet(parsedData);
                        getRandomMeal(parsedData);
                        setReady(true);
                    }
                } catch (error) {
                    console.error('Error processing JSON data:', error);
                }
            })
            .catch((e) => console.error(e));
    }

    function fetchDiets() {
        fetch(`http://localhost:8080/diets/getAll`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setAllDiets(data);
            })
            .catch(e => console.error(e))
    }

    function fetchMeals() {
        fetch(`http://localhost:8080/diets/getAllMeals`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setAllMeals(data);
            })
            .catch(e => console.error(e))
    }

    function getDietId(name) {
        console.log(name);
        for(let diet of allDiets) {
            console.log(diet.mealName + ' ' + diet.id + ' ' + name);
            if(diet.dietName === name) {
                navigate('/diets/' + diet.id)
            }
        } 
    }

    function getMealId(name) {
        console.log(name);
        for(let meal of allMeals) {
            console.log(meal.mealName + ' ' + meal.id + ' ' + name);
            if(meal.mealName === name) {
                navigate('/meals/' + meal.id)
            }
        } 
    }


    function getRandomMeal(data) {
        setRandomMealNumber(Math.floor(Math.random() * (data.mealsArray.length)));
    }

    return (
        <div className='main'>
            {readyToLoad ? (
                userDiet == null ? (
                    <div className="wrapper-row-no-diets">
                        <img id='viking-eat' src={viking_eat} alt="" />
                        <div className="wrapper-column-no-diets">
                            <p>Looks like you haven't chosen any diet yet...</p>
                            <button id="button-main-no-diets" onClick={() => navigate('/diets/search')}>Choose a diet!</button>
                        </div>
                    </div>
                ) : (
                    <div className="wrapper-column-logged-in">
                        <div className="wrapper-row">
                            <h1>Your diet:</h1>
                            <button class='card-diets-logged-in' id="your-diet-button" type='button' onClick={() => getDietId(userDiet.dietName)}>
                                <img className='diet-picture' src={userDiet.imageUrl} alt="diet-picture" />
                                <h2>{userDiet.dietName}</h2>
                                <h2>{userDiet.dailyCalories}</h2>
                                <h2>{userDiet.foodType}</h2>
                            </button>
                            <button className='side-button' id="change-diet-button" type='button' onClick={() => navigate('/diets/search')}>Change diet</button>
                        </div>
                        <div className="wrapper-row">
                            <h1>Your next meal:</h1>
                            <button class='card-diets-logged-in' id="your-meal-button" type='button' onClick={() => getMealId(userDiet.mealsArray[randomMealNumber].mealName)}>
                                <h2>{userDiet.mealsArray[randomMealNumber].mealName}</h2>
                                <h2>{userDiet.mealsArray[randomMealNumber].mealCalories}</h2>
                                <h2>{userDiet.mealsArray[randomMealNumber].foodType}</h2>
                            </button>
                            <button className='side-button' id="roll-meal-button" type='button' onClick={() => getRandomMeal(userDiet)}>Roll a new meal</button>
                        </div>
                    </div>
                )
            ) : (
                <div className="centered-text">
                    <h1>Please wait while we load your diet data :D!</h1>
                    <div class="lds-ring"><div></div><div></div><div></div><div></div></div>
                </div>
            )}
        </div >
    );
}

export default DietsLoggedIn;