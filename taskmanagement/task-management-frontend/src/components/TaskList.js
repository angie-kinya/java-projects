import React, { useEffect, useState } from 'react';
import {getAllTasks, deleteTask, updateTask} from '../services/taskService';
import axios from "axios";

const TaskList = ({ onEdit }) => {
    const [tasks, setTasks] = useState([]);

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

    const handleDelete = async (id) => {
        try {
            await deleteTask(id);
            // Refresh the task list after deletion
            loadTasks();
        } catch (error) {
            console.error("Error deleting task:", error);
            alert("Failed to delete task.");
        }
    };

    return (
        <div>
            <h2 className="text-center mb-4">Task List</h2>
            {tasks.length === 0 ? (
                <p className="text-center">No tasks available. Add some tasks!</p>
            ) : (
                <ul className="list-group">
                    {tasks.map(task => (
                        <li key={task.id} className="list-group-item d-flex justify-content-between align-items-center">
                            <div>
                                <h5>{task.title}</h5>
                                <p>{task.description}</p>
                                <p>
                                    <strong>Due:</strong> {task.dueDate || 'No due date set'}
                                </p>
                                <p>
                                    <strong>Status:</strong> {task.completed ? 'Completed' : 'Incomplete'}
                                </p>
                            </div>
                            <div>
                                <button
                                    className="btn btn-sm btn-warning me-2"
                                    onClick={() => onEdit(task.id)}
                                >
                                    Update
                                </button>
                                <button
                                    className="btn btn-sm btn-danger"
                                    onClick={() => handleDelete(task.id)}
                                >
                                    Delete
                                </button>
                            </div>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default TaskList;