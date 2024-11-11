import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Dashboard() {
    const [tenantInfo, setTenantInfo] = useState(null);

    useEffect(() => {
        // Replace with the appropriate URL to your backend
        axios.get('/api/tenants/sample-house-number')
            .then(response => {
                setTenantInfo(response.data);
            })
            .catch(error => {
                console.error('Error fetching tenant information:', error);
            });
    }, []);

    return (
        <div>
            <h2>Welcome to your Dashboard!</h2>
            {tenantInfo ? (
                <div>
                    <p>House Number: {tenantInfo.houseNumber}</p>
                    <p>Rent: {tenantInfo.rent}</p>
                    <p>Water Bill: {tenantInfo.waterBill}</p>
                    <p>Trash Collection: {tenantInfo.trashCollection}</p>
                </div>
            ) : (
                <p>Loading tenant information...</p>
            )}
        </div>
    );
}

export default Dashboard;
