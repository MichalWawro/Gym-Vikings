//import?

const NavBarLoggedIn = ({ handleLoginChange }) => {
    return (
        <div>
            <button id="AboutButton" className="NavButton" type="button" onClick={() => null}>
                About
            </button>
            <button id="ContactButton" className="NavButton" type="button" onClick={() => null}>
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