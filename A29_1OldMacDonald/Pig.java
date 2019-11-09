/**
 * 
 *  TODO Make a pig object
 *
 *  @author  gwong676
 *  @version Oct 28, 2018
 *  @author  Period: 5
 *  @author  Assignment: A29_1OldMacDonald
 *
 *  @author  Sources: TODO
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;

    /**
     * 
     * @param type the type of the pig - should be pig
     * @param sound the sound the pig makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }

    /**
     * @return the sound the pig makes
     */
    public String getSound()
    {
        return mySound;
    }

    /**
     * @return the type of the pig - should be pig
     */
    public String getType()
    {
        return myType;
    }
}