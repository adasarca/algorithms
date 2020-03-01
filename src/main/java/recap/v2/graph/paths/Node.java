package recap.v2.graph.paths;

public class Node {

    int id;
    int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
