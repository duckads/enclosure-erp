package kr.co.shield.utility;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.Map;
import java.util.Map.Entry;

@Slf4j
public class HttpUtils {
	
	private static int CONNECTION_TIMEOUT = 5000;
	private static int RECEIVE_TIMEOUT = 25000;
	
	public static String processHttp(String requestUrl, Map<String, String> requestParam) throws Exception {
		
		String rtnMsg = null;
		
		int statusCode = 0;
		String result = null;
		log.info("REQUEST URL  : " + requestUrl);
		log.info("PARAM: " + requestParam.toString());
		
		HttpClient httpClient = null;
		PostMethod postMethod = null;
		
		HostConfiguration hostConf = null;
		
		try {
			httpClient = new HttpClient();
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTION_TIMEOUT);
			httpClient.getHttpConnectionManager().getParams().setSoTimeout(RECEIVE_TIMEOUT);
			
			postMethod = new PostMethod(requestUrl);
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=euc-kr");
			postMethod.setRequestHeader("Cache-Control", "no-cache");
			postMethod.setRequestBody(makeParam(requestParam));
			
			hostConf = new HostConfiguration();
			hostConf.setHost(postMethod.getURI().getHost(), postMethod.getURI().getPort());
			
			try {
				statusCode = httpClient.executeMethod(postMethod);
			} catch (Exception e) {
				log.error("error {}", statusCode);
				e.printStackTrace();
				throw e;
			}
			
			Header[] headers = postMethod.getResponseHeaders();
			if (headers != null && headers.length > 0) {
				for(Header header : headers) {
					log.info("headers {} -> {}", header.getName(),  header.getValue());
				}
			}
			
			if (statusCode != 200) {
				log.error("error {}", statusCode);
				throw new HttpException("서버응답 에러 / " + statusCode);
			}
			
			result = postMethod.getResponseBodyAsString();
			log.info("result {}", result.trim());
			rtnMsg = result.trim();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error {}", statusCode);
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (postMethod != null) {
					postMethod.releaseConnection();
				}
				if (httpClient != null) {
					httpClient.getHttpConnectionManager().getConnection(hostConf).close();
				}
			} catch (Exception e) {
			}
		}
		
		return rtnMsg;
	}
	
	private static NameValuePair[] makeParam(Map<String, String> request) throws Exception {
		NameValuePair[] rtnArray = null;
		
		if (request != null && !request.isEmpty()) {
			rtnArray = new NameValuePair[request.size()];
			
			int inx = 0;
			for(Entry<String, String> entry : request.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				rtnArray[inx++] = new NameValuePair(key, new String(value.getBytes(), "KSC5601"));
			}
		}
		
		return rtnArray;
	}
	
}
