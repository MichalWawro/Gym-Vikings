import './Info.css'

function Info({setBegginingInfo}){

    return(
        <div className='info'>
        <h1 className="info-h" style={{color: 'black'}}>Your next training is right here. In case of the exercises being too hard or too light consider switching amount of reps, weight or using other type of gym equipment. </h1>
        <button className='info-button' onClick={()=>setBegginingInfo(true)}>Lets do it!</button>
        </div>
    )
}

export default Info;