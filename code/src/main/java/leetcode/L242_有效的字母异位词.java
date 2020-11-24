package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L242_有效的字母异位词 {


    public static void main(String[] args) {
        boolean anagram = new Solution().isAnagram("a", "a");
        System.out.println(anagram);

    }

    static class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                Integer count = map.getOrDefault(ch, 0);
                map.put(ch, ++count);
            }
            for (char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                if (map.get(ch) < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
