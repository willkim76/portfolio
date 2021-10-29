/**
 * Test provides a platform to test basic functionality of
 * the LinkedList classes.
 */

public class Test {
    public static void main(String[] args) {
        Test.testNodes();
        Test.testList();


    }

    private static void testNodes() {
        Node a = new Node("Cat");
        Node b = new Node("Dog", a);
        // Node c = new Node(b);



        System.out.println(a);
        System.out.println(b.getNode());
        //System.out.println(c);
    }

    private static void testList() {
        List data = new List();
        List data2 = new List();
        data.add("Link");
        data.add("is");
        data.add("broken");
        data.add(5);
        Object value = data.get(3);
        System.out.println(value);
        System.out.println(data.size());
        System.out.println(data2.size());
    }
}