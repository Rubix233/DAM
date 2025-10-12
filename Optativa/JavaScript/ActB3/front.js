const tareas = [];
const completas = [];

// --- Load tasks from server ---
async function cargarTareas() {
    try {
        const res = await fetch('/api/tasks');
        const data = await res.json();

        // Clear current arrays
        tareas.length = 0;
        completas.length = 0;

        // Load pending tasks
        if (data.tareas) tareas.push(...data.tareas);

        // Load completed tasks and convert date strings back to Date objects
        if (data.completas) {
            completas.push(...data.completas.map(t => ({
                nombre: t.nombre,
                fechaPrevista: t.fechaPrevista ? new Date(t.fechaPrevista) : null,
                fechaCompletada: t.fechaCompletada ? new Date(t.fechaCompletada) : null
            })));
        }

        actualizarLista();
    } catch (err) {
        console.error('Error loading tasks:', err);
    }
}

// --- Save tasks to server ---
async function guardarTareas() {
    try {
        await fetch('/api/tasks', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ tareas, completas })
        });
    } catch (err) {
        console.error('Error saving tasks:', err);
    }
}

// --- Add a new task ---
function agregarTarea(nombre, fecha) {
    if (nombre.trim() != '') {
        const fechaPrevista = fecha ? new Date(fecha) : null;
        if (fechaPrevista) fechaPrevista.setHours(23, 59); // End of day
        tareas.push({ nombre, fechaPrevista });
        actualizarLista();
        guardarTareas();
    }
}

// --- Mark a task as completed ---
function marcarCompletada(index) {
    const tarea = tareas.splice(index, 1)[0];
    const fechaCompletada = new Date();
    const tareaCompleta = { nombre: tarea.nombre, fechaPrevista: tarea.fechaPrevista, fechaCompletada };
    completas.push(tareaCompleta);
    actualizarLista();
    guardarTareas();
}

// --- Update the task lists in the DOM ---
function actualizarLista() {
    const lista = document.getElementById('listaTareas');
    lista.innerHTML = '';

    const listaCompletas = document.getElementById('listaTareasCompletas');
    listaCompletas.innerHTML = '';

    // Incomplete tasks
    if (tareas.length != 0) {
        tareas.forEach((tarea, index) => {
            const tarjeta = document.createElement('div');
            tarjeta.className = 'tarjeta';

            const info = document.createElement('div');
            info.className = 'info';
            info.textContent = tarea.nombre;

            const prevista = document.createElement('div');
            prevista.className = 'info';
            prevista.textContent = `Prevista: ${tarea.fechaPrevista ? tarea.fechaPrevista.toLocaleDateString('es-ES') + ' || ' + tarea.fechaPrevista.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'}) : 'Sin fecha prevista'}`;

            const botonCompletar = document.createElement('button');
            botonCompletar.textContent = "Marcar como completada";
            botonCompletar.style.marginLeft = '10px';
            botonCompletar.onclick = () => marcarCompletada(index);

            tarjeta.appendChild(info);
            tarjeta.appendChild(prevista);
            tarjeta.appendChild(botonCompletar);
            lista.appendChild(tarjeta);

            document.getElementById('incompletas').style.display = 'block';
        });
    } else {
        document.getElementById('incompletas').style.display = 'none';
    }

    // Completed tasks
    if (completas.length != 0) {
        completas.forEach((tarea) => {
            const tarjeta = document.createElement('div');
            tarjeta.className = 'tarjeta';
            if (tarea.fechaPrevista && tarea.fechaPrevista < tarea.fechaCompletada) {
                tarjeta.className += ' atrasada';
            } else {
                tarjeta.className += ' completada';
            }

            const info = document.createElement('div');
            info.className = 'info';
            info.textContent = tarea.nombre;

            const prevista = document.createElement('div');
            prevista.className = 'info';
            prevista.textContent = `Prevista: ${tarea.fechaPrevista ? tarea.fechaPrevista.toLocaleDateString('es-ES') + ' || ' + tarea.fechaPrevista.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'}) : 'Sin fecha prevista'}`;

            const completada = document.createElement('div');
            completada.className = 'info';
            completada.textContent = `Completada: ${tarea.fechaCompletada.toLocaleDateString('es-ES') + ' || ' + tarea.fechaCompletada.toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'})}`;

            tarjeta.appendChild(info);
            tarjeta.appendChild(prevista);
            tarjeta.appendChild(completada);
            listaCompletas.appendChild(tarjeta);

            document.getElementById('completas').style.display = 'block';
        });
    } else {
        document.getElementById('completas').style.display = 'none';
    }
}

// --- Event listeners ---
document.getElementById('agregar').addEventListener('click', () => {
    const nuevaTarea = document.getElementById('nuevaTarea').value;
    const fechaEntrega = document.getElementById('fechaEntrega').value;
    agregarTarea(nuevaTarea, fechaEntrega);
    document.getElementById('nuevaTarea').value = '';
    document.getElementById('fechaEntrega').value = '';
});

window.addEventListener('DOMContentLoaded', () => {
    cargarTareas();
});
