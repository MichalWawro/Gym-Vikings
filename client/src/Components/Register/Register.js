import React, { useState , useEffect} from "react";
import Form from "./Form";
import Home from "../HomePage/Home"
import "./RegisterForm.css";
import { useNavigate } from 'react-router-dom';
const Register = () => {
    const[name, setName] = useState('');
    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');
    const[error, setError] = useState(null);

    const navigate = useNavigate()

    useEffect(() => {
        document.title = 'Gym Viking: Register';
      }, [])
  

    async function handleRegister(event){
        event.preventDefault();
        if (isValidEmail(email)) {
            try{
                const response = await fetch(`http://localhost:8080/user/register`, {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify({username:name, password:password,email:email})
                })
                    const data = await response.text()
                    console.log(response.status, data)
                    navigate("/")
                }   
                catch (error) {
                console.error("Error during registration:", error);
                }
        } else {
        setError('Email is invalid');
        }  
    }

    function isValidEmail(email) {
        return /\S+@\S+\.\S+/.test(email);
      }


    return (
        <>
            <div className="container">
            <div className="app-wrapper">
                <div>
                    <h2 className="title">Create Account</h2>
                </div>

                <form className="form-wrapper">
                    <div className="form-group">
                        <label className="label">Name</label>
                        <input
                            className="input"
                            type="text"
                            name="name"
                            value={name}
                            onChange={e=>setName(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label className="label">Email</label>
                        <input
                            className="input"
                            type="email"
                            name="email"
                            value={email}
                            onChange={e=>setEmail(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <label className="label">Password</label>
                        <input
                            className="input"
                            type="password"
                            name="password"
                            value={password}
                            onChange={e=>setPassword(e.target.value)}
                        />
                    </div>
                    <div className="form-group">
                        <button className="submit" type="submit" onClick={(e)=>{handleRegister(e)}}>Register</button>
                    </div>
                    {error && <h2 style={{color: 'red'}}>{error}</h2>}
                </form>
            </div>
        </div>
        </>
    );
};

export default Register;