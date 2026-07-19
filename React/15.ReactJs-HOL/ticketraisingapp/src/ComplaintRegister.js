import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);

    this.state = {
      employeeName: "",
      complaint: ""
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const refNumber = Math.floor(Math.random() * 1000000);

    alert(
      `Thanks ${this.state.employeeName}.\nYour complaint has been submitted successfully.\nReference Number: ${refNumber}`
    );

    this.setState({
      employeeName: "",
      complaint: ""
    });
  };

  render() {
    return (
      <div className="container">
        <h2>Ticket Raising App</h2>

        <form onSubmit={this.handleSubmit}>
          <table>
            <tbody>
              <tr>
                <td>Employee Name</td>
                <td>
                  <input
                    type="text"
                    name="employeeName"
                    value={this.state.employeeName}
                    onChange={this.handleChange}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>Complaint</td>
                <td>
                  <textarea
                    name="complaint"
                    rows="5"
                    cols="30"
                    value={this.state.complaint}
                    onChange={this.handleChange}
                    required
                  ></textarea>
                </td>
              </tr>

              <tr>
                <td></td>
                <td>
                  <button type="submit">Submit Complaint</button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;