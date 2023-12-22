import React, { useState, useEffect } from "react";
import DietsLoggedIn from "./DietsLoggedIn";
import DietsLoggedOut from "./DietsLoggedOut";

const Diets = ({ user}) => {

    useEffect(() => {
        document.title = 'Gym Viking: Diets';
    }, [])

    return (
        <div className='mainDiets'>
            {user ? (
                <DietsLoggedIn user={user} />
            ) : (
                <DietsLoggedOut />
            )}
        </div>
    );
};

export default Diets;