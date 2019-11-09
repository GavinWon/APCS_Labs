/**
 * 
 * TODO Constructs a teacher object TODO extends Person
 *
 * @author Gavin Wong
 * @version Oct 21, 2018
 * @author Period: 5
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: TODO
 */
public class Teacher extends Person
{
    private String mySubject;

    private double mySalary;


    /**
     * 
     * @param name
     *            the name of the teacher
     * @param age
     *            the age of the teacher
     * @param gender
     *            the gender of the teacher
     * @param sub
     *            the subject the teacher is teaching
     * @param sal
     *            the sallary of the teacher
     */
    public Teacher( String name, int age,
        String gender, String sub, double sal )
    {
        super( name, age, gender );
        mySubject = sub;
        mySalary = sal;
    }


    /**
     * 
     * TODO returns the subject teacher is teaching
     * 
     * @return mySubject
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * 
     * TODO changes mySubject
     * 
     * @param sub what mySubject is being changed into
     */
    public void setSubject( String sub )
    {
        mySubject = sub;
    }


    /**
     * 
     * TODO returns the sallary of the teacher
     * 
     * @return mySalary
     */
    public double getSalary()
    {
        return mySalary;
    }


    /**
     * 
     * TODO changes mySalary
     * 
     * @param sal what mySalary is being changed into
     */
    public void setSalary( double sal )
    {
        mySalary = sal;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + 
                        mySubject + ", salary: " + mySalary;
    }
}
