package domain;
import static org.junit.Assert.*;

import domain.celulas.CelulaNormal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CelulaNormalUTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CelulaNormalUTest
{
    /**
     * Default constructor for test class CelulaNormalUTest
     */
    public CelulaNormalUTest()
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
     * Deberia morir despues de 3 ticTac.
     *
     * @result La celula normal muere.
     */
    @Test
    public void normalshouldDie1()
    {
       AutomataCelular auto = new AutomataCelular();
       CelulaNormal indiana = new CelulaNormal(auto, 1, 1);
       auto.ticTac();
       auto.ticTac();
       auto.ticTac();
       assertEquals(indiana.getEstado(), 'm');
    }
    
    /**
     * Deberia morir despues de 3 ticTac.
     *
     * @result La celula normal muere.
     */
    @Test
    public void normalshouldDie2()
    {
       AutomataCelular auto = new AutomataCelular();
       CelulaNormal OO7= new CelulaNormal(auto, 2, 2);
       auto.ticTac();
       auto.ticTac();
       auto.ticTac();
       assertEquals(OO7.getEstado(), 'm');
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
