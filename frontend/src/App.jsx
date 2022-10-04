import { useState } from 'react';
import './App.css'

const App = () => {  

  const [word, setWord] = useState('');

  fetch('/api/hello')
    .then(response => response.text())
    .then(data => setWord(data));

  return (
    <div className="App">
      <p>{word}</p>
    </div>
  )
}

export default App;
