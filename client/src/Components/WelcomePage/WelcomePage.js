// import 'WelcomePage.css';

//components
import WelcomePageLoggedIn from './WelcomePageLoggedIn.js';
import WelcomePageLoggedOut from './WelcomePageLoggedOut.js';

const WelcomePage = ({isLoggedIn, handleLoginChange, user}) => {
    return(
        <div>
            {isLoggedIn ?
                <WelcomePageLoggedIn user={user}/>
                :
                <WelcomePageLoggedOut handleLoginChange={handleLoginChange}/>
            }
        </div>
    );
};

export default WelcomePage;