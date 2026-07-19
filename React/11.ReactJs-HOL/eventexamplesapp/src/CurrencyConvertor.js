import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);

    this.state = {
      rupees: "",
      euro: ""
    };
  }

  handleChange = (event) => {
    this.setState({
      rupees: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const euro = (this.state.rupees / 90).toFixed(2);

    this.setState({
      euro: euro
    });
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>

        <form onSubmit={this.handleSubmit}>

          <label>Indian Rupees : </label>

          <input
            type="number"
            value={this.state.rupees}
            onChange={this.handleChange}
          />

          <button type="submit">
            Convert
          </button>

        </form>

        <h3>Euro : € {this.state.euro}</h3>

      </div>
    );
  }
}

export default CurrencyConvertor;