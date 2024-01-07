import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import './DietInfo.css';

const DietInfo = () => {
    const [dietInfo, setDietInfo] = useState([]);
    const [allDiets, setAllDiets] = useState([]);
    const [mealIndex, setMealIndex] = useState(0);
    const [readyToLoad, setReady] = useState(null);
    const { index } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        fetchDietInfo();
        // fetchAllDiets();
    }, []);

    function fetchDietInfo() {
        fetch(`http://localhost:8080/diets/getDietById?dietId=${index}`)
            .then(res => res.json())
            .then(data => {
                console.log('xd')
                console.log(data);
                setDietInfo(data);
                setReady(true);
            })
            .catch(e => console.error(e))
    }

    function fetchAllDiets() {
        fetch(`http://localhost:8080/diets/getAll`)
            .then(res => {
                if (!res.ok) {
                    throw new Error(`HTTP error! Status: ${res.status}`);
                }
                return res.json();
            })
            .then(data => {
                console.log(data);
                setAllDiets(data);
            })
            .catch(e => console.error(e));
    }

    function getMeal(int) {
        if ((mealIndex + int) < 0) {
            setMealIndex(dietInfo.mealsArray.length - 1) //Last meal
        } else if ((mealIndex + int) > dietInfo.mealsArray.length - 1) {
            setMealIndex(0)
        } else {
            setMealIndex(mealIndex + int)
        }

        console.log(mealIndex)
    }

    return (
        <div className="DietInfoPage">
            {readyToLoad ? (
                <div className="diet-wrapper-column">
                    <img className='diets-diet-picture' src={dietInfo.imageUrl} alt="diet-picture" />
                    <div className="diet-wrapper-right-column">
                        <div id="diet-name" className="diet-wrapper-row">
                            <h1>Diet Name:</h1>
                            <h1 className="diet-right-side-text">{dietInfo.dietName}</h1>
                        </div>
                        <div id="diet-type" className="diet-wrapper-row">
                            <h1>Diet Type:</h1>
                            <h1 className="diet-right-side-text">{dietInfo.foodType}</h1>
                        </div>
                    </div>
                    <h1 id="diet-meal-text">Your next meal:</h1>
                    <div className="diet-wrapper-row-meal">
                        <button id='diets-left-side-button' className="next-meal-button" type='button' onClick={() => getMeal(-1)}>Previous Meal</button>
                        <button class='card-diets-logged-in' id="diets-your-meal-button" type='button' onClick={() => navigate('/meals/' + dietInfo.mealsArray[mealIndex].id)}>
                            <h2>{dietInfo.mealsArray[mealIndex].mealName}</h2>
                            <h2>Avg. Calories {dietInfo.mealsArray[mealIndex].mealCalories}</h2>
                            <h2>{dietInfo.mealsArray[mealIndex].foodType}</h2>
                        </button>
                        <button id='diets-right-side-button' className="next-meal-button" type='button' onClick={() => getMeal(1)}>Next Meal</button>
                    </div>
                </div>

            ) : (
                <div className="centered-text">
                    <h1>We're fetching a diet for you, give us a moment</h1>
                </div>
            )
            }

        </div>
    )
}

export default DietInfo;