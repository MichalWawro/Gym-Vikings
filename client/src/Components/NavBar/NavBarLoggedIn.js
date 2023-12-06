import { useNavigate } from 'react-router-dom';

const NavBarLoggedIn = ({ handleLoginChange }) => {
    const navigate = useNavigate();
    return (
        <div>
            <button id="AboutButton" className="NavButton" type="button" onClick={() => navigate("/about")}>
                About
            </button>            
           <button id="ContactButton" className="NavButton" type="button" onClick={() => navigate("/contact")}>
                Contact
            </button>          
            <button id="ProfileButton" className="NavButton" type="button" onClick={() => null}>
                Profile
            </button>
            <button id="LogOutButton" className="NavButton" type="button" onClick={() => handleLoginChange(false)}>
                Log Out
            </button>
        </div>
    );
};

export default NavBarLoggedIn;