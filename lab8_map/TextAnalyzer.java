package Map.lab8_map;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
		String line ;//= null;
		int index = 1;
		while ((line = reader.readLine()) != null) {
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
			String word = words[i] ;
			int position = index + i;
			if (i == words.length - 1) {
				position = - position;
			}
				add(word, position++);
			}
			index += words.length;
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer> positions = map.getOrDefault(word, new ArrayList<>());
		positions.add(position);
		map.put(word, positions);
	}
	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
	    ArrayList<String> sortedWords = new ArrayList<>(map.keySet());
	    Collections.sort(sortedWords); //sắp xếp theo bảng chữ cái
	    for (String word : sortedWords) {
	    	ArrayList<Integer> positions = map.get(word);
	    	System.out.print(word + ": ");
	    	for (int position : positions) {
	    		System.out.print(position + " ");
	    	}
	    	System.out.println();
	    }
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		ArrayList<String> words = new ArrayList<>();
		for (Map.Entry<String ,ArrayList<Integer>> entry : map.entrySet()) {
			String word = entry.getKey();
			if (!word.equals(" \n")) {
				words.add(word);
			}
		}
		System.out.println(String.join(" ", words));
	}

	// This method will return the word that occurs most frequently in the text file
	//từ xuất hiện nhiều nhất
	public String mostFrequentWord() {
		String most = null;
		int max = 0;
		for (Map.Entry<String , ArrayList<Integer>> entry : map.entrySet()) {
			String word = entry.getKey();
			ArrayList<Integer> positions = entry.getValue();
			int frequency = positions.size();
			if (frequency > max) {
				most = word;
				max = frequency;
			}
		}
		return most;
	}
}
