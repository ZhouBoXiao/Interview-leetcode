package 面试相关._网络;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

    }
}
