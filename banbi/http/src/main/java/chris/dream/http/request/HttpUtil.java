package chris.dream.http.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
  
public class HttpUtil {
  
  private static CloseableHttpClient httpClient;
  
  static {
    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    cm.setMaxTotal(200);
    cm.setDefaultMaxPerRoute(20);
    cm.setDefaultMaxPerRoute(50);
    httpClient = HttpClients.custom().setConnectionManager(cm).build();
  }
  
  public static String get(String url) {
    CloseableHttpResponse response = null;
    BufferedReader in = null;
    String result = "";
    try {
  
      HttpGet httpGet = new HttpGet(url);
      response = httpClient.execute(httpGet);
  
      in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      StringBuffer sb = new StringBuffer("");
      String line = "";
      String NL = System.getProperty("line.separator");
      while ((line = in.readLine()) != null) {
        sb.append(line + NL);
      }
      in.close();
      result = sb.toString();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (null != response) response.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println(get("https://www.baidu.com/"));
  }
}