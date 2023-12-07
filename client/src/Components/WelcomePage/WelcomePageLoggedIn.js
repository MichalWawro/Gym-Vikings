import React, { useState } from "react";
import Training from "../TrainingComponents/Training";

const WelcomePageLoggedIn = ({user}) => {



    const[training, setTraining] = useState(null);


    function fetchTraining(){
        fetch(`http://localhost:8080/training/provideNextTraining?userId=${user.id}`)
        .then(res=> res.json())
        .then(data => {
            console.log(data)
            setTraining(data)
        })
        .catch(e=>console.error(e))
    }


    return (
        <>
        {training ? 
        (
        <Training training={training} userId={user.id}/>
        )
        :
        (
        <div className="content">
            <h1 className="BorderedRubik">Hello {user.name}</h1>
            <div className="MainButtonContainer">

                    <button id='ChoiceButton' className="MainButton" type="button" onClick={()=>fetchTraining()}>Start your training</button>
                    

                {user.diets.length > 0 ?
                    <button id='ChoiceButton' className="MainButton" type="button">Your next meal is</button>
                    // Tutaj router do strony z detalami kolejnego posiłku
                    :
                    <button id='ChoiceButton' className="MainButton" type="button">Let's choose a diet!</button>
                    //Tutaj router do strony, która pomaga wybrać dietę
                }
            </div>
        </div>
        )
    }
</>
    );
};

export default WelcomePageLoggedIn;