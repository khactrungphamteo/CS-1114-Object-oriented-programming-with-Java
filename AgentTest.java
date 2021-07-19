import sofia.micro.*;

// -------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- trung99
/**
 *  Different test cases for agent class
 *
 *  @author trung99
 *  @version 2020.03.24
 */
public class AgentTest extends TestCase
{
    //~ Fields ................................................................
    private City trungcity;
    
    


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AgentTest test object.
     */
    public AgentTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    /**
     * set up conditions
     */
    
    public void setUp()
    {
        trungcity = new City(3, 3);
    }
    
    /**
     * test method for  getKind() method
     */
    public void testGetKind()
    {
        
        Agent trung = new Agent("elephant", 0.3);
        trungcity.add(trung, 1, 1);    
        assertEquals("elephant", trung.getKind());
    }

    /**
     * test method for  getThreshold() method
     */
    public void testGetThreshold()
    {
        
        Agent trung = new Agent("elephant", 0.3);
        trungcity.add(trung, 1, 1);
        assertEquals(trung.getThreshold(), 0.3, 0.2);

    }

    /**
     * test method for isSameKindAs() method if method returns true
     */
    public void testIsSameKindAs()
    {
       
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("elephant", 0.3);
        trungcity.add(trung, 1, 1);
        trungcity.add(trung1, 2, 1);
        assertTrue(trung.isSameKindAs(trung1));
    }

    /**
     * test for method isSameKindAs() method if method returns false
     */
    public void testIsSameKindAs1()
    {
        
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("monkey", 0.3);
        trungcity.add(trung, 1, 1);
        trungcity.add(trung1, 2, 1);
        assertFalse(trung.isSameKindAs(trung1));
    }

    /**
     * test  for isSatisfiedAt() method if method returns true
     */
    public void testIsSatisfiedAt()
    {  
        
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("monkey", 0.3);
        Agent trung2 = new Agent("monkey", 0.3);
        Agent trung3 = new Agent("monkey", 0.3);
        trungcity.add(trung, 0, 0);
        trungcity.add(trung1, 1, 0);
        trungcity.add(trung2, 1, 1);
        trungcity.add(trung3, 0, 1);
        assertTrue(trung1.isSatisfiedAt(1, 0));
    }

    /**
     * test method for isSatisfiedAt() method if method returns false
     */
    public void testIsSatisfiedAt1()
    {
        
        Agent trung = new Agent("elephant", 0.5);
        Agent trung1 = new Agent("elephant", 0.5);
        Agent trung2 = new Agent("monkey", 0.5);
        Agent trung3 = new Agent("monkey", 0.5);
        trungcity.add(trung, 0, 0);
        trungcity.add(trung1, 0, 1);
        trungcity.add(trung2, 1, 1);
        trungcity.add(trung3, 1, 0);
        assertFalse(trung3.isSatisfiedAt(1, 0));
    }

    /**
     * test method for isSatisfied() method if method returns treu
     */
    public void testIsSatisfied()
    {
        
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("monkey", 0.3);
        Agent trung2 = new Agent("monkey", 0.3);       
        trungcity.add(trung, 0, 0);
        trungcity.add(trung1, 1, 0);
        trungcity.add(trung2, 0, 1);       
        assertTrue(trung1.isSatisfied());
    }

    /**
     * test method for isSatisfied() method if method returns false
     */
    public void testIsSatisfied1()
    {
       
        Agent trung = new Agent("elephant", 0.5);
        Agent trung1 = new Agent("elephant", 0.5);
        Agent trung2 = new  Agent("monkey", 0.5);
        Agent trung3 = new Agent("monkey", 0.5);
        trungcity.add(trung, 0, 0);
        trungcity.add(trung1, 0, 1);
        trungcity.add(trung2, 1, 1);
        trungcity.add(trung3, 1, 0);
        assertFalse(trung3.isSatisfied());
    }

    /**
     * test for relocate() method
     */
    public void testRelocate()
    {
        
        Agent trung = new Agent("elephant", 0.5);
        Agent trung1 = new Agent("elephant", 0.5);
        
        Agent trung2 = new Agent("monkey", 0.5);
        Agent trung3 = new Agent("monkey", 0.5);
        Agent trung4 = new Agent("monkey", 0.5);
        
        
        trungcity.add(trung, 1, 0);
        trungcity.add(trung1, 2, 1);
        trungcity.add(trung2, 0, 0);
        trungcity.add(trung3, 1, 1);
        trungcity.add(trung4, 2, 0);
        
        trung4.relocate();
        assertEquals(2, trung4.getGridX());
        assertEquals(2, trung4.getGridY());
    }
    
    /**
     * test relocate() method for
     * different situations
     */
    public void testRelocate1()
    {
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("monkey", 0.3);
        Agent trung2 = new Agent("monkey", 0.3);
       
        trungcity.add(trung1, 0, 0);
        trungcity.add(trung, 0, 1);
        trungcity.add(trung2, 1, 1);
        trungcity.add(trung, 1, 0);
        trung.relocate();
        assertFalse(trung.isSatisfied());
    }

    /**
     * test relocate() method for different 
     * situations
     */
    public void testRelocate2()
    {
        
        Agent trung = new Agent("monkey", 0.3);
        Agent trung1 = new Agent("monkey", 0.3);
        Agent trung2 = new Agent("monkey", 0.3);
        Agent trung3 = new Agent("monkey", 0.3);
        trungcity.add(trung1, 0, 0);
        trungcity.add(trung, 0, 1);
        trungcity.add(trung2, 1, 1);
        trungcity.add(trung3, 1, 0);
        trungcity.add(trung, 1, 0);
        trung.relocate();
        assertTrue(trung.isSatisfied());
    }

    /**
     * tese method for act() method
     */
    public void testAct()
    {
        
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("elephant", 0.3);
        Agent trung2 = new Agent("monkey", 0.3);
        Agent trung3 = new Agent("monkey", 0.3);
        Agent trung4 = new Agent("monkey", 0.3);
        trungcity.add(trung, 1, 0);
        trungcity.add(trung1, 2, 1);
        trungcity.add(trung2, 0, 0);
        trungcity.add(trung3, 1, 1);
        trungcity.add(trung4, 2, 0);
        trung4.act();
        assertEquals(2, trung4.getGridX());
        assertEquals(0, trung4.getGridY());
    }
    
    /**
     * test act method 
     * for another different situation
     * 
     */
    
    public void testAct2()
    {
        Agent trung = new Agent("elephant", 0.3);
        Agent trung1 = new Agent("monkey", 0.3);
        Agent trung2 = new Agent("monkey", 0.3);
        Agent trung3 = new Agent("elephant", 0.3);
        
        trungcity.add(trung, 1, 1);
        trungcity.add(trung1, 0, 1);
        trungcity.add(trung2, 0, 0);
        trungcity.add(trung3, 1, 0);
      
        trung.act();
        assertEquals(1, trung.getGridX());
        assertEquals(1, trung.getGridY());
    }

    


   

}
