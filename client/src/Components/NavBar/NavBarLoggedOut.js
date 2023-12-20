import { useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from "react";

const NavBarLoggedOut = ({ login, tryingToSign, setTryingToSign, setUser, setJwt}) => {
    
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const[error, setError] = useState(null);

    const navigate = useNavigate();

    async function getUserFromDb(){
        try{
            const getRes = await fetch(`http://localhost:8080/user/getUserInfoByName?name=${username}`)
            const data = await getRes.json()
            console.log("Data z get user from db", data)
            return data.username
        }
        catch(error){
            setError('Wrong username and/or password.');
            console.log(error)
        }
    }


    async function handleLogin(){
        // event.preventDefault()
        const postRes = await fetch(`http://localhost:8080/user/login`, {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify({username:username, password:password})
        })
        const data = await postRes.json();
        console.log("Do podglądu -> login data", data)
        

        const usernameFromDb = await getUserFromDb()

        if(username === usernameFromDb){
            console.log("user exists")
            setUser(data.user)
            setJwt(data.jwt)
            navigate('/')
            
            console.log("Do podglądu -> login data.user", data.user)
        }
        else{
            console.log("user dont exist")
            setLoginState(false);
            setUser("No user")
        }
    }
        
    function handleUsername(e){
        // console.log(e.target.value)
        setUsername(e.target.value)
    }

    function handlePassword(e){
        // console.log(e.target.value)
        setPassword(e.target.value)
    }


    

    
    return (
        <div>

            
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
            {error && <h3 style={{color: 'red'}}>{error}</h3>}
        </div>
    );
};

export default NavBarLoggedOut;