package common;

public class Solution {

    public static void main(String[] args) {
//        TreeNode head = new TreeNode(1);
//        TreeNode left = null;
//        TreeNode right = new TreeNode(2);
//        head.left = left;
//        head.right = right;
//        new Solution().deleteNode(head, 1);

//        String abbc = new Solution().longestPalindrome("aba");
//        System.out.println(abbc);

//        System.out.println(true & true);
//        System.out.println(true & false);
//        System.out.println(false & true);
//        System.out.println(false & false);
//        char[] letters = {'c', 'f', 'j'};
//
//        char divide = new Solution().nextGreatestLetter(letters, 'j');
//        System.out.println(divide);

//        System.out.println(Integer.valueOf("0001"));

//        System.out.println(new Solution().compareVersion("0.1","1.1"));

//        new Solution().cal8queens(0);

        System.out.println("八皇后问题");
        findQueen(0);
        System.out.println("八皇后问题共有："+map+"种可能");

    }

    public static int[][] arry=new int[8][8];//棋盘，放皇后
    public static int map=0;//存储方案结果数量
    public static void findQueen(int i){//寻找皇后节点
        if(i>7){//八皇后的解
            map++;
            print();//打印八皇后的解
            return;
        }

        for(int m=0;m<8;m++){//深度回溯,递归算法
            if(check(i,m)){//检查皇后摆放是否合适
                arry[i][m]=1;
                findQueen(i+1);
                arry[i][m]=0;//清零，以免回溯的时候出现脏数据
            }
        }
    }

    public static boolean check(int k,int j){//判断节点是否合适
        for(int i=0;i<8;i++){//检查行列冲突
            if(arry[i][j]==1){
                return false;
            }
        }
        for(int i=k-1,m=j-1; i>=0 && m>=0; i--,m--){//检查左对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        for(int i=k-1,m=j+1; i>=0 && m<=7; i--,m++){//检查右对角线
            if(arry[i][m]==1){
                return false;
            }
        }
        return true;
    }

    public static void print(){//打印结果
        System.out.print("方案"+map+":"+"\n");
        for(int i=0;i<8;i++){
            for(int m=0;m<8;m++){
                if(arry[i][m]==1){
                    //System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");
                    System.out.print("o ");
                }
                else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    int maxW = Integer.MIN_VALUE;

    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            maxW = Math.max(maxW, cw);
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }


    int[] result = new int[8];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列



    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8 个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有 8 中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第 row 行的棋子放到了 column 列
                cal8queens(row + 1); // 考察下一行
            }
        }
    }

    private boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第 i 行的 column 列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第 i 行 leftup 列有棋子吗？
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) { // 考察右上对角线：第 i 行 rightup 列有棋子吗？
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int len = Math.max(version1Array.length, version2Array.length);
        for (int i = 0; i < len; i++) {
            Integer v1;
            Integer v2;
            if (i >= version1Array.length) {
                v1 = 0;
            } else {
                v1 = Integer.valueOf(version1Array[i]);
            }

            if (i >= version2Array.length) {
                v2 = 0;
            } else {
                v2 = Integer.valueOf(version2Array[i]);
            }
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }


    public int divide(int dividend, int divisor) {
        boolean flag = false;
        if (dividend < 0 && divisor < 0 || (dividend > 0 && divisor > 0)) {
            flag = true;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
        }
        // [−231,  231 − 1]

        return -1;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        return nextGreatestLetter(low, high, letters, target);
    }

    char nextGreatestLetter(int low, int high, char[] letters, char target) {
        if (low > high) {
            return letters[0];
        }
        int mid = low + (high - low) / 2;
        if (letters[mid] > target) {
            // 判断是否第一个
            if (mid == 0 || letters[mid - 1] <= target) {
                return letters[mid];
            }
            return nextGreatestLetter(low, mid - 1, letters, target);
        } else {
            return nextGreatestLetter(mid + 1, high, letters, target);
        }
    }


    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode p = root;
        if (p == null) {
            return null;
        }
        while (p != null && p.val != val) {
            if (p.val > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p;
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (val > root.val && root.right != null) {
            insertIntoBST(root.right, val);
        } else if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (val < root.val && root.left != null) {
            insertIntoBST(root.left, val);
        }
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        } else if (val > root.val && root.right != null) {
            insert(root.right, val);
        } else if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        } else if (val < root.val && root.left != null) {
            insert(root.left, val);
        }
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode p = root;
        TreeNode pp = null;
        while (p != null && p.val != key) {
            pp = p;
            if (p.val > key) {
                p = p.left;
            } else if (p.val < key) {
                p = p.right;
            }
        }

        if (p == null) {
            return root;
        }

        // 左右节点都存在的情况
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点,替换待删除的节点
            TreeNode minPP = p;
            TreeNode minP = p.right;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            // 删除右子树最小节点
            p = minP;
            pp = minPP;
        }
        // 只需要处理删除p节点,p 必然只有一个叶子节点或者没有叶子节点
        TreeNode pChild = null;
        if (p.left != null) {
            pChild = p.left;
        } else if (p.right != null) {
            pChild = p.right;
        }
        if (pp == null) {
            // 删除的是跟节点
            root = pChild;
        } else if (pp.left == p) {
            pp.left = pChild;
        } else if (pp.right == p) {
            pp.right = pChild;
        }
        return root;
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int maxLen = 0;
        int start = 0;
        int end = charArray.length - 1;
        for (int i = 0; i < s.length(); i++) {
            // diff s[i] and s[i+1]
            if (i + 1 >= s.length()) {
                break;
            }
            if (charArray[i] == charArray[i + 1]) {
                int k1 = i, k2 = i + 1;
                while (k1 >= 0 && k2 < s.length()) {
                    if (charArray[k1] != charArray[k2]) {
                        // 计算长度
                        int len = k2 - k1;
                        if (len > maxLen) {
                            start = k1;
                            end = k2;
                        }
                        break;
                    }
                    k1--;
                    k2++;
                }
            }
        }
        return s.substring(start, end);
    }


}
