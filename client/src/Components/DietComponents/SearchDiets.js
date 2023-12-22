import React, { useState, useEffect } from "react";
import './Diets.css';
import './SearchDiets.css';
import { useNavigate } from 'react-router-dom';

const SearchDiets = ({ user }) => {
    const [allDiets, setAllDiets] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchDiets();
    }, []);

    function fetchDiets() {
        fetch(`http://localhost:8080/diets/getAll`)
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setAllDiets(data);
            })
            .catch(e => console.error(e))
    }

    function setDiet(dietId) {
        fetch(`http://localhost:8080/user/setDiet?userId=${user.id}&dietId=${dietId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(res => {
                if (!res.ok) {
                    throw new Error(`HTTP error! Status: ${res.status}`);
                }
                return res.json();
            })
            .then(data => {
                console.log(user.id);
                console.log(dietId);
                console.log(data);
                navigate('/diets')
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

    return (
        <div>
            {allDiets ? (
                <div class="search-diets-wrapper-column">
                    <p></p>
                    {allDiets.map((item) => (
                        <div className="search-diets-wrapper-row">
                            <button key={item.id} className='card-diets-logged-in-search' onClick={() => navigate('/diets/' + item.id)}>
                                <img className='all-diets-picture' src={item.imageUrl} alt="diet-picture" />{item.dietName}<br></br>{item.dietDescription}
                            </button>
                            <button id="set-diet-button" className="NavButton" onClick={() => setDiet(item.id)}>Set as your diet</button>
                        </div>
                    ))}
                </div >
            ) : (
                <div className="centered-text">
                    <h1>We're fetching diets for you, give us a moment :D</h1>
                    <div class="lds-ring"><div></div><div></div><div></div><div></div></div>
                </div>
            )
            }
        </div>

    );
}

export default SearchDiets;