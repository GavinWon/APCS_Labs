import java.util.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
  
   @author  TODO Your Name
   @version TODO Date

   Period - TODO Your Period
   Assignment - A29.1 Old MacDonald

   Sources - TODO list collaborators
 */
public class Farm
{
   private Animal[] a = new Animal[3];

   public Farm()
   {      
       a[0] = new NamedCow("cow","Elsie","moo");
       a[1] = new Chick("chick","cluckity cluck", "cheep");
       a[2] = new Pig("pig","oink");
   }

   public void animalSounds()
   {
      for (int i = 0; i < a.length; i++)
      {
         System.out.println(a[i].getType() + " goes " + a[i].getSound());
      }
      NamedCow named = (NamedCow)a[0];
      System.out.println( named.getType() + " is named " + named.getName() );
   }
}

