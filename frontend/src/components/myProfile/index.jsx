import React from 'react';
import authService from '../../services/authService';

const Profile = () => {
    const currentUser = authService.getCurrentUser();

    return (
        <div>
        <h1>Profile</h1>
        <div>
            <p><strong>Username:</strong> {currentUser.username}</p>
            <p><strong>Email:</strong> {currentUser.email}</p>
        </div>
        </div>
    );
    };

export default Profile;
