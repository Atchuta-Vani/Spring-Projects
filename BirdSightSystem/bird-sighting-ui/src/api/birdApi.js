const API_BASE = 'http://localhost:8080/birdsightings';

export const getAllBirdSightings = async () => {
  const res = await fetch(`${API_BASE}/`);
  return res.json();
};

export const getBirdSightingById = async (id) => {
  const res = await fetch(`${API_BASE}/${id}`);
  return res.json();
};

export const createBirdSighting = async (birdSighting) => {
  const res = await fetch(API_BASE, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(birdSighting),
  });

  if (!res.ok) {
    throw new Error('Failed to create bird sighting');
  }

  return res;
};
