import sofia.micro.*;

//-------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- trung99
/**
 *  check move agents to satisfied 
 *  positions
 *
 *  @author trung99
 *  @version 2020.03.24
 */
public class Agent extends Actor
{
    //~ Fields ................................................................
    private String animal;
    private double thresHold;

    //~ Constructor ...........................................................
    // ----------------------------------------------------------
    /**
     * Creates a new Agemt object.
     * @param ani             type of agent
     * @param thres           satisfaction threshold
     */
    public Agent(String ani, double thres)
    {
        /*# Do any work to initialize your class here. */

        super.setImage(ani + ".png");
        this.animal = ani;
        thresHold = thres;
    }

    //~ Methods ...............................................................
    /**
     * the getter method that returns the kind 
     * of agent 
     * @return animal field
     */

    public String getKind()
    {
        return this.animal;
    }

    /**
     * the getter method that returns the agent's 
     * satisfaction threshold
     * @return satisfaction threshold
     */

    public double getThreshold()
    {
        return this.thresHold;
    }
    
    /**
     * A boolean method that returns 
     * true if this agent 
     * is the same kind of agent as the one provided.
     * @param trung   Current agent
     * @return true if the current agent 
     * is the same kind as the one provided
     */

    public boolean isSameKindAs(Agent trung)
    {
        return animal.equals(trung.getKind());
    }
    
    /**
     * a boolean method that returns true if the agent
     * is at the current position
     * @param targetX    Target x coordinate
     * @param targetY    Target y coordinate
     * @return true if agent is at satisfied location
     * 
     */

    public boolean isSatisfiedAt(int targetX, int targetY)
    {

        int sumSameType = 0;
        int sumDiffType = 0;
        int lowX = Math.max(0, targetX - 1);
        int highX = Math.min(this.getWorld().getWidth(), targetX + 1);
        int lowY = Math.max(0, targetY - 1);
        int highY = Math.min(this.getWorld().getHeight(), targetY + 1);

        for (int x = lowX; x <= highX; x++)
        {
            for (int y = lowY; y <= highY; y++)
            {
                Agent agent = this.getWorld().getOneObjectAt(x, y, Agent.class);
                if ((agent != null) && (x != targetX || y != targetY))
                {
                    if (this.isSameKindAs(agent))
                    {
                        sumSameType++;
                    }
                    else
                    {
                        sumDiffType++;
                    }
                }

            }
        }
        double sumSameType1 = sumSameType;
        double sumDiffType1 = sumDiffType;
        double sumTotal = sumSameType1 + sumDiffType1;
        return thresHold <= sumSameType1 / sumTotal;

        

    }
    
    /**
     * a boolean method that returns true if 
     * the agent is satisfied at the specific location
     * @return true if agent is at satisfied 
     * location
     */

    public boolean isSatisfied()
    {
        return isSatisfiedAt(this.getGridX(), this.getGridY());
    }

    /**
     * A method that relocates the agent
     * if it is not at satisfied position
     */

    public void relocate()
    {
        for (int x = 0; x < this.getWorld().getWidth(); x++)
        {
            for (int y = 0; y < this.getWorld().getHeight(); y++)
            {
                Agent agent = this.getWorld().getOneObjectAt(x, y, Agent.class);
                if ((agent == null) && this.isSatisfiedAt(x, y))
                {
                    this.setGridLocation(x, y);
                }

            }
        }
    }
    
    /**
     * execute one turn for the agent
     */

    public void act()
    {
        if (!isSatisfied())
        {
            this.relocate();
        }
    }

}
