//TODO Add Comments
public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female

     public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }

    public String getName()
    {
        return myName;
    }

    public int getAge()
    {
        return myAge;
    }

    public String getGender()
    {
        return myGender;
    }

    public void setName( String name )
    {
        myName = name;
    }

    public void setAge( int age )
    {
        myAge = age;
    }

    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}