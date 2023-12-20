import './NavBar.css';
import { useNavigate } from 'react-router-dom';
//Components
import NavBarLoggedIn from './NavBarLoggedIn.js';
import NavBarLoggedOut from './NavBarLoggedOut.js';

const NavBar = ({login, tryingToSign, setTryingToSign, setUser, setJwt, user}) => {
    const navigate = useNavigate();
    return (
        <div>
            <button id="AboutButton" className="HomeButton" type="button" onClick={() => navigate("")}>

            </button>

            {user ?
                <NavBarLoggedIn setUser={setUser}/>
                :
                <NavBarLoggedOut tryingToSign={tryingToSign} login={login} setTryingToSign={setTryingToSign} setUser={setUser} setJwt={setJwt}/>
            }
        </div>
    );
};

export default NavBar;