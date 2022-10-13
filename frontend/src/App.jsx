import { useState } from 'react';
import './App.css'
import LocationSelector from '../components/LocationSelector';

const App = () => {

  const [locations, setLocations] = useState([]);
  const [currLat, setLat] = useState('');
  const [currLon, setLon] = useState('');
  const [zoom, setZoom] = useState(10);
  const [test, setTest] = useState([]);

  const zoomIn = () => {
    if (zoom === 20) return;
    setZoom(zoom + 1);
  }

  const zoomOut = () => {
    if (zoom === 1) return;
    setZoom(zoom - 1);
  }

  return (
    <div className="App">
      <div className='selectorTable'>
        <div className='selectorBody'>
          <LocationSelector setWordOnSubmit={setLocations} setLatitude={setLat} setLongitude={setLon} setTest={setTest} />
        </div>
        <div className='tableBody'>
          <table>
            <tr>
              <th>Name</th>
              <th>Type of Place</th>
              <th>Distance</th>
            </tr>
            {
              test.map(location => {
                return (
                  <tr>
                    <td>{location.name}</td>
                    <td>{location.place}</td>
                    <td>{location.dist}</td>
                  </tr>
                );
              })
            }
          </table>
        </div>
      </div>
      <div className='map'>
        <img src={`https://maps.googleapis.com/maps/api/staticmap?center=${currLat == '' ? '33.7490' : currLat},${currLon == '' ? '-84.3880' : currLon}&zoom=${zoom}&size=500x500${locations.length === 0 ? `` : `&markers=color:blue%7C${currLat == '' ? '33.7490' : currLat},${currLon == '' ? '-84.3880' : currLon}`}&key=AIzaSyBjZXpz2X3e0KhnzBK8Av7IDnbwfm0ZowU`} alt="" />
        <div className='buttons'>
          <button onClick={zoomIn}>Zoom In</button>
          <button onClick={zoomOut}>Zoom Out</button>
        </div>
      </div>
    </div>
  )
}

export default App;
