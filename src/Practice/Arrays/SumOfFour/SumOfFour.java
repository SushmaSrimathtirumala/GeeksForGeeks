package Practice.Arrays.SumOfFour;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Gopala Akshintala on 2/4/17.
 */
public class SumOfFour {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tests = scn.nextInt();
        while (tests-- > 0) {
            int len = scn.nextInt();
            int sumOfFour = scn.nextInt();
            int[] arr = new int[len];
            fillArray(arr, scn);
            sumOfFour(arr, sumOfFour);
            System.out.println();
        }
    }

    private static void sumOfFour(int[] arr, int sumOfFour) {
        PairSum[] auxiliaryArr = computeAuxiliaryArr(arr);
        Arrays.sort(auxiliaryArr);
        Set<Set<PairSum>> allCombinations = new HashSet<>();
        int left = 0, right = auxiliaryArr.length - 1;
        while (left < right) {
            int currentSum = auxiliaryArr[left].sum + auxiliaryArr[right].sum;
            if (currentSum == sumOfFour && noCommon(auxiliaryArr[left], auxiliaryArr[right])) {
                Set<PairSum> combination = new HashSet<>(Arrays.asList(auxiliaryArr[left], auxiliaryArr[right]));
                allCombinations.add(combination);
                left++;
                right--;
            } else if (currentSum < sumOfFour) {
                left++;
            } else {
                right--;
            }
        }
        printAllCombinations(allCombinations);
    }

    private static void printAllCombinations(Set<Set<PairSum>> allCombinations) {
        if (allCombinations.size() > 0) {
            allCombinations.forEach(combination -> {
                combination.forEach(e -> System.out.print(e.first + " " + e.second + " "));
                System.out.print("$");
            });
        } else {
            System.out.print("-1");
        }
    }

    private static boolean noCommon(PairSum pair1, PairSum pair2) {
        return !(pair1.first == pair2.first || pair1.first == pair2.second
                || pair1.second == pair2.first || pair1.second == pair2.second);
    }

    private static PairSum[] computeAuxiliaryArr(int[] arr) {
        int arrLen = arr.length;
        int auxiliaryArrLen = arrLen * (arrLen - 1) / 2;
        PairSum[] auxiliaryArr = new PairSum[auxiliaryArrLen];
        int k = 0;
        for (int i = 0; i < arrLen - 1; i++) {
            for (int j = i + 1; j < arrLen; j++) {
                auxiliaryArr[k] = new PairSum();
                auxiliaryArr[k].sum = arr[i] + arr[j];
                auxiliaryArr[k].first = i;
                auxiliaryArr[k].second = j;
                k++;
            }
        }
        return auxiliaryArr;
    }

    private static void fillArray(int[] arr, Scanner scn) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
}

class PairSum implements Comparable<PairSum> {
    int first;
    int second;
    int sum;

    @Override
    public int compareTo(PairSum o) {
        return Integer.compare(this.sum, o.sum);
    }
}
