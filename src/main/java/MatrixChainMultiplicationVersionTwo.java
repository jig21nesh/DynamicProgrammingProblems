/**
 * Created by Jiggy on 22/06/2017.
 */
public class MatrixChainMultiplicationVersionTwo {


    private int[][] m;
    private int[][] s;
    private int     n;

    MatrixChainMultiplicationVersionTwo(int n){
        m = new int[n + 1][n + 1];
        s = new int[n + 1][n + 1];
        this.n = n;
    }

    public static void main(String[] args) {

        int theArray[] = new int[] {10, 100, 5, 50};

        MatrixChainMultiplicationVersionTwo versionTwo = new MatrixChainMultiplicationVersionTwo(theArray.length - 1);
        versionTwo.dynamicProgramming(theArray);
        System.out.println(versionTwo.print(1, versionTwo.n));
    }

    private String print(int i, int j)
    {
        if (i == j)
            return "A[" + i + "]";
        else
            return "(" + print(i, s[i][j])
                    + print(s[i][j] + 1, j) + ")";
    }


    private void dynamicProgramming(int[] theArray){
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;


        for (int l = 2; l <= n; l++)
        {
            for (int i = 1; i <= n - l + 1; i++)
            {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                {
                    int q = m[i][k] + m[k + 1][j] + theArray[i - 1] * theArray[k] * theArray[j];
                    if (q < m[i][j])
                    {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
}
