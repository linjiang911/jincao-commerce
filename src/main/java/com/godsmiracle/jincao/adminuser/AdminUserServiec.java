package com.godsmiracle.jincao.adminuser;

import java.util.List;

import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;
/**
 * adminUser
 * @author linjiang
 *
 */
public interface AdminUserServiec {
	
	Paging<AdminUser> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(AdminUser adminUser);

	void saveAll(List<AdminUser> listAdminUser);
	
	List<AdminUser> findALL();

	List<AdminUser> findALLByHQL(String hql, Object...object);

	AdminUser findByFristOneHQL(String hql, Object...object)throws Exception;

	AdminUser findOneFrist(String propName, Object object);
	
}
