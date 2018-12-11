package chris.dream.other;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		try (InputStream in = new FileInputStream("C:\\Users\\lkai1\\Desktop\\t1.txt");
			 InputStreamReader inReader = new InputStreamReader(in);
			 BufferedReader reader = new BufferedReader(inReader)){
			String line = null;
			while(null != (line = reader.readLine())){
//				System.out.println(line);
				String[] params = line.split("\\s");
				String name = params[0].split("=")[1].replaceAll("\"", "");
				String code = params[3].split("=")[1].replaceAll("\"", "");
//				System.out.println(name + ":" + code);
			    sb.append(name).append(":").append(code).append(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println(sb.toString());
	}

}
