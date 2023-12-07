import React, { useState } from "react";


const Profile = ({ user }) => {
    //placeholder
    return (
        <>
            <p>
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
                name: {user.user.username}
                <br />
                age: {user.user.age}
                <br />
                <br />
            </p>
        </>
    );
};



export default Profile;