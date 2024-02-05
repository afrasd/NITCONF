// App.js

import React, { useEffect } from 'react';
import './App.css';
import LoginForm from './components/LoginForm/LoginForm';
import Buttons from './components/LoginForm/Buttons';
import Cards from './components/LoginForm/card';
import Form from './components/LoginForm/form'

import axios from 'axios';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  useEffect(() => {
    // Example of making a GET request to a server running on localhost:8080
    axios.get('http://localhost:8080/api/data')
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div style={{ display: 'flex', height: '100vh' }}>
      <BrowserRouter>
        <Routes>
          <Route index element={<LoginForm />} />
          <Route path="/login" element={<LoginForm />} />

          <Route path="/dummy" element={
            <div style={{ display: 'flex', flex: 1 }}>
              <Buttons style={{ flex: 1 }} />
              <div style={{ flex: 1, display: 'flex', justifyContent: 'flex-end' }}>
                <Cards />
              </div>
            </div>
          } />

          <Route path="/form" element={<Form />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
