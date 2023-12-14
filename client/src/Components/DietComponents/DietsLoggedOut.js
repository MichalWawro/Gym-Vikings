import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';

const DietsLoggedOut = ({}) => {
    const navigate = useNavigate();

    return(
        <div>
            <h1>Here will be info about our diets '2nd panel'</h1>
        </div>
    );
}

export default DietsLoggedOut;