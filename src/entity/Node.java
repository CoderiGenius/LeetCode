package entity;

public class Node {

    public int data;
   public Node left;
   public Node right;

    @Override
    public String toString() {
        return "Node{" +
                "root=" + data +
                ", left=" + left.data +
                ", right=" + right.data +
                '}';
    }
}
