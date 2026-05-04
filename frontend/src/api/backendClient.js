const API_URL = import.meta.env.VITE_API_URL ?? 'http://localhost:8081/api';

export async function testBackend() {
  const response = await fetch(`${API_URL}/test`, {
    method: 'GET',
    headers: {
      Accept: 'text/plain'
    }
  });

  if (!response.ok) {
    throw new Error(`Error HTTP ${response.status}`);
  }

  return response.text();
}
