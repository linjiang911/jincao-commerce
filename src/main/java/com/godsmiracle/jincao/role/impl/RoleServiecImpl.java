package com.godsmiracle.jincao.role.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godsmiracle.jincao.adminuser.AdminUserServiec;
import com.godsmiracle.jincao.common.util.ExtraSpringHibernateTemplate;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;
import com.godsmiracle.jincao.pub.bsc.dao.po.Role;
import com.godsmiracle.jincao.role.RoleService;


@Service
public class RoleServiecImpl implements RoleService {
	private static Class<?> poc=Role.class;
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<Role> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From AdminUser where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(Role entity) {
		extraSpringHibernateTemplate.saveByPoc(entity);
	}
	
	@Override
	public void remove(Role entity) {
		extraSpringHibernateTemplate.deleteByPoc(entity);
	}

	@Override
	public void removeAll(List<Role> list) {
		extraSpringHibernateTemplate.removeAll(list);
	}
	
	@Override
	public void update(Role entity) {
		extraSpringHibernateTemplate.updataByPoc(entity);
	}
	
	@Override
	public void updateAll(List<Role> list) {
		extraSpringHibernateTemplate.updataAll(list);
	}
	
	@Override
	public void saveAll(List<Role> listAdminUser) {
		extraSpringHibernateTemplate.saveAll(listAdminUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findALL() {
		return (List<Role>) extraSpringHibernateTemplate.findAll(poc);
		
	}

	@Override
	public List<Role> findALLByHQL(String hql, Object... object) {
		return extraSpringHibernateTemplate.findAllByHQL(hql, object);
	}

	@Override
	public Role findByFristOneHQL(String hql, Object...object) throws Exception {
		return extraSpringHibernateTemplate.findFirstOneByHQL(hql, object);
	}

	@Override
	public Role findOneFrist(String propName, Object object) {
		return extraSpringHibernateTemplate.findFirstOneByPropEq(poc, propName, object);
	}
	
}
