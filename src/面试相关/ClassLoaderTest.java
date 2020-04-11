package 面试相关;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("*********类加载器***********");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element: urls) {
            System.out.println(element.toExternalForm());


        }

        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("***********扩展类加载器*************");
        String property = System.getProperty("java.ext.dirs");
        for (String path: property.split(";")) {
            System.out.println(path);

        }

    }
}
