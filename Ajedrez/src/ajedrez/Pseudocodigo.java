/**
 * Programa: Ajedrez

Autor: Andy Jan

Entorno:

    i, j, fila, col es numérico entero
	
    filaPar, colPar es booleano

Algoritmo:

    Escribir "Introduzca fila: "
    Leer fila
	
    Escribir "Introduzca columna: "
    Leer col
	
    filaPar --> FALSO
    colPar --> FALSO
	
    para i de 1 a 8 hacer
	
        para j de 1 a 8 hacer
		
            si j = col + (fila - i) o j = col - (fila - i) entonces
			
                Escribir "*"
                colPar --> !colPar
				
            Si no
                Si filaPar entonces
                    Si colPar entonces
                        Escribir "B"
                        colPar --> !colPar
                    Si no
                        Escribir "N"
                        colPar --> !colPar
                    Fin Si
				
                Si no
                    Si !colPar entonces
                        Escribir "B"
                        colPar --> !colPar
                    Si no
                        Escribir "N"
                        colPar --> !colPar
                    Fin Si
                Fin Si
            Fin Si
        Fin Para
		
        filaPar --> !filaPar
		
    Fin Para
	
Fin Programa
 */