package chris.dream.http.request;

import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class UrlUtil {
	
	public static final String HTML_CODE = "UTF8";

	private static String mapToString(Map<String, Object> params) {

		if (params == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			try {
				sb.append(entry.getKey()).append("=");
				if (entry.getValue() instanceof String) {

					sb.append(URLEncoder.encode((String) entry.getValue(),
							HTML_CODE));
				} else {
					sb.append(entry.getValue());
				}
				sb.append("&");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (sb.length() > 1) {
			// 删掉最后一个&字符
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String parseGetUrl(String urlStr, Map<String, Object> params) {
		
		String paramsStr = mapToString(params);
		
		if (!StringUtils.isEmpty(paramsStr)) {
			if (urlStr.indexOf("?") > -1) {
				urlStr = urlStr + "&" + paramsStr;
			} else {
				urlStr = urlStr + "?" + paramsStr;
			}
		}
		return urlStr;
	}
	
}
