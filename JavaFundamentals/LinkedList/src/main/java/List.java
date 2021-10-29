/**
 * List implements a List data structure type using the Node
 * class with fundamental functions of List behavior. The
 * List can contain any Object.
 *
 * @author William Kim
 */
public class List {
    private Node head = null;

    public List() { }

    public void add(Object object) {
        Node newNode = new Node(object, this.head);
        this.head = newNode;
    }

    public void add(Object object, int index) {
        if (this.size() == 0) {
            this.add(object);
        } else {
            Node newNode = new Node(object,
                getNodeAtIndex(checkIndex(index)).getNode());
            getNodeAtIndex(index).setNode(newNode);
        }
    }

    public Object get(int index) {
        return getNodeAtIndex(checkIndex(index)).getObject();
    }

    /* TODO
    public boolean remove(Object object) {

        return false;
    }

    public Object remove (int index) {

    }
    */

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return size() > 0;
    }

    public int size() {
        int toReturn = 0;
        Node pointer = head;
        while(pointer != null) {
            pointer = pointer.getNode();
            toReturn++;
        }
        return toReturn;
    }

    /* TODO
    @Override
    public String toString() {
        String toReturn = "[";

    }
    */

    // Helper iterator method to reduce redundancy. Returns
    // the node at a specified index. Index must be valid.
    private Node getNodeAtIndex(int index) {
        int iterator = this.size() - 1;
        Node pointer = head;
        while(pointer != null) {
            if (iterator-- == index) { return pointer; }
            pointer = pointer.getNode();
        }
        return null;
    }

    private int checkIndex(int index) {
        final String errMsg = "Invalid Index.";
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException(errMsg);
        }
        return index;
    }
}
