import util.DisjointSet;
import java.util.*;

public class Two {
    public static boolean canReachDestination(HashMap<String, List<String>> bridges, String source, String destination) {
        DisjointSet<String> disjointSet = new DisjointSet<>(bridges.size() * 2); // number of unique islands x2

        for (Map.Entry<String, List<String>> entry : bridges.entrySet()) {
            String island = entry.getKey();
            List<String> connectedIslands = entry.getValue();
            for (String connectedIsland : connectedIslands) {
                disjointSet.union(island, connectedIsland);
            }
        }
        return disjointSet.find(source).equals(disjointSet.find(destination));
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> bridges = new HashMap<>();
        bridges.put("IslandA", Arrays.asList("IslandB", "IslandC"));
        bridges.put("IslandB", Arrays.asList("IslandD"));
        bridges.put("IslandC", Arrays.asList("IslandE"));

        String source = "IslandA";
        String destination = "IslandD";

        boolean canBeReached = canReachDestination(bridges, source, destination);
        System.out.println("Can be reached froom " + source + " to " + destination + ": " + canBeReached);
    }
}
