package com.zyx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 001 两数之和
 * tag:哈希表，模拟
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 */
public class Num001_TwoSum{
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = twoSum(nums, 6);
        System.out.println("res:" + res[0] + "," + res[1]);
    }
}
