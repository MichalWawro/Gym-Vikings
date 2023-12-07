import { useState } from "react"
import Training from "./Training";

function TrainingIcon ({userId, training, index}){

    const[startTraining, setStartTraining] = useState();

    function getTraining(trainingId){
        fetch(`http://localhost:8080/training/getTrainingFromUser?userId=${userId}&trainingId=${trainingId}`)
        .then(res => res.json())
        .then(data => {
            setStartTraining(data)
        })
        .catch(e=>console.error(e))
    }
    return(
        <>
        {startTraining ? 
        (
        <Training training={startTraining} userId={userId}/>
        )
        :
        (        
        <>
        <h1 className="training-name">{training.name}</h1>
        <h2 className="training-difficulty">Level: {training.level}</h2>
        <button onClick={()=>{getTraining(index + 1)}}>Start</button>
        </>
        )
        }
        </>
    )
}

export default TrainingIcon;