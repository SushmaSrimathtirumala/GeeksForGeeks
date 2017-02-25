package Regular.Arrays.SquareRoot;

/**
 * Created by gakshintala on 7/2/16.
 */
public class SquareRoot {
    public static void main(String[] args) {
        int x = 81;
        System.out.println(squareRoot(x));
    }

    private static int squareRoot(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            int midSquare = mid * mid;
            if (midSquare == x) {
                return mid;
            } else if (midSquare < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
