import CohortDetails from "./Components/CohortDetails";

function App() {

  return (

    <div style={{ margin: "30px" }}>

      <h1>Cohorts Details</h1>

      <CohortDetails
        name="INTADMDF10 - .NET FSD"
        date="22-Feb-2022"
        status="Scheduled"
        coach="Aathma"
        trainer="Jojo Jose"
      />

      <CohortDetails
        name="ADM21JF014 - Java FSD"
        date="10-Sep-2021"
        status="Ongoing"
        coach="Apoorv"
        trainer="Elisa Smith"
      />

      <CohortDetails
        name="CDBJF21025 - Java FSD"
        date="24-Dec-2021"
        status="Ongoing"
        coach="Aathma"
        trainer="John Doe"
      />

    </div>

  );
}

export default App;