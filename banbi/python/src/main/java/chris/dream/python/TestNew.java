package chris.dream.python;

import java.io.StringWriter;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class TestNew {
	public static void main(String[] args) {
		PySystemState sys = Py.getSystemState();
		// 加入python路径
		sys.path.add("D:\\IDE_Workspace\\python\\Classify_Nine\\classify");
		sys.path.add("D:\\DevTool\\Anaconda3");
		sys.path.add("D:\\DevTool\\Anaconda3\\DLLs");
		sys.path.add("D:\\DevTool\\Anaconda3\\Lib");
		sys.path.add("D:\\DevTool\\Anaconda3\\Lib\\site-packages");
		sys.path.add("D:\\DevTool\\Anaconda3\\Lib\\site-packages\\numpy\\lib");
		sys.path.add("D:\\DevTool\\Anaconda3\\Lib\\site-packages\\numpy\\core");

		// 设置jython调用Python的属性
		Properties props = new Properties();
		props.put("python.home", "D:\\DevTool\\Anaconda3\\Lib");
		props.put("python.console.encoding", "UTF-8");
		props.put("python.security.respectJavaAccessibility", "false");
		props.put("python.import.site", "false");
		Properties preprops = System.getProperties();
		PythonInterpreter.initialize(preprops, props, new String[0]);

		org.python.util.PythonInterpreter python = new org.python.util.PythonInterpreter();

		python.execfile("C:\\Users\\lkai1\\Desktop\\test.py");// 执行python文件

		PyFunction func = (PyFunction) python.get("add", PyFunction.class); // 获取python文件的函数

		int a = 1, b = 2; // 初始化函数参数
		PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));// 调用python文件的函数，并传入参数，接收返回值
		System.out.println("anwser = " + pyobj.toString());// 打印出python的返回值
	}
}
