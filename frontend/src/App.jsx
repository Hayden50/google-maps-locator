import { useState } from 'react';
import './App.css'
import LocationSelector from '../components/LocationSelector';
import Login from '../components/Login';

const App = () => {  

  const [word, setWord] = useState('');

  return (
    <div className="App">
      {/* <LocationSelector setWordOnSubmit={setWord}/> */}
      <Login />
      <p>{word === '' ? 'Select a Latitude and Longitude' : word}</p>
    </div>
  )
}

export default App;
