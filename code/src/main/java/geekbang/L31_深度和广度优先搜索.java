package geekbang;

import java.util.LinkedList;
import java.util.Queue;

public class L31_深度和广度优先搜索 {


    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0, 6);
        System.out.println("----");
        graph.dfs(0,6);

    }

    static class Graph {
        // 顶点的个数
        private int v;
        // 邻接表
        private LinkedList<Integer>[] adj;

        // 生成顶点为v个的无向图
        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        /**
         * 添加图的边
         */
        public void addEdge(int s, int t) {
            adj[s].add(t);
            adj[t].add(s);
        }

        /**
         * 从顶点s到顶点t的路径,广度优先遍历,是最短路径
         */
        public void bfs(int s, int t) {
            if (s == t) {
                return;
            }
            boolean[] visit = new boolean[v];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(s);
            visit[s] = true;
            int[] prev = new int[v];
            for (int i = 0; i < v; i++) {
                prev[i] = -1;
            }
            while (!queue.isEmpty()) {
                Integer w = queue.poll();
                for (Integer q : adj[w]) {
                    if (!visit[q]) {
                        prev[q] = w;
                        if (q == t) {
                            printPath(prev, s, t);
                            return;
                        }
                        visit[q] = true;
                        queue.offer(q);
                    }
                }
            }
        }

        /**
         * 深度优先遍历,顶点s到顶点t,不一定是最短路径
         */
        private boolean found = false;

        public void dfs(int s, int t) {
            if (s == t) {
                return;
            }
            boolean[] visit = new boolean[v];
            int[] prev = new int[v];
            for (int i = 0; i < v; i++) {
                prev[i] = -1;
            }
            recurDfs(s, t, visit, prev);
            printPath(prev, s, t);
        }

        private void recurDfs(int s, int t, boolean[] visit, int[] prev) {
            if (found) {
                return;
            }
            visit[s] = true;
            if (s == t) {
                found = true;
                return;
            }
            for (Integer q : adj[s]) {
                if (!visit[q]) {
                    prev[q] = s;
                    recurDfs(q, t, visit, prev);
                }
            }

        }


        private void printPath(int[] prev, int s, int t) {
            if (prev[t] != -1 && t != s) {
                printPath(prev, s, prev[t]);
            }
            System.out.println(t + " ");
        }

    }
}
