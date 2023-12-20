import './NavBar.css';
import { useNavigate } from 'react-router-dom';
//Components
import NavBarLoggedIn from './NavBarLoggedIn.js';
import NavBarLoggedOut from './NavBarLoggedOut.js';

const NavBar = ({ isLoggedIn, setLoginState, handleLoginChange, login, tryingToSign, setTryingToSign, user, setUser, setJwt}) => {
    const navigate = useNavigate();
    return (
        <div>
            <button id="AboutButton" className="HomeButton" type="button" onClick={() => navigate("")}>

            </button>

            {isLoggedIn ?
                <NavBarLoggedIn  setUser={setUser} user={user} setLoginState={setLoginState}/>
                :
                <NavBarLoggedOut  setLoginState={setLoginState} tryingToSign={tryingToSign} login={login} setTryingToSign={setTryingToSign} user={user} setUser={setUser} setJwt={setJwt}/>
            }
        </div>
    );
};

export default NavBar;