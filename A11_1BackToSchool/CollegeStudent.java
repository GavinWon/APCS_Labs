// TODO add comments
/**
 * 
 * TODO Makes a college student object TODO extends student, which extends
 * person
 *
 * @author Gavin Wong
 * @version Oct 21, 2018
 * @author Period: 5
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: TODO
 */
public class CollegeStudent extends Student
{
    private int myYear;

    private String myMajor;


    /**
     * 
     * @param name
     *            the name of the student
     * @param age
     *            the age of the student
     * @param gender
     *            the gender of the student
     * @param idnum
     *            the idnum of the student
     * @param gpa
     *            the gpa of the student
     * @param year
     *            the year in which the student is in
     * @param major
     *            the major of the student
     */
    public CollegeStudent( String name, int age, String gender, String idnum,
        double gpa, int year, String major )
    {
        super( name, age, gender, idnum, gpa );
        this.myYear = year;
        this.myMajor = major;
    }


    /**
     * 
     * TODO returns the year of the student
     * 
     * @return myYear or the year of student
     */
    public int getYear()
    {
        return myYear;
    }


    /**
     * 
     * TODO change myYear
     * 
     * @param year the year to change myYear into
     */
    public void setYear( int year )
    {
        myYear = year;
    }


    /**
     * 
     * TODO returns the major of the student
     * 
     * @return myMajor or the major of the student
     */
    public String getMajor()
    {
        return myMajor;
    }


    /**
     * 
     * TODO change myMajor
     * 
     * @param major the major to change myMajor into
     */
    public void setMajor( String major )
    {
        myMajor = major;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
