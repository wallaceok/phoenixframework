package org.phoenix.cases.lianmeng;

import java.io.IOException;
import java.util.LinkedList;

import org.phoenix.action.WebElementActionProxy;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;

import com.meterware.httpunit.WebResponse;

/**
 * 使用phoenix做接口测试的案例
 * @author mengfeiyang
 *
 */
public class ContactJieKou extends WebElementActionProxy{
	private static String caseName = "报告查看";
	public ContactJieKou() {
	}
	@Override
	public LinkedList<UnitLogBean> run(CaseLogBean arg0) {
		init(caseName,arg0);
		WebResponse resp = webProxy.webAPIAction().getResponseByGet("http://v.youku.com/player/getPlayList/VideoIDS/XNzUwODY4Nzc2/timezone/+08/version/5/source/video?ran=7318&n=3&ctype=10&ev=1&password=");
		String s = null;
		resp.getContentLength();

		try {
			s = webProxy.webAPIAction().getJSONValue(resp.getText(), "JSON.data[0].dvd.point[3].title");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(s);
		String r = webProxy.checkPoint().checkIsMatcher("创新就是一层窗户纸", s);
		if(r == null){
			System.out.println("==================接口通过===================");
		}
		return getUnitLog();
	}
	
	public static void main(String[] args) {
		ContactJieKou yw = new ContactJieKou();
		LinkedList<UnitLogBean> ll = yw.run(new CaseLogBean());
		for(UnitLogBean l : ll){
			System.out.println(l.getContent());
		}
	}
	
}
