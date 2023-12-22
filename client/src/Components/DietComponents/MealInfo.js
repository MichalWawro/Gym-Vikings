import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
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


    useEffect(() => {
        if (!isNaN(Number(index))) {
            fetchMealInfo();
        } else {
            setIsNumber(false);
            setReady(true);
        }
    }, []);

    function fetchMealInfo() {
        fetch(`http://localhost:8080/diets/getMealById?mealId=${index}`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setMealInfo(data);
                ingredientsToString(data.ingredients);
                gramsToString(data.grams);
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
                        <div className="meal-wrapper-column">
                            <div id="meal-name" className="meal-wrapper-row">
                                <h1>Meal Name:</h1>
                                <h1 className="meal-right-side-text">{mealInfo.mealName}</h1>
                            </div>
                            <div id="meal-calories" className="meal-wrapper-row">
                                <h1>Avg. Meal Calories:</h1>
                                <h1 className="meal-right-side-text">{mealInfo.mealCalories}</h1>
                            </div>
                            <div id="meal-type" className="meal-wrapper-row">
                                <h1>Food Type:</h1>
                                <h1 className="meal-right-side-text">{mealInfo.foodType}</h1>
                            </div>
                            <div id="meal-prep" className="meal-wrapper-row">
                                <h1>Prep Instructions:</h1>
                                <h1 className="meal-right-side-text">{mealInfo.perpInstructions}</h1>
                            </div>
                            <div id="meal-ingredients" className="meal-wrapper-row">
                                <h1></h1>
                            </div>
                            <div id="meal-ingredients" className="meal-wrapper-row">
                                <h1><p />Ingredients:</h1>
                                <h1 className="meal-right-side-text"><p />{ingredientsString}</h1>
                            </div>
                            <div id="meal-grams" className="meal-wrapper-row">
                                <h1>Grams:</h1>
                                <h1 className="meal-right-side-text">{gramsString}</h1>
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