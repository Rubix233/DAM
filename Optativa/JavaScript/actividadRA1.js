console.log("Hola Mundo");

//a Declaración y Uso de Variables
let nombre = "Andy";
let edad = 30;
let esEstudiante = true;

console.log("Nombre: " + nombre + ", Edad: " + edad + ", Estudiante: " + esEstudiante);//Interpolación de cadenas clasica

//b Operaciones Básicas con Variables Numéricas
let num1 = 10;
let num2 = 5;
let suma = num1 + num2;
let resta = num1 - num2;
let multiplicacion = num1 * num2;
let division = num1 / num2;

console.log(`Suma de ${num1} y ${num2}: ${suma}, Resta: ${resta}, Multiplicación: ${multiplicacion}, División: ${division}`);//Interpolación de cadenas js

//c Concatenación de Cadenas
let mensaje = "Mi nombre es " + nombre + ", tengo " + edad + " años.";

console.log(mensaje);

//d Uso de typeof para Verificar Tipos de Datos
console.log("nombre es " + typeof nombre);
console.log("edad es " + typeof edad);
console.log("esEstudiante es " + typeof esEstudiante);
console.log("mensaje es " + typeof mensaje);