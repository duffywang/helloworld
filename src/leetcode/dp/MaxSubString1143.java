package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2021-05-23
 **/
public class MaxSubString1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        int length1 = text1Array.length;
        int length2 = text2Array.length;

        if (length1 == 0 || length2 == 0) return 0;
        int[][] matrix = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (text1Array[i] == text2Array[j]) {
                    if (i - 1 < 0 || j - 1 < 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i - 1 < 0 && j - 1 < 0) {
                        matrix[i][j] = 0;
                    } else if (i - 1 < 0) {
                        matrix[i][j] = matrix[i][j - 1];
                    } else if (j - 1 < 0) {
                        matrix[i][j] = matrix[i - 1][j];
                    } else {
                        matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);

                    }
                }
            }
        }
        return matrix[length1 - 1][length2 - 1];
    }

    public static void main(String[] args) {
        int i = longestCommonSubsequence("cae", "abcd");
        System.out.println(i);
    }
}
