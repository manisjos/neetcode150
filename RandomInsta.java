import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RandomInsta {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Xabi",
                "Ramos",
                "Jis",
                "Swas",
                "Kris",
                " ",
                null,
                "mans",
                ""
        );
        List<String> filteredNames =
                names.stream()
                        .filter(Objects::nonNull) // ignores the nulls
                        .filter(x -> !x.isBlank())
//                .filter(x->!x.isEmpty())
                        .collect(Collectors.toList());
        System.out.println(filteredNames);

    }
}
