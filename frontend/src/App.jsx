import { useEffect, useState } from 'react';
import './App.css'

const App = () => {  

  const [word, setWord] = useState('');

  fetch('http://localhost:8080/api/data')
    .then(response => response.toString())
    .then(data => setWord(data));

  return (
    <div className="App">
      <p>{word}</p>
    </div>
  )
}

export default App;
