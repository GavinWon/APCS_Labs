import java.util.Random;
import java.util.TreeSet;
import java.util.PriorityQueue;

/**
 * Represents a single ski trail that a skier can take
 *
 * @author Gavin Wong
 * @version 3/21/2019
 * @author Period - 5
 *
 * @author Assignment - HeapsPQSkiTrail
 *
 * @author Sources - TODO list collaborators
 */
public class SkiTrail
{
    private PriorityQueue<Skier> skierPQ;
    private double length;
    private Random rand;

    /**
     * Create a new SkiTrail object.
     *
     * @param len  length of trail
     */
    public SkiTrail(double len)
    {
        skierPQ = new PriorityQueue<Skier>();
        length = len;
        rand = new Random();
    }

    /**
     * Create a new SkiTrail object.
     *
     * @param len  length of trail
     * @param seed random seed - used for test purposes
     */
    public SkiTrail(double len, long seed)
    {
        this(len);
        rand.setSeed(seed);
    }

    /**
     * Calculates the time it takes for the skier to go down the trail by
     * dividing the length of the trail by the product of the skier skill level
     * and a random double between 1.0 and 2.0. The method should then set the
     * skiers current time to be its previous current time plus the time to get
     * down the hill. Finally the method addSkier should put the skier into the
     * priority queue skierPQ.
     *
     * @param sk  skier to add to the priority queue
     */
    public void addSkier(Skier sk)
    {
        double addTime = length / ((rand.nextDouble() + 1) * sk.skillLevel());
        sk.setTime(sk.time() + addTime);
        skierPQ.add(sk);
    }

    /**
     * Removes all of the skiers in the priority queue skierPQ whose current
     * times are smaller than the parameter clockTime and returns them in a
     * TreeSet.
     *
     * @param  clockTime  time
     * @return all Skiers that arrive at the bottom of the trail before
     *         clockTime
     */
    public TreeSet skiersDownAtTime(double clockTime)
    {
        TreeSet<Skier> ski = new TreeSet<Skier>();
        for (Skier person : skierPQ)
        {
            if (person.time() < clockTime)
            {
                ski.add(person);
            }
        }
        skierPQ.removeAll(ski);
        return ski; //FIX ME!
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public PriorityQueue<Skier> getSkierPQ()
    {
        return skierPQ;
    }
}

