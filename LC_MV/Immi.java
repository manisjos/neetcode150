package LC_MV;

import java.util.ArrayList;
import java.util.List;

public final class Immi {

    // private final class declaration
    // fields private final
    // initialized via constructor
    // No Setters
    //
    private final int age;
    private final String name;
    private final List<String> skills;

    Immi(int age, String name, List<String> skills) {
        this.age = age;
        this.name = name;
        //        this.skills = skills;  // ❌ BAD
        this.skills =new ArrayList<>(skills);
    }

    int getAge(){
        return age;
    }
    String getName(){
        return name;
    }
    List<String> getSkills(){
//        return skills;  // ❌ BAD
        return new ArrayList<>(skills);
    }
}
