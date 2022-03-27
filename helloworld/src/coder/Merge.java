package coder;

/**
 * @auther : wangyufei
 * @date : 2020-09-05
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Merge {
    public static int[] merge(int[] A, int m, int[] B, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;
        if(m == 0)A = B;
        while(index != 0){
            if(B[index2] > A[index1]){
                A[index--] = B[index2--];
            }else{
                A[index--] = A[index1--];
            }
        }
        if(index2 != -1){
            for(int i = 0; i <= index2;i++){
                A[i] = B[i];
            }
        }
        return A;
    }

}
