import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Grammar encapsulates a context-free grammar which can be used to create
 * random sentences from within the grammar.
 * 
 * @author david levine and <your name here>
 * @version 26 November 2022
 *
 */
public class Grammar {
	private Map<String, List<String>> grammar;

	/**
	 * Construct a grammar from a file.
	 * @param fileName name of the file containing grammatical rules
	 * @throws FileNotFoundException if <code>fileName</code> is not found
	 */
	public Grammar(String fileName) throws FileNotFoundException {
		Scanner gramFile = new Scanner(new File(fileName));
		grammar = new TreeMap<String, List<String>>();

		while (gramFile.hasNextLine()) {
			String symbol = gramFile.nextLine().strip();
			if (symbol.length() > 0) {
				boolean doneWithSymbol = false;
				ArrayList<String> productions = new ArrayList<>();
				while (!doneWithSymbol) {
					String expansion = gramFile.nextLine().strip();
					if (expansion.endsWith(";")) {
						doneWithSymbol = true;
					}
					expansion = expansion.substring(0, expansion.length() - 1).strip();
					productions.add(expansion);
				}
				grammar.put(symbol, productions);
			}
		}

	}

	/**
	 * Pick a random expansion of a given non-terminal from the grammar
	 * TO BE COMPLETED BY STUDENT - currently returns its parameter!!!!
	 * @param startSymbol the symbol to expand
	 * @return a random expansion of <code>startSymbol</code>
	 */
	public String expand(String startSymbol) {
	    return startSymbol;
	}
	
	/**
	 * Return a toString of the grammatical rules.
	 * Should only be used for debugging purposes!
	 * @return a poorly formatted string encapsulating the grammatical rules
	 */
	public String toString() {
		return grammar.toString();
	}
	

}
