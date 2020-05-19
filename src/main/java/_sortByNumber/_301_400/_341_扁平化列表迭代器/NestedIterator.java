package _sortByNumber._301_400._341_扁平化列表迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/4 22:48
 */

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
public class  NestedIterator implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<>();
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }

    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                add(nestedInteger.getList());
            }
        }
    }


    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
