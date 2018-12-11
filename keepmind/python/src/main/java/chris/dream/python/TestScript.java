package chris.dream.python;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class TestScript {
	public static void main(String[] args) {
		try {
			System.out.println("start");
//			String[] args1 = new String[] { "python", "C:/Users/lkai1/Desktop/test.py" };
			String[] args1 = new String[] { "python", "D:/IDE_Workspace/python/Classify_Nine/classify/predictor.py" };
			Process pr = Runtime.getRuntime().exec(args1, null, new File("D:/IDE_Workspace/python/Classify_Nine/classify"));

			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			int status = pr.waitFor();
			if(status != 0) {
				System.err.println(":(");
				throw new Exception("坏了");
			} else {
				System.out.println("end");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
