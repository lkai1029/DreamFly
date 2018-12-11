package chris.dream.python;

import java.util.Properties;

import org.python.core.PyFloat;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
		props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
		props.put("python.import.site", "false");
		
		Properties preprops = System.getProperties();
		
		PythonInterpreter.initialize(preprops, props, new String[0]);
		
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.execfile("C:\\Users\\lkai1\\Desktop\\add.py" );

		// 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型 
		PyFunction add = interpreter.get("add", PyFunction.class);
		int a = 5, b = 10;
		// 调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型” 
		PyObject addResult = add.__call__(new PyInteger(a), new PyInteger(b));

		System.out.println("the anwser is: " + addResult);

		addResult = add.__call__(new PyInteger(a), new PyInteger(b));

		System.out.println("the anwser is: " + addResult);

/*		try {
			System.out.println("start");
			String[] args1 = new String[] { "python", "C:\\Users\\lkai1\\Desktop\\test.py" };
//			String[] args1 = new String[] { "python", "D:\\IDE_Workspace\\python\\Classify_Nine\\classify\\predictor.py" };
			Process pr = Runtime.getRuntime().exec(args1);

			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
	}
}
