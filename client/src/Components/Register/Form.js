import React, { useState,useEffect } from 'react';
import './UserData.css';
import { Navigate } from 'react-router-dom';
import Home from '../HomePage/Home';
import HomePageLoggedIn from '../HomePage/HomePageLoggedIn';
import Login from './Components/NavBar/Login/Login'
const Form = ({ registeredUser }) => {

    const[age, setAge] = useState('');
    const[weight, setWeight] = useState('');
    const[height, setHeight] = useState('');
    const[allergies, setAllergies] = useState([])
    const[dietType, setDietType] = useState('');
    const[foodType, setFoodType] = useState('');
    const[gender, setGender] = useState('');
    const[amountOfTrainingsPerWeek, setAmountOfTrainingsPerWeek]= useState('');

    const[registered, setRegistered] = useState();

    const[user,setUser] = useState();


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


      function formDone() {
          fetch(`http://localhost:8080/user/formDone?userId=${registeredUser.id}`, {
              method: 'PATCH',
              headers: {'Content-Type': 'application/json'},
              body: JSON.stringify({
                  gender: gender,
                  age: age,
                  weight: weight,
                  amountOfTrainingsPerWeek: amountOfTrainingsPerWeek,
                  height: height,
                  allergies: allergies.map(allergy => allergy.toUpperCase())
              })
          })
          .then(res => {
              console.log("Response from server:", res);
              return res.json();
          })
          .then(data => {
              console.log("Parsed JSON data:", data);
          })
          .catch(e => console.error(e));
      }


      function getPropperUser(){
        fetch(`http://localhost:8080/user/getUserInfo?userId=7`)
        .then(res=>res.json())
        .then(data=>{
            console.log("-------------------------" + data);
            setUser(data)
            setRegistered("go")})
        .catch(e=>console.error(e))
      }

       
      const handleSubmit = (e) => {
        e.preventDefault();
        formDone();
        getPropperUser()
      };
    


    return (
        <>
        {registered ? 
            (
                <Login username={registeredUser.username} password={registeredUser.password}/>
            )
            :
            (
                  <div className="data-container">
            <div className="data-wrapper">


                <div className="data-form-group">
                    <label className="data-label"></label>

                    <label className="data-label-title">Fill up form</label>
                </div>

                <form className="data-form-wrapper" style={{ color: 'white', }} onSubmit={handleSubmit}>
                    <div className="data-form-group">
                        <label className="data-label">Age</label>
                        <input
                            className="data-input"
                            type="number"
                            name="age"
                            value={age}
                            onChange={e=>setAge(e.target.value)}
                        />{' '}
                        <label className="data-label">years</label>
                    </div>

                    <div className="data-form-group">
                        <label className="data-label">Weight</label>
                        <input
                            className="data-input"
                            type="number"
                            name="weight"
                            value={weight}
                            onChange={e=>setWeight(e.target.value)}
                        />{' '}
                        </div>
                    <div className="data-form-group">
                        <label className="data-label">Amount of trainings previously done per week</label>
                        <input
                            className="data-input"
                            type="number"
                            name="age"
                            value={amountOfTrainingsPerWeek}
                            onChange={e=>setAmountOfTrainingsPerWeek(e.target.value)}
                        />{' '}
                        <label className="data-label">kg</label>
                    </div>

                    <div className="data-form-group">
                        <label className="data-label">Height</label>
                        <input
                            className="data-input"
                            type="number"
                            name="height"
                            value={height}
                            onChange={e=>setHeight(e.target.value)}
                        />{' '}
                        <label className="data-label">cm</label>
                    </div>

                    <div className="data-form-group">
                        <label className="data-label-checkbox-allergies">Allergies</label>
                        {Object.values(Allergy).map((allergy) => (
                            <label key={allergy}>
                                <input
                                    type="checkbox"
                                    name="allergies"
                                    value={allergy}
                                    checked={allergies.includes(allergy)}
                                    onChange={() => handleCheckboxChange(allergy)}
                                />
                                {allergy}
                            </label>
                        ))}
                    </div>

                    <div className="data-form-group">
                        <label className="data-label">Food Types</label>
                        <select
                            name="foodType"
                            className="data-select"
                            value={foodType}
                            onChange={e=>setFoodType(e.target.value)}
                        >
                            {Object.values(FoodType).map((foodType) => (
                                <option key={foodType} value={foodType}>
                                    {foodType}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="data-form-group">
                        <label className="data-label">Diet Types</label>
                        <select
                            name="dietType"
                            className="data-select"
                            value={dietType}
                            onChange={e=>setDietType(e.target.value)}
                        >
                            {Object.values(DietType).map((dietType) => (
                                <option key={dietType} value={dietType}>
                                    {dietType}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="data-form-group">
                        <label className="data-label">Gender</label>
                        <select
                            name="gender"
                            className="data-select"
                            value={gender}
                            onChange={e=>setGender(e.target.value)}
                        >
                            {Object.values(Gender).map((gender) => (
                                <option key={gender} value={gender}>
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
        </div>)}
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
