package leetcode;

import java.util.Arrays;

/**
 * @auther : wangyufei
 * @date : 2020-07-18
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 **/
public class MaximumSwap670 {
    public static int maximumSwap(int num) {
        char[] orgin = Integer.toString(num).toCharArray();
        char[] newArray = Integer.toString(num).toCharArray();
        int len = orgin.length;
        Arrays.sort(newArray);
        int i = 0;
        for (; i < len; i++) {
            if (orgin[i] != newArray[i]) {
                break;
            }
        }
        char orginNum = orgin[i];
        char newArrayNum = newArray[i];
        int start = 0, end = len - 1;
        for (; start < len; start++) {
            if (orgin[start] == orginNum) break;
        }
        for (; end >= 0; end--) {
            if (orgin[end] == newArrayNum) break;
        }

        char tem = orgin[start];
        orgin[start] = orgin[end];
        orgin[end] = tem;

        return Integer.valueOf(String.valueOf(orgin));

    }

    public static int maximumSwap2(int num) {
        String numStr = String.valueOf(num);
        String maxStr = Integer.toString(num);
        for (int i = 0; i < numStr.length(); i++) {
            for (int j = i + 1; j < numStr.length(); j++) {
                char[] numArr = numStr.toCharArray();
                char temp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = temp;
                String reString = String.valueOf(numArr);
                if (reString.compareTo(maxStr) > 0) {
                    maxStr = reString;
                }
            }
        }
        return Integer.valueOf(maxStr);
    }


    public static void main(String[] args) {
        int res = maximumSwap(5621);
        System.out.println(res);
    }
}
