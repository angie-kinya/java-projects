import React, { useState } from 'react';
import TaskList from './components/TaskList';
import TaskForm from './components/TaskForm';

function App() {
  const [taskToEdit, setTaskToEdit] = useState(null);

  const handleEdit = (task) => {
    setTaskToEdit(task);
  };

  const handleSave = () => {
    setTaskToEdit(null); // clear the form after save
  };

  return (
    <div>
      <h1>Task Management</h1>
      <TaskForm taskToEdit={taskToEdit} onSave={handleSave} />
      <TaskList onEdit={handleEdit} />
    </div>
  );
}

export default App;
