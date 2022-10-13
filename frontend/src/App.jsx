import { useState } from 'react';
import '../styles/App.css'
import LocationSelector from '../components/LocationSelector';

const App = () => {  

  const [word, setWord] = useState('');

  return (
    <div className="App">
      <LocationSelector setWordOnSubmit={setWord}/>
      <p>{word === '' ? 'Select a Latitude and Longitude' : word}</p>
    </div>
  )
}

export default App;
