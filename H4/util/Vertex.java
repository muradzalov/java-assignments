package util;
import java.util.*;
public class Vertex implements Comparable<Vertex> {
    public String name;
    public int indegree;
    public int topNum;
    public int discovered;
    public int finished;
    public boolean processed;
    public Vertex pred;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        Vertex another = (Vertex) o;
        return this.name.equals(another.name);
    }

    @Override
    public String toString() {
        return name + " w/ topNum/ discovered/ finished: " + topNum + "/ " + discovered + "/ " + finished;
    }

    public Vertex(String name) {
        this.name = name;
        this.indegree = 0;
        this.discovered = 0;
        this.processed = false;
    }

    public int compareTo(Vertex another) {
        return topNum - another.topNum;
    }
}

class Main {
    private static void addEdge(Vertex from, Vertex to, HashMap<Vertex, Set<Vertex>> graph) {
        if (!graph.containsKey(from))
            graph.put(from, new HashSet<Vertex>());
        graph.get(from).add(to);
        to.indegree++;
    }

    public static void topSortUsingDFS(HashMap<Vertex, Set<Vertex>> graph, Vertex[] vertices)
    {
        LinkedList<Vertex> starters = new LinkedList<Vertex>();
        for (Vertex v : vertices)
            if (v.indegree == 0)
                starters.add(v);
        Stack<Vertex> stack = new Stack<Vertex>();
        int time = 0;
        int topNum = vertices.length; 
        for (Vertex startVertex : starters) {
            stack.push(startVertex);
            while (!stack.empty()) {
                Vertex current = stack.pop();
                if (current.finished > 0)
                    continue;
                if (current.processed) {
                    current.finished = ++time;
                    current.topNum = topNum--;
                    continue;
                }
                current.discovered = ++time;
                if (!graph.containsKey(current)) {// out-degree = 0
                    current.finished = ++time;
                    current.topNum = topNum--;
                    continue;
                }
                current.processed = true;
                stack.push(current);
                for (Vertex neighbor : graph.get(current))
                    if (neighbor.discovered == 0) {
                        neighbor.pred = current;
                        stack.push(neighbor);
                    }
            }
        }
    }


public static void main(String[] args) {
        HashMap<Vertex, Set<Vertex>> graph = new HashMap<Vertex, Set<Vertex>>();
        Vertex[] vertices = new Vertex[] { new Vertex("shirt"), // 0
                new Vertex("watch"), // 1
                new Vertex("undershorts"), // 2
                new Vertex("pants"), // 3
                new Vertex("belt"), // 4
                new Vertex("tie"), // 5
                new Vertex("jacket"), // 6
                new Vertex("socks"), // 7
                new Vertex("shoes") // 8
        };
        addEdge(vertices[7], vertices[8], graph);
        addEdge(vertices[2], vertices[8], graph);
        addEdge(vertices[2], vertices[3], graph);
        addEdge(vertices[3], vertices[8], graph);
        addEdge(vertices[3], vertices[4], graph);
        addEdge(vertices[0], vertices[4], graph);
        addEdge(vertices[0], vertices[5], graph);
        addEdge(vertices[5], vertices[6], graph);
        addEdge(vertices[4], vertices[6], graph);
        topSortUsingDFS(graph, vertices);
        Arrays.sort(vertices);
        for (Vertex v : vertices)
            System.out.println(v);
    }
}

 