package LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Product;

import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder.StudentBuilder;

import java.util.List;

// Step 1: Product class - Complex Student object
public class Student {
    // mandatory fields
    int rollNumber;
    String name;
    int age;
    String branch;

    // optional fields
    String fatherName;
    String motherName;
    String emailId;
    String mobileNo;
    List<String> subjects;

    // Constructor - package private, only builder can create
    public Student(StudentBuilder studentBuilder)
    {
        this.rollNumber = studentBuilder.rollNumber;
        this.age = studentBuilder.age;
        this.name = studentBuilder.name;
        this.branch = studentBuilder.branch;
        this.fatherName = studentBuilder.fatherName;
        this.motherName = studentBuilder.motherName;
        this.mobileNo = studentBuilder.mobileNo;
        this.subjects = studentBuilder.subjects;
        this.emailId = studentBuilder.emailId;
    }

    public String toString()
    {
        return " roll number: " + this.rollNumber +
                " age: " + this.age +
                " name: " + this.name +
                " branch: " + this.branch +
                " father name: " + this.fatherName +
                " mother name: " + this.motherName +
                " subjects: " + subjects.get(0) + "," + subjects.get(1) + "," + subjects.get(2) +
                " mobile no: " + this.mobileNo +
                " email id: " + this.emailId;
    }
}
