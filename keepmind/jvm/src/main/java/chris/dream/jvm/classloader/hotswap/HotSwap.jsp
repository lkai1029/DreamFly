<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="chris.dream.jvm.classloader.hotswap.*" %>
<%
	InputStream is = new FileInputStream("C:/Users/lkai1/Desktop/TestClass.class");
	byte[] b = new byte[is.available()];
	is.read(b);
	is.close();

	out.println("<textarea style='width:1000;height=800'>");
	out.println(JavaClassExecuter.execute(b));
	out.println("</textarea>"); 
%>

