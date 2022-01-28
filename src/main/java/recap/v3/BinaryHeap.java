package recap.v3;

public class BinaryHeap {

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(50);
        heap.add(4);
        heap.add(10);
        heap.add(5);
        heap.add(12);
        heap.add(14);
        heap.add(7);
        heap.add(20);
        heap.add(13);
        heap.add(15);
        heap.add(17);

        System.out.println(heap.getMin());

        heap.add(9);
        System.out.println("Added 9, current min is " + heap.getMin());

        heap.remove(0);
        System.out.println("Removed first, current min is " + heap.getMin());
        heap.remove(0);
        System.out.println("Removed first, current min is " + heap.getMin());
        heap.remove(0);
        System.out.println("Removed first, current min is " + heap.getMin());
        heap.remove(0);
        System.out.println("Removed first, current min is " + heap.getMin());
        heap.remove(0);
        System.out.println("Removed first, current min is " + heap.getMin());
    }

    private int[] heap;
    private int size;

    public BinaryHeap(int capacity) {
        this.heap = new int[capacity];
    }

    public void add(int value) {
        if (this.size < this.heap.length) {
            this.heap[this.size++] = value;
            this.heapifyUp(size - 1);
        }
    }

    public void remove(int index) {
        if (index == this.size - 1) {
            this.size--;
        } else if (index >= 0 && index < this.size) {
            this.swap(index, this.size - 1);
            this.size--;

            if (index == 0 || this.heap[index / 2] < this.heap[index])
                this.heapifyDown(index);
            else
                this.heapifyUp(index);
        }
    }

    public Integer getMin() {
        if (this.size == 0)
            return null;
        return this.heap[0];
    }

    private void heapifyUp(int pos) {
        while(pos > 0 && this.heap[pos / 2] > this.heap[pos]) {
            this.swap(pos / 2, pos);
            pos /= 2;
        }
    }

    private void heapifyDown(int index) {
        int min = index;
        for (int i = 0; i < 2; i++) {
            int child = index * 2 + i;
            if (child < this.size && this.heap[min] > this.heap[child])
                min = child;
        }

        if (min != index) {
            this.swap(index, min);
            this.heapifyDown(min);
        }
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }
}
