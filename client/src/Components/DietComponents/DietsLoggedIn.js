import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';
import image from '../../assets/background.png';

const DietsLoggedIn = ({ user }) => {
    const [readyToLoad, setReady] = useState(false);
    const [userDiets, setUserDiets] = useState(null);
    const navigate = useNavigate();

    //fetch diets od user.id
    //.then (setReady(true))

    return (
        <div className='main'>
            {readyToLoad ? (
                userDiets == null ? (
                    <div className="wrapper-row">
                        <img id='viking-eat' src={image} alt="" />
                        <div className="wrapper-column">
                            <p>Description description description description description description description description description description description description description description description description description description</p>
                            <button id="button-main" onClick={() => navigate('/login')}>Let's get it started!</button>
                        </div>
                    </div>
                ) : (
                    <div>
                        <h1>Here will be shown user diets '4th panel'</h1>
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