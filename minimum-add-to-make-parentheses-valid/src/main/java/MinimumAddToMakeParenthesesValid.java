public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int counter = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (balance < 0) {
                balance++;
                counter++;
            }
        }
        return counter + balance;
    }

}
