package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L1160 {

    public static void main(String[] args) {
        int atach = new Solution().countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");
        System.out.println(atach);
    }


    static class Solution {
        public int countCharacters(String[] words, String chars) {
            if (chars.length() == 0 || words.length == 0) {
                return 0;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (char c : chars.toCharArray()) {
                Integer count = map.getOrDefault(c, 0);
                map.put(c, ++count);
            }
            int total = 0;
            for (String word : words) {
                if (match(word, new HashMap<>(map))) {
                    total += word.length();
                }
            }
            return total;
        }

        private boolean match(String word, Map<Character, Integer> map) {
            for (char c : word.toCharArray()) {
                Integer integer = map.get(c);
                if (integer == null || integer == 0) {
                    return false;
                }
                map.put(c, --integer);
            }
            return true;
        }
    }
}
