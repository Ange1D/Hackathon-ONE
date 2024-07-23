import React, { useState } from 'react';
import authService from '../../services/authService';


import "./register.css"


const Register = () => {
    
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [acceptTerms, setAcceptTerms] = useState(false);
    const [message, setMessage] = useState('');

    const handleRegister = (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
        setMessage('Passwords do not match');
        return;
    }

    if (!acceptTerms) {
        setMessage('You must accept the terms and conditions');
        return;
    }

    const headers = authService.getAuthHeader();

    authService.register(username, email, password, { headers }).then(
        (response) => {
        setMessage('User registered successfully!');
        },
        (error) => {
        const resMessage =
            (error.response && error.response.data && error.response.data.message) ||
            error.message ||
            error.toString();

        setMessage(resMessage);
        }
    );
    };

    return(
        <div className="register">
            <div className="registerTitle">
            <img src="./images/splashart-lol1.png" alt="Splashart-lol1" />
                <h2>SIGN UP</h2>
            </div>
            <form onSubmit={handleRegister}>
                <div className="registerCred">
                    <h3>USERNAME</h3>
                    <input type="text" value={username} onChange={e => setUsername(e.target.value)} required/>
                    <h3>EMAIL</h3>
                    <input type="email" value={email} onChange={e => setEmail(e.target.value)} required/>
                    <h3>PASSWORD</h3>
                    <input type="password" value={password} onChange={e => setPassword(e.target.value)} required/>
                    <h3>CONFIRM PASSWORD</h3>
                    <input type="password" value={confirmPassword} onChange={e => setConfirmPassword(e.target.value)} required/>
                    <label htmlFor=""><input type="checkbox" className="check" checked={acceptTerms} onChange={e => setAcceptTerms(e.target.checked)}/> 
                        i accept the <a href="">TERMS & CONDITIONS</a></label>
                    <button type="submit" disabled={!acceptTerms}>REGISTER</button>
                </div>
            </form>
            {message && <div>{message}</div>}
        </div>
    )
}

export default Register;




/*import React, { useState } from 'react';
import authService from '../../services/authService';

const Register = () => {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [acceptTerms, setAcceptTerms] = useState(false);
    const [message, setMessage] = useState('');

    const handleRegister = (e) => {
    e.preventDefault();

    if (password !== confirmPassword) {
        setMessage('Passwords do not match');
        return;
    }

    if (!acceptTerms) {
        setMessage('You must accept the terms and conditions');
        return;
    }

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
            <input type="text" value={username} onChange={e => setUsername(e.target.value)} required />
        </div>
        <div>
            <label>Email</label>
            <input type="email" value={email} onChange={e => setEmail(e.target.value)} required />
        </div>
        <div>
            <label>Password</label>
            <input type="password" value={password} onChange={e => setPassword(e.target.value)} required />
        </div>
        <div>
            <label>Confirm Password</label>
            <input type="password" value={confirmPassword} onChange={e => setConfirmPassword(e.target.value)} required />
        </div>
        <div>
            <input type="checkbox" checked={acceptTerms} onChange={e => setAcceptTerms(e.target.checked)} />
            <label>I accept the terms and conditions</label>
        </div>
        <button type="submit" disabled={!acceptTerms}>Register</button>
        </form>
        {message && <div>{message}</div>}
    </div>
    );
};

export default Register;

 */