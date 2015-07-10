package org.phoenix.cases.lianmeng;

import java.util.LinkedList;

import org.phoenix.action.WebElementActionProxy;
import org.phoenix.model.CaseLogBean;
import org.phoenix.model.UnitLogBean;
import org.xml.sax.SAXException;

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
		
		//webProxy.openNewWindowByPhantomJs("http://lianmeng.360.cn/media/contact/index.html");
		WebResponse resp = webProxy.webAPIAction().getResponseByGet("http://lianmeng.360.cn/media/contact/index.html");
		String s = null;
		try {
			s = resp.getTitle();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		System.out.println(s);
		String r = webProxy.checkPoint().checkIsMatcher("360联盟 - 联系我们", s);
		if(r == null){
			System.out.println("==================接口通过===================");
		}
		//webProxy.closeWindow();
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
