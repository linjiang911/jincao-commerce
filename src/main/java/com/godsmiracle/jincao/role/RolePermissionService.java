package com.godsmiracle.jincao.role;

import java.util.List;

import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.RolePermission;
/**
 * adminUser
 * @author linjiang
 *
 */
public interface RolePermissionService {
	
	Paging<RolePermission> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(RolePermission entity);

	void saveAll(List<RolePermission> listAdminUser);
	
	List<RolePermission> findALL();

	List<RolePermission> findALLByHQL(String hql, Object...object);

	RolePermission findByFristOneHQL(String hql, Object...object)throws Exception;

	RolePermission findOneFrist(String propName, Object object);

	void remove(RolePermission entity);

	void removeAll(List<RolePermission> entityList);

	void update(RolePermission entity);

	void updateAll(List<RolePermission> list);
}
