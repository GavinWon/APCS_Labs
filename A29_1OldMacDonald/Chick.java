import java.util.Random;
/**
 * 
 *  TODO Creates a Chick Object
 *
 *  @author  Gavin Wong
 *  @version Oct 28, 2018
 *  @author  Period: 5
 *  @author  Assignment: A29_1OldMacDonald
 *
 *  @author  Sources: TODO
 */
class Chick implements Animal
{
    private String myType;
    private String mySound1;
    private String mySound2;
    
    
    /**
     * 
     * @param type type type of the chick- should be hcick
     * @param sound the sound the chick makes
     */
    public Chick(String type, String sound)
    {
        myType = type;
        mySound1 = sound;
    }
    
    /**
     * 
     * @param type the type - should be chick
     * @param sound1 first possible sound
     * @param sound2 second possible sound
     */
    public Chick(String type, String sound1, String sound2)
    {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }
    
    /**
     * @return one of the two sounds
     */
    public String getSound()
    {
        Random rand = new Random();
        int temp = rand.nextInt(2);
        if (temp == 0 || mySound2 == null)
        {
            return mySound1;
        }
        else
        {
            return mySound2;
        }
    }
    
    /**
     * @return the type - should be the chick
     */
    public String getType()
    {
        return myType;
    }
}