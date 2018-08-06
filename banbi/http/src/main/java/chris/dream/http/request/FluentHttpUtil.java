package chris.dream.http.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

public class FluentHttpUtil {
	public static String httpGet(String url, Map<String, Object> params) {
		String result = "";
		try {
			result = Request.Get(UrlUtil.parseGetUrl(url, params)).
					connectTimeout(5000).socketTimeout(5000).
					execute().returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String httpPost(String url, Map<String, String> params) {
		String result = null;
		List<NameValuePair> nvs = new ArrayList<>();
		if(params != null && !params.isEmpty()) {
			for(Map.Entry<String, String> entry : params.entrySet()) {
				nvs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		try {
			result = Request.Post(url).
					body(new UrlEncodedFormEntity(nvs)).
					connectTimeout(5000).socketTimeout(5000).
					execute().returnContent().asString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		String content = "您好 请 讲 你好 手机号 改成 八元 套餐 请问 密码 好像 查 一下子 忘 发送 短信 验证码 接到 请 告诉 哎行 一会 给我发 太多 咱是 十月份 一共 二十 验证码 请问 收到 幺 零零 你好 请 稍等一下 八块钱 套餐 包括 五十分钟 免费 通 国内 通话时间 来电显示 超出 打电话 一毛 接听电话 免费 本月 更改 月 生效 三十八 套餐 停办 改完 恢复 确认 改成 八块 八块 改成 套餐 几个 月 想 改 那行 谢谢 八八 元 更改 完 下个月 执行 八块 十一月份 扣 八块钱 恩是 七月 一号 恩是 谢谢 客气 请问 拜拜 祝您 生活 愉快 再见";

		String url = "http://localhost:9188/nlap/classify/svm/multilv";
		Map<String, String> params = new HashMap<>();
		params.put("content", content);
		for(int i = 0; i < 1000; i++) {
			new Thread() {

				@Override
				public void run() {
					String result = FluentHttpUtil.httpPost(url, params);
					System.out.println(result);
				}
				
			}.start();
		}
		
	}
}
