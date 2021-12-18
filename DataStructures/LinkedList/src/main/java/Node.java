/**
 * Node provides the basic building block for implementing
 * singly linked data structure types.
 * @author William Kim
 */

class Node {
    //Instance variables
    private Object object;
    private Node node;

    //Constructors
    public Node() { }

    public Node(Object object) { setObject(object); }

    public Node(Object object, Node node) {
        setObject(object);
        setNextNode(node);
    }

    // Setter and Getters
    public void setObject(Object object) { this.object = object; }

    public Object getObject() { return this.object; }

    public void setNextNode(Node node) { this.node = node; }

    public Node getNextNode() { return this.node; }

    public boolean hasNextNode() {
        return this.getNextNode() != null;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
