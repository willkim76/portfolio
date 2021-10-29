/**
 * List implements a List data structure type using the
 * Node class with fundamental functions of List
 * behavior. The List can contain any Object type.
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

    public Object get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int iterator = this.size() - 1;
        Node pointer = head;
        while(pointer != null) {
            if (iterator-- == index) {
                return pointer.getObject();
            }
            pointer = pointer.getNode();
        }
        return null;
    }

    /* TODO
    public boolean remove(Object object) {

        return false;
    }

    public Object remove (int index) {

    }
    */

    public boolean isEmpty() {
        boolean toReturn = true;


        return toReturn;
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
}
