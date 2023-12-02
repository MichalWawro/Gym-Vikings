// import 'WelcomePage.css';

//components
import WelcomePageLoggedIn from './WelcomePageLoggedIn.js';
import WelcomePageLoggedOut from './WelcomePageLoggedOut.js';

const WelcomePage = ({isLoggedIn, handleLoginChange}) => {
    return(
        <div>
            {isLoggedIn ?
                <WelcomePageLoggedIn/>
                :
                <WelcomePageLoggedOut handleLoginChange={handleLoginChange}/>
            }
        </div>
    );
};

export default WelcomePage;