package leetcode.Math;

/**
 * @auther : wangyufei
 * @date : 2022-03-05
 * <p>
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * <p>
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 **/
public class TitleToNumber171 {
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        char[] array = columnTitle.toCharArray();
        int len = array.length;
        for (int i = 0, j = len; i < len; i++, j--) {
            int num = array[i] - 'A' + 1;
            res += num * Math.pow(26, j - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
