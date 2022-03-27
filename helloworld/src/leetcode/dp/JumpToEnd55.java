package leetcode.dp;

/**
 * @auther : wangyufei
 * @date : 2020-01-16
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class JumpToEnd55 {


    public static void main(String[] args) {

        int[] input = {3,2,1,0,4};
        boolean res = canJump(input);
        System.out.println(res);

    }

    public static boolean canJump(int[] input) {
        int length = input.length;
        if (length < 2) return true;
        int max_reach = 0;
        for (int i = 0; i < length; i++) {
            //如果当前可到达最大距离小于当前index,且又没有到达终点，故返回false
            if (i > max_reach) return false;
            max_reach = Math.max(i + input[i], max_reach);
            //优化，提早判断是否可达到终点，若是结束
            if (max_reach >= length - 1) return true;
        }
        return max_reach >= (length - 1);
    }

}
