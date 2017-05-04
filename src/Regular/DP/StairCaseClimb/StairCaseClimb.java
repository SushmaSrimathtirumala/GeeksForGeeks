package Regular.DP.StairCaseClimb;

/**
 * Created by Gopala Akshintala on 6/2/17.
 */
public class StairCaseClimb {
    public static void main(String[] args) {
        int stairsCount = 4, numWaysToJump = 2;
        System.out.println(numberOfWaysToJump(stairsCount, numWaysToJump));
    }

    private static int numberOfWaysToJump(int stairsCount, int numWaysToJump) {
        int[] table = new int[stairsCount + 1];
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i <= stairsCount; i++) {
            for (int j = 1; j <= numWaysToJump && j <= i; j++) {
                table[i] += table[i - j];
            }
        }
        return table[stairsCount];
    }

}
