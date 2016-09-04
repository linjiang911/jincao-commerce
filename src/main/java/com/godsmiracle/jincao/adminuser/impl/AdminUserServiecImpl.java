package com.godsmiracle.jincao.adminuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godsmiracle.jincao.adminuser.AdminUserServiec;
import com.godsmiracle.jincao.common.util.ExtraSpringHibernateTemplate;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;


@Service
public class AdminUserServiecImpl implements AdminUserServiec {
	private static Class<?> poc=AdminUser.class;
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<AdminUser> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From AdminUser where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(AdminUser entity) {
		extraSpringHibernateTemplate.saveByPoc(entity);
	}
	
	@Override
	public void remove(AdminUser entity) {
		extraSpringHibernateTemplate.deleteByPoc(entity);
	}

	@Override
	public void removeAll(List<AdminUser> list) {
		extraSpringHibernateTemplate.removeAll(list);
	}
	
	@Override
	public void update(AdminUser entity) {
		extraSpringHibernateTemplate.updataByPoc(entity);
	}
	
	@Override
	public void updateAll(List<AdminUser> list) {
		extraSpringHibernateTemplate.updataAll(list);
	}
	
	@Override
	public void saveAll(List<AdminUser> listAdminUser) {
		extraSpringHibernateTemplate.saveAll(listAdminUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminUser> findALL() {
		return (List<AdminUser>) extraSpringHibernateTemplate.findAll(poc);
		
	}

	@Override
	public List<AdminUser> findALLByHQL(String hql, Object... object) {
		return extraSpringHibernateTemplate.findAllByHQL(hql, object);
	}

	@Override
	public AdminUser findByFristOneHQL(String hql, Object...object) throws Exception {
		return extraSpringHibernateTemplate.findFirstOneByHQL(hql, object);
	}

	@Override
	public AdminUser findOneFrist(String propName, Object object) {
		return extraSpringHibernateTemplate.findFirstOneByPropEq(poc, propName, object);
	}
	
}
