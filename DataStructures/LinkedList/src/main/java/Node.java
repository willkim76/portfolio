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
        setNextNode(node);
    }

    // Setter and Getters
    final void setObject(Object object) { this.object = object; }

    final Object getObject() { return this.object; }

    final void setNextNode(Node node) { this.node = node; }

    final Node getNextNode() { return this.node; }

    final boolean hasNextNode() {
        return this.getNextNode() != null;
    }
}
