import sofia.micro.*;
import sofia.util.Random;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- trung99
/**
 *  generate the world
 *  
 *
 *  @author trung99
 *  @version 2020.03.24
 */
public class CityTest extends TestCase
{
    //~ Fields ................................................................
    private City trungCity;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CityTest test object.
     */
    public CityTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
        trungCity = new City(3, 3);
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**
     * city test
     */
    
    public void testCity()
    {
        assertEquals(3, trungCity.getWidth());
        assertEquals(3, trungCity.getHeight());
        
    }
    
    
    /**
     * test populate method for elephant agent
     */
    public void testPopulate()
    {
        
        Random.setNextDoubles(0.2);
        trungCity.populate(0.3, 0.4, 0.3);
        Agent trung = trungCity.getOneObjectAt(0, 0, Agent.class);
        assertEquals("elephant", trung.getKind());
    }
    
    /**
     * test populate method for monkey agent
     */
    
    public void test1Populate()
    {
        
        Random.setNextDoubles(0.4);
        trungCity.populate(0.3, 0.4, 0.3);
        Agent agent = trungCity.getOneObjectAt(0, 0, Agent.class);
        assertEquals("monkey", agent.getKind());
    } 
    
    
    
    

}
