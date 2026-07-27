import { useState } from "react";

function CurrencyConverter() {

  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState("");

  function convertCurrency() {
    const result = (parseFloat(rupees) / 90).toFixed(2);
    setEuro(result);
  }

  return (
    <div>

      <h1>Currency Converter</h1>

      <input
        type="number"
        placeholder="Enter Rupees"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      />

      <br /><br />

      <button onClick={convertCurrency}>
        Convert to Euro
      </button>

      <br /><br />

      <h2>Euro : {euro}</h2>

    </div>
  );
}

export default CurrencyConverter;