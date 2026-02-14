package LC_MV;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableObject {
//    Make the class final //
//    Make all fields private final//
//    No setters//
//    Initialize via constructor//
//    Return defensive copies for mutable fields

    private final String name;
    private final int age;
    private final List<String> skills;

    public ImmutableObject(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        //        this.skills = skills;  // ❌ BAD
        this.skills = new ArrayList<>(skills);
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public List<String> getSkills(){
        //        return skills;  // ❌ BAD
        return new ArrayList<>(skills);
    }
}
