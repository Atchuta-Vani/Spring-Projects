import React, { useEffect, useState } from 'react';
import { getAllBirdSightings } from '../api/birdApi';

const BirdList = ({ onSelect }) => {
  const [birds, setBirds] = useState([]);
  const [loading, setLoading] = useState(true);  // New loading state
  const [error, setError] = useState(null);      // New error state

  useEffect(() => {
    getAllBirdSightings()
      .then((data) => {
        setBirds(data);
        setLoading(false);  // Set loading to false once data is fetched
      })
      .catch((err) => {
        setError('Failed to load bird sightings');  // Set error message if the fetch fails
        setLoading(false);  // Set loading to false if there's an error
        console.error(err);  // Log error to the console for debugging
      });
  }, []);

  if (loading) {
    return <div>Loading...</div>;  // Show loading state while the data is being fetched
  }

  if (error) {
    return <div>{error}</div>;  // Show error message if an error occurs
  }

  return (
    <div>
      <h2>Bird Sightings</h2>
      <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr>
            <th>Species Name</th>
            <th>Latitude</th>
            <th>Description</th>
            <th>Image</th>
          </tr>
        </thead>
        <tbody>
          {birds.map((bird) => (
            <tr key={bird.id} onClick={() => onSelect(bird.id)} style={{ cursor: 'pointer' }}>
              <td>{bird.speciesName || 'N/A'}</td>
              <td>{bird.locationLat || 'N/A'}</td>
              <td>{bird.description || 'N/A'}</td>
              <td>
                {bird.imageUrl ? (
                  <img src={bird.imageUrl} alt="bird" style={{ width: '100px' }} />
                ) : (
                  'No image'
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default BirdList;
