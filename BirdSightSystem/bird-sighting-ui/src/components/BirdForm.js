import React, { useState } from 'react';
import { createBirdSighting } from '../api/birdApi';

const BirdForm = ({ onCreated }) => {
  const [formData, setFormData] = useState({
    speciesName: '',
    description: '',
    imageUrl: '',
    locationLat: '',  // Consider initializing to 0 or null
    locationLong: '', // Consider initializing to 0 or null
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const dataToSend = {
        ...formData,
        locationLat: parseFloat(formData.locationLat),
        locationLong: parseFloat(formData.locationLong),
      };

      // Make sure createBirdSighting is handling this data correctly
      await createBirdSighting(dataToSend);

      alert('Bird sighting added!');

      // Reset form fields
      setFormData({
        speciesName: '',
        description: '',
        imageUrl: '',
        locationLat: '',
        locationLong: '',
      });

      if (onCreated) onCreated();
    } catch (err) {
      // Log more error information to understand the issue better
      console.error('Error adding bird sighting:', err);
      alert('Failed to add sighting.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Add Bird Sighting</h3>
      <input
        name="speciesName"
        placeholder="Species Name"
        value={formData.speciesName}
        onChange={handleChange}
        required
      />
      <input
        name="description"
        placeholder="Description"
        value={formData.description}
        onChange={handleChange}
        required
      />
      <input
        name="imageUrl"
        placeholder="Image URL"
        value={formData.imageUrl}
        onChange={handleChange}
      />
      <input
        type="number"
        name="locationLat"
        placeholder="Latitude"
        value={formData.locationLat}
        onChange={handleChange}
        required
      />
      <input
        type="number"
        name="locationLong"
        placeholder="Longitude"
        value={formData.locationLong}
        onChange={handleChange}
        required
      />
      <button type="submit">Submit</button>
    </form>
  );
};

export default BirdForm;
