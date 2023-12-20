import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import './MealInfo.css';
import './Diets.css';
import '../../App.css';

const DietInfo = () => {
    const [mealInfo, setMealInfo] = useState([]);
    const [ingredientsString, setIngredientsString] = useState([]);
    const [gramsString, setGramsString] = useState([]);
    const [isIndexNumber, setIsNumber] = useState(true);
    const [readyToLoad, setReady] = useState(false);
    const { index } = useParams();
    const navigate = useNavigate();


    useEffect(() => {
        getIndex();
        if (!isNaN(Number(index))) {
            fetchMealInfo();
        } else {
            setIsNumber(false);
            setReady(true);
        }
    }, []);

    function getIndex() {
        // console.log(index)
    }

    function fetchMealInfo() {
        fetch(`http://localhost:8080/meals/getMealById?mealId=${index}`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setMealInfo(data);
                setReady(true);
            })
            .catch(e => console.error(e))
    }



    function ingredientsToString(ingredientsArray) {
        console.log(ingredientsArray);
        let returnString = '| ';
        for (let i = 0; i < ingredientsArray.length; i++) {
            returnString += ingredientsArray[i].name;
            returnString += `\n| `;
        }
        setIngredientsString(returnString);
    }

    function gramsToString(gramsArray) {
        console.log(gramsArray);
        let returnString = '| ';
        for (let i = 0; i < gramsArray.length; i++) {
            returnString += gramsArray[i];
            returnString += `\n| `;
        }
        setGramsString(returnString);
    }

    return (
        <div className="MealInfoPage">
            {readyToLoad ?
                (isIndexNumber ?
                    (
                        <div className="MealInfoPage">
                            <div className="LeftHalfMealInfo">
                                <h1><p />Meal Name:</h1>
                                <h1><p />Meal Calories:</h1>
                                <h1><p />Food Type:</h1>
                                <h1><p />Prep Instructions:</h1>
                                <h1><p />      _</h1>
                                <h1><p />Ingredients:</h1>
                                <h1><p />Grams:</h1>
                                {/* <h1><p/>{mealInfo.ingredients}</h1> */}
                                {/* <h1><p/>{mealInfo.grams}</h1> */}
                            </div>
                            <div className="RightHalfMealInfo">
                                <h1><p />{mealInfo.mealName}</h1>
                                <h1><p />Meal Calories: {mealInfo.mealCalories}</h1>
                                <h1><p />{mealInfo.foodType}</h1>
                                <h1><p />{mealInfo.perpInstructions}</h1>
                                <h1><p />{ingredientsString}</h1>
                                <h1><p />{gramsString}</h1>
                            </div>
                        </div>
                    ) : (
                        <div className="centered-text">
                            <h1>Seems like your index is not a number :/</h1>
                        </div>
                    )
                ) : (
                    <div className="centered-text">
                        <h1>We're fetching a meal for you, give us a moment :D</h1>
                    </div>
                )
            }
        </div >
    )
}

export default DietInfo;