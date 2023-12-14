import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';

const DietsLoggedIn = ({ user }) => {
    const [readyToLoad, setReady] = useEffect(false);
    const [userDiets, setUserDiets] = useEffect(null);
    const navigate = useNavigate();

    //fetch diets od user.id
    //.then (setReady(true))

    return (
        <div>
            {readyToLoad ? (
                userDiets == null ? (
                    <div >
                        <h1>Here will be shown user diets '4th panel'</h1>
                    </div>
                ) : (
                    <div>
                        <h1>Here will be shown no diets info '3rd panel'</h1>
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