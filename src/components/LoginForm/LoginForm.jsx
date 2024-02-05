import React from 'react'
import './LoginForm.css'
import { useState } from 'react';
import { FaUser } from "react-icons/fa";
import { FaLock } from "react-icons/fa";


const LoginForm = () => {
    const[username,setUsername]=useState('')
    const[password,setPassword]=useState('')
    const[students,setStudents]=useState([])

    const handleClick=(e)=>{
        e.preventDefault()
        const reviewer={username,password}
        console.log(reviewer)
        fetch("http://localhost:8080/",{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(reviewer)
    
      }).then((e)=>{
        console.log("New Reviewer logged in")
        console.log(e)
      })
    }


    return (
        <div className='wrapper'>
            <form action="/dummy" method="POST">
                <h1>Login</h1>
                <div className="input-box">
                    <input type="text" placeholder='Username' required value={username} onChange={(e)=>setUsername(e.target.value)}/>
                    <FaUser className='icon' />
                </div>
                <div className="input-box">
                    <input type="password" placeholder='Password' required value={password} onChange={(e)=>setPassword(e.target.value)}/>
                    <FaLock className='icon'/>
                </div>

                <button type="submit" onClick={handleClick}>Login</button>
            </form>
        </div>

        
    );
};

export default LoginForm;