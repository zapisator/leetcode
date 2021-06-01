public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        final char[] chars = s.toCharArray();
        final StringBuilder builder = new StringBuilder();
        int brackets = 0;

        for (char ch : chars) {
            brackets += ch == '(' ? 1 : -1;
            if (brackets > 1 || brackets == 1 && ch == ')') {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

}
