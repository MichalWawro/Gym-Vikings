import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import viking_image from '../../assets/vikinglogo1.png';

const DietsLoggedIn = ({ user }) => {
    const [readyToLoad, setReady] = useState(false);
    const [userDiet, setUserDiet] = useState(null);
    const [randomMealNumber, setRandomMealNumber] = useState(0);
    const navigate = useNavigate();

    useEffect(() => {
        console.log('use effect')
        if (user != null) {
            fetchUserDiet();
        } else {
            setReady(true);
        }
    }, []);

    function fetchUserDiet() {
        fetch(`http://localhost:8080/diet/getDietWithCalories?userId=1`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setUserDiet(data);
                getRandomMeal(data);
                setReady(true);
            })
            .catch(e => console.error(e))
    }

    function getRandomMeal(data) {
        setRandomMealNumber(Math.floor(Math.random() * (data.mealsArray.length)));
    }

    return (
        <div className='main'>
            {readyToLoad ? (
                userDiet == null ? (
                    <div className="wrapper-row-no-diets">
                        <img id='viking-eat' src={viking_image} alt="" />
                        <div className="wrapper-column-no-diets">
                            <p>Looks like you haven't chosen any diet yet...</p>
                            <button id="button-main-no-diets" onClick={() => navigate('/diet/search')}>Choose a diet!</button>
                        </div>
                    </div>
                ) : (
                    <div className="wrapper-column-logged-in">
                        <div className="wrapper-row">
                            <h1>Your diet:</h1>
                            <button class='card-diets-logged-in' id="your-diet-button" type='button' onClick={() => navigate('/diets/' + userDiet.dietName)}>
                                <img /*src={userDiet.picture}*/ alt="diet-picture"/>
                                <h2>{userDiet.dietName}</h2>
                                <h2>{userDiet.dailyCalories}</h2>
                                <h2>{userDiet.foodType}</h2>
                            </button>
                            <button className='side-button' id="change-diet-button" type='button' onClick={() => navigate('/diets/search')}>Change diet</button>
                        </div>
                        <div className="wrapper-row">
                            <h1>Your next meal:</h1>
                            <button class='card-diets-logged-in' id="your-meal-button" type='button' onClick={() => navigate('/meals/' + userDiet.mealsArray[randomMealNumber].id)}>
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
                </div>
            )}
        </div >
    );
}

export default DietsLoggedIn;