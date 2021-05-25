import java.util.Arrays;

public class StringCompression {

    public int compress(char[] chars) {
        final StringBuilder builder = new StringBuilder();
        char current = '\n';
        int count = 0;

        for (char ch : chars) {
            if (current == ch) {
                count++;
                continue;
            }
            if (count > 1) {
                builder.append(String.valueOf(count).toCharArray());
            }
            builder.append(ch);
            current = ch;
            count = 1;
        }
        if (count > 1) {
            builder.append(String.valueOf(count).toCharArray());
        }
        for (int i = 0; i < builder.length(); i++)
            chars[i] = builder.charAt(i);
        return builder.length();
    }

}
