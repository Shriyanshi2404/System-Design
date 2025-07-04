package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle.More_detail.BadCode;



// child class
public class ReadOnlyFile extends File{

    @Override
    public void write(){
        throw new UnsupportedOperationException("Can't write to a read only file");
    }
}