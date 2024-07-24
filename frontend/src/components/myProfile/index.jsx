import React from 'react';
import authService from '../../services/authService';

const Profile = () => {
    const currentUser = authService.getCurrentUser();

    return (
        <div>
        <h1>Profile</h1>
        {currentUser ? (
            <div>
            <p><strong>Username:</strong> {currentUser.username}</p>
            <p><strong>Email:</strong> {currentUser.email}</p>
            </div>
        ) : (
            <p>You are not logged in.</p>
        )}
        </div>
    );
};

export default Profile;
