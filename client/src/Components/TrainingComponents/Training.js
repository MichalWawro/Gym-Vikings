import React, { useEffect, useState } from "react"
import Exercise from "./Exercise/Exercise";
import './Training.css'
import FillTheForm from "../FillTheForm";
import { useNavigate } from "react-router-dom";
import Info from './Info';

function Training({ user, setUser }) {
    const navigate = useNavigate()
    const [begginingInfo, setBegginingInfo] = useState(false);
    const [training, setTraining] = useState();




    function provideNextTraining() {
        fetch(`http://localhost:8080/training/provideNextTraining?userId=${user.id}`)
            .then(res => res.json())
            .then(data => {
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
            .then(data=>{
                setUser(data);
                navigate('/')
            })
            .catch(error => {
                console.error('Error:', error);
            });

    }

    useEffect(() => {
        console.log('tu zaczyna sie trening')
        provideNextTraining();
    }, [])




    function validateFormDone(user) {
        if (user.age == 0 || user.gender == null || user.weight == 0 || user.height == 0 || user.level == null) {
            return (<FillTheForm />)
        } else {
            return (<>
                {begginingInfo == true?
                    (training ?
                        (<div className="training">
                            <h1 className="training-name">{training.name}</h1>
                            <h2>BodyParts: </h2>
                            {training.bodyParts.map((bodyPart, index) => <h3>{bodyPart}</h3>)}
                            {training.exercises.map((exercise, index) => <Exercise exercise={exercise} index={index} />)}
                            <div className="end-button-padding">
                                <button className="end-button" onClick={() => {trainingDone()}}>Training Done</button>
                            </div>
                        </div>
                        )
                        :
                        (<>
                            <div className="waiting">
                                <h1>Wait... your training being prepared</h1>
                                <div class="lds-ring"><div></div><div></div><div></div><div></div></div>
                            </div>
                        </>)
                    )
                    :
                    (
                        <Info setBegginingInfo={setBegginingInfo} />
                    )
                }
            </>
            )
        }
    }

    return (<>
        {validateFormDone(user)}
    </>

    )
}

export default Training;