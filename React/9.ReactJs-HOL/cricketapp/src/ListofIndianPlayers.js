import React from "react";

function ListofIndianPlayers(props)
{
    return(
        <>
        {
            props.IndianPlayers.map((item,index)=>
            (
                <div key={index}>
                    <li>Mr. {item}</li>
                </div>
            ))
        }
        </>
    );
}

export default ListofIndianPlayers;