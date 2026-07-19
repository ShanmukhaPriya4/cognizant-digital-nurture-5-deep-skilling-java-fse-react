import React from "react";

export function OddPlayers(players)
{
    const [first, second, third, fourth, fifth, sixth] = players;

    return(
        <ul>
            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>
        </ul>
    );
}

export function EvenPlayers(players)
{
    const [first, second, third, fourth, fifth, sixth] = players;

    return(
        <ul>
            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>
        </ul>
    );
}