/**
 * Created by Ada.Sarca
 * Date: 11/20/2018
 */
package recap.v1;
/*
* children(x) = 2*x + 1, 2*x + 2
* parent(x) =
* */
public class MinHeap {

    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity + 1];
    }

    public void insert(int value) {
        if (this.size == this.capacity) {
            return;
        }
        this.heap[++this.size] = value;
        this.heapifyUp(this.size);
    }

    public Integer getMin() {
        if (this.size > 0) {
            return this.heap[1];
        }
        return null;
    }

    public Integer extractMin() {
        if (this.size == 0) {
            return null;
        }
        int min = this.heap[1];
        this.deleteKey(1);
        return min;
    }

    public void deleteKey(int pos) {
        if (pos < 1 || pos > this.size) {
            return;
        }
        if (pos == this.size) {
            this.size--;
            return;
        }

        this.swap(pos, this.size);
        this.size--;

        if (pos > 1 && this.heap[pos] < this.heap[pos/2]) {
            this.heapifyUp(pos);
        } else {
            this.heapifyDown(pos);
        }
    }

    public void print() {
        for (int i = 1; i <= this.size; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    private void heapifyUp(int pos) {
        int parent = pos/2;
        if (pos == 1 || this.heap[parent] <= this.heap[pos]) {
            return;
        }
        this.swap(pos, parent);
        this.heapifyUp(parent);
    }

    private void heapifyDown(int pos) {
        int min = pos;
        for (int i = 0; i < 2; i++) {
            int child = 2 * pos + i;
            if (child <= this.size && this.heap[child] < this.heap[min]) {
                min = child;
            }
        }
        if (min != pos) {
            this.swap(min, pos);
            this.heapifyDown(min);
        }
    }

    private void swap(int pos1, int pos2) {
        int aux = this.heap[pos1];
        this.heap[pos1] = this.heap[pos2];
        this.heap[pos2] = aux;
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
        minHeap.deleteKey(5);
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

        System.out.println("Removing last element...");
        minHeap.deleteKey(8);
        minHeap.print();
    }
}
