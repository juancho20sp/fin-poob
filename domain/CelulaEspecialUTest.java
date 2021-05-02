package domain;
import static org.junit.Assert.*;

import domain.celulas.CelulaEspecial;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CelulaEspecialUTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CelulaEspecialUTest
{
    /**
     * Default constructor for test class CelulaEspecialUTest
     */
    public CelulaEspecialUTest()
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
     * Deberia seguir viva despues de 3 ticTac.
     *
     * @result La celula especial vive.
     */
    @Test
    public void especialshouldLive1()
    {
       AutomataCelular auto = new AutomataCelular();
       CelulaEspecial agamenon = new CelulaEspecial(auto, 1, 1);
       CelulaEspecial venus = new CelulaEspecial(auto, 2, 2);
       auto.ticTac();
       auto.ticTac();
       auto.ticTac();
       assertEquals(agamenon.getEstado(), 'v');
       assertEquals(venus.getEstado(), 'v');
    }
    
    /**
     * Deberia morir despues de 27 ticTac.
     *
     * @result La celula especial muere.
     */
    @Test
    public void especialshouldLive2()
    {
       AutomataCelular auto = new AutomataCelular();
       CelulaEspecial agamenon = new CelulaEspecial(auto, 1, 1);
       CelulaEspecial venus = new CelulaEspecial(auto, 3, 3);
       for(int i = 1; i <= 27; i++)
       {
           auto.ticTac();
       }
       assertEquals(agamenon.getEstado(), 'm');
       assertEquals(venus.getEstado(), 'm');
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
