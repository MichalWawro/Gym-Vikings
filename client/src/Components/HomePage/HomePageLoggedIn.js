import React, { useState } from "react";
import Training from "../TrainingComponents/Training";

const HomePageLoggedIn = ({ user }) => {
    const [training, setTraining] = useState(null);
    const [meal, setMeal] = useState(null);

    useEffect(() => {
        fetchNextMeal();
      }, []);

    function fetchUserTraining() {
        fetch(`http://localhost:8080/training/provideNextTraining?userId=${user.id}`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setTraining(data)
            })
            .catch(e => console.error(e))
    }

    function fetchNextMeal() {
        fetch(`http://localhost:8080/diet/provideNextMeal?userId=${user.id}`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setMeal(data)
            })
            .catch(e => console.error(e))
    }

    return (
        <>
            {training ?
                (
                    <Training training={training} userId={user.id} />
                )
                :
                (
                    <div className="content">
                        <h1 className="BorderedRubik">Hello {user.name}</h1>
                        <div className="MainButtonContainer">

                            <button id='ChoiceButton' className="MainButton" type="button" onClick={() => fetchUserTraining()}>Start your training</button>


                            {user.diets.length > 0 ?
                                <button id='ChoiceButton' className="MainButton" type="button" onClick={() => navigate("/diets")}>Your next meal is: {meal.mealName}</button>
                                // Tutaj router do strony z detalami kolejnego posiłku
                                :
                                <button id='ChoiceButton' className="MainButton" type="button" onClick={() => navigate("/diets")}>Let's choose a diet!</button>
                                //Tutaj router do strony, która pomaga wybrać dietę
                            }
                        </div>
                    </div>
                )
            }
        </>
    );
};

export default HomePageLoggedIn;