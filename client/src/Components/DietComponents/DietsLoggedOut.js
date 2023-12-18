import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';
import image2 from '../../assets/spaghetti.jpg';

const DietsLoggedOut = ({ }) => {
    const navigate = useNavigate();

    return (
        <div class="wrapper-column">
            <div className="text-box-wrapper">
                <img id='image-left' src={image} alt="" />
                <div className="text-box">
                    <p>Description description description description description description description description description description description  description description description description description description description description description description description description description description description description description description</p>
                </div>
            </div>
            <div className="text-box-wrapper">
                <img id='image-right' src={image} alt="" />
                <div className="text-box">
                    <p>Description description description description description description description description description description description  description description description description description description description description description description description description description description description description description description</p>
                </div>
            </div>
            <button id="button-main" onClick={() => navigate('/login')}>Let's get it started!</button>
        </div >
    );
}

export default DietsLoggedOut;