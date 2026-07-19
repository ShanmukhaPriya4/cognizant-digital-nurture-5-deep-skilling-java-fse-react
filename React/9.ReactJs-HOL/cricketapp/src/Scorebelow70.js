import React from "react";

function Scorebelow70(props) {

    const players = props.players.filter(player => player.score < 70);

    return (
        <>
        {
            players.map((item,index)=>
            (
                <div key={index}>
                    <li>
                        Mr. {item.name}
                        <span> {item.score}</span>
                    </li>
                </div>
            ))
        }
        </>
    );
}

export default Scorebelow70;