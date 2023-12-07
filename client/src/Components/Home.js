import React, { useState } from "react";

import WelcomePage from './WelcomePage/WelcomePage';


const Home = ({user}) => {
    const [isLoggedIn, setLoginState] = useState(false);
    const handleLoginChange = (bool) => {
        setLoginState(bool);
      };
    return (   
          <main>           
            <WelcomePage isLoggedIn={isLoggedIn} handleLoginChange={handleLoginChange} user={user} />            
          </main>
    );
};

export default Home;