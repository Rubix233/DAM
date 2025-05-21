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
public class PartidaTest {

    private Partida partida;

    public PartidaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        partida = new Partida();
    }

    @After
    public void tearDown() {
        partida = null;
    }

    /**
     * Test del método getTurno.
     */
    @Test
    public void testGetTurno() {
        System.out.println("Test: getTurno");
        assertEquals("El turno inicial debe ser del jugador 0", 0, partida.getTurno());
        partida.tirada((byte) 0);
        assertEquals("Después de una tirada, el turno debe cambiar al jugador 1", 1, partida.getTurno());
    }

    /**
     * Test del método esFinPartida.
     */
    @Test
    public void testEsFinPartida() {
        System.out.println("Test: esFinPartida");
        assertFalse("Una nueva partida no debe estar finalizada", partida.esFinPartida());

        // Simular victoria horizontal
        partida.tirada((byte) 0); // Jugador 1
        partida.tirada((byte) 0); // Jugador 2
        partida.tirada((byte) 1); // Jugador 1
        partida.tirada((byte) 1); // Jugador 2
        partida.tirada((byte) 2); // Jugador 1
        partida.tirada((byte) 2); // Jugador 2
        partida.tirada((byte) 3); // Jugador 1 → gana

        assertTrue("Después de 4 en raya, la partida debe estar finalizada", partida.esFinPartida());
    }

    /**
     * Test del método tirada.
     */
    @Test
    public void testTirada() {
        System.out.println("Test: tirada");

        // Tirada válida
        boolean result = partida.tirada((byte) 0);
        assertTrue("Debe permitir colocar ficha en columna válida", result);

        // Llenar una columna
        for (int i = 0; i < 5; i++) {
            partida.tirada((byte) 0); // Coloca fichas en la misma columna
        }

        result = partida.tirada((byte) 0);
        assertFalse("No debe permitir colocar en columna llena", result);

        // Tirada fuera de rango
        result = partida.tirada((byte) -1);
        assertFalse("No debe permitir colocar ficha en columna inválida", result);

        result = partida.tirada((byte) 8);
        assertFalse("No debe permitir colocar ficha fuera del tablero", result);
    }

    /**
     * Test del método getGanador.
     */
    @Test
    public void testGetGanador() {
        System.out.println("Test: getGanador");

        assertEquals("No debe haber ganador al inicio", 0, partida.getGanador());

        // Simular victoria vertical del jugador 1
        partida.tirada((byte) 0); // J1
        partida.tirada((byte) 1); // J2
        partida.tirada((byte) 0); // J1
        partida.tirada((byte) 1); // J2
        partida.tirada((byte) 0); // J1
        partida.tirada((byte) 1); // J2
        partida.tirada((byte) 0); // J1 gana

        assertEquals("El ganador debe ser el jugador 1", 1, partida.getGanador());
    }
}