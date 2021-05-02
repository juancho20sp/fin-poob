package domain;
import static org.junit.Assert.*;

import domain.celulas.CelulaConway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CelulaConwayUTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CelulaConwayUTest
{
    /**
     * Default constructor for test class CelulaConwayUTest
     */
    public CelulaConwayUTest()
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
     * Deberia seguir parpadear ticTac.
     *
     * @result La celulas parpadean.
     */
    @Test
    public void conwayshouldParpadear1()
    {
        AutomataCelular auto = new AutomataCelular();
        CelulaConway john7 = new CelulaConway(auto, 28, 14);
        CelulaConway horton7 = new CelulaConway(auto, 28, 15);
        CelulaConway pacho7 = new CelulaConway(auto, 28, 16);
        auto.ticTac();
        assertEquals(john7.getEstado(), 'm');
        assertEquals(pacho7.getEstado(), 'm');
        assertEquals(auto.getElemento(27, 15).getEstado(), 'v');
        assertEquals(auto.getElemento(29, 15).getEstado(), 'v');
    }
    
    /**
     * Deberia seguir parpadear ticTac.
     *
     * @result Las celulas deberian permanecer vivas.
     */
    @Test
    public void conwayshouldLive()
    {
        AutomataCelular auto = new AutomataCelular();
        CelulaConway john5 = new CelulaConway(auto, 29, 0);
        CelulaConway horton5 = new CelulaConway(auto, 29, 1);
        CelulaConway pacho5 = new CelulaConway(auto, 28, 0);
        CelulaConway camilo5 = new CelulaConway(auto, 28, 1); 
        auto.ticTac();
        assertEquals(john5.getEstado(), 'v');
        assertEquals(horton5.getEstado(), 'v');
        assertEquals(pacho5.getEstado(), 'v');
        assertEquals(camilo5.getEstado(), 'v');
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
