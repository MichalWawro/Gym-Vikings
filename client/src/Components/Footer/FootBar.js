import './FootBar.css';
import{ useNavigate } from 'react-router-dom';

const FootBar = ({user}) => {
    const navigate = useNavigate();

    function username(user){
        if (!user){
            return "No one"
        }
        else {
            return user.username
        }
    }


    return (
        <div className='footer-content'>
            <h4>{username(user) + " logged"}</h4>
            <h5 className='footer-content'>2023 Gym Viking. <br></br>All rights reserved.</h5>
            <p>Follow us: <br></br><a href="https://facebook.com/gym_viking" target="_blank" rel="noopener noreferrer">Facebook</a> | <a href="https://twitter.com/gym_viking" target="_blank" rel="noopener noreferrer">Twitter</a>  <a href="https://instagram.com/gym_viking" target="_blank" rel="noopener noreferrer">Instagram</a></p>
            <div className='spacer'></div>
            <button id="AboutButton" className="NavButton" type="button" onClick={() => navigate("/about")}>
                About
            </button>
            <button id="ContactButton" className="NavButton" type="button" onClick={() => navigate("/contact")}>
                Contact
            </button>
        </div>

    );
};

export default FootBar;