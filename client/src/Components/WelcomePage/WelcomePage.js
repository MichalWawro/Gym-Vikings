// import 'WelcomePage.css';

//components
import WelcomePageLoggedIn from './WelcomePageLoggedIn.js';
import WelcomePageLoggedOut from './WelcomePageLoggedOut.js';

const WelcomePage = ({isLoggedIn, handleLoginChange, testUserNumber}) => {
    return(
        <div>
            {isLoggedIn ?
                <WelcomePageLoggedIn testUserNumber={testUserNumber}/>
                :
                <WelcomePageLoggedOut handleLoginChange={handleLoginChange}/>
            }
        </div>
    );
};

export default WelcomePage;