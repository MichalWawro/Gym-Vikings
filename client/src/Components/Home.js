import React, { useState } from "react";

import WelcomePage from './WelcomePage/WelcomePage';


const Home = () => {
    const [isLoggedIn, setLoginState] = useState(false);
    const handleLoginChange = (bool) => {
        setLoginState(bool);
      };
    return (   
          <main>           
            <WelcomePage isLoggedIn={isLoggedIn} handleLoginChange={handleLoginChange} testUserNumber={1} />            
          </main>
    );
};

export default Home;