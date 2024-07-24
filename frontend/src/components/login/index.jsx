import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import authService from '../../services/authService';

import './login.css'

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();
    
    const handleLogin = (e) => {
        e.preventDefault();
    
        authService.login(username, password).then(
            (response) => {
                console.log('Login successful:', response); // Agrega este log
                navigate('/profile'); // Redirige al perfil después de un inicio de sesión exitoso
            },
            (error) => {
                console.log('Login error:', error); // Agrega este log
                const resMessage =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
        
                setMessage(resMessage);
            }
            );
        };

    return (
        <div className="login">
            <div className="loginTitle">
            <img src="./images/splashart-lol1.png" alt="Splashart-lol1" />
                <h2>LOGIN</h2>
            </div>
            <form className="loginCred" onSubmit={handleLogin}>
                <div>
                <h3>username</h3>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} required />
                </div>
                <div>
                <h3>Password</h3>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                </div>
                <button type="submit">Login</button>
            </form>
            {message && <div>{message}</div>}
        </div>
    );
    };
    export default Login;