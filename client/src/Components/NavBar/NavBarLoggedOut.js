//import ??

const NavBarLoggedOut = ({ handleLoginChange }) => {
    return (
        <div>
            <button id="AboutButton" className="NavButton" type="button" onClick={() => null}>
                About
            </button>
            <button id="ContactButton" className="NavButton" type="button" onClick={() => null}>
                Contact
            </button>
            <button id="SignInButton" className="NavButton" type="button" onClick={() => handleLoginChange(true)}>
                Sign In
            </button>
            <button id="RegisterButton" className="NavButton" type="button" onClick={() => null}>
                Register
            </button>
        </div>
    );
};

export default NavBarLoggedOut;