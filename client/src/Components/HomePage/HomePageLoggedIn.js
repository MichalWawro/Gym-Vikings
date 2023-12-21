import React, { useState, useEffect } from "react";
import Training from "../TrainingComponents/Training";
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';
import image2 from '../../assets/vikingEating.png';
import image3 from '../../assets/viking.png'

const HomePageLoggedIn = ({user}) => {
    const [training, setTraining] = useState(null);
    const [meal, setMeal] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        console.log("---------------------------HOME PAGE LOGGED IN--------------------------" + user.name)
      }, []);


    return (
        <div className="background-image2">
        <div className="wrapper">
            <div className="cards">
                <button className="card" onClick={() => navigate("/training")}>
                    <img src={image3} alt="" />
                    <h2>Training</h2>
                    <p>Join our training program that will help you get sheredded in no time</p>
                </button>
                <button className="card" onClick={() => navigate("/diets")}>
                    <img src={image2} alt="" />
                        <h2>Diets</h2>
                        <p>Our app offers a variety of diets for all of your foody needs</p>
                </button>
            </div >
        </div >
        </div>
    );
};

export default HomePageLoggedIn;