import './NavBar.css';

//Components
import NavBarLoggedIn from './NavBarLoggedIn.js';
import NavBarLoggedOut from './NavBarLoggedOut.js';

const NavBar = ({ isLoggedIn, handleLoginChange }) => {
    return (
        <div>
            {isLoggedIn ?
                <NavBarLoggedIn handleLoginChange={handleLoginChange} />
                :
                <NavBarLoggedOut handleLoginChange={handleLoginChange} />
            }
        </div>
    );
};

export default NavBar;