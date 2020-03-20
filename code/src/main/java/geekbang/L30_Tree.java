package geekbang;

import java.util.LinkedList;
import java.util.Queue;

public class L30_Tree {


    public static void main(String[] args) {

        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        graph.bfs(0,6);
    }




    static class Graph { // 无向图
        private int v; // 顶点的个数
        private LinkedList<Integer>[] adj; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }


        public void bfs(int s, int t) {
            if (s == t) return;
            boolean[] visited = new boolean[v];
            visited[s]=true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            int[] prev = new int[v];
            for (int i = 0; i < v; ++i) {
                prev[i] = -1;
            }
            while (queue.size() != 0) {
                int w = queue.poll();
                for (int i = 0; i < adj[w].size(); ++i) {
                    int q = adj[w].get(i);
                    if (!visited[q]) {
                        prev[q] = w;
                        if (q == t) {
                            print(prev, s, t);
                            return;
                        }
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");
        }

    }


}
