

import java.util.Comparator;
import java.util.Objects;

//Declare a public class that implements the Comparator interface for which a compare()
// implementation will compare strings
public class Proj04Runner implements Comparator<String>{
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
    }//end getter method

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
    } // end method

    //Override the HashCode method as it is recommended when overriding
    //the equals method to ensure that duplicate elements have identical
    //hashcode which is important when using hash-based collections like
    //hashSet
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }//end method

    //Override the toString method in order to display a meaningful string representation
    @Override
    public String toString() {
        return name;
    }//end method


    //Implement compare from the Comparator Interface to compare strings and store them in descending order
    @Override
    public int compare(String o1, String o2){
        return -(o1.compareToIgnoreCase(o2));
    } //end compare method

    //takes in a list and creates a treeSet in alphabetical order disregarding case
    public String runA(String[] list){

    }

    //takes in a list and creates a treeSet in descending case reverse alphabetical order
    public String runB(String[] list){

    }

}//end class Proj02Runner

