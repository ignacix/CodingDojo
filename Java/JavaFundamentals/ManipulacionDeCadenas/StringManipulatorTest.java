public class StringManipulatorTest {
    public static void main(String[] args) {
        
        StringManipulator manipulator = new StringManipulator();

        System.out.println(manipulator.trimAndConcat("   Hoola ", "  Adio ooos    "));

        System.out.println(manipulator.getIndexOrNull("Hi, My name is Ignacio", 'c'));

        System.out.println(manipulator.concatSubstring("ignacio", 2, 7, "Hola"));


    }
}
