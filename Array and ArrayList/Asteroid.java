import sofia.micro.*;

public class Asteroid extends OrbitalObject
{
    public Asteroid(int moveSize)
    {
        super(moveSize);
    }
    
    public void act()
    {
        this.move(moveSize);
        this.turn(moveSize);
    }
}
