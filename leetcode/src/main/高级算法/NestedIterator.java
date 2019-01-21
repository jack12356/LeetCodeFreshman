import java.util.Iterator;
import java.util.List;
import java.util.Stack;



public class NestedIterator implements Iterator {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            if (stack.peek().isInteger()) return true;
            List<NestedInteger> list = stack.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--)
                stack.push(list.get(i));
        }
        return false;
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }
}
