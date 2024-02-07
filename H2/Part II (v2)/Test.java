import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Test {
    public static final String INPUT = System.getProperty("user.dir") + "/input/";
    public static final String OUTPUT = System.getProperty("user.dir") + "/output/";
    public static void main(String[] args) throws FileNotFoundException {
	TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	long startTime;
	long totalTime = 0;
	for(int i = 1; i <= 77;i++) {
	    Scanner scnr = new Scanner(new File(INPUT + i + ".okpuncs"));
	    while(scnr.hasNext()) {
		String word = scnr.next();
		startTime = System.nanoTime();
		if(!map.containsKey(word))map.put(word, 0);
		map.put(word, 1 + map.get(word));
		totalTime += (System.nanoTime() - startTime);
	    }
	}
	PrintWriter out = new PrintWriter(OUTPUT + "frequencies.txt");
	startTime = System.nanoTime();
	Set<String> allWords = map.keySet();
	totalTime += (System.nanoTime() - startTime);
	for(String word: allWords) {
	    startTime = System.nanoTime();
	    int frequency = map.get(word);
	    totalTime += (System.nanoTime() - startTime);
	    out.printf("%s\t%d\n", word, frequency);
	    out.flush();
	}
	out.close();
	System.out.printf("%.3f ms", totalTime/1e6);
    }
}
