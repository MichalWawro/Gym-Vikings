import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import './DietInfo.css';

const DietInfo = () => {
    const [allDiets, setAllDiets] = useState([]);
    const [mealIndex, setMealIndex] = useState(null);
    const { index } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        getIndex();
        fetchAllDiets();
    }, []);

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
                getRandomMeal(index);
            })
            .catch(e => console.error(e));
    }

    function getIndex() {
        console.log(index)
    }

    function addDiet(dietId) {
        fetch(`http://localhost:8080/user/setDiet?userId=99&dietId=${dietId}`, {
            method: 'PATCH',
            headers: { 'Content-Type': 'application/json' }
        })
            .then(res => {
                if (!res.ok) {
                    throw new Error(`HTTP error! Status: ${res.status}`);
                }
                return res.text();
            })
            .then(data => {
                console.log("Add Diet Response Text:", data);
                try {
                    const jsonData = JSON.parse(data);
                    console.log("Add Diet Parsed Response:", jsonData);
                } catch (jsonError) {
                    console.error("Add Diet JSON Parse Error:", jsonError);
                }
            })
            .catch(e => console.error("Add Diet Error:", e));
    }

    function getRandomMeal(int) {
        setMealIndex(Math.floor(Math.random() * allDiets[index].meals.length));
    }

    return (
        <div className="DietInfoPage">
            {allDiets.length > 0 ? (
                <div className="DietInfoPage">
                    <div className="LeftHalfDietInfo">
                        <div className="TopHalf">
                            <button style={{ whiteSpace: 'pre-line' }} className='DietInfo'>{allDiets[index].dietName}{'\n\n\n\n'}{allDiets[index].dietDescription}</button>
                        </div>
                        <div className="BottomHalf">
                            <button className='AddToDiets' onClick={async () => {
                                await addDiet(1);
                                navigate('/diets');
                            }}>Add to your diets!</button>
                        </div>
                    </div>
                    {mealIndex != null ? (
                        <div className="RightHalfDietInfo">
                            <button style={{ whiteSpace: 'pre-line' }} className="DietInfo" onClick={() => navigate('/meals/' + allDiets[index].meals[mealIndex].id)}>
                                {allDiets[index].meals[mealIndex].mealName}{'\n\n\n\n'}{allDiets[index].meals[mealIndex].perpInstructions}
                            </button>
                        </div>
                    ) : (
                        <div className="RightHalfDietInfo">
                            <button className="DietInfo" onClick={() => getRandomMeal(index)}>Let's see what is your next meal!</button>
                        </div>
                    )}
                </div>

            ) : (
                <div className="centered-text">
                    <h1>We're fetching a diet for you, give us a moment</h1>
                </div>
            )}
        </div>
    )
}

export default DietInfo;