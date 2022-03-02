package 初级算法.数组.一_删除排序数组中的重复项;

import java.util.Arrays;

/**
 * @Title:
 * @BelongProjecet leetcode
 * @BelongPackage 初级算法.数组
 * @Description:
 * @Author: admin
 * @Date: 2022/3/2 13:57
 * @Version V1.0
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("nums为null或者长度为0.");
            return 0;
        }
        System.out.println("原数组：" + Arrays.toString(nums));
        //如果左指针和右指针指向的值一样，说明有重复的，
        //这个时候，左指针不动，右指针继续往右移。如果他俩
        //指向的值不一样就把右指针指向的值往前挪
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        System.out.println("修改后：" + Arrays.toString(Arrays.stream(nums).limit(++left).toArray()));
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("函数返回值：" + new Solution().removeDuplicates(arr));
    }
}
