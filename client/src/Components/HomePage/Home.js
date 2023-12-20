import React, { useEffect, useState } from "react";
import './Home.css'
import HomePageLoggedIn from './HomePageLoggedIn.js';
import HomePageLoggedOut from './HomePageLoggedOut.js';


const Home = ({user}) => {
  useEffect(() => {
    document.title = 'Gym Viking: Home';
  }, [])

    return (   
          <main>           
            <div>
            {user ?
                <HomePageLoggedIn user={user}/>
                :
                <HomePageLoggedOut/>
            }
        </div>          
          </main>
    );
};

export default Home;