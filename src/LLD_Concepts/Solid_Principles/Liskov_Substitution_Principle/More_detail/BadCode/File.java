package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle.More_detail.BadCode;


// super class
public class File {
    public void read(){
        System.out.println("reading from file...");
    }
    public void write(){
        System.out.println("Writing to file...");
    }
}