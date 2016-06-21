package Regular.Arrays.SubsetMaxAbsSumDiff;

/**
 * Created by gakshintala on 6/15/16.
 */
public class SubsetMaxAbsSumDiff {
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxAbsSumDiff(a));
    }

    private static int maxAbsSumDiff(int[] a) {
        int[] leftMin = constructLeftMin(a);
        int[] rightMin = constructRightMin(a);
        // Constructing leftMin on array with inverse sign gives leftMax with inverse sign, invert it again.
        int[] leftMax = invertSign(constructLeftMin(invertSign(a)));
        int[] rightMax = invertSign(constructRightMin(invertSign(a)));
        int len = a.length;
        int maxDiff = Integer.MIN_VALUE;
        // Max diff can be found by difference between min on one side and max on another.
        for (int i = 0; i < len; i++) {
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(leftMin[i] - rightMax[i]), Math.abs(leftMax[i] - rightMin[i])));
        }
        return maxDiff;
    }

    private static int[] invertSign(int[] a) {
        int len = a.length;
        int[] inverse = new int[len];
        for (int i = 0; i < len; i++) {
            inverse[i] = -a[i];
        }
        return inverse;
    }

    private static int[] constructRightMin(int[] a) {
        int len = a.length;
        int[] rightMin = new int[len];
        int curSum = a[len - 1], minSum = a[len - 1];
        // We proceed with negative sum as well, so nullifying when sum<0.
        for (int i = len - 2; i >= 0; i--) {
            curSum = Math.min(a[i], curSum + a[i]);
            minSum = Math.min(minSum, curSum);
            rightMin[i] = minSum;
        }
        return rightMin;
    }

    private static int[] constructLeftMin(int[] a) {
        int len = a.length;
        int[] leftMin = new int[len];
        int curSum = a[0], minSum = a[0];
        for (int i = 1; i < len; i++) {
            curSum = Math.min(a[i], curSum + a[i]);
            minSum = Math.min(minSum, curSum);
            leftMin[i] = minSum;
        }
        return leftMin;
    }
}
