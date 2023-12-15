import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';
import image2 from '../../assets/spaghetti.jpg';

const DietsLoggedOut = ({ }) => {
    const navigate = useNavigate();

    return (
        <div class="wrapper">
            <div class="cards">
                <button class="card" onClick={() => navigate("/training")}>
                    <img src={image} alt="" />
                    <h2>Training</h2>
                    <p>Join our training program that will help you get sheredded in no time</p>
                </button>
                <button class="card" onClick={() => navigate("/diets")}>
                    <img src={image2} alt="" />
                        <h2>Diets</h2>
                        <p>Our app offers a variety of diets for all of your foody needs</p>
                </button>
            </div >
        </div >
    );
}

export default DietsLoggedOut;