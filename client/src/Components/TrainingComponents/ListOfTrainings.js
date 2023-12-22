import { useEffect, useState } from "react";
import Training from "./Training";
import TrainingIcon from "./TrainingIcon";
import { useNavigate } from 'react-router-dom';
import image_left from '../../assets/viking-left.jpg';
import image_right from '../../assets/viking-right.jpg';


function ListOfTrainings({ user }) {
    const navigate = useNavigate();

    useEffect(() => {
        console.log("----------LISTA TRENINGOW-----------------", user)
    }, [])

    return (

        <>
            {user ? (

                user.trainings.map((training, index) => <TrainingIcon userId={user.id} training={training} index={index} />)

            ) : (
                <div class="wrapper-column">
                <div className="text-box-wrapper-logged-out">
                    <img id='image-left' src={image_left} alt="" />
                    <div className="text-box">
                        <p>Our app offers a variety of diets for all your foody needs</p>
                    </div>
                </div>
                <div className="text-box-wrapper-logged-out">
                    <img id='image-right' src={image_right} alt="" />
                    <div className="text-box">
                        <p>Whether you want to lose weight or gain some muscles with us you can choose a diet that will help you achieve your dream goal</p>
                    </div>
                </div>
                <button id="button-main-logged-out" onClick={() => navigate('/register')}>Click to make an account!</button>
            </div >
            )}
        </>
    )
}
export default ListOfTrainings;