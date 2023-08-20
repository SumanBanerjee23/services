import React, { useState } from 'react';
import api from './ApiService';

function TokenValidator() {
  const [inputToken, setInputToken] = useState('');
  const [validationResult, setValidationResult] = useState('');

  const handleValidateToken = () => {
    api.post('/validate', { token: inputToken })
      .then(response => response.json())
      .then(data => setValidationResult(data.isValid ? 'Valid' : 'Invalid'))
      .catch(error => {
        console.error('Error validating token:', error);
        setValidationResult('Error');
      });
  };

  return (
    <div className="token-section">
      <h2>Validate Token</h2>
      <label>
        Enter Token:{' '}
        <input
          type="text"
          value={inputToken}
          onChange={e => setInputToken(e.target.value)}
        />
      </label>
      <button onClick={handleValidateToken}>Validate Token</button>
      <p>Validation Result: {validationResult}</p>
    </div>
  );
}

export default TokenValidator;
