import React, { useState } from 'react';
import './App.css';
import BirdList from './components/BirdList';
import BirdDetail from './components/BirdDetail';
import BirdForm from './components/BirdForm';

function App() {
  const [selectedBirdId, setSelectedBirdId] = useState(null);
  const [refresh, setRefresh] = useState(false);

  return (
    <div className="App">
      <h1>Bird Sighting System</h1>
      <BirdForm onCreated={() => setRefresh(!refresh)} />
      <BirdList key={refresh} onSelect={setSelectedBirdId} />
      <BirdDetail birdId={selectedBirdId} />
    </div>
  );
}

export default App;
