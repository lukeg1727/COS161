import java.io.FileNotFoundException;
/**
 * Generate - Uses the grammar class to generate random sentences from
 * the associated context-free grammar.
 * 
 * @author david levine
 * @version 25 November 2022
 *
 *
 */
public class Generate {

	public static void main(String[] args) throws FileNotFoundException {
		Grammar g = new Grammar("Extension-request.g");
		String s = g.expand("<start>");
		System.out.println(cleanUpSpacing(s));
	}

	/**
	 * Adjust spacing and create "line wrap" for a 'poorly' constructed string
	 * @param s the raw string
	 * @return a version of the same string with lines wrapped and punctuation well placed
	 */
	public static String cleanUpSpacing(String s) {
		s = s.strip();
		s = s.replaceAll("\\s+(?=\\p{Punct})", "");
			// Above regular expression from user aioobe @ StackOverflow; THANKS, aioobe!
		
		final int LETTER_LAST = 0;
		final int SPACE_LAST = 1;
		final int LINE_LIMIT = 50;

		int state = LETTER_LAST;
		String ans = "";
		int lineLength = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				state = SPACE_LAST;
				if (lineLength>LINE_LIMIT) {
					ans += '\n';
					lineLength = 0;
				}
			} else {
				if (state == SPACE_LAST) {
					if (lineLength > 0) {
						ans += ' ';
						lineLength++;
					}
					ans += c;
					lineLength++;
				} else {
					ans += c;
					lineLength++;
				}
				state = LETTER_LAST;
			}
		}
		return ans;
	}

}
