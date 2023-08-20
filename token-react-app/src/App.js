import React from 'react';
import './App.css';
import TokenGenerator from './TokenGenerator';
import TokenValidator from './TokenValidator';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Token App</h1>
        <main>
        <TokenGenerator />
        <TokenValidator />
      </main>
      </header>
    </div>
  );
}

export default App;
