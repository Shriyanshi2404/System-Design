package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle.More_detail.Good_Code;

// interface
public class WriteableFile extends ReadableFile implements Writeable {

    @Override
    public void write() {
        System.out.println("Writing to file...");
    }
}