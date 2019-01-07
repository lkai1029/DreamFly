package chris.dream.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 *  @author Chris
 *  @description: <p>类加载器与instanceof关键字演示</p>
 *  @date 下午 6:51 2018-12-11
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {

		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};

		Object obj = myLoader.loadClass("chris.dream.jvm.classloader.ClassLoaderTest").newInstance();

		System.out.println(obj.getClass());
		System.out.println(obj instanceof chris.dream.jvm.classloader.ClassLoaderTest);

		Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader());
	}
}

