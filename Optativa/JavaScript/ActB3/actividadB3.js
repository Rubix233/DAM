const tareas = [];
const completas = [];


function agregarTarea(nombre, fecha) {
    if (nombre.trim() != '') {
        nombre = (nombre);
        const fechaPrevista = fecha ? new Date(fecha) : null;
        fechaPrevista != null ? fechaPrevista.setHours(23, 59) : null; // Si hay fecha, ponerla al final del dia
        tareas.push({ nombre: nombre , fechaPrevista: fechaPrevista}); // Guardar fecha como objeto Date

    actualizarLista();
    }

}

function marcarCompletada(index) {
    const tarea = tareas.splice(index, 1)[0]; //Borrar de tareas desde el index, 1 elemento
    const fechaCompletada = new Date(); // Fecha actual
    const tareaCompleta = {nombre : tarea.nombre, fechaPrevista : tarea.fechaPrevista, fechaCompletada : fechaCompletada};
    completas.push(tareaCompleta); // Agregar a completas

    actualizarLista();
}

function actualizarLista() {
    //Crear las listas
    const lista = document.getElementById('listaTareas');
    lista.innerHTML = '';

    const listaCompletas = document.getElementById('listaTareasCompletas');
    listaCompletas.innerHTML = '';
    
    //Recorrer las tareas incompletas si no esta vacio
    if (tareas.length != 0) {
        tareas.forEach((tarea, index) => {
        //Crear tarjeta
        const tarjeta = document.createElement('div');
        tarjeta.className = 'tarjeta';

        //Mostrar tarea
        const info = document.createElement('div');
        info.className = 'info';
        info.textContent = tarea.nombre;
        
        //Mostrar fecha prevista
        const prevista = document.createElement('div');
        prevista.className = 'info';
        prevista.textContent = `Prevista: ${tarea.fechaPrevista ? tarea.fechaPrevista.toLocaleDateString('es-ES') + ' || ' + tarea.fechaPrevista.toLocaleTimeString([],{hour: '2-digit', minute: '2-digit'}) : 'Sin fecha prevista'}`;

        //Boton completar
        const botonCompletar = document.createElement('button');
        botonCompletar.textContent = "Marcar como completada";
        botonCompletar.style.marginLeft = '10px';
        botonCompletar.onclick = () => marcarCompletada(index);

        //Agregar a la tarjeta y luego a la lista
        tarjeta.appendChild(info);
        tarjeta.appendChild(prevista);
        tarjeta.appendChild(botonCompletar);
        lista.appendChild(tarjeta);

        document.getElementById('incompletas').style.display = 'block';
    });
    } else {
        document.getElementById('incompletas').style.display = 'none';
    }
    
    // Recorrer las tareas completadas si no esta vacio
    if (completas.length != 0) {
        completas.forEach((tarea, index) => {
            //Crear tarjeta
            const tarjeta = document.createElement('div');
            tarea.fechaPrevista != null && tarea.fechaPrevista < tarea.fechaCompletada ? tarjeta.className = 'tarjeta atrasada' : tarjeta.className = 'tarjeta completada';

            //Mostrar tarea
            const info = document.createElement('div');
            info.className = 'info';
            info.textContent = `${tarea.nombre}`;

            //Mostrar fecha prevista
            const prevista = document.createElement('div');
            prevista.className = 'info';
            prevista.textContent = `Prevista: ${tarea.fechaPrevista ? tarea.fechaPrevista.toLocaleDateString('es-ES') + ' || ' + tarea.fechaPrevista.toLocaleString([],{hour: '2-digit', minute: '2-digit'}) : 'Sin fecha prevista'}`;
        
            //Mostrar fecha completada
            const completada = document.createElement('div');
            completada.className = 'info';
            completada.textContent = `Completada: ${ tarea.fechaCompletada.toLocaleDateString('es-ES') + ' || ' + tarea.fechaCompletada.toLocaleString([],{hour: '2-digit', minute: '2-digit'})}`;

            //Agregar a la tarjeta y luego a la lista
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


document.getElementById('agregar').addEventListener('click', () => {
    const nuevaTarea = document.getElementById('nuevaTarea').value;
    const fechaEntrega = document.getElementById('fechaEntrega').value;
    agregarTarea(nuevaTarea, fechaEntrega);
    document.getElementById('nuevaTarea').value = '';
    document.getElementById('fechaEntrega').value = '';
});

