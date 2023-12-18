import { useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from "react";

const NavBarLoggedOut = ({ handleLoginChange, login, tryingToSign, setTryingToSign}) => {
    const navigate = useNavigate();
    
    return (
        <div>
            <div className="Spacer" />
            <button id="TrainingButton" className="NavButton" type="button" onClick={() => navigate("/trainings")}>
                Trainings
            </button>
            <button id="DietButton" className="NavButton" type="button" onClick={() => navigate("/diets")}>
                Diets
            </button>
            {tryingToSign ?

                <div id="MainLoginDiv" >
                    <button id="SignInExitButton" className="NavButton" type="button" onClick={() => setTryingToSign(false)}>
                        X
                    </button>
                    <div id="LoginDiv" >
                        <div style={{ display: "inline-block" }} >
                            <div className="LoginDivBox" >login:</div>
                            <div>
                                <input className="LoginInputBox" id="LoginInput" />
                            </div>
                        </div>
                        <div style={{ display: "inline-block" }} >
                            <div className="LoginDivBox" >password:</div>
                            <div>
                                <input className="LoginInputBox" id="PasswordInput" type="password" />
                            </div>
                        </div>
                    </div>
                    <button id="SignInLoginButton" className="NavButton" type="button" onClick={
                        () => {
                            setTryingToSign(false);
                            handleLoginChange(true);
                            login(document.getElementById("LoginInput").value, document.getElementById("PasswordInput").value)
                        }}>
                        Login
                    </button>
                </div>

                :
                <button id="SignInButton" className="NavButton" type="button" onClick={() => setTryingToSign(true)}>
                    Sign In
                </button>
            }

            <button id="RegisterButton" className="NavButton" type="button" onClick={() => navigate("/register")}>
                Register
            </button>
        </div>
    );
};

export default NavBarLoggedOut;