const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;

// Middleware to parse JSON in POST requests
app.use(express.json());

// Serve static files (CSS, JS)
app.use(express.static(path.join(__dirname)));

// Path to your JSON file
const tasksFile = path.join(__dirname, 'tareas.json');

// --- Helper functions ---
function readTasks() {
    if (!fs.existsSync(tasksFile)) return { tareas: [], completas: [] };
    const data = fs.readFileSync(tasksFile, 'utf-8');
    return JSON.parse(data);
}

function writeTasks(data) {
    fs.writeFileSync(tasksFile, JSON.stringify(data, null, 2));
}

// --- Routes ---
// Serve your HTML on root
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'actividadB3.html'));
});

// API to get tasks
app.get('/api/tasks', (req, res) => {
    res.json(readTasks());
});

// API to save tasks
app.post('/api/tasks', (req, res) => {
    writeTasks(req.body);
    res.json({ status: 'success' });
});

// --- Start server ---
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});
