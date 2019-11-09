/**
 * 
 * 
 * TODO Create a NamedCow Object TODO extends Cow
 *
 * @author gwong676
 * @version Oct 28, 2018
 * @author Period: 5
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: TODO
 */
class NamedCow extends Cow
{
    private String myName;


    /**
     * 
     * @param type the type of the NamedCow - should be cow
     * @param name the name of the cow
     * @param sound the sound the cow makes
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        myName = name;
    }


    /**
     * 
     * @param type the type of the NamedCow - should be cow
     * @param sound the sound the cow makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     * 
     * returns the name
     * 
     * @return the name of the NamedCow
     */
    public String getName()
    {
        return myName;
    }
}
