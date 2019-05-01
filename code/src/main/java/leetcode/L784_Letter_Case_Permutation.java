package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/4/21.
 */
public class L784_Letter_Case_Permutation {

    public static void main(String[] args) {
        new test().dfs(1);
    }


    static class Solution {

        private List<String> results = new ArrayList<>();
        boolean[] v = new boolean[12];
        int[] oneResult = new int[12];

        public List<String> letterCasePermutation(String S) {
            if (oneResult.length == S.length()) {
                return results;
            }
            char[] charArray = S.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (!Character.isAlphabetic(ch)) {
                    oneResult[i] = ch;
                } else {

                }
            }
            return null;
        }


        public String dfs(String s, int index, int len) {
            if (s.length() == len) {
                return s;
            }
            char[] charArray = s.toCharArray();
            char ch = charArray[index];
            if (Character.isAlphabetic(ch)) {
                charArray[index] = Character.toLowerCase(ch);
                dfs(Arrays.toString(charArray), index + 1 ,len);
                charArray[index] = Character.toUpperCase(ch);
                dfs(Arrays.toString(charArray), index + 1 ,len);
            } else {
                dfs(Arrays.toString(charArray), index + 1 ,len);
            }
            return s;
        }

    }

    static class test {

        int n = 3;
        int[] a = new int[100];
        boolean[] v = new boolean[100];

        void dfs(int dp)//dp从1到n，执行n次，每次选择一个数
        {
            if (dp > n)//dp为n+1的时候，就说明已经选了n个，可以输出了；
            {
                for (int i = 1; i <= n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (!v[i])//判断是不是选择过
                {
                    a[dp] = i;//保存当前选择
                    v[i] = true;//标记这个数字，防止同一个排列选择相同的数字。
                    dfs(dp + 1);
                    v[i] = false;//回溯回来的时候一定要清楚标记，不然下一个排列就能选择了，这也是最关键的地方，仔细思考一下。
                }
            }
        }

    }

}
