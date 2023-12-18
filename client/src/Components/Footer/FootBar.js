import './FootBar.css';

const FootBar = ({user}) => {

    function username(user){
        if (user === "No user"){
            return "No User"
        }
        else {
            return user.username
        }
    }


    return (
        <div className='FooterContent'>
            <h4>Logged in as {username(user)}</h4>
            <h5>All right company trademark yada yada</h5>
        </div>
    );
};

export default FootBar;