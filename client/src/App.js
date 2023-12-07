import React, { useState, useEffect } from "react";
import { Route, Routes } from 'react-router-dom';
import './App.css';
import './Components/Contact/ContactPage.css';
import './Components/About/AboutPage.css';
import Home from './Components/HomePage/Home';
import Form from './Components/Register/Form';
import NavBar from './Components/NavBar/NavBar';
import Footer from './Components/Footer/Footer';
//import UserData from "./Components/Register/UserData";
//import InputField from './Components/InputField';
import AboutPage from "./Components/About/AboutPage";
import ContactPage from "./Components/Contact/ContactPage";
import ListOfTrainings from "./Components/TrainingComponents/ListOfTrainings";
import Training from "./Components/TrainingComponents/Training";

function App() {
  const [isLoggedIn, setLoginState] = useState(false);
  const [tryingToSign, setTryingToSign] = useState(false);
  const handleLoginChange = (bool) => {
    setLoginState(bool);
  };

  const [user, setUser] = useState(null);

  
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');


  function fetchUser() {
    fetch(`http://localhost:8080/user/getUserInfo?userId=1`)
      .then(res => res.json())
      .then(data => {
        console.log(data);
        setUser(data)
        // console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",data);
      })
      .catch(e => console.error(e))
  }

  function login(username, password){
    // e.preventDefault()
    fetch(`http://localhost:8080/user/login`, {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({username:username, password:password})
    })
    .then(response => response.json())
    .then(response =>{  
    console.log("tu response:", response)
    console.log("error status:", response.status)
    if(response.status !== 401){
      setTryingToSign(false);
      handleLoginChange(true)
    }
    else{
      alert("incorrect login or password")
    }
    }
    )
    .catch(error =>{
    console.error(error)
    alert("connection error")
  })
  }


  useEffect(() => {
    // fetchUser();
    login();
  }, [])

  return (
    <div>
      <div className="App">
        <header className="App-header">
          <NavBar isLoggedIn={isLoggedIn} tryingToSign={tryingToSign} handleLoginChange={handleLoginChange} login={login} setTryingToSign={setTryingToSign}/>
          {

          }
        </header>
        <Routes>
          <Route path='/' element={<Home user={user} />}></Route>
          <Route path='contact' element={<ContactPage />}></Route>
          <Route path='register' element={<Form />}></Route>
          <Route path='about' element={<AboutPage />}></Route>
          <Route path='trainings' element={<ListOfTrainings user={user} />}></Route>
        </Routes>

      </div>
    </div>

  );
}

export default App;