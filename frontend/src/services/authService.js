import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1'; // Cambia esto a la URL de tu backend

const register = (username, password) => {
    return axios.post(`${API_URL}/user`, {
        username,
        password,
    });
};

const login = (username, password) => {
    return axios.post(`${API_URL}/login`, {
        username,
        password,
    }).then(response => {
        if (response.data.token) {
            localStorage.setItem('token', response.data.token);
        }
        return response.data;
    });
};

const logout = () => {
    localStorage.removeItem('token');
};

const getCurrentUser = () => {
    const token = localStorage.getItem('token');
    if (!token) {
        return null;
    }

    // Decodificar el token para obtener la información del usuario
    try {
        const payload = JSON.parse(atob(token.split('.')[1]));
        return { token, username: payload.username, password: payload.password };
    } catch (error) {
        return null;
    }
};

const getAuthHeader = () => {
    const token = localStorage.getItem('token');
    if (token) {
        return { Authorization: 'Bearer ' + token };
    } else {
        return {};
    }
};

export default {
    register,
    login,
    logout,
    getCurrentUser,
    getAuthHeader,
};
