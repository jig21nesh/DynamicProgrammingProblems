/**
 * Created by Jiggy on 22/06/2017.
 */
public class EditDistance {


    public static void main(String args[]) {
        String str1 = "geek";
        String str2 = "gesek";
        System.out.println(dynamicProgramming(str1, str2, str1.length(), str2.length()));
    }

    private static int min(int x, int y, int z) {
        if (x < y && x < z) return x;
        if (y < x && y < z) return y;
        else return z;
    }

    private static int dynamicProgramming(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;  // Min. operations = j

                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j - 1],  // Insert
                            dp[i - 1][j],  // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[m][n];
    }


}
