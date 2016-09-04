package com.godsmiracle.jincao.role;

import java.util.List;

import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;
import com.godsmiracle.jincao.pub.bsc.dao.po.Role;
/**
 * adminUser
 * @author linjiang
 *
 */
public interface RoleService {
	
	Paging<Role> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(Role entity);

	void saveAll(List<Role> listAdminUser);
	
	List<Role> findALL();

	List<Role> findALLByHQL(String hql, Object...object);

	Role findByFristOneHQL(String hql, Object...object)throws Exception;

	Role findOneFrist(String propName, Object object);

	void remove(Role entity);

	void removeAll(List<Role> entityList);

	void update(Role entity);

	void updateAll(List<Role> list);
	
}
