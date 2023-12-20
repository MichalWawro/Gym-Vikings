import './Exercise.css'

function Exercise({ exercise , index}) {

    function capitalizeFirstLetter(inputString) {
        return inputString.charAt(0).toUpperCase() + inputString.slice(1).toLowerCase();
    }

    return (
        <div className="exercise" id={index}>
            <h1>{exercise.name}</h1>
            <h2>Type: {exercise.type}</h2>
            <h2>Level: {exercise.level}</h2>
            <div class="details">
                <a>sets: {exercise.set}</a>
                <a>reps: {exercise.reps}</a>
                <a>weight: {exercise.weight} kg</a>
            </div>
            <div className='image-div'>
            <h2>Muscles engaged by exercise:</h2>
            <img className="image" id="img" src={exercise.img} />
            </div>
            <div className='video-div'>
            <h2>Propper way of doing this exercise:</h2>
            <img className="video" id="video" src={exercise.video} />
            </div>
        </div>
    )
}
export default Exercise;