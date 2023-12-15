import React, { useState, useEffect } from "react";
import './Diets.css';
import DietsLoggedIn from "./DietsLoggedIn";
import DietsLoggedOut from "./DietsLoggedOut";

const Diets = ({ user, isLoggedIn }) => {
    /*
    const [allDiets, setAllDiets] = useState([]);
    const [diets, setDiets] = useState(null);
    const [suggestedDiets, setSuggestedDiets] = useState(null);

    useEffect(() => {
        fetchAllDiets();
        fetchUserDiets();
        fetchSuggestedDiets();
    }, []);

    function fetchAllDiets() {
        fetch(`http://localhost:8080/diets/getAll`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setAllDiets(data)
            })
            .catch(e => console.error(e))
    }

    function fetchUserDiets() {
        fetch(`http://localhost:8080/diet/getDietsFromUser?userId=99`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setDiets(data)
            })
            .catch(e => console.error(e))
    }

    function fetchSuggestedDiets() {
        fetch(`http://localhost:8080/diet/suggestDiet?userId=99`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setSuggestedDiets(data)
            })
            .catch(e => console.error(e))
    }
*/

    return (
        <div className='mainDiets'>
            {isLoggedIn ? (
                <DietsLoggedIn user={user}/>
            ) : (
                <DietsLoggedOut/>
            )}
        </div>
    );
};

export default Diets;