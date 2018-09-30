package tree.unionfind;

public class DisjointSets {
    int elements;
    private int[] parent;
    private int[] rank;

    public DisjointSets(int elements) {
        this.elements = elements;
        this.parent = new int[elements];
        this.rank = new int[elements];

        for (int i = 1; i < elements; i++) {
            this.parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = this.find(x);
        int rootY = this.find(y);
        if (rootX == rootY) {
            return;
        }

        if (this.rank[rootX] > this.rank[rootY]) {
            this.parent[rootY] = rootX;
        } else {
            this.parent[rootX] = rootY;
            if (this.rank[rootX] == this.rank[rootY]) {
                this.rank[rootY]++;
            }
        }
    }

    public int find(int element) {
        if (this.parent[element] != element) {
            //path compression
            this.parent[element] = find(this.parent[element]);
        }
        return parent[element];
    }

    public void print() {
        System.out.println("Sets:");
        for (int i = 0; i < this.elements; i++) {
            System.out.print(this.parent[i] + " ");
        }
        System.out.println();

        System.out.println("Ranks:");
        for (int i = 0; i < this.elements; i++) {
            System.out.print(this.rank[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets(8);
        ds.union(0, 1);
        ds.union(5, 6);
        ds.union(5, 7);
        ds.union(0, 7);
        ds.union(3, 4);
        ds.union(0, 2);
        ds.print();
    }
}
