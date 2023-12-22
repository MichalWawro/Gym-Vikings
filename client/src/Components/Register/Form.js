import React, { useState, useEffect } from 'react';
import './UserData.css';
import { Navigate, useNavigate } from 'react-router-dom';
import Home from '../HomePage/Home';
import HomePageLoggedIn from '../HomePage/HomePageLoggedIn';
const Form = ({ user, setUser }) => {

    const navigate = useNavigate()


    const [personalData, setPersonalData] = useState({
        age: user.age,
        weight: user.weight,
        height: user.height,
        amountOfTrainingsPerWeek: user.amountOfTrainingsPerWeek,
        allergies: [],
        foodType: '',
        dietType: '',
        gender: ''
    })


    function setPersonalDataInfo(input){
        const output = input.toUpperCase();
        return output;
    }

    // const[age, setAge] = useState('');
    // const[weight, setWeight] = useState('');
    // const[height, setHeight] = useState('');
    const [allergies, setAllergies] = useState([])
    // const[dietType, setDietType] = useState('');
    // const[foodType, setFoodType] = useState('');
    // const[gender, setGender] = useState('');
    // const[amountOfTrainingsPerWeek, setAmountOfTrainingsPerWeek]= useState('');

    const [registered, setRegistered] = useState();




    const handleCheckboxChange = (allergy) => {
        setAllergies((prevAllergies) => {
            const uppercasedAllergy = allergy.toUpperCase();
            if (prevAllergies.includes(uppercasedAllergy)) {
                return prevAllergies.filter((item) => item !== uppercasedAllergy);
            } else {
                return [...prevAllergies, uppercasedAllergy];
            }
        });
    };


    async function formDone(e) {
        e.preventDefault();
        const patchRes = await fetch(`http://localhost:8080/user/formDone?userId=${user.id}`, {
            method: 'PATCH',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                gender: personalData.gender,
                age: personalData.age,
                weight: personalData.weight,
                amountOfTrainingsPerWeek: personalData.amountOfTrainingsPerWeek,
                height: personalData.height,
                allergies: personalData.allergies.map(allergy => allergy.toUpperCase()),
                foodType: personalData.foodType,
                dietType: personalData.dietType
            })
        })
        console.log("Response from server:", patchRes);
        const data = await patchRes.text() // tu zmineilem z json() na text(), bo w backendzie zwracany jest: ResponseEntity<String>
        console.log("Parsed JSON data:", data);

        //funkcję getPropperUser wrzuciłem tu bezpośrednio
        const getRes = await fetch(`http://localhost:8080/user/getUserInfo?userId=${user.id}`)
        const getData = await getRes.json()
        console.log("Data z getproper user", getData);
        setUser(getData)
        navigate('/profile')
    }

    // const handleSubmit = () => {
    //     formDone();
    //     navigate('/')
    // };



    return (
        <>
            {registered ?
                (
                    <HomePageLoggedIn user={user} />
                )
                :
                (
                    <div className="data-container">
                        <h1 className='fill-h'>Fill up the form</h1>

                            <form className="data-form-wrapper" style={{ color: 'white', }} onSubmit={e=>{formDone(e)}}>
                                <div className="data-form-group">
                                    <label style={{color: 'black'}} className="data-label">Age</label>
                                    <input
                                        className="data-input"
                                        type="number"
                                        name="age"
                                        value={personalData.age}
                                        onChange={e => setPersonalData({ ...personalData, age: e.target.value })}
                                    />{' '}
                                    <label className="data-label" style={{color: 'black'}}>years</label>
                                </div>

                                <div className="data-form-group">
                                    <label className="data-label" style={{color: 'black'}}>Weight</label>
                                    <input
                                        className="data-input"
                                        type="number"
                                        name="weight"
                                        value={personalData.weight}
                                        onChange={e => setPersonalData({ ...personalData, weight: e.target.value })}
                                    />{' '}
                                    <label className="data-label" style={{color: 'black'}}>kg</label>
                                </div>
                                <div className="data-form-group">
                                    <label className="data-label" style={{color: 'black'}}>Amount of trainings previously done per week</label>
                                    <input
                                        className="data-input"
                                        type="number"
                                        name="age"
                                        value={personalData.amountOfTrainingsPerWeek}
                                        onChange={e => setPersonalData({ ...personalData, amountOfTrainingsPerWeek: e.target.value })}
                                    />{' '}

                                </div>

                                <div className="data-form-group">
                                    <label className="data-label" style={{color: 'black'}}>Height</label>
                                    <input
                                        className="data-input"
                                        type="number"
                                        name="height"
                                        value={personalData.height}
                                        onChange={e => setPersonalData({ ...personalData, height: e.target.value })}
                                    />{' '}
                                    <label className="data-label" style={{color: 'black'}}>cm</label>
                                </div>

                                <div className="data-form-group">
                                    <label className="data-label-checkbox-allergies" style={{color: 'black'}}>Allergies</label>
                                    {Object.values(Allergy).map((allergy) => (
                                        <label key={allergy} style={{color: 'black'}}>
                                            <input
                                                type="checkbox"
                                                name="allergies"
                                                value={personalData.allergy}
                                                checked={allergies.includes(allergy)}
                                                onChange={() => handleCheckboxChange(allergy)}
                                            />
                                            {allergy}
                                        </label>
                                    ))}
                                </div>

                                <div className="data-form-group">
                                    <label className="data-label" style={{color: 'black'}}>Food Types</label>
                                    <select
                                        name="foodType"
                                        className="data-select"
                                        value={personalData.foodType}
                                        onChange={e => setPersonalData({ ...personalData,foodType: e.target.value})}
                                    >
                                        {Object.values(FoodType).map((foodType) => (
                                            <option key={foodType} value={foodType} style={{color: 'black'}}>
                                                {foodType}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="data-form-group">
                                    <label className="data-label" style={{color: 'black'}}>Diet Types</label>
                                    <select
                                        name="dietType"
                                        className="data-select"
                                        value={personalData.dietType}
                                        onChange={e => setPersonalData({ ...personalData, dietType: e.target.value })}
                                    >
                                        {Object.values(DietType).map((dietType) => (
                                            <option key={dietType} value={dietType} style={{color: 'black'}}>
                                                {dietType}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="data-form-group">
                                    <label className="data-label" style={{color: 'black'}}>Gender</label>
                                    <select
                                        name="gender"
                                        className="data-select"
                                        value={personalData.gender}
                                        onChange={e => setPersonalData({ ...personalData, gender: e.target.value })}
                                    >
                                        {Object.values(Gender).map((gender) => (
                                            <option key={gender} value={gender} style={{color: 'black'}}>
                                                {gender}
                                            </option>
                                        ))}
                                    </select>
                                </div>

                                <div className="data-submit-form-group">
                                    <button className="data-submit" type="submit">
                                        <label className="data-label-submit">Submit</label>
                                    </button>
                                </div>
                            </form>
                        </div>
                    )}
        </>
    );
};

const Allergy = {
    MILK: 'milk',
    EGGS: 'eggs',
    PEANUTS: 'peanuts',
    TREE_NUTS: 'tree_nuts',
    SOY: 'soy',
    WHEAT: 'wheat',
    FISH: 'fish',
    SHELLFISH: 'shellfish',
    SESAME: 'sesame',
    MUSTARD: 'mustard',
};

const FoodType = {
    VEGAN: 'vegan',
    VEGETARIAN: 'vegetarian',
    NORMAL: 'normal',
    CARNIVORE: 'carnivore',
};

const DietType = {
    CUTTING: 'cutting',
    STAYING: 'staying',
    BULKING: 'bulking',
};

const Gender = {
    FEMALE: 'Female',
    MALE: 'Male'
};

export default Form;
