package chris.dream.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String text = " 123 456 789 ";
		String regex = "\\s\\d+\\s";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}
}
