package graph.implement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename){
        File file = new File(filename);
        try(Scanner scanner = new Scanner(file)) {//写在括号中java可以自动帮助关闭资源
            V = scanner.nextInt();
            if(V < 0){
                throw new IllegalArgumentException("V must be non-negative!");
            }
            adj = new int[V][V];
            E = scanner.nextInt();
            for(int i = 0; i < E; i++){
                int a = scanner.nextInt();
                validateVertex(a); //判断当前定点是否合法
                int b = scanner.nextInt();
                validateVertex(b); //判断当前定点是否合法

                if(a == b){ //判断是否存在自环边
                    throw new IllegalArgumentException("Self Loop is Detected");
                }
                if(adj[a][b] == 1){ //判断是否存在平行边
                    throw new IllegalArgumentException("Parallel Edges are Detected");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v){ //判断当前定点是否合法
        if(v < 0 || v >= V){
            throw new IllegalArgumentException("Vertex"+v+"is invalid");
        }
    }

    private int V(){ //返回V
        return V;
    }

    private int E(){  //返回E
        return E;
    }

    private boolean hasEdge(int v ,int w){ //收否存在边
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    public ArrayList<Integer> adj(int v){ //返回某一顶点的邻边
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(adj[v][i] == 1){
                res.add(i);
            }
        }
        return res;
    }

    public int degree(int v){
        return adj(v).size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                sb.append(String.format("%d ",adj[i][j]));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);
    }
}
