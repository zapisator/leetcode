import java.util.LinkedList;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {

    private Integer integer;
    private List<NestedInteger> nestedIntegers;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        integer = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return integer != null && nestedIntegers == null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
                return isInteger() ? integer : null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        integer = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (nestedIntegers == null) {
            nestedIntegers = new LinkedList<>();
        }
        nestedIntegers.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return nestedIntegers;
    }
}

public class MiniParser {
    public NestedInteger deserialize(String s) {
        NestedInteger result = new NestedInteger();
        return result;
    }
}
