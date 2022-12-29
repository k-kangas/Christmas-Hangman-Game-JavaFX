/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * JavaFX Christmas Hangman Game (Disappearing Snowman) - Simple hangman game using JavaFX
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordbank {
	
	// Attributes
	private ArrayList<String> wordList = new ArrayList<String>();
	private int Size;
	// Constructor
	public Wordbank(ArrayList<String> words) {
		this.wordList = words;
	}
	// We don't want people to change the txtFile is why it's private?
	private ArrayList <String> SetList(ArrayList<String> words){
		File file = new File("WordLists.txt");
		Scanner input;
		try {
			input = new Scanner(file);
			while(input.hasNext()) {
				String Word = input.next();
				words.add(Word);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return words;
	}
	// Behaviors
	public void setWordList(ArrayList<String> words) {
		this.wordList = SetList(words);
	}
	
	public ArrayList<String> getWordList(){
		return wordList;
	}
	
	public String getRandomWord(ArrayList<String> words, int sizeMin, int sizeMax) {
		ArrayList<String> tempList = new ArrayList<>();
		
		for (int i = 0; i < words.size(); i ++) {
			String Word = words.get(i);
			if (Word.length() >= sizeMin && Word.length() <= sizeMax) {
				tempList.add(Word);
			}
		}	
		Random random = new Random();
		int index = random.nextInt(tempList.size());
		String randomWord = tempList.get(index);
		setSize(randomWord.length());
		return randomWord;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		this.Size = size;
	}
}

