//importy??

const HomePageLoggedOut = ({ handleLoginChange }) => {
    return (
        <div className="content">
            <h1 className="BorderedRubik">Welcome to our training and fitness app!</h1>
            <p>Click the button below to get started</p>
            <div className="MainButtonContainer">
                <button id="GetStartedButton" className="MainButton" type="button" onClick={() => handleLoginChange(true)}>
                    LET'S GET STARTED
                </button>
            </div>
        </div>
    );
};

export default HomePageLoggedOut;