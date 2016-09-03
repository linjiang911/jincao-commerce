package com.godsmiracle.jincao.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godsmiracle.jincao.common.util.ExtraSpringHibernateTemplate;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.Permission;
import com.godsmiracle.jincao.role.PermissionService;


@Service
public class PermissionServiecImpl implements PermissionService {
	private static Class<?> poc=Permission.class;
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<Permission> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From AdminUser where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(Permission entity) {
		extraSpringHibernateTemplate.saveByPoc(entity);
	}

	@Override
	public void saveAll(List<Permission> listAdminUser) {
		extraSpringHibernateTemplate.saveAll(listAdminUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> findALL() {
		return (List<Permission>) extraSpringHibernateTemplate.findAll(poc);
		
	}

	@Override
	public List<Permission> findALLByHQL(String hql, Object... object) {
		return extraSpringHibernateTemplate.findAllByHQL(hql, object);
	}

	@Override
	public Permission findByFristOneHQL(String hql, Object...object) throws Exception {
		return extraSpringHibernateTemplate.findFirstOneByHQL(hql, object);
	}

	@Override
	public Permission findOneFrist(String propName, Object object) {
		return extraSpringHibernateTemplate.findFirstOneByPropEq(poc, propName, object);
	}
	
}
