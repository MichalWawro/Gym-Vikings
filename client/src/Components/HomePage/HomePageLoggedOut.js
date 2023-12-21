import { useNavigate } from 'react-router-dom';

const HomePageLoggedOut = ({}) => {
    const navigate = useNavigate();

    return (
        <div className='background-image'>
            <div className="content">
                <h1 className="BorderedRubik">Welcome to our training and fitness app!</h1>
                </div>
            </div>
    );
};

export default HomePageLoggedOut;