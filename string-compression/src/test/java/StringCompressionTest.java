import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCompressionTest {

    final StringCompression stringCompression = new StringCompression();

    @Test
    void threeGroupsWithLengthFrom2to9_returns6() {
        Assertions.assertEquals(6, stringCompression.compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    @Test
    void singleChar_returns1() {
        Assertions.assertEquals(1, stringCompression.compress(new char[]{'a'}));
    }

    @Test
    void singleCharAndGroupOf12Chars_returns4() {
        Assertions.assertEquals(4, stringCompression.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

    @Test
    void threeGroupsWithLengthFrom2To9_WhereOneGroupRepeatsCharactersOfAnother_returns6() {
        Assertions.assertEquals(6, stringCompression.compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

}