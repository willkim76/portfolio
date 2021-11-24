import javax.sound.midi.Soundbank;

/**
 * Test provides a platform to test basic functionality of
 * the LinkedList classes.
 */

public class MainTest {
    public static void main(String[] args) {
        //MainTest.testNodes();
        //MainTest.testList();
        MainTest.testNumberList();
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
        String name;
        List data = new List();
        System.out.println("Adding Link, is, broken");
        data.add("Link");
        data.add("is");
        data.add("broken");
        System.out.println("Adding random at index1");
        data.add("random", 1 );

        System.out.println("Printing Data 1");
        System.out.println(data);
        System.out.println(data.remove("random"));
        System.out.println(data.remove(2));
        System.out.println(data);

        System.out.println("Adding fire to index 1");
        data.add("fire", 1);
        System.out.println(data);
        data.add("cold");
        System.out.println(data);

    }

    public static void testNumberList() {
        List numb = new List();

        numb.add("3");
        numb.add("1");
        numb.add("1");
        numb.add("3");
        numb.add("1");
        numb.add("3");
        System.out.println("Added numbers");
        System.out.println(numb);

        numb.remove("1");
        numb.remove(1);
        System.out.println("Removing 1");
        System.out.println(numb);
    }
}