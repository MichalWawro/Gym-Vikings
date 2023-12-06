//import??

const usersArray = [{
    name: 'User1',
    trainings: ['Training1', 'Training2', 'Training3'],
    diets: ['Diet1', 'Diet2', 'Diet3']
}, {
    name: 'User2',
    trainings: ['Training1', 'Training2', 'Training3'],
    diets: []
}, {
    name: 'User3',
    trainings: [],
    diets: []
}];

const WelcomePageLoggedIn = ({ testUserNumber }) => {
    const user = usersArray[testUserNumber];
    return (
        <div className="content">
            <h1 className="BorderedRubik">Hello {user.name}</h1>
            <div className="MainButtonContainer">
                {user.trainings.length > 0 ?
                    <button id='ChoiceButton' className="MainButton" type="button">Your next training is: {user.trainings[1]}</button>
                    // Tutaj router do strony z detalami kolejnego treningu
                    :
                    <button id='ChoiceButton' className="MainButton" type="button">Let's choose a training!</button>
                    //Tutaj router do strony, która pomaga wybrać training
                }
                {user.diets.length > 0 ?
                    <button id='ChoiceButton' className="MainButton" type="button">Your next meal is: {user.diets[1]}</button>
                    // Tutaj router do strony z detalami kolejnego posiłku
                    :
                    <button id='ChoiceButton' className="MainButton" type="button">Let's choose a diet!</button>
                    //Tutaj router do strony, która pomaga wybrać dietę
                }
            </div>
        </div>

    );
};

export default WelcomePageLoggedIn;