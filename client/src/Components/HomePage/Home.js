import React, { useState } from "react";
import './Home.css'
import HomePageLoggedIn from './HomePageLoggedIn.js';
import HomePageLoggedOut from './HomePageLoggedOut.js';


const Home = ({user, isLoggedIn}) => {
    // const [isLoggedIn, setLoginState] = useState(false);
    const handleLoginChange = (bool) => {
        // setLoginState(bool);
      };
    return (   
          <main>           
            <div>
            {isLoggedIn ?
                <HomePageLoggedIn user={user}/>
                :
                <HomePageLoggedOut/>
            }
        </div>          
          </main>
    );
};

export default Home;