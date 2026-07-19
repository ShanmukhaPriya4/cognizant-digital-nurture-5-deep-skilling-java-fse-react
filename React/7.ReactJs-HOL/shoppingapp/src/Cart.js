import React, { Component } from "react";

class Cart extends Component {
  render() {
    return (
      <table border="1" cellPadding="10" cellSpacing="0">
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          {this.props.item.map((item, index) => (
            <tr key={index}>
              <td>{item.itemname}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

export default Cart;