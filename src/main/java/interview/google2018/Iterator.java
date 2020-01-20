package interview.google2018;

public interface Iterator<T> {
    T next(); // null at end
    boolean hasNext();
}

