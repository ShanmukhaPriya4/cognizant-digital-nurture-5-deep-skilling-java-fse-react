import { Link } from "react-router-dom";
import trainersMock from "./TrainersMock";

function TrainersList() {

    return (

        <div>

            <h1>Trainers List</h1>

            <ul>

                {
                    trainersMock.map((trainer) => (

                        <li key={trainer.trainerId}>

                            <Link to={`/trainers/${trainer.trainerId}`}>
                                {trainer.name}
                            </Link>

                        </li>

                    ))
                }

            </ul>

        </div>

    );

}

export default TrainersList;