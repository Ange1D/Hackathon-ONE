import axios from 'axios';

const API_URL = 'http://localhost:8000'; // Cambia esto a la URL de tu backend

const register = (username, email, password) => {
    return axios.post(`${API_URL}/user`, {
        username,
        email,
        password,
    });
    };

    const login = (email, password) => {
    return axios.post(`${API_URL}/login`, {
        email,
        password,
    }).then(response => {
        if (response.data.token) {
        localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
    });
    };

    const logout = () => {
    localStorage.removeItem('user');
    };

    const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem('user'));
    };

    const getAuthHeader = () => {
    const user = getCurrentUser();
    if (user && user.token) {
        return { Authorization: `Bearer ${user.token}` };
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
