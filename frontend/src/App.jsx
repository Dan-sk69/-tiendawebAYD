import { useEffect, useState } from 'react';
import { testBackend } from './api/backendClient.js';

export default function App() {
  const [status, setStatus] = useState('Verificando backend...');

  useEffect(() => {
    testBackend()
      .then(setStatus)
      .catch(() => setStatus('No se pudo conectar con el backend'));
  }, []);

  return (
    <main className="app-shell">
      <section className="status-panel">
        <p className="eyebrow">Sistema de Ventas de Ropa</p>
        <h1>Panel inicial</h1>
        <p className="status">{status}</p>
      </section>
    </main>
  );
}
