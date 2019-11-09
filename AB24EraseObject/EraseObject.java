import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;

/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  Gavin Wong
 *  @version 11/19/2018
 *  @author Period: 5
 *  @author Assignment: AB24_1EraseObject_GridWorld
 *
 *  @author Sources: TODO
 */
public class EraseObject extends World<Tile>
{
    private static final Color IMGOBJ_COLOR = Color.BLACK;
    private static final Color ERASE_COLOR = Color.WHITE;
    
    /**
     * Constructs a default 20x20 grid containing black tiles
     * at the locations given in the file "digital.txt".
     */
    public EraseObject()
    {
        this( new BoundedGrid<Tile>( 20, 20 ), "digital.txt" );
    }

    /**
     * Constructs an EraseObject World with the provided grid. Populates
     * the world with black tile objects at the locations given in the 
     * specified file (fName).
     * 
     * @param bg    bounded grid used by this World
     * @param fName name of file containing location information for
     *               tile placement in this World
     */
    public EraseObject( BoundedGrid<Tile> bg, String fName )
    {
        setGrid( bg );
        getData( fName );

        setMessage( "Click on the object to be erased" );
    }

    /**
     * Overrides <code>info.gridworld.world.World&lt;Tile&lt;.locationClicked</code>
     * This method is called when the user clicks on a location in the WorldFrame.
     * Invokes the recursive erase procedure on the clicked location.
     * 
     * @param loc the grid location that the user selected
     * @return true - the world consumes the click
     */
    public boolean locationClicked( Location loc )
    {
        Grid<Tile> gr = getGrid();

        setMessage( "Tile clicked at " + loc );
        erase( gr, loc.getRow(), loc.getCol() );

        return true;
    }

    /**
     *  Loads the data from the specified file containing tile locations
     *  into the this grid.
     *  
     *  The first entry in the provided text file is the number of pairs
     *  that follow (i.e., 55). Each subsequent line contains a pair of
     *  integers, separated by a blank space. Each pair is a row and column
     *  coordinate that specifies the location of a black tile in the
     *  starting grid.
     *  
     *  @param fName name of file containing tile locations
     * @throws FileNotFoundException 
     */
    private void getData( String fName )// throws FileNotFoundException
    {
        File f = new File(fName);
        Scanner scan = null;
        Grid<Tile> gr = getGrid();
        try
        {
            scan = new Scanner(f);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + fName + " ***");
            System.exit(1);
        }
        int numPairs = scan.nextInt();
        System.out.println(numPairs);
        for (int index = 0; index < numPairs; index++)
        {
            int r = scan.nextInt();
            int c = scan.nextInt();
            gr.put( new Location(r,c) , new Tile (Color.BLACK));
        }
        
    }

    /**
     * Recursively changes the color of a series of adjacent tiles (erases)
     * starting at the given coordinates if this coordinate is part of
     * the object. The method should erase the entire object (remove black).
     *
     * @param gr     grid containing sequences of adjacent tiles
     * @param row    row coordinate to begin erasure
     * @param col    column coordinate to begin erasure
     */
    private void erase( Grid<Tile> gr, int row, int col )
    {
        Tile t = gr.get(new Location(row, col));
        if (t != null && t.getColor() == Color.BLACK)
        {
            t.setColor(Color.WHITE);
            for (int indexR = row - 1; indexR <= row + 1; indexR++)
            {
                for (int indexY = col - 1; indexY <= col + 1; indexY++)
                {
                    if (gr.isValid(new Location(indexR,indexY)))
                    {
                        Tile t1 = gr.get(new Location(indexR, indexY));
                        if (t1 != null && t1.getColor() == Color.BLACK &&
                                        (indexR != row || indexY != col))
                        {
                            erase(gr, indexR, indexY);
                        }
                    }
                    
                }
            }
        }
        
        
    }

    public static void main( String[] args )
    {
        new EraseObject().show();
    }
}
