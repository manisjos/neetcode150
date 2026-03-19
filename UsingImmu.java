import LC_MV.ImmutableObject;

import java.util.ArrayList;
import java.util.List;

public class UsingImmu {
    public static void main(String[] args) {
        List<String> someList = List.of(new String[]{"abc", "bcd"});
        ImmutableObject immutableObject = new ImmutableObject("swasli", 1, List.of("abc", "bcd"));
        immutableObject.getSkills().add("test");
        immutableObject.getSkills().add("test1");
        System.out.println("Immu " + immutableObject.getSkills());
    }
}
