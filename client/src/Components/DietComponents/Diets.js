import React, { useState, useEffect } from "react";

const Diets = ({ user }) => {
    const [diets, setDiets] = useState(null);
    const [suggestedDiets, setSuggestedDiets] = useState(null);


    useEffect(() => {
        fetchUserDiets();
    }, []);

    function fetchUserDiets() {
        fetch(`http://localhost:8080/diet/suggestDiet?userId=${user.id}`)
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setDiets(data)
            })
            .then(() => {
                if (!diets.length > 0) {
                    suggestDiets();
                }
            })
            .catch(e => console.error(e))

        function suggestDiets() {
            fetch(`http://localhost:8080/diet/suggestDiet?userId=${user.id}`)
                .then(res => res.json())
                .then(data => {
                    console.log(data)
                    setSuggestedDiets(data)
                })
                .catch(e => console.error(e))

        }
        return (
            <main>
                <div>
                    
                </div>
            </main>
        );
    };
}

export default Diets;