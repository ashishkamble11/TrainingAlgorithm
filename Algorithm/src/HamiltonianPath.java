import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamiltonianPath
{
    public static void printPaths(Graph g, int v, boolean[] visited, List<Integer> path, int N)
    {
        if (path.size() == N)
        {
            for (int i : path)
                System.out.print(i + " ");
            System.out.println();

            return;
        }

        for (int w : g.adjList.get(v))
        {
            if (!visited[w])
            {
                visited[w] = true;
                path.add(w);

                printPaths(g, w, visited, path, N);

                visited[w] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1),
                new Edge(0, 2),
                new Edge(0, 3),
                new Edge(1, 2),
                new Edge(1, 3),
                new Edge(2, 3)
        );

        final int N = 4;

        Graph g = new Graph(edges, N);

        int start = 0;

        List<Integer> path = new ArrayList<>();
        path.add(start);

        boolean[] visited = new boolean[N];
        visited[start] = true;

        printPaths(g, start, visited, path, N);
    }
}

class Edge
{
    int source, dest;

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

class Graph
{
    List<List<Integer>> adjList = null;

    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}