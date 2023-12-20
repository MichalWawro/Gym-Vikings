import { useNavigate } from 'react-router-dom';

const NavBarLoggedIn = ({ handleLoginChange, setUser, setLoginState }) => {
    const navigate = useNavigate();




    return (
        <div>
            <div className="Spacer" />
            <button id="TrainingButton" className="NavButton" type="button" onClick={() => navigate("/trainings")}>
                Trainings
            </button>
            <button id="DietButton" className="NavButton" type="button" onClick={() => navigate("/diets")}>
                Diets
            </button>
            <button id="FormButton" className="NavButton" type="button" onClick={() => navigate("/form")}>
                Form
            </button>
            <button id="ProfileButton" className="NavButton" type="button" onClick={() => navigate("/profile")}>
                Profile
            </button>
            <button id="LogOutButton" className="NavButton" type="button" onClick={() => {
                setUser("No user")
                setLoginState(false)
                navigate('')
            }}>
                Log Out
            </button>
        </div>
    );
};

export default NavBarLoggedIn;