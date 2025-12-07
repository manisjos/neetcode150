import java.util.*;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String fn, String ln) {
        this.firstName = fn;
        this.lastName = ln;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        Person p1 = new Person("firstName", "lastName");
        Person p2 = new Person("firstName", "lastName");
        List<Person> ls = new ArrayList<>();
//        Set<Person> ss = new HashSet<>();
//
        ls.add(p1); ls.add(p2);
//        ss.add(p1); ss.add(p2);
//
//        System.out.println("list "+ls.size());
//        System.out.println("set "+ls.size());
        Iterator<Person> itr = ls.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
            ls.add(new Person("firstName3","lastName3"));
        }

    }
}
