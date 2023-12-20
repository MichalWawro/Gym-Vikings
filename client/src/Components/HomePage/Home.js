import React, { useEffect, useState } from "react";
import './Home.css'
import HomePageLoggedIn from './HomePageLoggedIn.js';
import HomePageLoggedOut from './HomePageLoggedOut.js';


const Home = ({user}) => {

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