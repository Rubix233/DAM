/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sumar method, of class Calculadora.
     */
    @Test
    public void testSumar() {
        System.out.println("sumar");
        double a = 1.0;
        double b = 2.0;
        Calculadora instance = new Calculadora();
        double expResult = 3.0;
        double result = instance.sumar(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of restar method, of class Calculadora.
     */
    @Test
    public void testRestar() {
        System.out.println("restar");
        double a = 1.0;
        double b = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 1.0;
        double result = instance.restar(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiplicar method, of class Calculadora.
     */
    @Test
    public void testMultiplicar() {
        System.out.println("multiplicar");
        double a = 2.0;
        double b = 3.0;
        Calculadora instance = new Calculadora();
        double expResult = 6.0;
        double result = instance.multiplicar(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dividir method, of class Calculadora.
     */
    @Test
    public void testDividir() {
        System.out.println("dividir");
        double a = 10.0;
        double b = 2.0;
        Calculadora instance = new Calculadora();
        double expResult = 5.0;
        double result = instance.dividir(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getResultado method, of class Calculadora.
     */
    @Test
    public void testGetResultado() {
        System.out.println("getResultado");
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.getResultado();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setResultado method, of class Calculadora.
     */
    @Test
    public void testSetResultado() {
        System.out.println("setResultado");
        double resultado = 0.0;
        Calculadora instance = new Calculadora();
        instance.setResultado(resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of resetear method, of class Calculadora.
     */
    @Test
    public void testResetear() {
        System.out.println("resetear");
        Calculadora instance = new Calculadora();
        instance.resetear();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}