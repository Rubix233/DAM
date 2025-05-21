/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andy Jan
 */
public class TableroTest {
    private Tablero tablero;
    
    public TableroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tablero = new Tablero();
    }

    @After
    public void tearDown() {
        tablero = null;
    }

    /**
     * Test of estaLleno method, of class Tablero.
     */
    @Test
    public void testEstaLleno() {
        System.out.println("Test: estaLleno");
        assertFalse("Un tablero nuevo no debe estar lleno", tablero.estaLleno());

        // Llenamos el tablero completamente
        for (int col = 0; col < 8; col++) {
            for (int fila = 0; fila < 6; fila++) {
                tablero.colocaFicha('X', (byte) fila, (byte) col);
            }
        }

        assertTrue("El tablero debería estar lleno", tablero.estaLleno());
    }

    /**
     * Test of buscaVacio method, of class Tablero.
     */
    @Test
    public void testBuscaVacio() {
        System.out.println("Test: buscaVacio");
        byte col = 3;

        // Columna vacía → debería devolver 5 (última fila)
        assertEquals("Debe encontrar el hueco en la última fila (5)", 5, tablero.buscaVacio(col));

        // Llenamos columna
        for (byte fila = 0; fila < 6; fila++) {
            tablero.colocaFicha('O', fila, col);
        }

        assertEquals("Columna llena debe devolver -1", -1, tablero.buscaVacio(col));
    }

    /**
     * Test of colocaFicha method, of class Tablero.
     */
    @Test
    public void testColocaFicha() {
        System.out.println("Test: colocaFicha");
        boolean result = tablero.colocaFicha('X', (byte) 5, (byte) 0);
        assertTrue("Debe permitir colocar ficha en posición válida", result);

        // Intento de colocar en una posición fuera de rango
        result = tablero.colocaFicha('X', (byte) 6, (byte) 0);
        assertFalse("No debe permitir colocar ficha fuera del rango de filas", result);
    }

    /**
     * Test of haGanado method, of class Tablero.
     */
        @Test
    public void testHaGanadoHorizontal() {
        System.out.println("Test: haGanado - horizontal");

        // Colocar 4 fichas en línea horizontal en fila 5
        for (byte col = 0; col < 4; col++) {
            tablero.colocaFicha('X', (byte) 5, col);
        }

        assertTrue("Debería detectar victoria horizontal", tablero.haGanado('X'));
    }

    @Test
    public void testHaGanadoVertical() {
        System.out.println("Test: haGanado - vertical");

        byte col = 0;
        for (byte fila = 6; fila > 1; fila--) {
            tablero.colocaFicha('O', fila, col);
        }

        assertTrue("Debería detectar victoria vertical", tablero.haGanado('O'));
    }

    @Test
    public void testHaGanadoDiagonal() {
        System.out.println("Test: haGanado - diagonal ↘");

        /*
         * Simulacion diagonal:
         */
        tablero.colocaFicha('X', (byte) 2, (byte) 0);
        tablero.colocaFicha('X', (byte) 3, (byte) 1);
        tablero.colocaFicha('X', (byte) 4, (byte) 2);
        tablero.colocaFicha('X', (byte) 5, (byte) 3);

        assertTrue("Debería detectar victoria diagonal ↘", tablero.haGanado('X'));
    }

    /**
     * Test del método PintaTablero.
     * Este método imprime en consola, así que simplemente se ejecuta.
     */
    @Test
    public void testPintaTablero() {
        System.out.println("Test: PintaTablero");
        tablero.PintaTablero();  // Aquí no hay aserción, se verifica visualmente si se desea.
    }
}