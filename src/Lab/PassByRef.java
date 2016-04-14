package Lab;

/**
 * Created by gakshintala on 4/13/16.
 */
public class PassByRef {
    public static void main(String[] args) {
        String str = null;
        pass(str);
        System.out.println(str);
    }

    private static void pass(String str) {
        str = "abc";
    }

}
