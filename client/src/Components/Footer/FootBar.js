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
            <h5 className='footer-content'>All right company trademark yada yada</h5>
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