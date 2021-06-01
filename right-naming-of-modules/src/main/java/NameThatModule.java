import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class NameThatModule {

    public static void main(String[] args) {
        final String s = "Design Parking System".trim();
        System.out.printf("\n\nModule name:\n%s\n\nClass name:\n%s\n\n",
                nameOfModule(s), nameOfClass(s)
        );
    }

    private static String nameOfModule(String s) {
        return s.toLowerCase(Locale.ROOT).replace(' ', '-');
    }

    private static String nameOfClass(String s) {
        return Arrays.stream(s.split("\\W"))
                .map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .collect(Collectors.joining(""));
    }

}
