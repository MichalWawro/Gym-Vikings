import { useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from "react";

const NavBarLoggedOut = ({ handleLoginChange }) => {
    const navigate = useNavigate();
    const [tryingToSign, setTryingToSign] = useState(false);
    return (
        <div>
            <div className="Spacer" />
            <button id="AboutButton" className="NavButton" type="button" onClick={() => navigate("/about")}>
                About
            </button>
            <button id="ContactButton" className="NavButton" type="button" onClick={() => navigate("/contact")}>
                Contact
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