import java.util.Random;

public class SkierArrival
{
    private double numPerMinute;
    private Random rand;
    private static int nextID = 0;
    private double interval;

    public SkierArrival(double rate, double interval)
    {
        numPerMinute = rate;
        rand = new Random();
        this.interval = interval;
    }

    // precondition: numPerMinute * interval < 60.0
    public Skier arrival(double currentTime)
    {
        double prob = numPerMinute * interval / 60.0;

        if (rand.nextDouble() < prob)
        {
            nextID++;
            return new Skier( "Skier" + nextID, rand.nextInt(3) + 1, currentTime);
        }
        else
        {
            return null;
        }
    }
}
