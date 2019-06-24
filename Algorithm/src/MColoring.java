
public class MColoring
{
    final int V=4;
    int color[];

    boolean checkColor(int v, int graph[][], int color[], int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    boolean graphColor(int graph[][], int m, int color[], int v)
    {
        if(v==V)
            return true;
        for(int c=1; c<=m; c++)
        {
            if (checkColor(v, graph, color, c))
            {
                color[v] = c;

                if (graphColor(graph, m,
                        color, v + 1))
                    return true;

                color[v] = 0;
            }
        }

        return false;
    }

    boolean graphColoringUtil(int graph[][], int m)
    {
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        if (!graphColor(graph, m, color, 0))
        {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(color);
        return true;
    }

    void printSolution(int color[])
    {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        MColoring coloring=new MColoring();
        int graph[][] = {{0, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 0}};
        int m = 3;
        coloring.graphColoringUtil(graph,m);
    }
}
