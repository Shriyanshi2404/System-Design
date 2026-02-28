package LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Leaf;

import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Component.FileSystem;

// Step 2: Leaf - File
public class File implements FileSystem {
    String fileName;

    public File(String name)
    {
        this.fileName = name;
    }

    @Override
    public void ls()
    {
        System.out.println("File name is : " + fileName);
    }
}
