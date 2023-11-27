import React from 'react';
import './App.css';
import Form from './Components/Register/Form';
import { useState } from 'react';
import './App.css';
import InputField from './Components/InputField';

function App() {
  const [isLoggedIn, changeLoginState] = useState(false);

  const handleLoginChange = (bool) => {
    changeLoginState(bool);
  };

  return (
    <div>
      <div className="App">
        <header className="App-header">
          <button id="AboutButton" className="NavButton" type="button" onClick={() => null}>
            About
          </button>
          <button id="ContactButton" className="NavButton" type="button" onClick={() => null}>
            Contact
          </button>
          {isLoggedIn ? (
            <div>
              <button id="ProfileButton" className="NavButton" type="button" onClick={() => null}>
                Profile
              </button>
              <button id="LogOutButton" className="NavButton" type="button" onClick={() => handleLoginChange(false)}>
                Log Out
              </button>
            </div>
          ) : (
            <div>
              <button id="SignInButton" className="NavButton" type="button" onClick={() => handleLoginChange(true)}>
                Sign In
              </button>
              <button id="RegisterButton" className="NavButton" type="button" onClick={() => null}>
                Register
              </button>
            </div>
          )}
        </header>
        <main>
          <div className="content">
            <h1 className="BorderedRubik">Welcome to our training and fitness app!</h1>
            <p>Click the button below to get started</p>
            <button id="GetStartedButton" className="NavButton" type="button" onClick={() => handleLoginChange(true)}>
              LET'S GET STARTED
            </button>
          </div>
        </main>
        <footer className="App-footer">
          <div>
            <h5>All right company trademark yada yada</h5>
          </div>
        </footer>
      </div>
    </div>
  );
}

export default App;