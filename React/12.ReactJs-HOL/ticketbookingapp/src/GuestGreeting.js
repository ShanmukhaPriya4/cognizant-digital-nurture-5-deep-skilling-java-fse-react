import React from 'react';

function GuestGreeting() {
  return (
    <div>
      <h2>Welcome Guest!</h2>

      <h3>Flight Details</h3>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Flight No</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>AI101</td>
            <td>Chennai</td>
            <td>Delhi</td>
            <td>10:00 AM</td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>Mumbai</td>
            <td>Bangalore</td>
            <td>2:30 PM</td>
          </tr>
        </tbody>
      </table>

      <p><strong>Please Login to Book Tickets.</strong></p>
    </div>
  );
}

export default GuestGreeting;