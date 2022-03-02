package 初级算法.数组.二_买卖股票的最佳时机II;

/**
 * @Title:
 * @BelongProjecet leetcode
 * @BelongPackage 初级算法.数组.一_删除排序数组中的重复项.二_买卖股票的最佳时机II
 * @Description:
 * @Author: admin
 * @Date: 2022/3/2 14:49
 * @Version V1.0
 */
public class Solution {
    /*
     判断出来后一天的价钱比前一天的高，那么我们就执行这次买卖操作，并记录获得的收益
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max = max + (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int total = 0, index = 0, length = prices.length;
        while (index < length) {
            //如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1])
                index++;
            //股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < length - 1 && prices[index] <= prices[index + 1])
                index++;
            //计算这段上涨时间的差值，然后累加
            total += prices[index++] - min;
        }
        return total;
    }

    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //原数组中如果后一个减去前一个是正数，说明是上涨的，
            //我们就要累加，否则就不累加
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(arr));
        System.out.println(new Solution().maxProfit1(arr));
        System.out.println(new Solution().maxProfit2(arr));
    }
}
