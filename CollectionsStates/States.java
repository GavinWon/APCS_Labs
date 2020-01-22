 import java.util.*;

/**
 * Represents various States and their respective cities.
 *
 * @author Gavin Wong
 * @version 4/8/2019
 * @author Period - 5
 *
 * @author Assignment - TestSem2CollectionsStates
 *
 * @author Sources - TODO list collaborators
 */
public class States
{
    private Map<String, Set<String>> theMap;

    public States()
    {
        theMap = new TreeMap<String, Set<String>>();
    }

    // postcondition: Information from theCity
    // has been added to theMap
    public void addCityToMap(CityInfo theCity)
    {
        String value = theCity.city();
        String key = theCity.state();
        if (theMap.containsKey(key))
        {
            theMap.get(key).add(value);
        }
        else
        {
            Set<String> city = new TreeSet<String>();
            city.add(value);
            theMap.put(key, city);
        }
    }

    public void printOneState(String theState)
    {
        // not allowed since output is specified without the "[...]"
        // System.out.println(theState + " " + theMap.get(theState));

        Set<String> value = theMap.get(theState);
        System.out.print(theState);
        for (String city : value)
        {
            System.out.print(" " + city);
        }
    }

    public void printAllStates()
    {
        for (String s : theMap.keySet())
        {
            printOneState(s);
            System.out.println();
        }
    }

    //*************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, Set<String>> getTheMap()
    {
        return theMap;
    }
}
