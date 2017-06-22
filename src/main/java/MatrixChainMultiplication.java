/**
 * Created by Jiggy on 22/06/2017.
 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int theArray[] = new int[] {1, 2, 3, 4};


        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();

        System.out.println(matrixChainMultiplication.dynamicProgramming(theArray, theArray.length));

    }

    private int dynamicProgramming(int[] theArray, int sizeOfTheArray){

        int m[][] = new int[sizeOfTheArray][sizeOfTheArray];

        int i, j, k, L, q;


        for (i = 1; i < sizeOfTheArray; i++)
            m[i][i] = 0;

        for (L=2; L<sizeOfTheArray; L++)
        {
            for (i=1; i<sizeOfTheArray-L+1; i++)
            {
                j = i+L-1;
                if(j == sizeOfTheArray) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + theArray[i-1]*theArray[k]*theArray[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][sizeOfTheArray-1];
    }

}
