import './Exercise.css'

function Exercise({ exercise, index }) {

  function capitalizeFirstLetter(inputString) {
    return inputString.charAt(0).toUpperCase() + inputString.slice(1).toLowerCase();
  }

  return (
    <div className="exercise" id={index}>
      <div className='exercise-row'>
        <div className="exercise-details">
          <h1 className='exercise-name'>{exercise.name}</h1>
          <h2 className='exercise-type'>Type: {exercise.type}</h2>
          <div className="details">
            <h3>sets: {exercise.set}</h3>
            <h3>reps: {exercise.reps}</h3>
            <h3>weight: {exercise.weight} kg</h3>
          </div>
        </div>
        <div className='exercise-media'>
            <h2>Muscles engaged by exercise:</h2>
            <img className="image" id="img" src={exercise.img} />
            <h2>Propper way of doing this exercise:</h2>
            <img className="video" id="video" src={exercise.video} />
        </div>
      </div>
    </div>

  )
}
export default Exercise;