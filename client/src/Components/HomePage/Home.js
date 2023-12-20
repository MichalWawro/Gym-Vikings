import React, { useEffect, useState } from "react";
import './Home.css'
import HomePageLoggedIn from './HomePageLoggedIn.js';
import HomePageLoggedOut from './HomePageLoggedOut.js';


const Home = ({user, isLoggedIn}) => {
  useEffect(() => {
    document.title = 'Gym Viking: Home';
  }, [])

    // const [isLoggedIn, setLoginState] = useState(false);
    const handleLoginChange = (bool) => {
        // setLoginState(bool);
      };
    return (   
          <main>           
            <div>
            {isLoggedIn ?
                <HomePageLoggedIn/>
                :
                <HomePageLoggedOut/>
            }
        </div>          
          </main>
    );
};

export default Home;