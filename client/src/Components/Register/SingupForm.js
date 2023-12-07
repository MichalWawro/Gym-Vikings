import React from "react";
import useForm from "./useForm";
import "./RegisterForm.css";
const SignUpForm = ({ submitForm }) => {
    const { handleChange, handleFormSubmit, values, errors} = useForm(submitForm);

    return (
        <div className="container">
            <div className="app-wrapper">
                <div>
                    <h2 className="title">Create Account</h2>
                </div>

                <form className="form-wrapper" onSubmit={handleFormSubmit}>
                    <div className="form-group">
                        <label className="label">Name</label>
                        <input
                            className="input"
                            type="text"
                            name="name"
                            value={values.name}
                            onChange={handleChange}
                        />
                        {errors.name && <p className="error">{errors.name}</p>}
                    </div>
                    <div className="form-group">
                        <label className="label">Email</label>
                        <input
                            className="input"
                            type="email"
                            name="email"
                            value={values.email}
                            onChange={handleChange}
                        />
                        {errors.email && <p className="error">{errors.email}</p>}
                    </div>
                    <div className="form-group">
                        <label className="label">Password</label>
                        <input
                            className="input"
                            type="password"
                            name="password"
                            value={values.password}
                            onChange={handleChange}
                        />
                        {errors.password && <p className="error">{errors.password}</p>}
                    </div>
                    <div className="form-group">
                        <button className="submit" type="submit">Sign Up</button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default SignUpForm;