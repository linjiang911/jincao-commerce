package com.godsmiracle.jincao.role;

import java.util.List;

import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.Permission;
/**
 * adminUser
 * @author linjiang
 *
 */
public interface PermissionService {
	
	Paging<Permission> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(Permission entity);

	void saveAll(List<Permission> listAdminUser);
	
	List<Permission> findALL();

	List<Permission> findALLByHQL(String hql, Object...object);

	Permission findByFristOneHQL(String hql, Object...object)throws Exception;

	Permission findOneFrist(String propName, Object object);

	void remove(Permission entity);

	void removeAll(List<Permission> entityList);

	void update(Permission entity);

	void updateAll(List<Permission> list);
}
