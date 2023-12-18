import { useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from "react";

const NavBarLoggedOut = ({ handleLoginChange, login, tryingToSign, setTryingToSign, setUser, setJwt}) => {
    
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();


    async function handleLogin(){
        // event.preventDefault()
        const postRes = await fetch(`http://localhost:8080/user/login`, {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify({username:username, password:password})
        })
        const data = await postRes.json();
        console.log("Do podglądu -> login data", data)
        console.log("Do podglądu -> login data.user", data.user)
        setUser(data.user)
        setJwt(data.jwt)
    }
        
    function handleUsername(e){
        console.log(e.target.value)
        setUsername(e.target.value)
    }

    function handlePassword(e){
        console.log(e.target.value)
        setPassword(e.target.value)
    }


    

    
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
                            <div className="LoginDivBox" >username:</div>
                            <div>
                                <input className="LoginInputBox" id="LoginInput" onChange={handleUsername} />
                            </div>
                        </div>
                        <div style={{ display: "inline-block" }} >
                            <div className="LoginDivBox" >password:</div>
                            <div>
                                <input className="LoginInputBox" id="PasswordInput" type="password" onChange={handlePassword} />
                            </div>
                        </div>
                    </div>
                    <button id="SignInLoginButton" className="NavButton" type="button" onClick={
                        () => {
                            setTryingToSign(false);
                            handleLoginChange(true);
                            handleLogin(document.getElementById("LoginInput").value, document.getElementById("PasswordInput").value)
                        }}>
                        Login
                    </button>
                </div>

                :
                <button id="SignInButton" className="NavButton" type="button" onClick={() => setTryingToSign(true)}>
                    Login
                </button>
            }

            <button id="RegisterButton" className="NavButton" type="button" onClick={() => navigate("/register")}>
                Register
            </button>
        </div>
    );
};

export default NavBarLoggedOut;