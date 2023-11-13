package Map.lab8_map;

//import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();
	private Entry<String, Integer> entry;

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		try {
			Scanner sc = new Scanner(new File(fileName));		
			while (sc.hasNext()) {
				String words = sc.next();
					map.put(words , map.getOrDefault(words, 0) + 1);
				}
			}catch (IOException e) {
				e.printStackTrace();
		}
	}
	


	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	//in ra số lần token duy nhất xuất hiện trong file
	public void printWordCounts() throws FileNotFoundException {
		 for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		 Map<String, Integer> sortedMap = new TreeMap<>(map);
	        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
	            System.out.println(entry.getKey() + " - " + entry.getValue());
	        }
	}
	public static void main(String[] args) throws FileNotFoundException {
        MyWordCountApp wordCountApp = new MyWordCountApp();
        wordCountApp.loadData();
        System.out.println("CountUnique: " + wordCountApp.countUnique());
        wordCountApp.printWordCounts();
        //wordCountApp.printWordCountsAlphabet();
    }
}
