import { useNavigate } from "react-router-dom";
import './FillTheForm.css'

function FillTheForm(){
    const navigate = useNavigate()


    return(
        <div className="fill-form">
        <h1 className="fill-form-h" style={{color: 'black'}}>You need to fill up the form first</h1>
        <button className="go-to-form-button" onClick={()=>navigate('/form')}>Go to form</button>
        </div>
    )


}

export default FillTheForm;