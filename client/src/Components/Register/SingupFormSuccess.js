import React from "react";
import UserData from "./UserData";

const singupFormSuccess = ({ registeredUser }) => {
    return (
        <div>
        <div className="container">
            <div className="app-wrapper">
                {/*<h1 className="form-success">Account Created!</h1>*/}
                <UserData registeredUser={registeredUser} />
            </div>

        </div>
        <UserData  />
    </div>
    )
}
export default singupFormSuccess