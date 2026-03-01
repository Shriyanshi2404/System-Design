package LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Director;

import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder.EngineeringStudentBuilder;
import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder.MBAStudentBuilder;
import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder.StudentBuilder;
import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Product.Student;

// Step 5: Director class for common student registration processes
public class StudentRegistrationDirector {

    StudentBuilder studentBuilder;

    public StudentRegistrationDirector(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }


    public Student createStudent()
    {
        if(studentBuilder instanceof EngineeringStudentBuilder)
            return createEngineeringStudent();
        else if(studentBuilder instanceof MBAStudentBuilder)
            return createMBAStudent();
        return null;
    }


    public Student createEngineeringStudent()
    {
        return studentBuilder
                .setRollNumber(1) // EngineeringStudentBuilder
                .setAge(22)
                .setName("John")
                .setFatherName("Paul")
                .setMotherName("Jane")
                .setBranch("Computer Science and Engineering")
                .setSubjects() // Engineering-specific method
                .build();

    }

    public Student createMBAStudent()
    {
        return studentBuilder.setRollNumber(2) // MBAStudentBuilder
                .setAge(24)
                .setName("Sarah")
                .setFatherName("Gabriel")
                .setMotherName("Taylor")
                .setBranch("Business Administration")
                .setSubjects() // MBA-specific method
                .setMobileNo("9876543210")
                .setEmailId("sarahgabriel@iitb.com")
                .build();
    }
}
