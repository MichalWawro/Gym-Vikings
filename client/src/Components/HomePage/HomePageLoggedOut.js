import { useNavigate } from 'react-router-dom';

const HomePageLoggedOut = ({}) => {
    const navigate = useNavigate();

    return (
        <div className='background-image'>
            <div className="content">
                <div className='text-content'>
                <h1 className="BorderedRubik">Welcome to the Vikings Land!</h1>
                <h3 className=''>We are here to provide you with top level of trainings and diets. Start your journey now by signing yourself and filling your personal data form</h3>
                <div className="MainButtonContainer">
                </div>
                    <button id="GetStartedButton" className="MainButton" type="button" onClick={() => navigate("/register")}>
                        LET'S GET STARTED
                    </button>
                </div>
            </div>
        </div>
    );
};

export default HomePageLoggedOut;