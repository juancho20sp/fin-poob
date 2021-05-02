package domain;
import java.awt.Color;
import static org.junit.Assert.*;

import domain.celulas.Calefactor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalefactorUTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalefactorUTest
{
    /**
     * Default constructor for test class CalefactorUTest
     */
    public CalefactorUTest()
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
     * @result La celula cambia el color.
     */
    @Test
    public void normalshouldChangeColor1()
    {
       AutomataCelular auto = new AutomataCelular();
       Calefactor indiana = new Calefactor(auto, 0, 29);
       auto.ticTac();
       assertEquals(indiana.getColor(), Color.yellow);
       auto.ticTac();
       assertEquals(indiana.getColor(), Color.red);
    }
    
    /**
     * Deberia cambiar el color por cada tic.
     *
     * @result La celula cambia el color.
     */
    @Test
    public void normalshouldChangeColor2()
    {
       AutomataCelular auto = new AutomataCelular();
       Calefactor indiana = new Calefactor(auto, 29, 29);
       auto.ticTac();
       assertEquals(indiana.getColor(), Color.yellow);
       auto.ticTac();
       assertEquals(indiana.getColor(), Color.red);
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
