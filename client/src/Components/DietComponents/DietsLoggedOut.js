import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import sushi from '../../assets/sushi.jpeg';
import steak from '../../assets/steak.jpg';

const DietsLoggedOut = ({ }) => {
    const navigate = useNavigate();

    useEffect(() => {
        console.log('use effectxdxddxdddxd')

    }, []);

    return (
        <div class="wrapper-column">
            <div className="text-box-wrapper-logged-out">
                <img id='image-left' src={steak} alt="" />
                <div className="text-box">
                    <p>Explore a variety of diets tailored to your nutritional goals in our app. Whether you're aiming to lose weight or boost muscle growth, our diverse range of diet plans caters to your unique needs.</p>
                </div>
            </div>
            <div className="text-box-wrapper-logged-out">
                <img id='image-right' src={sushi} alt="" />
                <div className="text-box">
                    <p>Achieve your health and wellness goals with personalized nutrition right at your fingertips!</p>
                </div>
            </div>
            <button id="button-main-logged-out" onClick={() => navigate('/register')}>Click to make an account!</button>
        </div >
    );
}

export default DietsLoggedOut;