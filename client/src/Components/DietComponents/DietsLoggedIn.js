import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';

const DietsLoggedIn = ({ user }) => {
    const [readyToLoad, setReady] = useState(false);
    const [userDiet, setUserDiet] = useState(null);
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
        fetch(`http://localhost:8080/diet/getDietsFromUser?userId=99`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setUserDiet(data);
                setReady(true);
            })
            .catch(e => console.error(e))
    }

    return (
        <div className='main'>
            {readyToLoad ? (
                userDiet == null ? (
                    <div className="wrapper-row">
                        <img id='viking-eat' src={image} alt="" />
                        <div className="wrapper-column">
                            <p>Description description description description description description description description description description description description description description description description description description</p>
                            <button id="button-main-diets-logged-out" onClick={() => navigate('/login')}>Let's get it started!</button>
                        </div>
                    </div>
                ) : (
                    <div className="wrapper-column-logged-in">
                        <div className="wrapper-row">
                            <h1>Your diet:</h1>
                            <button class='card-diets-logged-in' id="your-diet-button" type='button' onClick={() => navigate('/diets/')}>
                                <img /*src={userDiet.picture}*/ alt="diet-picture"/>
                                <h2>Diet-name-here</h2>
                                <h2>Diet-avg-kcal</h2>
                                <h2>Diet-type?</h2>
                            </button>
                            <button className='side-button' id="change-diet-button" type='button' onClick={() => navigate('/diets/search')}>Change diet</button>
                        </div>
                        <div className="wrapper-row">
                            <h1>Your next meal:</h1>
                            <button class='card-diets-logged-in' id="your-meal-button" type='button' onClick={() => navigate('/meals/')}>
                                <h2>Meal-name-here</h2>
                                <h2>Meal-kcal</h2>
                                <h2>Meal-type?</h2>
                            </button>
                            <button className='side-button' id="roll-meal-button" type='button' onClick={() => console.log('roll meal on backend')}>Roll a new meal</button>
                        </div>
                    </div>
                )
            ) : (
                <div>
                    <h1>Please wait while we load your diet data :D!</h1>
                </div>
            )}
        </div >
    );
}

export default DietsLoggedIn;