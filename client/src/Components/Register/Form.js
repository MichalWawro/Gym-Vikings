import React, { useState } from "react";
import SignUpForm from "./SingupForm";
import SignUpFormSuccess from "./SingupFormSuccess";

const Form = () => {
    const [formIsSubmitted, setFormIsSubmitted] = React.useState(false);
    const [registeredUser, setRegisteredUser] = React.useState(null);

    const submitForm = async (userData) => {
        setRegisteredUser(userData);
        setFormIsSubmitted(true);
    };

    return (
        <div>
            {!formIsSubmitted ? (
                <SignUpForm submitForm={submitForm} />
            ) : (
                <div>
                    <React.Fragment>
                        <SignUpFormSuccess registeredUser={registeredUser} />
                    </React.Fragment>

                </div>
            )}
        </div>
    );
};
// const Form = () => {
//     const [formIsSubmitted, setFormIsSubmitted] = useState(false);
//     const submitForm = () => {
//         setFormIsSubmitted(true);
//     }
//     return (
//         <div>
//             {!formIsSubmitted ? (
//                 <SingupForm submitForm={submitForm} />
//             ) : (
//                 <SingupFormSuccess />
//             )}
//         </div>
//     );
// };



export default Form;