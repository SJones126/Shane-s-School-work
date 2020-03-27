import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class tester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = null;
		Map<String, Integer> look = new HashMap<String, Integer>();
		try {
			input = new Scanner(new File("Basketball.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Text = "";
		while (input.hasNextLine()) {
			Scanner line = new Scanner(input.nextLine());
			while (line.hasNext()) {
				String next = line.next();
				String lower = next.toLowerCase();
				Text = Text + lower + " ";
				lower = lower.replace(".", "").replace(",", "").replace("'", "");
				if (look.containsKey(lower)) {
					int val = look.get(lower) + 1;
					look.put(lower, val);
				} else {
					look.put(lower, 1);
				}
			}
		}
		String[] Words = new String[4];
		HashMap<String, Integer> sortedMap = sortMapByValues(look);
		Set<String> WordSet = sortedMap.keySet();
		int i = 0;
		for (String W : WordSet) {
			if (i < 4) {
				Words[i] = W.toString();
				i++;
			} else {
				break;
			}
		}
		compress(Text, Words);
		decompress(Words);
	}

	private static HashMap<String, Integer> sortMapByValues(Map<String, Integer> opt) {
		Set<Entry<String, Integer>> mapEntries = opt.entrySet();
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(mapEntries);
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> ele1, Entry<String, Integer> elses) {
				return elses.getValue().compareTo(ele1.getValue());
			}
		});
		// Storing the list into Linked HashMap to preserve the order of insertion.
		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			map2.put(entry.getKey(), entry.getValue());
		}
		return (HashMap<String, Integer>) map2;
	}

	public static void compress(String Text, String[] Words) throws IOException {
		String newText = Text.replace(Words[0], "%").replace(Words[1], "$").replace(Words[2], "*").replace(Words[3],
				"#");
		BufferedWriter writer = new BufferedWriter(new FileWriter("CompressedBasketball.txt"));
		writer.write(newText);
		writer.close();
		System.out.println("Compressed Text : ");
		System.out.println(newText);
	}

	public static void decompress(String[] Words) throws FileNotFoundException {
		Scanner small = new Scanner(new File("CompressedBasketball.txt"));
		String Text = "";
		while (small.hasNextLine()) {
			Scanner scNext = new Scanner(small.nextLine());
			while (scNext.hasNext()) {
				String nex = scNext.next();
				String str = nex.toLowerCase();
				Text = Text + str + " ";
			}
		}
		String newText = Text.replace("%", Words[0]).replace("$", Words[1]).replace("*", Words[2]).replace("#",
				Words[3]);
		System.out.println("Decompressed Text : ");
		System.out.println(newText);
	}
}