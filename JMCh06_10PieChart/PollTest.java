/**
 *  TODO Write a one-sentence summary of your class here.
 *
 *  @author  TODO Gavin Wong
 *  @version TODO /9/12/18
 *  @author  Period: TODO 6
 *  @author  Assignment: JMCh06_10PieChart
 *
 *  @author  Sources: TODO list collaborators
 */
public class PollTest
{
    /**
     * TODO Write your method description here.
     * @param args arguments and other stuff
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami",
            "Brian", "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
