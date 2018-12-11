package chris.dream.python;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class Jython {
	public static void main(String args[]) throws IOException {
		PythonInterpreter interpreter = new PythonInterpreter();
		PySystemState sys = Py.getSystemState();
		
		sys.path.add("D:\\DevTool\\Jython-2.7.0\\Lib");
		interpreter.exec("import sys");
		interpreter.exec("print sys.path");
		
//		interpreter.exec("path = \"D:\\DevTool\\Jython-2.7.0\\Lib\"");
//		interpreter.exec("sys.path.append(path)");
//		interpreter.exec("print sys.path");
		InputStream filepy = new FileInputStream("C:\\Users\\lkai1\\Desktop\\add.py");
		interpreter.execfile(filepy);
		
		PyFunction add = interpreter.get("add", PyFunction.class);
		int a = 5, b = 10;
		// 调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型” 
		PyObject addResult = add.__call__(new PyInteger(a), new PyInteger(b));

		System.out.println("the anwser is: " + addResult);
		
		filepy.close();
	}
}
