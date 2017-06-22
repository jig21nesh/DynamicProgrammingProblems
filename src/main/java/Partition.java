/**
 * Created by Jiggy on 22/06/2017.
 * <p>
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 * <p>
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 * <p>
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 * <p>
 * <p>
 * Source - http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 */
public class Partition {
    private static boolean isSubsetSum(int arr[], int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        if (arr[n - 1] > sum)
            return isSubsetSum(arr, n - 1, sum);

        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        return isSubsetSum(arr, n - 1, sum) ||
                isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    private static boolean findPartition(int arr[], int n) {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum % 2 != 0)
            return false;

        // Find if there is subset with sum equal to half
        // of total sum
        return isSubsetSum(arr, n, sum / 2);
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {

        int arr[] = {3, 1, 5, 9, 12};
        int n = arr.length;
        if (findPartition(arr, n))
            System.out.println("Can be divided into two " +
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }
}
