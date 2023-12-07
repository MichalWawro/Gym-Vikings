import React, { useState,useEffect } from 'react';
import './UserData.css';
const UserData = ({ registeredUser }) => {
    const [formData, setFormData] = useState({
        allergies: [],
        foodType: 'vegan',
        dietType: 'cutting',
        age: '',
        weight: '',
        height: '',
        id: registeredUser?.id || '',
        gender:'Female'
    });

    useEffect(() => {
        if (registeredUser) {
            // Update formData only if registeredUser is available
            setFormData((prevFormData) => ({
                ...prevFormData,
                // id: registeredUser.id || '',
                id: 1
            }));
        }
    }, [registeredUser]);

    // const handleInputChange = (e) => {
    //     const { name, value } = e.target;
    //
    //     setFormData((prevFormData) => ({
    //         ...prevFormData,
    //         [name]: value,
    //     }));
    // };
    const handleInputChange = (e) => {
        const { name, value } = e.target;

        setFormData((prevFormData) => ({
            ...prevFormData,
            [name]: value,
        }));
    };

    const handleCheckboxChange = (category, value) => {
        setFormData((prevFormData) => ({
            ...prevFormData,
            [category]: prevFormData[category].includes(value)
                ? prevFormData[category].filter((item) => item !== value)
                : [...prevFormData[category], value],
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        // Convert allergies to uppercase before sending
        const uppercaseAllergies = formData.allergies.map((allergy) => allergy.toUpperCase());
        const uppercaseFoodType = formData.foodType.toUpperCase();
        const uppercaseDietType = formData.dietType.toUpperCase();

        const formDataToSend = {
            ...formData,
            allergies: uppercaseAllergies,
            foodType: uppercaseFoodType,
            dietType: uppercaseDietType
        };
        console.log("DATA SENT: ",formDataToSend);
        try {
            const response = await fetch('http://localhost:8080/user/formDone', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formDataToSend),
            });

            if (response.ok) {
                console.log('Form data successfully submitted to the backend.');
            } else {
                console.error('Failed to submit form data to the backend.');
            }
        } catch (error) {
            console.error('An error occurred while submitting form data:', error);
        }
    };

    return (
        <div className="data-container">
            <div className="data-wrapper">


                <div className="data-form-group">
                    <label className="data-label"></label>

                    <label className="data-label-title">Fill up form</label>
                </div>

                <form onSubmit={handleSubmit} className="data-form-wrapper" style={{ color: 'white', }}>
                    <div className="data-form-group">
                        <label className="data-label">Age</label>
                        <input
                            className="data-input"
                            type="number"
                            name="age"
                            value={formData.age}
                            onChange={handleInputChange}
                        />{' '}
                        <label className="data-label">years</label>
                    </div>

                    <div className="data-form-group">
                        <label className="data-label">Weight</label>
                        <input
                            className="data-input"
                            type="number"
                            name="weight"
                            value={formData.weight}
                            onChange={handleInputChange}
                        />{' '}
                        <label className="data-label">kg</label>
                    </div>

                    <div className="data-form-group">
                        <label className="data-label">Height</label>
                        <input
                            className="data-input"
                            type="number"
                            name="height"
                            value={formData.height}
                            onChange={handleInputChange}
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
                                    checked={formData.allergies.includes(allergy)}
                                    onChange={() => handleCheckboxChange('allergies', allergy)}
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
                            value={formData.foodType}
                            onChange={handleInputChange}
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
                            value={formData.dietType}
                            onChange={handleInputChange}
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
                            value={formData.gender}
                            onChange={handleInputChange}
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
        </div>
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


export default UserData;
