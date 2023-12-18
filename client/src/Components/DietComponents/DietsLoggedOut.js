import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';
import image2 from '../../assets/spaghetti.jpg';

const DietsLoggedOut = ({ }) => {
    const navigate = useNavigate();

    useEffect(() => {
        console.log('use effectxdxddxdddxd')

    }, []);

    return (
        <div class="wrapper-column">
            <div className="text-box-wrapper-logged-out">
                <img id='image-left' src={image} alt="" />
                <div className="text-box">
                    <p>Our app offers a variety of diets for all your foody needs</p>
                </div>
            </div>
            <div className="text-box-wrapper-logged-out">
                <img id='image-right' src={image} alt="" />
                <div className="text-box">
                    <p>Whether you want to lose weight or gain some muscles with us you can choose a diet that will help you achieve your dream goal</p>
                </div>
            </div>
            <button id="button-main-logged-out" onClick={() => navigate('/register')}>Click to make an account!</button>
        </div >
    );
}

export default DietsLoggedOut;