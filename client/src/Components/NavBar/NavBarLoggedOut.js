import { useNavigate } from 'react-router-dom';

const NavBarLoggedOut = ({ handleLoginChange }) => {
    const navigate = useNavigate();

    return (
        <div>
           <button id="AboutButton" className="NavButton" type="button" onClick={() => navigate("/about")}>
                About
            </button>            
            <button id="ContactButton" className="NavButton" type="button" onClick={() => navigate("/contact")}>
                Contact
            </button>            
            <button id="SignInButton" className="NavButton" type="button" onClick={() => handleLoginChange(true)}>
                Sign In
            </button>            
            <button id="RegisterButton" className="NavButton" type="button" onClick={() => navigate("/register")}>
                Register
            </button>            
        </div>
    );
};

export default NavBarLoggedOut;