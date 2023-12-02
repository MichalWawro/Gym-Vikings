//importy??

const WelcomePageLoggedOut = ({ handleLoginChange }) => {
    return (
        <div className="content">
            <h1 className="BorderedRubik">Welcome to our training and fitness app!</h1>
            <p>Click the button below to get started</p>
            <button id="GetStartedButton" className="NavButton" type="button" onClick={() => handleLoginChange(true)}>
                LET'S GET STARTED
            </button>
        </div>
    );
};

export default WelcomePageLoggedOut;