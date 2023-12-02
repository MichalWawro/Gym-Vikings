import React from 'react';
import { useState } from 'react';
import './App.css';
// import Form from './Components/Register/Form';
// import InputField from './Components/InputField';
import NavBar from './components/NavBar/NavBar';
import WelcomePage from './components/WelcomePage/WelcomePage';
import Footer from './components/Footer/Footer';


function App() {
  const [isLoggedIn, setLoginState] = useState(false);

  const handleLoginChange = (bool) => {
    setLoginState(bool);
  };

  return (
    <div>
      <div className="App">
        <header className="App-header">
          <NavBar isLoggedIn={isLoggedIn} handleLoginChange={handleLoginChange} />
          {/* W przyszłości z routerem */}
        </header>
        <main>
          <WelcomePage isLoggedIn={isLoggedIn} handleLoginChange={handleLoginChange} testUserNumber={1} />
        </main>
        <footer className="App-footer">
          <Footer />
        </footer>
      </div>
    </div>
  );
}

export default App;