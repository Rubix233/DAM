const tareas = [];
const completas = [];


function agregarTarea(nombre) {
    tareas.push({ nombre });
    actualizarLista();
}

function actualizarLista() {
    const lista = document.getElementById('listaTareas');
    lista.innerHTML = '';

    const listaCompletas = document.getElementById('listaTareasCompletas');
    listaCompletas.innerHTML = '';

    tareas.forEach((tarea, index) => {
        const card = document.createElement('div');
        card.style.border = '1px solid #ccc';
        card.style.borderRadius = '6px';
        card.style.padding = '12px';
        card.style.marginBottom = '10px';
        card.style.width = '300px';
        card.style.boxSizing = 'border-box';
        card.style.background = '#fafafa';

        card.textContent = `${tarea.nombre} - Pendiente`;

        const botonCompletar = document.createElement('button');
        botonCompletar.textContent = "Marcar como completada";
        botonCompletar.style.marginLeft = '10px';
        botonCompletar.onclick = () => marcarCompletada(index);

        card.appendChild(botonCompletar);
        lista.appendChild(card);
    });
    if (completas.length != 0) {
        completas.forEach((tarea, index) => {
            const card = document.createElement('div');
            card.style.border = '1px solid #4CAF50';
            card.style.borderRadius = '6px';
            card.style.padding = '12px';
            card.style.marginBottom = '10px';
            card.style.width = '300px';
            card.style.boxSizing = 'border-box';
            card.style.background = '#e8f5e9';
            card.textContent = `${tarea.nombre} finalizada: ${tarea.fecha.toLocaleString()}`;
            listaCompletas.appendChild(card);
    });
    }
    
}

function marcarCompletada(index) {
    const tarea = tareas.splice(index, 1)[0]; //Borrar de tareas desde el index, 1 elemento
    const fecha = new Date();
    const tareaCompleta = {nombre : tarea.nombre, fecha : fecha}; // Crear objeto con fecha
    completas.push(tareaCompleta); // Agregar a completas
    actualizarLista();
}

document.getElementById('agregar').addEventListener('click', () => {
    const nuevaTarea = document.getElementById('nuevaTarea').value;
    agregarTarea(nuevaTarea);
    document.getElementById('nuevaTarea').value = '';
});

