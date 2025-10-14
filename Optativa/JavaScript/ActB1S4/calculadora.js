let num1 = 0;
let num2 = 0;
let operator = '+';
let resultado = 0;


//Mostrar
function display(shown) {
    document.getElementById('display').textContent = shown;
}

//Limpiar Calculadora
function clearCalculator() {
    num1 = 0;
    num2 = 0;
    operator = '+';
    resultado = 0;
    display(0);
}

//Mostrar construccion de operacion
function displayOperation(num1, num2, operator) {
    if(num1 != 0 && num2 != 0) {
       display(`${num1} ${operator} ${num2}`);
    } else {
        if(num1 === 0) {
            display(`${num2}`);
        } else {
            display(`${num1} ${operator}`);
        }    
    }    
}

//Construir numero
function buildNumber(digit) {
    if(num2 != 0) {
        num2 = ''+ num2 + digit;
    } else {
        num2 = digit;      
    }
    displayOperation(num1, num2, operator);
}

//Calcular resultado
function calculate() {

    num1 = parseFloat(num1);
    num2 = parseFloat(num2);
    switch(operator) {
        case '+':
            resultado = num1 + num2;
            break;
        case '−':
            resultado = num1 - num2;
            break;
        case '×':
            resultado = num1 * num2;
            break;
        case '÷':
            resultado = num1 / num2;
            break;
        case '%':
            resultado = num2/num1*100;
            break;
        case '^':
            resultado = Math.pow(num1, num2);
            break;
        };         
    resultado = parseFloat(resultado.toFixed(4));
}  

//Asignar Funcion a los botones
document.querySelectorAll('.buttons button').forEach(button => {
    button.addEventListener('click', () => {
        let className = button.className;
        if (className === 'operator') {
            calculate();
            num1 = resultado;
            operator = button.textContent;
            num2 = 0;
            displayOperation(num1, num2, operator);
        } else if (className === 'digit') {
            buildNumber(button.textContent);
        } else if (className === 'clear') {
            clearCalculator();
        } else if (className === 'equals') {
            calculate();
            display(resultado);
        }
    });
});

