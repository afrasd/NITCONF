// Cards.jsx

import React from 'react';
import './card.css'; // Make sure to adjust the path based on your project structure
import { useState } from 'react';

function Cards() {
  const [username, setUsername] = useState('Your Name');

  return (
    <div className='Card' >
        <div className='image-container'>
          <img
            src="../assets/discussion.jpg"
            alt=''
            height="100px"
          />
        </div>
    
      <div className='lower-container'>
        <br/>
        <br/>
        <br/>
        
      </div>
    </div>
  );
}

export default Cards;
