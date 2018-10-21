package interview.google2018;

import java.util.List;

public class MockInputStream implements InputStream<Integer> {
    List<Integer> list;
    java.util.Iterator<Integer> iterator;

    public MockInputStream(List<Integer> list) {
        this.list = list;
        this.iterator = this.list.iterator();
    }

    public Integer read() {
        if (this.iterator.hasNext()) {
            return this.iterator.next();
        }
        return null;
    }
}

