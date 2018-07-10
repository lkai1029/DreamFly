package chris.deram.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumRegex {
	
	public static void t1() {
		String text = "";
		
		String regex = "";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}

}
