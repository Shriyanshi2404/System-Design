package LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Client;

import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder.EngineeringStudentBuilder;
import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder.MBAStudentBuilder;
import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Director.StudentRegistrationDirector;
import LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Product.Student;

public class StudentDemo {

    public static void main(String[] args)
    {
        System.out.println("===== Builder Design Pattern =====");
        // Create director objects
        StudentRegistrationDirector director1 = new StudentRegistrationDirector(new EngineeringStudentBuilder());
        StudentRegistrationDirector director2 = new StudentRegistrationDirector(new MBAStudentBuilder());

        // Create students using different builders
        Student engineerStudent = director1.createEngineeringStudent();
        Student mbaStudent = director2.createMBAStudent();

        // Print student details
        System.out.println("===> Student details:" + engineerStudent.toString());
        System.out.println("===> Student details:" + mbaStudent.toString());

    }
}
