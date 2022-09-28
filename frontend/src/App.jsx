import { useEffect, useState } from 'react';
import './App.css'

function App() {
  const[text, setText] = useState('');
  
  useEffect(() => {
    fetch('/api/hello')
        .then(response => response.text())
        .then(message => setText(message))
    },[]);
  
  return (
    <div className="App">
      <h1>{text}</h1>
    </div>
  )
}

export default App;
