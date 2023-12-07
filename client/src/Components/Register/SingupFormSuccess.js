import React from "react";
import UserData from "./UserData";

const singupFormSuccess = ({ registeredUser }) => {
    return (
        <div className="container">
            <div className="app-wrapper">
                <h1 className="form-success">Account Created!</h1>
                <label>{registeredUser.name}</label>
                <UserData registeredUser={registeredUser} />
            </div>
        </div>
    )
}
export default singupFormSuccess