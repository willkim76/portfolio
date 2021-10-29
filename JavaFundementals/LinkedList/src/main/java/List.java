/**
 * List implements a List data structure type using the
 * Node class.
 * @author William Kim
 */
public class List<T> {
    private Node head;

    public <T> List() { }

    public <T> List(int number) {
        for(int index = 0; index < number; index++) {

        }
    }

    public static void main(String[] args) {
        List<String> data = new List<String>();
    }
}
