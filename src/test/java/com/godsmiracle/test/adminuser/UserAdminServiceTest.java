package com.godsmiracle.test.adminuser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.godsmiracle.jincao.adminuser.AdminUserServiec;
import com.godsmiracle.jincao.common.util.CommonResp;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;
import com.godsmiracle.test.util.SpringJunitService;

public class UserAdminServiceTest extends SpringJunitService {
	@Autowired
	private AdminUserServiec adminUserServiec;
	
	@Test
	public void testSava() throws Exception {
		AdminUser adminUser = new AdminUser();
		adminUser.setName("林江");
		adminUser.setPassword("123");
		adminUserServiec.sava(adminUser);
		assertEquals(adminUser!=null, true);
	}
	@Test
	public void testQueryPageByName() {
		Paging<AdminUser> queryPageByName = adminUserServiec.queryPageByName(1, 6, "s");
		CommonResp bs = CommonResp.buildSuccessResp(queryPageByName);
		assertEquals(bs.getCode()==0,true);
	}

	@Test
	public void testSaveAll() {
		List<AdminUser> arrayList = new ArrayList<AdminUser>();
		for(int i=0;i<100000;i++){
			AdminUser adminUser = new AdminUser();
			adminUser.setName("ssdd"+i);
			adminUser.setPassword("123");
			arrayList.add(adminUser);
		}
		adminUserServiec.saveAll(arrayList);
		assertEquals(arrayList.size()>0,true);
	}
}
