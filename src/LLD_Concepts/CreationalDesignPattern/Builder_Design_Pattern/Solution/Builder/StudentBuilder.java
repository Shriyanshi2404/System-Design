package LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder;

import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Product.Student;

import java.util.List;

// Step 2: Abstract Builder interface
public abstract class StudentBuilder {

    // mandatory fields
    public int rollNumber;
    public String name;
    public int age;
    public String branch;

    // optional fields
    public String fatherName;
    public String motherName;
    public String emailId;
    public String mobileNo;
    public List<String> subjects;


    public StudentBuilder setRollNumber(int rollNumber)
    {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    public StudentBuilder setAge(int age)
    {
        this.age = age;
        return this;
    }

    public StudentBuilder setBranch(String branch)
    {
        this.branch = branch;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public StudentBuilder setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public StudentBuilder setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    // Build method
    public Student build() {
        return new Student(this);
    }

}
