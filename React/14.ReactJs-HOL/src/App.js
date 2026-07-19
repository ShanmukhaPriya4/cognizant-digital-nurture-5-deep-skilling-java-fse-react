import React, { useState } from "react";
import EmployeesList from "./Components/EmployeesList";
import ThemeContext from "./ThemeContext";
import "./App.css";

function App() {
  const [theme, setTheme] = useState("light");

  const employees = [
    {
      id: 1,
      name: "John",
      designation: "Software Engineer",
      department: "Development"
    },
    {
      id: 2,
      name: "David",
      designation: "Project Manager",
      department: "Management"
    },
    {
      id: 3,
      name: "Priya",
      designation: "QA Engineer",
      department: "Testing"
    }
  ];

  const changeTheme = () => {
    setTheme(theme === "light" ? "dark" : "light");
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management</h1>

        <button className={theme} onClick={changeTheme}>
          Change Theme
        </button>

        <EmployeesList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;


