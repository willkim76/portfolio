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
    Node() { this(null, null); }

    Node(Object object) { this(object, null); }

    Node(Object object, Node node) {
        setObject(object);
        setNode(node);
    }
    // Copy constructor
    Node(Node that) {
        setObject(that.getObject());
        setNode(that.getNode());
    }
    // Setter and Getters
    void setObject(Object that) { this.object = that; }

    Object getObject() { return this.object; }

    void setNode(Node that) { this.node = that.node; }

    Node getNode() { return this.node; }
}
