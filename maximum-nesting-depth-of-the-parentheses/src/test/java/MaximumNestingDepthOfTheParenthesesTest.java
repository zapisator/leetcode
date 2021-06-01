import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumNestingDepthOfTheParenthesesTest {

    @Test
    void test_3_1() {
        Assertions.assertEquals(3, new MaximumNestingDepthOfTheParentheses().maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    @Test
    void test_3_2() {
        Assertions.assertEquals(3, new MaximumNestingDepthOfTheParentheses().maxDepth("(1)+((2))+(((3)))"));
    }

    @Test
    void test_1() {
        Assertions.assertEquals(1, new MaximumNestingDepthOfTheParentheses().maxDepth("1+(2*3)/(2-1)"));
    }

    @Test
    void test_0() {
        Assertions.assertEquals(0, new MaximumNestingDepthOfTheParentheses().maxDepth("1"));
    }

}