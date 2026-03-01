package LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder;

import java.util.ArrayList;
import java.util.List;

// Step 3: Concrete Builder for Engineering Students
public class EngineeringStudentBuilder extends StudentBuilder {

    // Engineering-specific methods
    @Override
    public StudentBuilder setSubjects()
    {
        List<String> subjects = new ArrayList<>();
        subjects.add("COA");
        subjects.add("DAA");
        subjects.add("DSA");
        subjects.add("English");
        this.subjects = subjects;
        return this;
    }
}
