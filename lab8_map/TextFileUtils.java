package Map.lab8_map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import lab7.arraylist.Student;

public class TextFileUtils {
	// read the content of a text file
	public static void readText(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				System.out.println(tokens.nextToken());
			}
		}
		reader.close();
	}

	public static void main(String[] args) {
		TextAnalyzer textAnalyzer = new TextAnalyzer();
		try {
			//readText("data/fit.txt");
			textAnalyzer.load("data/short.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//System.out.println(load(textAnalyzer));
    textAnalyzer.displayWords();
    System.out.println();
    textAnalyzer.displayText();
    System.out.println();
    System.out.println("Từ xuất hiện nhiều nhất: " + textAnalyzer.mostFrequentWord());
}	
}
