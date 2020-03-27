import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class file {
	private Scanner input = null;
	private ArrayList<String>wordList = new ArrayList<String>();
	private HashSet<String> wordSet = new HashSet<String>();
	private ArrayList<Entry<String>> entryList = new ArrayList<Entry<String>>();
	String Line;
	public void text() throws FileNotFoundException{
		File name= new File("basketball.txt");
		//has the name of the file that needs to be inputted to be read.
		//sets it to name
		input = new Scanner(name);
		//sets the input value to a new scanner of name that was assigned in previous line
		try{
			String line;//names a string named line
			//sets string tokenizer to line.
			while((line = input.nextLine())!=null){//checks to see if line = input and not equal to null
				StringTokenizer token = new StringTokenizer(line);
				while(token.hasMoreTokens()) {
					String words=token.nextToken();
					wordList.add(words.toLowerCase());//sets wordlist to lower
					wordSet.add(words.toLowerCase());//sets wordset to lower
				}
			}
		}
		catch(NoSuchElementException e) {
		
		Iterator<String> my = wordSet.iterator();
		while(my.hasNext()) {
			String word = my.next();
			//going in a line of what is in the wordset and continues down the line if words.
			int frequency = Collections.frequency(wordList, word);//checks the frequency of wordlist and word
			Entry<String> enter = new Entry<String>(word,frequency);//puts the list into entry string named enter
			entryList.add(enter);//enter is added to the entrylist
		}
		}
		Collections.sort(entryList);//entrylist is sorted
	}
	//this method prints the frequent words in the correct sequence
	void printFrequentWords() {
		for(int i=0;i<4;i++){
	           System.out.println(entryList.get(i).word+" appears "+ entryList.get(i).frequency+" time(s).");
	           }
	}
	public String removePunctuation(String s) {//method removes punctuation
		String res = "";
		for(Character c : s.toCharArray()) {
			if(Character.isLetterOrDigit(c)) {
				res+=c;
			}
		}
		return res;
	}
	public class Entry<T> implements Comparable<Entry<T>>{
		public String word;
		public int frequency;
		public Entry(String word,int f) {
			this.word=word;
			frequency = f;
		}
		@Override
		public String toString() {//makes the string to be able to print
			return "Entry[word = "+word +",frequency= "+ frequency + "]";
		}
		@Override
		public int compareTo(Entry<T> arg0) {
			return arg0.frequency-frequency;
		}
	}
	//main has the program to be visualized and is able to print it.
	public static void main(String[] args) throws FileNotFoundException{
		file out = new file();
		out.text();
		out.printFrequentWords();
		
	}

}