import React, { useContext } from "react";
import ThemeContext from "../ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  return (
    <div className="card">
      <h2>{employee.name}</h2>

      <p>
        <strong>ID:</strong> {employee.id}
      </p>

      <p>
        <strong>Designation:</strong> {employee.designation}
      </p>

      <p>
        <strong>Department:</strong> {employee.department}
      </p>

      <button className={theme}>View</button>

      <button className={theme}>Edit</button>
    </div>
  );
}

export default EmployeeCard;
