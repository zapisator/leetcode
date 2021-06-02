import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    final static int FIRST = 0;
    final static int LAST = 1;

    public List<Integer> partitionLabels(String s) {
        final char[] chars = s.toCharArray();
        final int[][] charCoordinates = new int[LAST - FIRST + 1]['z' - 'a' + 1];
        final LinkedList<Integer> result = new LinkedList<>();

        Arrays.fill(charCoordinates[FIRST], -1);
        for (int i = 0; i < chars.length; i++) {
            final int value = chars[i] - 'a';

            if (charCoordinates[FIRST][value] == -1) {
                charCoordinates[FIRST][value] = i;
            }
            if (charCoordinates[LAST][value] < i) {
                charCoordinates[LAST][value] = i;
            }

            final int length = charCoordinates[LAST][value] - charCoordinates[FIRST][value] + 1;
            if (result.size() == 0 || length == 1) {
                result.addLast(length);
            } else {
                Integer current = result.removeLast();
                while (current < length - 1 )  {
                    current += result.removeLast();
                }
                result.addLast(current + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

}
