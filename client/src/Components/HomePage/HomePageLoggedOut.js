import { useNavigate } from 'react-router-dom';

const HomePageLoggedOut = ({}) => {
    const navigate = useNavigate();

    return (
        <div className='background-image'>
            <div className="content">
                <h1 className="BorderedRubik">Welcome to our training and fitness app!</h1>
                <div className="MainButtonContainer">
                    <button id="GetStartedButton" className="MainButton" type="button" onClick={() => navigate("/register")}>
                        LET'S GET STARTED
                    </button>
                </div>
            </div>
        </div>
    );
};

export default HomePageLoggedOut;