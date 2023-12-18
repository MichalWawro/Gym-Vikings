import React, { useState , useEffect} from "react";
import Form from "./Form";
import "./RegisterForm.css";

const Register = ({login}) => {
    const[name, setName] = useState('');
    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');

    const[changeToForm, setChangeToForm] = useState(null);

    const[registeredUser,setRegisteredUser] = useState(null);

    async function handleRegister(event){
        event.preventDefault();
        try{
        const response = await fetch(`http://localhost:8080/user/register`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({username:name, password:password,email:email})
        })

        if (response.ok) {
            const data = await response.json();
            console.log(data);
            setRegisteredUser(data);
            setChangeToForm("no ta");
          } else {
            console.error("Registration failed");
          }
        } catch (error) {
          console.error("Error during registration:", error);
        }
    }


    return (
        <>
        {changeToForm ? 
            (
                <Form registeredUser={registeredUser} login={login}></Form>
            )
            :
            (        <div className="container">
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
                </form>
            </div>
        </div>
        )
        }
        </>


    );
};

export default Register;