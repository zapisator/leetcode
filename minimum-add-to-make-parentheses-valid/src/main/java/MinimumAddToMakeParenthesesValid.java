public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        final char[] chars = s.toCharArray();
        int counter = 0;
        int balance = 0;

        for (char ch : chars) {
            balance += ch == '(' ? 1 : -1;
            if (balance < 0) {
                balance++;
                counter++;
            }
        }
        return counter + balance;
    }

}
