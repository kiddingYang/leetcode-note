package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2018/10/16.
 */
public class L349_Intersection_of_Two_Arrays {

    public static void main(String[] args) {

    }


    static class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums2[j] == nums1[i]) {
                        set.add(nums1[i]);
                        break;
                    }
                }
            }
            int[] nums = new int[set.size()];
            Object[] objects = set.toArray();
            for (int i = 0; i < objects.length; i++) {
                nums[i] = (int) objects[i];
            }
            return nums;
        }


        public int[] intersection2(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Map<Integer,Integer> map = new HashMap<>();
            for (int i : nums1) {
                map.put(i,i);
            }
            for (int i : nums2) {
                Integer integer = map.get(i);
                if(integer != null) {
                    set.add(i);
                }
            }
            int[] nums = new int[set.size()];
            Object[] objects = set.toArray();
            for (int i = 0; i < objects.length; i++) {
                nums[i] = (int) objects[i];
            }
            return nums;
        }

    }


}
