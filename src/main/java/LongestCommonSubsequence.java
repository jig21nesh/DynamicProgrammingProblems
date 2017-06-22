/**
 * Created by Jiggy on 22/06/2017.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        subsequence.findTheSeq("ACBDEA", "ABCDA");
    }
    private void findTheSeq(String stringA, String stringB){
        char[] charA = stringA.toCharArray();
        char[] charB = stringB.toCharArray();


        String[][] solution = new String[charA.length + 1][charB.length + 1];
        int[][] LCS = new int[charA.length + 1][charB.length + 1];

        for (int i = 0; i <= charB.length; i++) {
            LCS[0][i] = 0;
            solution[0][i] = "0";
        }

        // if B is null then LCS of A, B =0
        for (int i = 0; i <= charA.length; i++) {
            LCS[i][0] = 0;
            solution[i][0] = "0";
        }



        for (int i = 1; i <= charA.length; i++) {
            for (int j = 1; j <= charB.length; j++) {
                if (charA[i - 1] == charB[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    solution[i][j] = "diagonal";
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                    if (LCS[i][j] == LCS[i - 1][j]) {
                        solution[i][j] = "top";
                    } else {
                        solution[i][j] = "left";
                    }
                }
            }
        }

        String x = solution[charA.length][charB.length];
        StringBuffer answer = new StringBuffer();
        int indexA = charA.length;
        int indexB = charB.length;
        while (!x.equals("0")){
            if (solution[indexA][indexB].equals("diagonal")) {
                answer.append(charA[indexA - 1]);
                indexA--;
                indexB--;
            } else if (solution[indexA][indexB].equals("left")) {
                indexB--;
            } else if (solution[indexA][indexB].equals("top")) {
                indexA--;
            }
            x = solution[indexA][indexB];
        }
        System.out.println(answer);
    }
}
