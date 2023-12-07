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
        bodyPart: [],
        trainingLevel: 'beginner',
        trainingType: 'cardio',
        id: registeredUser?.id || '', // Use optional chaining
        username: registeredUser?.name || '',
    });

    useEffect(() => {
        if (registeredUser) {
            // Update formData only if registeredUser is available

            setFormData((prevFormData) => ({
                ...prevFormData,
                id: registeredUser.id || '',
                name: registeredUser.name || '',
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
        const uppercaseBodyPart = formData.bodyPart.map((bPart) => bPart.toUpperCase());
        const uppercaseFoodType = formData.foodType.toUpperCase();
        const uppercaseDietType = formData.dietType.toUpperCase();
        const uppercaseTrainingLevel = formData.trainingLevel.toUpperCase();
        const uppercaseTrainingType = formData.trainingType.toUpperCase();

        const formDataToSend = {
            ...formData,
            allergies: uppercaseAllergies,
            bodyPart: uppercaseBodyPart,
            foodType: uppercaseFoodType,
            dietType: uppercaseDietType,
            level: uppercaseTrainingLevel,
            trainingType: uppercaseTrainingType,
        };
        console.log("DATA SENT: ",formDataToSend);
        try {
            const response = await fetch('http://localhost:8080/user/userData', {
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
                        <label className="data-label-checkbox">Part of body</label>
                        {Object.values(BodyPart).map((bodyPart) => (
                            <label key={bodyPart}>
                                <input
                                    type="checkbox"
                                    name="bodyPart"
                                    value={bodyPart}
                                    checked={formData.bodyPart.includes(bodyPart)}
                                    onChange={() => handleCheckboxChange('bodyPart', bodyPart)}
                                />
                                {bodyPart}
                            </label>
                        ))}
                    </div>
                    <div className="data-form-group">
                        <label className="data-label">Training Level</label>
                        <select
                            className="data-select"
                            name="trainingLevel"
                            value={formData.trainingLevel}
                            onChange={handleInputChange}
                        >
                            {Object.values(TrainingLevel).map((trainingLevel) => (
                                <option key={trainingLevel} value={trainingLevel}>
                                    {trainingLevel}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="data-form-group">
                        <label className="data-label">Training Type</label>
                        <select
                            className="data-select"
                            name="trainingType"
                            value={formData.trainingType}
                            onChange={handleInputChange}
                        >
                            {Object.values(TrainingType).map((trainingType) => (
                                <option key={trainingType} value={trainingType}>
                                    {trainingType}
                                </option>
                            ))}
                        </select>
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

                    <div className="data-submit-form-group">
                        <button className="data-submit" type="submit">
                            <label className="data-label-submit">Submit</label>
                        </button>
                    </div>
                </form>
            </div>
        </div>




        // <form onSubmit={handleSubmit} style={{ color: 'white' }}>
        //     {/*<div style={{ marginBottom: '100px' }}></div>*/}
        //     <div>
        //         <label><h2>Please fill your data:</h2></label>
        //     </div>
        //     <div>
        //         <label>Age:  </label>
        //         <input
        //             type="number"
        //             name="age"
        //             value={formData.age}
        //             onChange={handleInputChange}
        //         /> years
        //     </div>
        //
        //     <div>
        //         <label>Weight:  </label>
        //         <input
        //             type="number"
        //             name="weight"
        //             value={formData.weight}
        //             onChange={handleInputChange}
        //         /> kg
        //     </div>
        //
        //     <div>
        //         <label>Height:  </label>
        //         <input
        //             type="number"
        //             name="height"
        //             value={formData.height}
        //             onChange={handleInputChange}
        //         /> cm
        //     </div>
        //
        //     <div>
        //         <label>Part of body to train:  </label>
        //         {Object.values(BodyPart).map((bodyPart) => (
        //             <label key={bodyPart}>
        //                 <input
        //                     type="checkbox"
        //                     name="bodyPart"
        //                     value={bodyPart}
        //                     checked={formData.bodyPart.includes(bodyPart)}
        //                     onChange={() => handleCheckboxChange('bodyPart', bodyPart)}
        //                 />
        //                 {bodyPart}
        //             </label>
        //         ))}
        //     </div>
        //
        //     <div>
        //         <label>Training Level: </label>
        //         <select
        //             name="trainingLevel"
        //             value={formData.trainingLevel}
        //             onChange={handleInputChange}
        //         >
        //             {Object.values(TrainingLevel).map((trainingLevel) => (
        //                 <option key={trainingLevel} value={trainingLevel}>
        //                     {trainingLevel}
        //                 </option>
        //             ))}
        //         </select>
        //     </div>
        //
        //     <div>
        //         <label>Training Type: </label>
        //         <select
        //             name="trainingType"
        //             value={formData.trainingType}
        //             onChange={handleInputChange}
        //         >
        //             {Object.values(TrainingType).map((trainingType) => (
        //                 <option key={trainingType} value={trainingType}>
        //                     {trainingType}
        //                 </option>
        //             ))}
        //         </select>
        //     </div>
        //
        //     <div><p></p></div>
        //     <div>
        //         <label><h2>Please indicate your preferences:</h2></label>
        //     </div>
        //
        //     <div>
        //         <label>Allergies:  </label>
        //         {Object.values(Allergy).map((allergy) => (
        //             <label key={allergy}>
        //                 <input
        //                     type="checkbox"
        //                     name="allergies"
        //                     value={allergy}
        //                     checked={formData.allergies.includes(allergy)}
        //                     onChange={() => handleCheckboxChange('allergies', allergy)}
        //                 />
        //                 {allergy}
        //             </label>
        //         ))}
        //     </div>
        //
        //     <div>
        //         <label>Food Types:  </label>
        //         <select
        //             name="foodType"
        //             value={formData.foodType}
        //             onChange={handleInputChange}
        //         >
        //             {Object.values(FoodType).map((foodType) => (
        //                 <option key={foodType} value={foodType}>
        //                     {foodType}
        //                 </option>
        //             ))}
        //         </select>
        //     </div>
        //
        //     <div>
        //         <label>Diet Types:  </label>
        //         <select
        //             name="dietType"
        //             value={formData.dietType}
        //             onChange={handleInputChange}
        //         >
        //             {Object.values(DietType).map((dietType) => (
        //                 <option key={dietType} value={dietType}>
        //                     {dietType}
        //                 </option>
        //             ))}
        //         </select>
        //     </div>
        //
        //     <div><p></p></div>
        //     <button type="submit">Submit</button>
        // </form>
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

const BodyPart = {
    BICEPS: 'biceps',
    TRICEPS: 'triceps',
    SHOULDER: 'shoulder',
    FOREARM: 'forearm',
    BACK: 'back',
    CHEST: 'chest',
    ABS: 'abs',
    LEGS: 'legs',
    GLUTE: 'glute',
    CALVES: 'calves',
};

const TrainingLevel = {
    BEGINNER: 'beginner',
    INTERMEDIATE: 'intermediate',
    ADVANCED: 'advanced',
    ELITE: 'elite',
    EXPERT: 'expert',
};

const TrainingType = {
    CARDIO: 'cardio',
    CALISTHENICS: 'calisthenics',
    WEIGHTS: 'weights',
};

export default UserData;
