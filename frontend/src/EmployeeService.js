import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1/employee';

const fetchEmployees = () => axios.get(API_URL);
const addEmployee = (newEmployee) => axios.post(API_URL, newEmployee);
const deleteEmployee = (id) => axios.delete(`${API_URL}/${id}`);

export { fetchEmployees, addEmployee, deleteEmployee };
