import React, { useState } from 'react';
import api from './ApiService';

function TokenGenerator() {
  const [availableDigits, setAvailableDigits] = useState('');
  const [generatedToken, setGeneratedToken] = useState('');

  const handleGenerateToken = () => {
    const availableDigitsList = availableDigits.split(',').map(Number);
    api.post('/generate', { availableDigits: availableDigitsList })
      .then(response => setGeneratedToken(response.data.token))
      .catch(error => console.error('Error generating token:', error));
  };

  return (
    <div className="token-section">
      <h2>Generate Token</h2>
      <label>
        Available Digits (comma-separated):{' '}
        <input
          type="text"
          value={availableDigits}
          onChange={e => setAvailableDigits(e.target.value)}
        />
      </label>
      <button onClick={handleGenerateToken}>Generate Token</button>
      <p>Generated Token: {generatedToken}</p>
    </div>
  );
}

export default TokenGenerator;
