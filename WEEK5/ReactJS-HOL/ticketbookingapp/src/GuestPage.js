function GuestPage() {
  return (
    <div>
      <h2>Welcome Guest</h2>

      <h3>Flight Details</h3>

      <table border="1">
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>AI101</td>
            <td>Delhi</td>
            <td>Mumbai</td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>Chennai</td>
            <td>Bangalore</td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>patna</td>
            <td>Bangalore</td>
          </tr>

          <tr>
            <td>AI204</td>
            <td>patna</td>
            <td>Chennai</td>
          </tr>
        </tbody>
      </table>

      <p>Please Login to Book Tickets.</p>
    </div>
  );
}

export default GuestPage;