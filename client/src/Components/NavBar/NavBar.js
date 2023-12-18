import './NavBar.css';
import { useNavigate } from 'react-router-dom';
//Components
import NavBarLoggedIn from './NavBarLoggedIn.js';
import NavBarLoggedOut from './NavBarLoggedOut.js';

const NavBar = ({ isLoggedIn, handleLoginChange, login, tryingToSign, setTryingToSign, setUser, setJwt}) => {
    const navigate = useNavigate();
    return (
        <div>
            <button id="AboutButton" className="HomeButton" type="button" onClick={() => navigate("")}>

            </button>

            {isLoggedIn ?
                <NavBarLoggedIn handleLoginChange={handleLoginChange} setUser={setUser}/>
                :
                <NavBarLoggedOut handleLoginChange={handleLoginChange} tryingToSign={tryingToSign} login={login} setTryingToSign={setTryingToSign} setUser={setUser} setJwt={setJwt}/>
            }
        </div>
    );
};

export default NavBar;