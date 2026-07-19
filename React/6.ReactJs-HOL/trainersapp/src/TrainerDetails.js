import { useParams } from "react-router-dom";
import trainersMock from "./TrainersMock";

function TrainerDetails() {

    const { id } = useParams();

    const trainer = trainersMock.find(
        t => t.trainerId === id
    );

    if (!trainer)
        return <h2>Trainer Not Found</h2>;

    return (

        <div>

            <h2>{trainer.name}</h2>

            <p><b>ID:</b> {trainer.trainerId}</p>

            <p><b>Email:</b> {trainer.email}</p>

            <p><b>Phone:</b> {trainer.phone}</p>

            <p><b>Technology:</b> {trainer.technology}</p>

            <p><b>Skills:</b></p>

            <ul>

                {
                    trainer.skills.map((skill, index) => (

                        <li key={index}>{skill}</li>

                    ))
                }

            </ul>

        </div>

    );

}

export default TrainerDetails;