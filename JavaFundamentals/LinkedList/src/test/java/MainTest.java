/**
 * Test provides a platform to test basic functionality of
 * the LinkedList classes.
 */

public class MainTest {
    public static void main(String[] args) {
        MainTest.testNodes();
        MainTest.testList();
    }

    private static void testNodes() {
        Node a = new Node("Cat");
        Node b = new Node("Dog", a);
        // Node c = new Node(b);

        System.out.println(a);
        System.out.println(b.getNextNode());
        //System.out.println(c);
    }

    private static void testList() {
        List data = new List();
        List data2 = new List();


        data.add("Link");
        data.add("is");
        data.add("broken");
        data.add("random", 1 );

        data2.add("first", 0);
        System.out.println(data2);
        data2.add("second", 0);

        System.out.println("Data 2");
        System.out.println(data2.size());
        System.out.println(data2);


        System.out.println("Data 1");
        System.out.println(data.size());
        System.out.println(data);

        List data3 = new List(data2);
        data3.add("third");

        System.out.println("Printing data 3");
        System.out.println(data3);
        //System.out.println("Removing first");
        //data3.remove("first");
        System.out.println(data3);

    }
}