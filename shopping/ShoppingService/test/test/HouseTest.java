package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.pony.data.dao.ShopDao;

public class HouseTest {

	private ShopDao shopDao;

	@Test
	public void Reg() {
		shopDao	 = new ShopDao();
		List<Object> params = new ArrayList<Object>();
		params.add("19");
		List<Map<String, Object>> flag=shopDao.listMessageMsgCollect(params);
		
//		// ����json�ַ���
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "����ɹ�");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", flag);
		System.out.println(jsonmsg);
		 

	}
}
