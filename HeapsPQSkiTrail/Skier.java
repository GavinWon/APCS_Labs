public class Skier implements Comparable<Skier>
{
    private String myName;
    private double curTime;   // in seconds from start
    private int skill;        // 1 slowest, 2, 3 fastest

    public Skier(String name, int skillLevel, double time)
    {
        myName = name;
        curTime = time;
        skill = skillLevel;
    }

    public String name()
    {
        return myName;
    }

    public double time()
    {
        return curTime;
    }

    public void setTime(double time)
    {
        curTime = time;
    }

    public int skillLevel()
    {
        return skill;
    }

    public int compareTo(Skier otherSkier)
    {
        return (int)(time() - otherSkier.time());
    }

    public String toString()
    {
        return name() + " " + skillLevel() + " time: " + time() + "| ";
    }
}
