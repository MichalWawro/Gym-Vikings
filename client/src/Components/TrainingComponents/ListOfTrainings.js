import { useEffect, useState } from "react";
import Training from "./Training";
import TrainingIcon from "./TrainingIcon";
import TrainingFromIcon from "./TrainingFromIcon";
import './ListOfTrainings.css'
import FillTheForm from "../FillTheForm";

function ListOfTrainings ({user, setPickedTraining}){

    function validateFormDone(user){
        if(user.trainings.length == 0){
            return(<FillTheForm/>)
        }else{
            return(
        <div className="list-of-trainings">
        {user.trainings.map((training, index)=><TrainingIcon training={training} setPickedTraining={setPickedTraining} index={index}/>)}
        </div>
            )
        }
    }

    useEffect(()=>{
        console.log("----------LISTA TRENINGOW-----------------", user)
    },[])

    return (
        <>
        {validateFormDone(user)}
        </>
    )
}
export default ListOfTrainings;