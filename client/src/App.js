import React, { useState } from "react";
import { Route, Routes } from 'react-router-dom';
import './App.css';
import './Components/Contact/ContactPage.css';
import './Components/About/AboutPage.css';
import Home from './Components/Home';
import Form from './Components/Register/Form';
import NavBar from './Components/NavBar/NavBar';
import Footer from './Components/Footer/Footer';
//import UserData from "./Components/Register/UserData";
// import InputField from './Components/InputField';
import AboutPage from "./Components/About/AboutPage";
import ContactPage from "./Components/Contact/ContactPage";

function App() {
  const [isLoggedIn, setLoginState] = useState(false);
  const handleLoginChange = (bool) => {
    setLoginState(bool);
  };

  return(
    <div>
    <div className="App">
      <header className="App-header">
        <NavBar isLoggedIn={isLoggedIn} handleLoginChange={handleLoginChange} />
        {
         
        }
      </header>
    <Routes>
      <Route path='/' element={<Home/>}></Route>
      <Route path='contact' element={<ContactPage/>}></Route>
      <Route path='register' element={<Form/>}></Route>
      <Route path='about' element={<AboutPage/>}></Route>

    </Routes>
    
    <footer className="App-footer">
          <Footer />
        </footer>
      </div>
    </div>

  );
}

export default App;