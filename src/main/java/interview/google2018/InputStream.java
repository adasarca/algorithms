package interview.google2018;

public interface InputStream<T> {
    T read(); // null at EOS
}

