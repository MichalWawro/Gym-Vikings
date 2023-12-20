import React,{useEffect, useState} from "react"
import Exercise from "./Exercise/Exercise";
import './Training.css'


function Training ({user}){
    const[congratulations, setCongratulations] = useState();
    const[training, setTraining] = useState();

    function provideNextTraining(){
        fetch(`http://localhost:8080/training/provideNextTraining?userId=${user.id}`)
        .then(res => res.json())
        .then(data=>{
            console.log("---------------------------------TRENING-------------------------------------- " + data)
            setTraining(data)
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    function trainingDone() {
        fetch(`http://localhost:8080/user/trainingDone?userId=${user.id}&trainingId=${training.id}`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json',
            },
        })
        .then(res => res.json())
        .catch(error => {
            console.error('Error:', error);
        });
        
    }

    useEffect(()=>{
        console.log('tu zaczyna sie trening')
        provideNextTraining();
    },[])


    return(<>
        
        {training ? 
        (<>
        <h1 className="training-name">{training.name}</h1>
        <h2>BodyParts: </h2>
        {training.bodyParts.map((bodyPart,index)=><h3>{bodyPart}</h3>)}
        {training.exercises.map((exercise,index)=><Exercise exercise={exercise} index={index}/>)}
        <buttton className="end-button" onClick={()=>{trainingDone()
        setCongratulations("git")
        }}>Training Done</buttton>
        </>
        )
        :
        (<>
        <h1>Wait... your training being prepared</h1>
        </>)
        }
        
        
        </>

    )
}

export default Training;