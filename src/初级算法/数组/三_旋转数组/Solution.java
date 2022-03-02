package 初级算法.数组.三_旋转数组;

import java.util.Arrays;

/**
 * @Title:
 * @BelongProjecet leetcode
 * @BelongPackage 初级算法.数组.三_旋转数组
 * @Description:
 * @Author: admin
 * @Date: 2022/3/2 15:55
 * @Version V1.0
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - k - 1);//先反转前面的
        reverse(nums, length - k, length - 1);//接着反转后面k个
        reverse(nums, 0, length - 1);//最后在反转全部的元素
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                //如果访问过，再次访问的话，会出现原地打转的现象，
                //不能再访问当前元素了，我们直接从他的下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                //把当前值保存在下一个位置，保存之前要把下一个位置的
                //值给记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("原数组:" + Arrays.toString(arr));
        new Solution().rotate(arr, k);
        System.out.println("向右轮转" + k + "位:" + Arrays.toString(arr));
    }
}
