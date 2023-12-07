import './NavBar.css';
import { useNavigate } from 'react-router-dom';
//Components
import NavBarLoggedIn from './NavBarLoggedIn.js';
import NavBarLoggedOut from './NavBarLoggedOut.js';

const NavBar = ({ isLoggedIn, handleLoginChange }) => {
    const navigate = useNavigate();
    return (
        <div>
            <button id="AboutButton" className="HomeButton" type="button" onClick={() => navigate("")}>

            </button>

            {isLoggedIn ?
                <NavBarLoggedIn handleLoginChange={handleLoginChange} />
                :
                <NavBarLoggedOut handleLoginChange={handleLoginChange} />
            }
        </div>
    );
};

export default NavBar;