import java.util.*;
import java.util.stream.Collectors;

public class ComparatorBasic {
    public static void main(String[] args) {
        List<Student> el = new ArrayList<>(Arrays.asList(
                new Student(11, "Xabi", 22.0),
                new Student(21, "Jis", 20),
                new Student(1, "Swas", 70),
                new Student(6, "Kris", 50),
                new Student(7, "Ramos", 40)

        ));

        List<Student> c2 = new ArrayList<>(Arrays.asList(
                new Student(11, "Xabi", 22.0),
                new Student(21, "Jis", 20),
                new Student(1, "Swas", 70),
                new Student(6, "Kris", 50),
                new Student(7, "Ramos", 40)

        ));

        List<Student> lambdaList = new ArrayList<>(Arrays.asList(
                new Student(11, "Xabi", 22.0),
                new Student(21, "Jis", 20),
                new Student(1, "Swas", 70),
                new Student(6, "Kris", 50),
                new Student(7, "Ramos", 40)

        ));
        System.out.println("Comparable Way: ");
        System.out.println("Before "+ el.stream().map(Student::getMarks).toList());
        Collections.sort(el);
        System.out.println("After "+ el.stream().map(Student::getMarks).toList());


        System.out.println("Comparator Way: ");
        System.out.println("Before "+ c2.stream().map(Student::getName).toList());
        c2.sort(new AgeComparator());
        System.out.println("After "+ c2.stream().map(Student::getName).toList());

        System.out.println("Lambda Way: ");

        System.out.println("Before "+ lambdaList.stream().map(Student::getName).toList());
        // Lambda — cleanest form
        lambdaList.sort((a,b)->a.getName().compareTo(b.getName()));

        // Method reference
        lambdaList.sort(Comparator.comparing(Student::getName));

        // Reverse order
        lambdaList.sort(Comparator.comparing(Student::getRollNum).reversed());
        System.out.println("After "+ lambdaList.stream().map(Student::getName).toList());


        // Chain multiple sorts
        lambdaList.sort(
                Comparator.comparing(Student::getName)
                        .thenComparing(Student::getRollNum)
                        .thenComparing(Student::getMarks)
        );

        // Null-safe
        Comparator.nullsFirst(Comparator.comparing(Student::getName));
        Comparator.nullsLast(Comparator.naturalOrder());

    }
}

