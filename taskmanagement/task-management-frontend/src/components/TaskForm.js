import React, { useState, useEffect } from 'react';
import axios from 'axios';

import { createTask, updateTask } from '../services/taskService';

const TaskForm = ({ taskToEdit, onSave }) => {
    const [task, setTask] = useState({ title: '', description: '', dueDate: '', completed: false});

    useEffect(() => {
        if (taskToEdit) {
            setTask(taskToEdit);
        } else {
            setTask({ title: '', description: '', dueDate: '', completed: false});
        }
    }, [taskToEdit]);

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setTask({ ...task, [name]: type === 'checkbox' ? checked : value });
    };

    const handleSubmit = async  (e) => {
        e.preventDefault();
        if (task && task.id) {
            await updateTask(task.id, task);
        } else if (task){
            await createTask(task);

        } else {
            console.error("Task is null or undefined!");
        }
        onSave();
        setTask({ title: '', description: '', dueDate: '', completed: false}); // clear the form
    };

    return (
        <div className="form-container">
            <div className="form-wrapper">
                <form onSubmit={handleSubmit}>
                    <h3 className="text-center">Task Form</h3>
                    <div className="mb-3">
                        <label htmlFor="title" className="form-label">Title</label>
                        <input
                            type="text"
                            id="title"
                            name="title"
                            value={task.title}
                            onChange={handleChange}
                            placeholder="Enter task title"
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="description" className="form-label">Description</label>
                        <textarea
                            id="description"
                            name="description"
                            className="form-control"
                            placeholder="Enter task description"
                            value={task.description}
                            onChange={handleChange}
                            rows="5"
                        ></textarea>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="dueDate" className="form-label">Due Date</label>
                        <input
                            type="date"
                            id="dueDate"
                            name="dueDate"
                            value={task.dueDate}
                            onChange={handleChange}
                            className="form-control"
                        />
                    </div>
                    <div className="form-check mb-3">
                        <input
                            type="checkbox"
                            id="completed"
                            name="completed"
                            checked={task.completed}
                            onChange={handleChange}
                            className="form-check-input"
                        />
                        <label className="form-check-label" htmlFor="completed">Completed</label>
                    </div>
                    <button type="submit" className="btn btn-primary w-100">Save Task</button>
                </form>
            </div>
        </div>
    );
};

export default TaskForm;