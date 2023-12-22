import { useState } from "react"
import Training from "./Training";
import TrainingFromIcon from "./TrainingFromIcon";
import { useNavigate } from 'react-router-dom';
import './TrainingIcon.css'


function TrainingIcon({ training, setPickedTraining, index}) {
    const navigate = useNavigate()

    const Viking = require(`../../assets/vikinglogo${index + 1}.png`);

    return (
        <>
            <div className="training-icon">
                <div className="trainer-div">
                    <h2 className="your-trainer">Your trainer:</h2>
                    <img className="trainer-image" src={Viking} width={250} height={250} />
                </div>
                <br></br>
                <div className="training-icon-details">
                    <h1 className="training-name">{training.name}</h1>
                    <h2 className="training-difficulty">Exercises:</h2>
                    {training.exercises.map((exercise, index) => <h3>{exercise.name}</h3>)}
                </div>
                <br></br>
                <button className='icon-button' onClick={() => {
                    setPickedTraining(training)
                    navigate("trainingFromList")
                }}>Start Training</button>
            </div>
        </>
    )
}

export default TrainingIcon;