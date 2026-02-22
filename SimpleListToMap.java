import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleListToMap {
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
          new Employee("Isshi",11,999,"Student","School"),
        new Employee("Krish",7,1999,"Student","School"),
        new Employee("Swas",1,9999,"Student","Life"),
        new Employee("Ramos",17,88,"Lead","Life")
        );
        Map<Integer,Employee> mapEmps =
        emps.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Function.identity()
                ));
        System.out.println(mapEmps);
    }
}
