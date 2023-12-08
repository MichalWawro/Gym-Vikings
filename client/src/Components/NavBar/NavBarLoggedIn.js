import { useNavigate } from 'react-router-dom';

const NavBarLoggedIn = ({ handleLoginChange }) => {
    const navigate = useNavigate();
    return (
        <div>
            <div className="Spacer" />
            <button id="AboutButton" className="NavButton" type="button" onClick={() => navigate("/about")}>
                About
            </button>
            <button id="ContactButton" className="NavButton" type="button" onClick={() => navigate("/contact")}>
                Contact
            </button>
            <button id="TrainingButton" className="NavButton" type="button" onClick={() => navigate("/trainings")}>
                Trainings
            </button>
            <button id="DietButton" className="NavButton" type="button" onClick={() => navigate("/diets")}>
                Diets
            </button>
            <button id="ProfileButton" className="NavButton" type="button" onClick={() => navigate("/profile")}>
                Profile
            </button>
            <button id="LogOutButton" className="NavButton" type="button" onClick={() => {
                handleLoginChange(false)
                navigate('')
            }}>
                Log Out
            </button>
        </div>
    );
};

export default NavBarLoggedIn;