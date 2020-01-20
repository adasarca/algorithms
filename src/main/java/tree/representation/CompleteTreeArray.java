package tree.representation;

public class CompleteTreeArray {
    private int capacity;
    private int maxChildren;

    private int size;
    private int[] tree;

    public CompleteTreeArray(int capacity, int maxChildren) {
        this.capacity = capacity;
        this.maxChildren = maxChildren;

        this.tree = new int[this.capacity];
    }

    public void add(int value) {
        if (this.size < this.capacity) {
            this.tree[size++] = value;
        }
    }

    public void printChildren(int pos) {
        if (pos < 0 || pos >= this.size) {
            return;
        }

        System.out.println("Children of " + this.tree[pos] + ": ");
        for (int i = 1; i <= this.maxChildren; i++) {
            int child = pos * this.maxChildren + i;
            if (child < this.size) {
                System.out.print(this.tree[child] + " ");
            }
        }
        System.out.println();
    }

    public void printParent(int pos) {
        if (pos < 0 || pos >= this.size) {
            return;
        }

        int parent = pos / this.maxChildren;
        if (parent >= 0) {
            System.out.println("Parent of " + this.tree[pos] + ": " + this.tree[parent]);
        }
    }

    public static void main(String[] args) {
        CompleteTreeArray tree = new CompleteTreeArray(15, 3);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.printChildren(2);
        tree.printParent(7);
        tree.printChildren(3);
    }
}
