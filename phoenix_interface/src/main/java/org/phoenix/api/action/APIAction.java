package org.phoenix.api.action;

import java.util.HashMap;

import com.meterware.httpunit.WebResponse;

/**
 * 接口测试
 * @author mengfeiyang
 *
 */
public interface APIAction {
	WebResponse getResponseByPost(String url);
	WebResponse getResponseByPost(String url,int connTimeOut,int readTimeout);
	WebResponse getResponseByPost(String url,HashMap<String,String> parameters,HashMap<String,String> headers);
	WebResponse getResponseByGet(String url);
	WebResponse getResponseByGet(String url,int connTimeOut,int readTimeout);
	WebResponse getResponseByGet(String url,HashMap<String,String> parameters,HashMap<String,String> headers);
	String getJSONValue(String jsonContent, String jsonPath);
}
