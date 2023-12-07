import React,{useEffect, useState} from "react"
import Exercise from "./Exercise/Exercise";
import './Training.css'

function Training ({training, userId}){


    function trainingDone() {
        fetch(`http://localhost:8080/user/trainingDone?userId=${userId}&trainingId=${training.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(res => res.json())
        .catch(error => {
            console.error('Error:', error);
        });
        
    }


    return(

        <>
        <h1 className="training-name">{training.name}</h1>
        <h2 className="training-difficulty">Level: {training.level}</h2>
        <h2>BodyParts: </h2>
        {training.bodyParts.map((bodyPart,index)=><h3>bodyPart</h3>)}
        {training.exercises.map((exercise,index)=><Exercise exercise={exercise} index={index}/>)}
        <buttton className="end-button" onClick={()=>trainingDone()}>Training Done</buttton>
        </>

    )
}

export default Training;