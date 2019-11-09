/**
 * Implements the minimum requirements specified by the Animal interface
 * 
 * @author Gavin Wong
 * @version
 * 
 *          Period - 1-7 Assignment - A29.1 - Old MacDonald
 * 
 *          Sources - Roger Frank
 */
public class Cow implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type the type of Cow
     * @param sound the sound the Cow makes
     */
    public Cow( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    public String getSound()
    {
        return mySound;
    }


    public String getType()
    {
        return myType;
    }
}
