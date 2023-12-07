import { useState, useEffect } from "react";
import validation from "./validations";

const useForm = (submitForm) => {
    const [values, setValues] = useState({
        name: "",
        email: "",
        password: "",
    });

    const [errors, setErrors] = useState({});
    const [dataIsCorrect, setDataIsCorrect] = useState(false);
    const [registeredUser, setRegisteredUser] = useState(null); // Initialize as null

    const handleChange = (event) => {
        setValues({
            ...values,
            [event.target.name]: event.target.value,
        });
    };

    const handleFormSubmit = async (event) => {
        event.preventDefault();
        setErrors(validation(values));
        setDataIsCorrect(true);
        try {
            const response = await fetch('http://localhost:8080/user/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(values),
            });

            if (response.ok) {
                const user = await response.json();
                console.log('User successfully registered:', user);
                setRegisteredUser(user);

            } else {
                console.error('Failed to register user. Server returned:', await response.text());
            }
        } catch (error) {
            console.error('An error occurred while registering the user:', error);
        }
    };

    useEffect(() => {
        if (Object.keys(errors).length === 0 && dataIsCorrect) {
            submitForm(true);
        }
    }, [errors, dataIsCorrect, submitForm]);

    return { handleChange, handleFormSubmit, errors, values,registeredUser};
};

export default useForm;