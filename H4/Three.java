import java.io.*;
import java.util.*;
import util.Vertex;

public class Three {

    private static void addEdge(Vertex from, Vertex to, HashMap<Vertex, Set<Vertex>> graph) {
        graph.computeIfAbsent(from, k -> new HashSet<>()).add(to);
        to.indegree++;
    }
    public static void topSortUsingDFS(HashMap<Vertex, Set<Vertex>> graph, Vertex[] vertices) {}
    public static void scheduleCourses(String fileName) throws IOException {
        HashMap<String, Vertex> vertexMap = new HashMap<>();
        HashMap<Vertex, Set<Vertex>> graph = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String course = parts[0];
                String[] prereqs = parts.length > 1 ? parts[1].split(",") : new String[0];
                Vertex courseVertex = vertexMap.computeIfAbsent(course, Vertex::new);
                for (String prereq : prereqs) {
                    Vertex prereqVertex = vertexMap.computeIfAbsent(prereq, Vertex::new);
                    addEdge(prereqVertex, courseVertex, graph);
                }
            }
        }
        Vertex[] vertices = vertexMap.values().toArray(new Vertex[0]);
        topSortUsingDFS(graph, vertices);
        Arrays.sort(vertices);

        for (Vertex v : vertices) {
            System.out.println("Iterative name: " + v.name);
        }
    }

    public static void main(String[] args) {
        try {
            scheduleCourses("prerequisites.txt");
        } catch (IOException e) {
            // stacktrace?
            System.out.println(e);
        }
    }
}
