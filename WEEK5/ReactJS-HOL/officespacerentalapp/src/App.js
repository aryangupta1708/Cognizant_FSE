function App() {

  const heading = "Office Space Rental App";

  const office = {
    name: "DBS Business Center",
    rent: 55000,
    address: "Chennai"
  };

  const officeList = [

    {
      name: "DBS Business Center",
      rent: 55000,
      address: "Chennai"
    },

    {
      name: "WeWork",
      rent: 75000,
      address: "Bangalore"
    },

    {
      name: "Regus",
      rent: 45000,
      address: "Hyderabad"
    }

  ];

  return (

    <div>

      <h1>{heading}</h1>

      <img
        src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=700"
        alt="Office"
        width="400"
      />

      <h2>Featured Office</h2>

      <p><b>Name:</b> {office.name}</p>

      <p>
        <b>Rent:</b>
        <span
          style={{
            color: office.rent < 60000 ? "red" : "green"
          }}
        >
          {" "}₹{office.rent}
        </span>
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Office List</h2>

      {

        officeList.map((item, index) => (

          <div key={index}>

            <h3>{item.name}</h3>

            <p>

              Rent :

              <span
                style={{
                  color: item.rent < 60000 ? "red" : "green"
                }}
              >
                {" "}₹{item.rent}
              </span>

            </p>

            <p>Address : {item.address}</p>

            <hr />

          </div>

        ))

      }

    </div>

  );

}

export default App;