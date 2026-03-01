package LLD_Concepts.CreationalDesignPattern.Builder_Design_Pattern.Solution.Builder;

import java.util.ArrayList;
import java.util.List;

// Step 3: Concrete Builder for MBA Students
public class MBAStudentBuilder extends StudentBuilder {

    // MBA-specific methods
    @Override
    public StudentBuilder setSubjects()
    {
        List<String> subjects = new ArrayList<>();
        subjects.add("Economics");
        subjects.add("Business studies");
        subjects.add("Finance");
        subjects.add("English");
        this.subjects = subjects;
        return this;
    }
}
