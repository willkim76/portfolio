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
    Node() { }

    Node(Object object) { setObject(object); }

    Node(Object object, Node node) {
        setObject(object);
        setNode(node);
    }
    // Copy constructor
    Node(Node that) {
        this.object = that.object;
        this.node = that.node;
    }
    // Setter and Getters
    void setObject(Object object) { this.object = object; }

    Object getObject() { return this.object; }

    void setNode(Node node) { this.node = node; }

    Node getNode() { return this.node; }

    public boolean hasNext() {
        if (this.getNode() != null) { return true; }
        return false;
    }

    @Override
    public String toString () { return object.toString(); }
}
