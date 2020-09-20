import java.util.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Gavin Wong
 * @version 1/24/2019
 * 
 * @author Period - Your Period
 * @author Assignment - Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;


    /**
     * Initializes a set of Actor called actors
     */
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }


    /**
     * 
     * put actor in the set actors
     * 
     * @param actor the actor that is being placed in the set
     */
    public void signUp( Actor actor )
    {
        actors.add( actor );
    }


    /**
     * 
     * puts a msg in the corresponding mailbox, by making actor recieve it
     * 
     * @param msg the msg being sent
     */
    public void dispatch( Message msg )
    {
        Actor reciever = msg.getRecipient();
        Actor sender = msg.getSender();
        if ( reciever == null )
        {
            for ( Actor a : actors )
            {
                if ( !a.getName().equals( sender.getName() ) )
                {
                    a.receive( msg );
                }
            }
        }
        else
        {
            reciever.receive( msg );
        }
    }


    /**
     * 
     * TODO For testing purposes
     * 
     * @return returns the set actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
