import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import util.UnbalancedTreeMap;

public class EfficiencyTest {
    public static void main(String[] args) {
        UnbalancedTreeMap customTreeMap = new UnbalancedTreeMap();
        TreeMap<String, Integer> javaTreeMap = new TreeMap<>();

        long customTotalTime = 0;
        long javaTotalTime = 0;

        for (int i = 1; i <= 77; i++) {
            try {
                Scanner scanner = new Scanner(new File("C:\\Users\\Murad\\Desktop\\HCAndersen Tales\\" + i + ".okpuncs"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] words = line.split("\\s+");

                    for (String word : words) {
                        // Custom TreeMap
                        long customStartTime = System.nanoTime();
                        customTreeMap.put(word, 1 + customTreeMap.get(word));
                        customTotalTime += (System.nanoTime() - customStartTime);

                        // Java's TreeMap
                        long javaStartTime = System.nanoTime();
                        javaTreeMap.put(word, 1 + javaTreeMap.getOrDefault(word, 0));
                        javaTotalTime += (System.nanoTime() - javaStartTime);
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File " + i + ".okpuncs not found");
            }
        }

        System.out.println("Custom TreeMap Time: " + customTotalTime);
        System.out.println("Java's TreeMap Time: " + javaTotalTime);
    }
}
