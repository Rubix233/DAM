
const entradaGeneral = 50;
const entradaVIP = 100;
const entradaInfantil = 25;
let totalGeneral = 0;
let totalVIP = 0;
let totalInfantil = 0;

function anadirEntrada(tipo) {
    if (tipo === 'general') {
        totalGeneral++;
    } else if (tipo === 'vip') {
        totalVIP++;
    } else if (tipo === 'infantil') {
        totalInfantil++;
    }
    actualizarContadores();
}
function restarEntrada(tipo) {
    if (tipo === 'general') {
        if (totalGeneral > 0) totalGeneral--;  

    } else if (tipo === 'vip') {
        if(totalVIP > 0) totalVIP--;

    } else if (tipo === 'infantil') {
        if(totalInfantil > 0) totalInfantil--;
    }
    actualizarContadores();
}
function actualizarContadores() {
    document.getElementById('contador-general').innerText = totalGeneral;
    document.getElementById('contador-vip').innerText = totalVIP;
    document.getElementById('contador-infantil').innerText = totalInfantil;   
}

function calcularTotal() {
    const total = (totalGeneral * entradaGeneral) + (totalVIP * entradaVIP) + (totalInfantil * entradaInfantil);
    let respuesta = confirm(`El precio final es: ${total} Eur \n\n¿Quieres proceder al pago?`);
    if (respuesta) {
        let ticket = "";
        for(let i = 0; i < totalGeneral; i++) {
            ticket += "Entrada General - 50 Eur\n";
        }
        for(let i = 0; i < totalVIP; i++) {
            ticket += "Entrada VIP - 100 Eur\n";
        } 
        for(let i = 0; i < totalInfantil; i++) {
            ticket += "Entrada Infantil - 25 Eur\n";
        }
    alert("Entradas compradas ✅");
    document.getElementById('container').style.display = 'none';
    document.getElementById('gracias').style.display = 'block';
    document.getElementById('total-pagado').innerText = `${ticket} \n El precio final ha sido de ${total} Eur`;
    
  }
}