import sofia.micro.*;

public class Space extends World
{
    private Asteroid[] asteroids;
    
    public Space()
    {
        super(500, 500, 1);

        asteroids = new Asteroid[3];
        
        for (int i = 0; i < asteroids.length; i++)
        {
            asteroids[i] = new Asteroid(10);
            this.add(asteroids[i],
                (i + 1) * 80,
                (i + 1) * 80);
        }
    }
}
