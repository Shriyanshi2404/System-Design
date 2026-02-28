package LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem;

import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Composite.Directory;
import LLD_Concepts.StructuralDesignPattern.Composite_Design_Pattern.FileSystem.Leaf.File;

public class FileSystemDemo {
    public static void main(String[] args)
    {
        System.out.println("======= Composite Design Pattern ======");

        // Create directories
        Directory moviesDirectory = new Directory("Movies");
        Directory comedyMovieDirectory = new Directory("ComedyMovies");

        // Build the tree structure hierarchically
        File actionMovie = new File("Border");
        File comedyMovie = new File("Hulchul");

        moviesDirectory.addFileInList(actionMovie);

        // creating sub-directory which has Comedy movie
        moviesDirectory.addFileInList(comedyMovieDirectory);
        comedyMovieDirectory.addFileInList(comedyMovie);

        // Display full structure
        moviesDirectory.ls();
    }
}
