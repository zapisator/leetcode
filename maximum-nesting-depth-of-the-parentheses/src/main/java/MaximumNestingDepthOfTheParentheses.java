public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxDepth = 0;
        int currantDepth = 0;

        for (char ch : chars) {
            if (ch == '(' || ch == ')') {
                currantDepth += ch == '(' ? 1 : -1;
                if (currantDepth > maxDepth) {
                    maxDepth = currantDepth;
                }
            }
        }
        return maxDepth;
    }

}
