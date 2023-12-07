import { useEffect, useState } from "react";
import Training from "./Training";
import TrainingIcon from "./TrainingIcon";


function ListOfTrainings ({user}){
    useEffect(()=>{
        console.log("---------------------------", user)
    },[])

    return (
        <>
        {user.trainings.map((training, index)=><TrainingIcon userId={user.id} training={training} index={index}/>)}
        </>
    )
}
export default ListOfTrainings;