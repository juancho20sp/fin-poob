package domain;
import java.awt.Color;
import static org.junit.Assert.*;

import domain.celulas.CelulaBipolar;
import domain.celulas.CelulaNormal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CelulaBipolarUTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CelulaBipolarUTest
{
    /**
     * Default constructor for test class CelulaBipolarUTest
     */
    public CelulaBipolarUTest()
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
     * Deberia seguir una viva y otra muerta despues de 3 ticTac.
     *
     * @result La celula especial vive.
     */
    @Test
    public void bipolarshouldChange1()
    {
       AutomataCelular auto = new AutomataCelular();
       CelulaNormal indiana = new CelulaNormal(auto, 0, 1);
       CelulaNormal OO7= new CelulaNormal(auto, 0, 0);
       CelulaBipolar pacho = new CelulaBipolar(auto, 1, 1);
       CelulaBipolar camilo = new CelulaBipolar(auto, 2, 2);
       auto.ticTac();
       auto.ticTac();
       auto.ticTac();
       assertEquals(pacho.getEstado(), 'm');
       assertEquals(camilo.getEstado(), 'v');
    }
    
    /**
     * Deberia seguir una viva y de color magenta de 3 ticTac.
     *
     * @result La celula especial vive.
     */
    @Test
    public void bipolarshouldChange2()
    {
       AutomataCelular auto = new AutomataCelular();
       CelulaNormal indiana = new CelulaNormal(auto, 0, 1);
       CelulaBipolar pacho = new CelulaBipolar(auto, 1, 1);
       CelulaBipolar camilo = new CelulaBipolar(auto, 2, 2);
       auto.ticTac();
       auto.ticTac();
       auto.ticTac();
       assertEquals(pacho.getEstado(), 'v');
       assertEquals(camilo.getEstado(), 'v');
       assertEquals(pacho.getColor(), Color.magenta);
       assertEquals(camilo.getColor(), Color.magenta);
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
