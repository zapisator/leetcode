public class GoalParserInterpretation {

    enum State {
        INITIAL,
        O_OR_AL,
        AL,
    }

    public String interpret(String command) {
        char[] chars  = command.toCharArray();
        StringBuilder builder = new StringBuilder();
        State state = State.INITIAL;

        for (char ch : chars) {
            if (ch == 'G') {
                builder.append('G');
                state = State.INITIAL;
            } else if (ch == '(') {
                state = State.O_OR_AL;
            } else if (ch == 'a' || ch == 'l') {
                state = State.AL;
            } else {
                if (state.equals(State.AL)) {
                    builder.append("al");
                } else {
                    builder.append('o');
                }
                state = State.INITIAL;
            }
        }
        return builder.toString();
    }
}
