package leetcode.LeftRightPoint;

/**
 * @auther : wangyufei
 * @date : 2020-10-06
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 **/
public class MoveZeroes283 {
    //双指针
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        for (int i = slow; i < len; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }else{
                nums[i-count] = nums[i];
            }
        }
        for(int i = nums.length - 1;i > nums.length - 1 - count;i--){
            nums[i] = 0;
        }
    }
}
