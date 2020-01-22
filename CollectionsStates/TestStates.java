import java.util.Map;
import java.util.Set;

/**
 * States class test shroud
 *
 * @author george_peck
 * @version Mar 15, 2017
 *
 * @author Period - 1-7
 * @author Assignment - States Free Response
 *
 * @author Sources - none
 */
public class TestStates
{
    public static void main(String[] args)
    {
        States stateMap = new States();

        stateMap.addCityToMap(new USCity("Albany", "NY"));
        stateMap.addCityToMap(new USCity("Miami", "FL"));
        stateMap.addCityToMap(new USCity("Hamilton", "NY"));
        stateMap.addCityToMap(new USCity("Jacksonville", "FL"));
        stateMap.addCityToMap(new USCity("Dallas", "TX"));

        USCity city1 = new USCity("Albany", "GA");
        USCity city2 = new USCity("Houston", "TX");

        stateMap.addCityToMap(city1);
        stateMap.addCityToMap(city2);

        stateMap.printOneState("FL");
        System.out.println();
        stateMap.printAllStates();
    }

}
