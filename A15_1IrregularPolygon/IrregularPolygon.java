import java.awt.geom.*;
import java.util.*;
import gpdraw.*;

/**
 * TODO Has an ArrayList of Points that are vertices of the polygon
 * TODO You can get perimeter and area, and draw the Irregular Polygon
 *
 * @author  TODO Gavin Wong
 * @version TODO 11/8/2018
 *
 * @author  Period - TODO Your Period
 * @author  Assignment - TODO Assignment Name
 * 
 * @author  Sources - TODO list collaborators
 */
public class IrregularPolygon
{
    private DrawingTool pen; // new DrawingTool( new SketchPad( 300, 300, 0 ) );
    private ArrayList<Point2D.Double> myPolygon;

    //constuctors
    
    /**
     * Initiliaze the ArrayList
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }

    // public methods
    
    /**
     * 
     * TODO adds a Point (vertex) to the myPolygon ArrayList
     * @param aPoint the point to add
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add(aPoint);
    }

    /**
     * 
     * TODO calculates the perimeter of the polygon
     * @return the perimeter of the polygon
     */
    public double perimeter()
    {
        double peri = 0;
        double d;
        int index;
        for (index = 0; index < myPolygon.size(); index++)
        {
            if (index == myPolygon.size() - 1)
            {
                d = Math.sqrt((myPolygon.get(0).getX() - 
                                myPolygon.get(index).getX())
                    * (myPolygon.get(0).getX() - myPolygon.get(index).getX())
                    + (myPolygon.get(0).getY() - myPolygon.get(index).getY())
                    * (myPolygon.get(0).getY() - myPolygon.get(index).getY()));
                peri += d;
                break;
            }
            
            double x1 = myPolygon.get(index).getX();
            double y1 = myPolygon.get(index).getY();
            double x2 = myPolygon.get(index + 1).getX();
            double y2 = myPolygon.get(index + 1).getY();
            d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            peri += d;
        }
        
        return peri;
    }

    /**
     * 
     * TODO calculates the area of the polygon
     * @return the area of the polygon
     */
    public double area()
    {
        double area = 0;
        double prod;
        for (int index = 0; index < myPolygon.size(); index++)
        {
            if (index == myPolygon.size() - 1)
            {
                prod = myPolygon.get(index).getX() * myPolygon.get(0).getY();
                area += prod;
                break;
                
            }
            double x1 = myPolygon.get(index).getX();
            double y2 = myPolygon.get(index + 1).getY();
            prod = x1 * y2;
            area += prod;
        }
        for (int index = 0; index < myPolygon.size(); index++)
        {
            if (index == myPolygon.size() - 1)
            {
                prod = myPolygon.get(0).getX() * myPolygon.get(index).getY();
                area -= prod;
                break;
                
            }
            double x2 = myPolygon.get(index + 1).getX();
            double y1 = myPolygon.get(index).getY();
            prod = x2 * y1;
            area -= prod;
        }
        return Math.abs(area / 2);
    }

    /**
     * 
     * TODO Uses the pen to draw the polygon
     */
    public void draw()
    {
        pen.up();
        for (int index = 0; index < myPolygon.size(); index++)
        {
            pen.move(myPolygon.get(index).getX(), myPolygon.get(index).getY());
            if (index == 0)
            {
                pen.down();
            }
            if (index == myPolygon.size() - 1)
            {
                pen.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
            }
            
        }
        
    }
}
