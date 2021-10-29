public class Test {

    public static void main(String[] args) {
        Test alpha = new Test();
        System.out.println("Gradle Test Running!");
        System.out.println(alpha.getName());
    }

    public String getName(String name) {
        return "This name: " + name;
    }
}
