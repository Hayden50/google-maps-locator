import { useState } from 'react';
import './App.css'
import LocationSelector from '../components/LocationSelector';

const App = () => {

  const [locations, setLocations] = useState([]);

  return (
    <div className="App">
      <LocationSelector setWordOnSubmit={setLocations}/>
      <div>
        {locations.map((value, index) => <li key={index}>{value}</li>)}
      </div>
    </div>
  )
}

export default App;
