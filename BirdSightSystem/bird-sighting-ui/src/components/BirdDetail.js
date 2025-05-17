import React, { useEffect, useState } from 'react';
import { getBirdSightingById } from '../api/birdApi';

const BirdDetail = ({ birdId }) => {
  const [bird, setBird] = useState(null);

  useEffect(() => {
    if (birdId) {
      getBirdSightingById(birdId).then(setBird);
    }
  }, [birdId]);


  if (!bird) return <div></div>;

  return (
    <div>
      <h3>Bird Details</h3>
      <p><strong>Species:</strong> {bird.speciesName}</p>
      <p><strong>Description:</strong> {bird.description}</p>
      <p><strong>Location: </strong> {bird.locationLat}</p>
      <p><strong>Image Url:</strong> {bird.imageUrl}</p>
    </div>
  );
};

export default BirdDetail;
