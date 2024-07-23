import React, { useState } from 'react';
import authService from '../../services/authService';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleLogin = (e) => {
        e.preventDefault();

        authService.login(email, password).then(
        () => {
            window.location.href = '/profile'; // Cambia esto a donde quieras redirigir después del login
        },
        error => {
            const resMessage = 
            (error.response && error.response.data && error.response.data.message) ||
            error.message ||
            error.toString();

            setMessage(resMessage);
        }
        );
    };

    return (
        <div>
        <form onSubmit={handleLogin}>
            <div>
            <label>Email</label>
            <input type="email" value={email} onChange={e => setEmail(e.target.value)} />
            </div>
            <div>
            <label>Password</label>
            <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
            </div>
            <button type="submit">Login</button>
        </form>
        {message && <div>{message}</div>}
        </div>
    );
};

export default Login;
