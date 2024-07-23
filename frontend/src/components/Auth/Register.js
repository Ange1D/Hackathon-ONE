import React, { useState } from 'react';
import authService from '../../services/authService';

const Register = () => {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleRegister = (e) => {
        e.preventDefault();

        authService.register(username, email, password).then(
        response => {
            setMessage('User registered successfully!');
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
        <form onSubmit={handleRegister}>
            <div>
            <label>Username</label>
            <input type="text" value={username} onChange={e => setUsername(e.target.value)} />
            </div>
            <div>
            <label>Email</label>
            <input type="email" value={email} onChange={e => setEmail(e.target.value)} />
            </div>
            <div>
            <label>Password</label>
            <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
            </div>
            <button type="submit">Register</button>
        </form>
        {message && <div>{message}</div>}
        </div>
    );
};

export default Register;
