import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- trung99
/**
 *  generate the world
 *
 *  @author trung99
 *  @version 2020.03.06
 */
public class City extends World
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new City object.
     */
    public City()
    {
        // Nothing to initialize, leaving the world a default size
        super(10, 10, 24);
        this.populate(0.3, 0.4, 0.3);
    }
    
    /**
     * second constructor to create new City object
     * @param width      width of the world
     * @param height     height of the world
     */

    public City(int width, int height)
    {
        super(width, height, 24);
        
    }
    
    /**
     * take three different parameters
     * @param elephantVal  percentage of Agent elephants
     * @param monkeyVal    percentaage of Agent monkeys
     * @param emptyCell    satisfaction threshold
     */

    public void populate(double elephantVal, double monkeyVal, double emptyCell)
    {

        for (int x = 0; x < this.getWidth(); x++)
        {
            for (int y = 0; y < this.getHeight(); y++)
            {
                double value = Random.generator().nextDouble(0.0, 1.0);
                if (value < elephantVal)
                {
                    Agent trung = new Agent("elephant", emptyCell);
                    add(trung, x, y);

                }
                else if (value < elephantVal + monkeyVal)
                {
                    Agent trung = new Agent("monkey", emptyCell);
                    add(trung, x, y);
                }
                

            }

        }
    

        
        
        

    }
}
