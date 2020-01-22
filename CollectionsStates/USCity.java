/**
 * Skeleton class that implements the CityInfo Interface
 *
 * @author george_peck
 * @version Mar 15, 2017
 *
 * @author Period - 1-7
 * @author Assignment - States Free Response
 *
 * @author Sources - none
 */
public class USCity implements CityInfo
{
    private String city;
    private String state;

    public USCity (String city, String state)
    {
        this.city = city;
        this.state = state;
    }

    public String city()
    {
        return city;
    }

    public String state()
    {
        return state;
    }

    public String toString()
    {
        return city() + ", " + state();
    }

}
