import { useEffect } from "react";
import { useParams } from "react-router-dom";

const DietInfo = () => {
    const { index } = useParams();

    useEffect(() => {
        getIndex();
    }, []);

    function getIndex() {
        console.log(index)
    }

    return (
        <div>
            XD!
        </div>
    );
}

export default DietInfo;