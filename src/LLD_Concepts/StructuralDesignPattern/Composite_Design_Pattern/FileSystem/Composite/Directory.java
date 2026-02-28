package LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Composite;

import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Component.FileSystem;
import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Leaf.File;

import java.util.ArrayList;
import java.util.List;

// Step 3: Composite - Folder
public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileList;

    public Directory(String name)
    {
        this.directoryName = name;
        this.fileList = new ArrayList<>();
    }

    @Override
    public void ls()
    {
        System.out.println("Directory name is : " + directoryName);
        for(FileSystem file : fileList)
        {
            file.ls();
        }
    }

    public void addFileInList(FileSystem fileSystem)
    {
        fileList.add(fileSystem);
    }

    public void removeFile(FileSystem fileSystem)
    {
        fileList.remove(fileSystem);
    }
}
