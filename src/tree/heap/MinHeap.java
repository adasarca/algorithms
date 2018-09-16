package tree.heap;

public class MinHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public Integer getMin() {
        if (this.size > 0) {
            return this.heap[0];
        }
        return null;
    }

    public Integer extractMin() {
        if (this.size == 0) {
            return null;
        }
        int min = this.heap[0];
        this.deleteKey(0);
        return min;
    }

    public void insert(int value) {
        if (this.size < this.capacity) {
            this.heap[this.size++] = value;
            this.heapifyUp(this.size - 1);
        }
    }

    public void deleteKey(int key) {
        if (this.size == 0 || key < 0 || key >= this.size) {
            return;
        }
        if (this.size == 1) {
            this.size--;
            return;
        }

        this.swap(key, this.size - 1);
        this.size--;
        if (key == 0 || this.heap[key/2] < this.heap[key]) {
            this.heapifyDown(key);
        } else {
            this.heapifyUp(key);
        }
    }

    public void print() {
        System.out.print("Min Heap: ");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    private void heapifyUp(int pos) {
        while (pos > 0 && this.heap[pos/2] > this.heap[pos]) {
            this.swap(pos, pos/2);
            pos /= 2;
        }
    }

    private void heapifyDown(int pos) {
        int min = pos;
        for (int i = 1; i <= 2; i++) {
            int child = pos * 2 + i;
            if (child < this.size && this.heap[child] < this.heap[min]) {
                min = child;
            }
        }
        if (min != pos) {
            this.swap(min, pos);
            this.heapifyDown(min);
        }
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        System.out.println("Adding 10, 6, 15...");
        minHeap.insert(10);
        minHeap.insert(6);
        minHeap.insert(15);
        minHeap.print();
        System.out.println("Adding 23, 17, 13, 4...");
        minHeap.insert(23);
        minHeap.insert(17);
        minHeap.insert(13);
        minHeap.insert(4);
        minHeap.print();
        System.out.println("Adding 11, 9...");
        minHeap.insert(11);
        minHeap.insert(9);
        minHeap.print();

        System.out.println("Removing 5th element...");
        minHeap.deleteKey(4);
        minHeap.print();

        System.out.println("Extracting minimum:");
        System.out.println(minHeap.extractMin());
        minHeap.print();

        System.out.println("Extracting minimum:");
        System.out.println(minHeap.extractMin());
        minHeap.print();

        System.out.println("Inserting 5...");
        minHeap.insert(5);
        minHeap.print();

        System.out.println("Inserting 2...");
        minHeap.insert(2);
        minHeap.print();

        System.out.println("Get minimum:");
        System.out.println(minHeap.getMin());
    }
}
