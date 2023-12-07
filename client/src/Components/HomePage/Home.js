import React, { useState } from "react";

import HomePageLoggedIn from './HomePageLoggedIn.js';
import HomePageLoggedOut from './HomePageLoggedOut.js';


const Home = ({user}) => {
    const [isLoggedIn, setLoginState] = useState(false);
    const handleLoginChange = (bool) => {
        setLoginState(bool);
      };
    return (   
          <main>           
            <div>
            {isLoggedIn ?
                <HomePageLoggedIn user={user}/>
                :
                <HomePageLoggedOut handleLoginChange={handleLoginChange}/>
            }
        </div>          
          </main>
    );
};

export default Home;