import React, { useState, useEffect } from "react";
import Training from "../TrainingComponents/Training";
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';
import image2 from '../../assets/spaghetti.jpg';

const HomePageLoggedIn = ({}) => {
    const [training, setTraining] = useState(null);
    const [meal, setMeal] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        // fetchNextMeal();
      }, []);

    // function fetchUserTraining() {
    //     fetch(`http://localhost:8080/training/provideNextTraining?userId=${user.id}`)
    //         .then(res => res.json())
    //         .then(data => {
    //             console.log(data)
    //             setTraining(data)
    //         })
    //         .catch(e => console.error(e))
    // }

    // function fetchNextMeal() {
    //     fetch(`http://localhost:8080/diet/provideNextMeal?userId=${user.id}`)
    //         .then(res => res.json())
    //         .then(data => {
    //             console.log(data)
    //             setMeal(data)
    //         })
    //         .catch(e => console.error(e))
    // }

    return (
        <div className="wrapper">
            <div className="cards">
                <button className="card" onClick={() => navigate("/training")}>
                    <img src={image} alt="" />
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
    );
};

export default HomePageLoggedIn;