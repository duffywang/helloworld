package leetcode;

/**
 * @auther : wangyufei
 * @date : 2020-10-07
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：数组最后一位是二叉树的根，前半部分都比根值小，后半部分比根值大，且每个部分都按照这种方式判断
 *
 * 注意：1、停止条件；2、记录过程中左右子树分割的下标；3、所有前半部分都比根值小，后半部分比根值大
 **/
public class VerifyPostorder33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j){
        if(i >= j)return true;
        int p = i;
        while(postorder[j] > postorder[p])p++;
        int m = p;
        while(postorder[j] < postorder[p])p++;
        return p == j && recur(postorder, i, m-1) && recur(postorder, m, j - 1);
    }
}
