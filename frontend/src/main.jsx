import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import '../styles/index.css'
import StartPage from './Start page'
import {
  BrowserRouter,
  Routes,
  Route,
} from 'react-router-dom';

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>
      <Route exact path='/' element={<StartPage />}></Route>
      <Route path='/landing' element={<App />}></Route>
    </Routes>
  </BrowserRouter>
)
