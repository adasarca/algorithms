package interview.google2018;

public abstract class FilterIterator<T> implements Iterator<T> {
    private InputStream<T> inputStream;
    private T nextToken;

    public FilterIterator(InputStream<T> inputStream) {
        this.inputStream = inputStream;
    }

    public T next() {
        if (this.nextToken != null) {
            T aux = this.nextToken;
            this.nextToken = null;
            return aux;
        }

        return this.getNextToken();
    }

    public boolean hasNext() {
        if (this.nextToken == null) {
            this.nextToken = this.getNextToken();
        }
        return (this.nextToken != null);
    }

    public abstract boolean condition(T element);

    private T getNextToken() {
        T token;
        do {
            token = this.inputStream.read();
        } while (token != null && !this.condition(token));
        return token;
    }
}

