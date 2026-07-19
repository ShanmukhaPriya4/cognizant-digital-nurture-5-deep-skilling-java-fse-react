import React from "react";
import "./App.css";
import office from "./office.jpg";

function App() {

  const heading = "Office Space";

  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "Regus",
      Rent: 70000,
      Address: "Bangalore"
    },
    {
      Name: "WeWork",
      Rent: 55000,
      Address: "Hyderabad"
    },
    {
      Name: "SmartWorks",
      Rent: 80000,
      Address: "Mumbai"
    }
  ];

  return (
    <div className="App">

      <h1>{heading}, at Affordable Range</h1>

      {officeList.map((officeItem, index) => (

        <div key={index}>

          <img
            src={office}
            alt="Office Space"
            width="300"
            height="200"
          />

          <h2>Name: {officeItem.Name}</h2>

          <h3
            className={
              officeItem.Rent <= 60000
                ? "textRed"
                : "textGreen"
            }
          >
            Rent: Rs. {officeItem.Rent}
          </h3>

          <h3>Address: {officeItem.Address}</h3>

          <hr />

        </div>

      ))}

    </div>
  );
}

export default App;
