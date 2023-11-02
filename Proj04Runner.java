

import java.io.Serializable;
import java.util.*;

//Declare a public class that implements the Comparator interface for which a compare()
// implementation will compare strings
public class Proj04Runner {
    String name = "";

    public Proj04Runner(){//overloaded constructor
        //The purpose of this constructor is to display
        // the certification.
        System.out.println(
                "I certify that this program is my own work \n"+
                        "and is not the work of others. I agree not \n" +
                        "to share my solution with others.\n" +
                        "Fred Butoma\n");
    }//end overloaded constructor

    //Overloaded constructor that takes only String values
    public Proj04Runner(String name){
        this.name = name;
    } //end overloaded constructor

    //Getter method for the String Value
    public String getName(){
        return name;
    }//end getName()

    //Override the equals method to provide consistent behavior when
    //there are duplicate strings
    public boolean equals(String obj){
        boolean equals = false;
        if (this.equals(obj)){
            equals = true;
        }
        if (!equals && obj != null && getClass().equals(obj.getClass())){
            equals = this.equals(obj);
        }
        return equals;
    } // end equals method

    //Override the HashCode method as it is recommended when overriding
    //the equals method to ensure that duplicate elements have identical
    //hashcode which is important when using hash-based collections like
    //hashSet
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }//end hashCode()

    //Override the toString method in order to display a meaningful string representation
    @Override
    public String toString() {
        return name;
    }//end toString()


//    //Implement compare from the Comparator Interface to compare strings and store them in descending order
//    @Override
//    public int compare(String o1, String o2){
//        return -(o1.compareToIgnoreCase(o2));
//    } //end compare method

    //intermediate list is sorted in case-insensitive alphabetical order
    //uses a treeSet to sort then mutates the array passed in
    public String[] runA(Object[] list){
    // initialize treeSet with TheComparator
        TreeSet tSet= new TreeSet(new TheComparator01());
        tSet = new TreeSet(new TheComparator02());
        int aSize = list.length;
        for (int i=0; i < aSize; i++){
            tSet.add(list[i]);
        }//end for loop

        //create new array using the treeSet
        String[] intermediateList = new String[tSet.size()];
       tSet.toArray(intermediateList);

       return intermediateList;
    }//end runA()

    //takes in a list and creates a treeSet in descending case reverse alphabetical order
//    public String runB(String[] list){
//
//    }//end runB()

}//end class Proj02Runner

class TheComparator01 implements Comparator, Serializable {

    //comparator class for Intermediate Results
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof String))
            throw new ClassCastException();
        if (!(o2 instanceof String))
            throw new ClassCastException();

        //Do an upper-case comparison
        int result;
        boolean o1IsLower = Character.isLowerCase(((String) o1).charAt(0));
        boolean o2IsLower = Character.isLowerCase(((String) o2).charAt(0));
        //if the second string is capitalized and first is not, first string goes first
        if (o1IsLower && !o2IsLower) { result = -1;}
       //if the first string is capitalized and the second isn't, second string goes first
        else if (!o1IsLower && o2IsLower) { result = 1;}
        //otherwise both strings are either both capitalized or not capitalized
        else { result = ((String) o1).compareToIgnoreCase(((String) o2));}

        return result;
    }//end compare()
}
class TheComparator02 implements Comparator, Serializable {

    //comparator class for Intermediate Results
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof String))
            throw new ClassCastException();
        if (!(o2 instanceof String))
            throw new ClassCastException();

        //Do an upper-case comparison
         int result = ((String)o1).compareToIgnoreCase((String)o2);

        //makes result reverse alphabetical order
        //result * (-1);

        return result;
    }//end compare()
}