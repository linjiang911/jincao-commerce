package com.godsmiracle.jincao.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godsmiracle.jincao.adminuser.AdminUserServiec;
import com.godsmiracle.jincao.common.util.ExtraSpringHibernateTemplate;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;
import com.godsmiracle.jincao.pub.bsc.dao.po.Role;
import com.godsmiracle.jincao.pub.bsc.dao.po.RolePermission;
import com.godsmiracle.jincao.role.RolePermissionService;
import com.godsmiracle.jincao.role.RoleService;


@Service
public class RolePermissionServiecImpl implements RolePermissionService {
	private static Class<?> poc=RolePermission.class;
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<RolePermission> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From AdminUser where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(RolePermission entity) {
		extraSpringHibernateTemplate.saveByPoc(entity);
	}

	@Override
	public void saveAll(List<RolePermission> listAdminUser) {
		extraSpringHibernateTemplate.saveAll(listAdminUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolePermission> findALL() {
		return (List<RolePermission>) extraSpringHibernateTemplate.findAll(poc);
		
	}

	@Override
	public List<RolePermission> findALLByHQL(String hql, Object... object) {
		return extraSpringHibernateTemplate.findAllByHQL(hql, object);
	}

	@Override
	public RolePermission findByFristOneHQL(String hql, Object...object) throws Exception {
		return extraSpringHibernateTemplate.findFirstOneByHQL(hql, object);
	}

	@Override
	public RolePermission findOneFrist(String propName, Object object) {
		return extraSpringHibernateTemplate.findFirstOneByPropEq(poc, propName, object);
	}
	
}
