package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle.More_detail.Good_Code;

public class ReadableFile implements Readable {

    @Override
    public void read() {
        System.out.println("Reading from file...");
    }
  
}
