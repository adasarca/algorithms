package interview.google2018;

import java.util.LinkedList;
import java.util.List;

public class MainInterview1 {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(-5);
        list.add(4);
        list.add(0);
        list.add(-17);
        list.add(13);
        list.add(-20);
        MockInputStream inputStream = new MockInputStream(list);
        FilterIterator<Integer> filterIterator = new FilterIterator<Integer>(inputStream) {
            public boolean condition(Integer element) {
                return element >= 0;
            }
        };

        System.out.println(filterIterator.hasNext());
        System.out.println(filterIterator.hasNext());
        System.out.println(filterIterator.next());
        System.out.println(filterIterator.hasNext());
        System.out.println(filterIterator.next());
        System.out.println(filterIterator.hasNext());
        System.out.println(filterIterator.next());
        System.out.println(filterIterator.hasNext());
        System.out.println(filterIterator.next());
        System.out.println(filterIterator.hasNext());
        System.out.println(filterIterator.next());
    }
}
