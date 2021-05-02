package domain;
import java.awt.Color;
import static org.junit.Assert.*;

import domain.celulas.Arcoiris;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArcoirisUTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArcoirisUTest
{
    /**
     * Default constructor for test class ArcoirisUTest
     */
    public ArcoirisUTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    /**
     * Deberia cambiar el color por cada tic.
     *
     * @result La celula cambia el color y forma.
     */
    @Test
    public void normalshouldChange1()
    {
       AutomataCelular auto = new AutomataCelular();
       Arcoiris indiana = new Arcoiris(auto, 1, 1);
       auto.ticTac();
       assertTrue(indiana.getColor() != Color.white);
    }
    
    /**
     * Deberia cambiar el color por cada tic.
     *
     * @result La celula cambia el color y forma.
     */
    @Test
    public void normalshouldChange2()
    {
       AutomataCelular auto = new AutomataCelular();
       Arcoiris OO7 = new Arcoiris(auto, 14, 14);
       auto.ticTac();
       assertTrue(OO7.getColor() != Color.white);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
