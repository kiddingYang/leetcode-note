/**
 * Created by Administrator on 2018/10/12.
 */
public class L779_Kth_Symbol_in_Grammar {


    public static void main(String[] args) {


    }

    /**
     * 已知N == 1的时候返回0，为了知道第N行第K个数字的值，
     * 只要知道它在第N-1行的第(K+1)/2个数字对应的值即可，因为0对应01，1对应10，
     * 那么如果K是奇数只需和原数字相同即可，如果K是偶数只需对原对应数字取反即可～
     */
    static class Solution {
        public int kthGrammar(int N, int K) {
            if (N == 1) {
                return 0;
            }
            return K % 2 == 0 ? (1 - kthGrammar(N - 1, K / 2)) : kthGrammar(N - 1, (K + 1) / 2);
        }
    }
}
