http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
http://www.practice.geeksforgeeks.org/problem-page.php?pid=146

An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

sortedPivotedArray

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3

---

Given a sorted and rotated array (rotated at some point) A[ ], and given an element K, the task is to find the index of the given element K in the array A[ ]. The array has no duplicate elements. If the element does not exist in the array, print -1.

Input:
The first line of the input contains an integer T, depicting the total number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array. Second line of each test case contains N space separated integers denoting the elements of the array A[ ]. Third line of each test case contains an integer K denoting the element to be searched in the array.


Output:

Corresponding to each test case, print in a new line, the index of the element found in the array.  If element is not present, then print -1.


Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 100005
0 ≤ A[i] ≤ 10000005
1 ≤ k ≤ 100005


Example:

Input
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6
65
51 52 53 54 55 56 57 58 59 60 61 62 63 64 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 
1


Output
5
1
-1
15
