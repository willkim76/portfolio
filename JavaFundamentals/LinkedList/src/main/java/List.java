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

    public List(List that) {
        this.head = that.head;
    }

    public void add(Object object) {
        this.head = new Node(object, this.head);
    }

    public void add(Object object, int index) {
        if (this.size() == 0 ) {
            add(object);
        } else {
            Node newNode = new Node(object,
                getNodeAtIndex(checkIndex(index)).getNextNode());
            getNodeAtIndex(index).setNextNode(newNode);
        }
    }

    public Object get(int index) {
        return getNodeAtIndex(checkIndex(index)).getObject();
    }

    // Removes the last instance of the Object in the list. Otherwise,
    // returns false
    public boolean remove(Object object) {
        Node pointer = head;
        while(pointer != null) {
            if (object.equals(pointer.getObject())) {
                head = pointer.getNextNode();
                return true;
            } else if (pointer.hasNextNode()) {
                if (object.equals(pointer.getNextNode().getObject())) {
                    pointer.setNextNode(pointer.getNextNode().getNextNode());
                    return true;
                }
            }
            pointer = pointer.getNextNode();
        }
        return false;
    }

    /*
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
        int size = 0;
        Node pointer = head;
        while(pointer != null) {
            pointer = pointer.getNextNode();
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        String string = "[";
        for(int index = 0; index < this.size(); index++) {
            string += getNodeAtIndex(index).getObject();
            if (index < this.size() - 1) {
                string += ", ";
            }
        } return string += "]";
    }

    // Helper iterator method to reduce redundancy. Returns
    // the node at a specified index. Index must be valid.
    private Node getNodeAtIndex(int index) {
        int iterator = this.size() - 1;
        Node pointer = head;
        while(pointer != null) {
            if (iterator-- == index) { return pointer; }
            pointer = pointer.getNextNode();
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
