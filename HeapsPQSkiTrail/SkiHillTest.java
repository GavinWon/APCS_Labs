import java.util.Set;
import java.util.Iterator;

public class SkiHillTest
{
    public static double INTERVAL     = 20.0;
    public static double SkiersPerMin = 1.0;
    public static int    ENDTIME      = 2400;

    public static void main(String[] args)
    {
        SkierArrival generator = new SkierArrival(SkiersPerMin, INTERVAL);

        SkiTrail trail = new SkiTrail(1200.0);

        for (double time = 0.0; time < ENDTIME; time += INTERVAL)
        {
            Skier sk = generator.arrival(time);
            if (sk != null)
            {
                System.out.println("Skier " + sk.name() + " arrives at " + sk.time());
                trail.addSkier(sk);
            }

            Set<Skier> skiersDown = trail.skiersDownAtTime(time);

            for (Skier skier : skiersDown)
            {
                System.out.println("      Skier " + skier.name() + " down at " + skier.time());
                skier.setTime(skier.time() + 300);
                trail.addSkier(skier);
            }

//            Iterator<Skier> itr = skiersDown.iterator();
//
//            while (itr.hasNext())
//            {
//                sk = itr.next();
//                System.out.println("      Skier " + sk.name() + " down at " + sk.time());
//                sk.setTime(sk.time() + 300);
//                trail.addSkier(sk);
//            }

        }
    }
}
