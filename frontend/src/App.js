import React, { useState, useEffect } from 'react';
import { fetchEmployees, addEmployee, deleteEmployee } from './EmployeeService';

function App() {
  const [employees, setEmployees] = useState([]);
  const [newEmployee, setNewEmployee] = useState({ name: '', email: '', age: '' });

  useEffect(() => {
    fetchEmployees().then(response => setEmployees(response.data));
  }, []);

  const handleAddEmployee = () => {
    addEmployee(newEmployee).then(() => {
      setEmployees([...employees, newEmployee]);
      setNewEmployee({ name: '', email: '', age: '' });
    });
  };

  const handleDeleteEmployee = (id) => {
    deleteEmployee(id).then(() => {
      setEmployees(employees.filter(employee => employee.id !== id));
    });
  };

  return (
    <div>
      <h1>Employee Management</h1>
      <div>
        <input
          type="text"
          placeholder="Name"
          value={newEmployee.name}
          onChange={(e) => setNewEmployee({ ...newEmployee, name: e.target.value })}
        />
        <input
          type="email"
          placeholder="Email"
          value={newEmployee.email}
          onChange={(e) => setNewEmployee({ ...newEmployee, email: e.target.value })}
        />
        <input
          type="number"
          placeholder="Age"
          value={newEmployee.age}
          onChange={(e) => setNewEmployee({ ...newEmployee, age: e.target.value })}
        />
        <button onClick={handleAddEmployee}>Add Employee</button>
      </div>
      <ul>
        {employees.map((employee) => (
          <li key={employee.id}>
            {employee.name} - {employee.email} - {employee.age}
            <button onClick={() => handleDeleteEmployee(employee.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
