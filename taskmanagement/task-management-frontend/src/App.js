import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import axios from 'axios';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';
import {getAllTasks} from "./services/taskService";

const App = () => {
    const [tasks, setTasks] = useState([]);
    const [taskToEdit, setTaskToEdit] = useState(null);

    // Load tasks from the backend when the app loads
    useEffect(() => {
        loadTasks();
    }, []);

    const loadTasks = async () => {
        try {
            const response = await getAllTasks();
            setTasks(response.data);
        } catch (error) {
            console.error("Error loading tasks:", error);
        }
    };

    const handleSaveTask = () => {
        loadTasks(); // Refresh tasks after save
        setTaskToEdit(null); // Clear editing state
    };

    const handleEditTask = (task) => {
        setTaskToEdit(task); // Set the task to edit
    };

    /* const handleSaveTask = async (task) => {
        try {
            await saveTask(task); // Save to backend
            setTaskToEdit(null); // Clear edit state
            loadTasks(); // Refresh the task list
        } catch (error) {
            console.error("Error saving task:", error);
        }
    };

    const handleEditTask = (task) => {
        setTaskToEdit(task); // Set the task to edit in the form
    }; */

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
                    <Route path="/" element={<TaskForm onSave={handleSaveTask} taskToEdit={taskToEdit} />} />
                    <Route path="/tasks" element={<TaskList tasks={tasks} onEdit={handleEditTask} />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
