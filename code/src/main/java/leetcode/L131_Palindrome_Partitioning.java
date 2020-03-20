package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L131_Palindrome_Partitioning {

    public static void main(String[] args) {

    }


    static class Solution {

        private List<String> result = new ArrayList<>();

        public List<List<String>> partition(String s) {


            return null;
        }

        private boolean valid(String s) {
            char[] charArray = s.toCharArray();
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (charArray[i] != charArray[j]) {
                    return false;
                }
            }
            return true;
        }
    }

}
