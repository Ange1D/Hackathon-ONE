import React, { useState } from 'react';
import axios from 'axios';

const CheckApiConnection = () => {
  const [status, setStatus] = useState(null);

  const checkConnection = async () => {
    try {
      const response = await axios.get('https://localhost:8000'); // Reemplaza con la URL de tu API
      setStatus(`Conexión exitosa: ${response.status}`);
    } catch (error) {
      if (error.response) {
        setStatus(`Error en la respuesta: ${error.response.status}`);
      } else if (error.request) {
        setStatus('No se recibió respuesta');
      } else {
        setStatus(`Error al configurar la solicitud: ${error.message}`);
      }
    }
  };

  return (
    <div>
      <button onClick={checkConnection}>Comprobar Conexión API</button>
      {status && <p>{status}</p>}
    </div>
  );
};

export default CheckApiConnection;
