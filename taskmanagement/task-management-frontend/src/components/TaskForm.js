import React, { useState, useEffect } from 'react';
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

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (task && task.id) {
            await updateTask(task.id, task);
        } else if (task){
            await createTask(task);
        } else {
            console.error("Task is null or undefined!");
        }
        onSave();
        setTask({ title: '', description: '', dueDate: '', completed: false});
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="title"
                placeholder="Task Title"
                value={task.title}
                onChange={handleChange}
                required
            />
            <input
                type="text"
                name="description"
                placeholder="Task Description"
                value={task.description}
                onChange={handleChange}
                required
            />
            <input
                type="date"
                name="dueDate"
                value={task.dueDate}
                onChange={handleChange}
            />
            <label>
                Completed:
                <input
                    type="checkbox"
                    name="completed"
                    checked={task.completed}
                    onChange={handleChange}
                />
            </label>
            <button type="submit">Save Task</button>
        </form>
    );
};

export default TaskForm;