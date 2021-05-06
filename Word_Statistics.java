import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Count_Words {

	public static void main(String[] args) throws IOException {

		// We use the BufferedReader because it always checks whether the requested data
		// already exist.
		BufferedReader reader;

		// Initialize lineCount and characterCount to Zero
		int lineCount = 0, characterCount = 0;

		// We use Map for key-value association
		Map<String, Integer> wordCounts = new HashMap<String, Integer>();
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("name of the text file : ");
			String fileName = sc.nextLine();
			reader = new BufferedReader(new FileReader(fileName)); // reads the file
			String line;

			while ((line = reader.readLine()) != null) {
				// If the file contains the text and is not empty

				lineCount++; // Increment the lineCount

				// split the line into words and store it in array
				String words[] = line.trim().split("\\s+");

				for (String word : words) {
					// The length of the word gives the count of characters

					characterCount += word.length();
                    
					//I am assuming all the characters should be converted to lower case. 
					//So that we can increment the count frequency of same word even if it is in upper case
					word = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

					// If the word occurs for the first time then we consider the count as 1
					if (!wordCounts.containsKey(word)) {
						wordCounts.put(word, 1);

					}

					// If the word occurs already then we increment its count
					else {
						wordCounts.put(word, wordCounts.get(word) + 1);
					}
				}
			}
			reader.close();
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Line count :" + lineCount); // prints line count
		System.out.println("character count :" + characterCount);// prints character count
		System.out.println("\n Word  count");

		for (String word : wordCounts.keySet())

			System.out.println(word + "\t" + wordCounts.get(word)); // prints the word along with its count

	}
}
