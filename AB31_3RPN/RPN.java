import java.util.*;

/**
 * RPN Calculator
 *
 * @author TODO Gavin Wong  
 * @version TODO 1/18/2019
 * @author Period: 5
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: TODO List Collaborators
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );
    
    private Stack<Integer> myStack;
    private Queue<String> myQ;

    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }
    
    /**
     *  **** Used for testing - Do Not Remove ***
     *  
     *  Constructs an RPN Calculator and then redirects the Scanner input
     *  to the supplied string.
     *  
     *  @param console  replaces console input
     */
    public RPN(String console)
    {
        this();
        scan = new Scanner( console );
    }

    /**
     * TODO Write your method description here.
     */
    public void calculate()
    {
        
        
        String nextInput = scan.nextLine();
        
        while (!nextInput.equals("q") && !nextInput.equals("Q"))
        {
            myQ.add(nextInput);
            switch (nextInput)
            {
                case "+":
                    add();
                    break;
                    
                case "-":
                    subtract();
                    break;
                    
                case "*":
                    multiply();
                    break;
                    
                case "/":
                    divide();
                    break;
                    
                default:
                    myStack.push(Integer.parseInt(nextInput));
                
            }
            nextInput = scan.nextLine();
            
        }
        
    
    System.out.print(qToString() + "= " + myStack.pop());
        
    }

    public void add()
    {
        int x = myStack.pop();
        int y = myStack.pop();
        
        myStack.push(x + y);
        
    }
    
    public void subtract()
    {
        int x = myStack.pop();
        int y = myStack.pop();
        
        myStack.push(y - x);
    }
    
    public void multiply()
    {
        int x = myStack.pop();
        int y = myStack.pop();
        
        myStack.push(x * y);
    }
    
    public void divide()
    {
        int x = myStack.pop();
        int y = myStack.pop();
        
        myStack.push(y / x);
        
    }
    
    public String qToString()
    {
        String print = "";
        while (!myQ.isEmpty())
        {
            print += myQ.remove() + " ";
        }
        return print;
    }
    
    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}