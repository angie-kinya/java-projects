import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import axios from 'axios';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';

const App = () => {
    const [taskToEdit, setTaskToEdit, tasks] = useState(null);

    const handleEdit = (task) => {
        setTaskToEdit(task);
    };

    const handleSubmit = () => {
        setTaskToEdit(null); // clear the form after save
    };

    return (
        <Router>
            <nav className="navbar navbar-light bg-light">
                <div className="container">
                    <Link className="navbar-brand" to="/">Task Manager</Link>
                    <Link className="btn btn-primary" to="/tasks">View Tasks</Link>
                </div>
            </nav>
            <div className="container mt-5">
                <Routes>
                    <Route path="/" element={<TaskForm onSave={handleSubmit} />} />
                    <Route path="/tasks" element={<TaskList tasks={tasks} />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
