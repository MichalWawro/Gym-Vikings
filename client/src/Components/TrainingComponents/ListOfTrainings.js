import { useEffect, useState } from "react";
import Training from "./Training";
import TrainingIcon from "./TrainingIcon";
import { useNavigate } from 'react-router-dom';
import image_left from '../../assets/viking-left.jpg';
import image_right from '../../assets/viking-right.jpg';
import TrainingFromIcon from "./TrainingFromIcon";
import './ListOfTrainings.css'
import FillTheForm from "../FillTheForm";

function ListOfTrainings({ user, setPickedTraining }) {
    const navigate = useNavigate();

    function validateFormDone(user) {
        if (user.trainings.length == 0) {
            return (<FillTheForm />)
        } else {
            return (
                <div className="list-of-trainings">
                    {user.trainings.map((training, index) => <TrainingIcon training={training} setPickedTraining={setPickedTraining} index={index} />)}
                </div>
            )
        }
    }

    useEffect(() => {
        console.log("----------LISTA TRENINGOW-----------------", user)
    }, [])

    return (

        <>
            {user ? (
                validateFormDone(user)
            ) : (
                <div class="wrapper-column">
                    <div className="text-box-wrapper-logged-out">
                        <img id='image-left' src={image_left} alt="" />
                        <div className="text-box">
                            <p>Explore a world of fitness possibilities with our app's diverse range of training programs. Whether you're aiming to shed pounds, build strength, or enhance your overall well-being, we've got the perfect workout plans for you.</p>
                        </div>
                    </div>
                    <div className="text-box-wrapper-logged-out">
                        <img id='image-right' src={image_right} alt="" />
                        <div className="text-box">
                            <p>From beginner-friendly routines to advanced challenges, our app caters to all fitness levels. Start your journey to a healthier, stronger you today!"</p>
                        </div>
                    </div>
                    <button id="button-main-logged-out" onClick={() => navigate('/register')}>Click to make an account!</button>
                </div >
            )}
        </>
    )
}
export default ListOfTrainings;