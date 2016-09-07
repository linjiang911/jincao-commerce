package com.godsmiracle.jincao.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godsmiracle.jincao.common.util.ExtraSpringHibernateTemplate;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.User;
import com.godsmiracle.jincao.user.UserServiec;


@Service
public class UserServiecImpl implements UserServiec {
	private static Class<?> poc=User.class;
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<User> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From User where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(User entity) {
		extraSpringHibernateTemplate.saveByPoc(entity);
	}
	
	@Override
	public void remove(User entity) {
		extraSpringHibernateTemplate.deleteByPoc(entity);
	}

	@Override
	public void removeAll(List<User> list) {
		extraSpringHibernateTemplate.removeAll(list);
	}
	
	@Override
	public void update(User entity) {
		extraSpringHibernateTemplate.updataByPoc(entity);
	}
	
	@Override
	public void updateAll(List<User> list) {
		extraSpringHibernateTemplate.updataAll(list);
	}
	
	@Override
	public void saveAll(List<User> listUser) {
		extraSpringHibernateTemplate.saveAll(listUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findALL() {
		return (List<User>) extraSpringHibernateTemplate.findAll(poc);
		
	}

	@Override
	public List<User> findALLByHQL(String hql, Object... object) {
		return extraSpringHibernateTemplate.findAllByHQL(hql, object);
	}

	@Override
	public User findByFristOneHQL(String hql, Object...object) throws Exception {
		return extraSpringHibernateTemplate.findFirstOneByHQL(hql, object);
	}

	@Override
	public User findOneFrist(String propName, Object object) {
		return extraSpringHibernateTemplate.findFirstOneByPropEq(poc, propName, object);
	}
	
}
