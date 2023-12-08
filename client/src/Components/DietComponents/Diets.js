import React, { useState, useEffect } from "react";
import './Diets.css';
import { useNavigate } from 'react-router-dom';

const Diets = ({ user }) => {
    const [allDiets, setAllDiets] = useState([]);
    const [diets, setDiets] = useState(null);
    const [suggestedDiets, setSuggestedDiets] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchAllDiets();
        fetchUserDiets();
        fetchSuggestedDiets();
    }, []);

    function fetchAllDiets() {
        fetch(`http://localhost:8080/diets/getAll`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setAllDiets(data)
            })
            .catch(e => console.error(e))
    }

    function fetchUserDiets() {
        fetch(`http://localhost:8080/diet/getDietsFromUser?userId=99`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setDiets(data)
            })
            .catch(e => console.error(e))
    }

    function fetchSuggestedDiets() {
        fetch(`http://localhost:8080/diet/suggestDiet?userId=99`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setSuggestedDiets(data)
            })
            .catch(e => console.error(e))
    }



    return (
        <div>
            {/* {allDiets && allDiets.length > 0 ? ( */}
            {diets && diets.length > 0 ? (
                <div id='MainDietsPage' className="DietPage">
                    <div className="LeftHalf">
                        <button style={{ whiteSpace: 'pre-line' }} className='MainDietButton' onClick={() => navigate(`/diets/${diets[0].id}`)}>{diets[0].dietName}{'\n\n\n\n'}{diets[0].dietDescription}</button>
                    </div>
                    <div className="RightHalf">
                        <div className="TopHalf">
                            {diets.slice(1, 4).map((diet, index) => (
                                <div key={index}>
                                    <button style={{ whiteSpace: 'pre-line' }} className='MainDietButton'  onClick={() => navigate(`/diets/${allDiets[index].id}`)}>{diet.dietName}{'\n\n\n\n'}{diet.dietDescription}</button>
                                </div>
                            ))}
                        </div>
                        <div className="BottomHalf">
                            {diets.slice(1, 4).map((diet, index) => (
                                <div key={index}>
                                        <button className='SetButton' onClick={() => {
                                        console.log("Set diet set diet")
                                        // setDietId(diets[index].id)
                                        // setDiet()
                                    }}>Change diet</button>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            ) : (
                <div id='SuggestButtonsContainer' className="DietPage">
                    {suggestedDiets && suggestedDiets.slice(0, 3).map((suggestedDiet, index) => (
                        <div key={index}>
                            <button style={{ whiteSpace: 'pre-line' }} className='SuggestButton' id={index} onClick={() => navigate(`/diets/${suggestedDiets[index].id - 1}`)}>{suggestedDiets[index].dietName}{'\n\n\n\n'}{suggestedDiets[index].dietDescription}</button>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Diets;