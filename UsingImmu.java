import LC_MV.ImmutableObject;

import java.util.ArrayList;

public class UsingImmu {
    public static void main(String[] args) {
        ImmutableObject immutableObject = new ImmutableObject("swasli",1,new ArrayList<>(){});
        immutableObject.getSkills().add("test");immutableObject.getSkills().add("test1");
        System.out.println("Immu "+immutableObject.getSkills()  );
    }
}
