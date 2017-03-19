package Regular.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        System.out.println(radiosRequired(x, n, k));
    }

    private static int radiosRequired(int[] x, int len, int r) {
        int count = 0;
        Arrays.sort(x);
        for(int i=0;i<len;) {
            int j = Math.abs(Arrays.binarySearch(x,x[i]+r));
            if(j>=len || x[j] > x[i]+r){
                j--;
            }
            int k = Math.abs(Arrays.binarySearch(x,x[j]+r));
            if(k>=len || x[k] > x[j]+r){
                k--;
            }
            i = k+1;
            count++;
        }
        return count;
    }
}
