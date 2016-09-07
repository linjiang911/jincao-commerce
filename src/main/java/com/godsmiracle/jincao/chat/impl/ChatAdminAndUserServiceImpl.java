package com.godsmiracle.jincao.chat.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godsmiracle.jincao.chat.ChatAdminAndUserService;
import com.godsmiracle.jincao.common.util.ExtraSpringHibernateTemplate;
import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.ChatAdminAndUser;


@Service
public class ChatAdminAndUserServiceImpl implements ChatAdminAndUserService {
	private static Class<?> poc=ChatAdminAndUser.class;
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<ChatAdminAndUser> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From Chat where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(ChatAdminAndUser entity) {
		extraSpringHibernateTemplate.saveByPoc(entity);
	}
	
	@Override
	public void remove(ChatAdminAndUser entity) {
		extraSpringHibernateTemplate.deleteByPoc(entity);
	}

	@Override
	public void removeAll(List<ChatAdminAndUser> list) {
		extraSpringHibernateTemplate.removeAll(list);
	}
	
	@Override
	public void update(ChatAdminAndUser entity) {
		extraSpringHibernateTemplate.updataByPoc(entity);
	}
	
	@Override
	public void updateAll(List<ChatAdminAndUser> list) {
		extraSpringHibernateTemplate.updataAll(list);
	}
	
	@Override
	public void saveAll(List<ChatAdminAndUser> listChat) {
		extraSpringHibernateTemplate.saveAll(listChat);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChatAdminAndUser> findALL() {
		return (List<ChatAdminAndUser>) extraSpringHibernateTemplate.findAll(poc);
		
	}

	@Override
	public List<ChatAdminAndUser> findALLByHQL(String hql, Object... object) {
		return extraSpringHibernateTemplate.findAllByHQL(hql, object);
	}

	@Override
	public ChatAdminAndUser findByFristOneHQL(String hql, Object...object) throws Exception {
		return extraSpringHibernateTemplate.findFirstOneByHQL(hql, object);
	}

	@Override
	public ChatAdminAndUser findOneFrist(String propName, Object object) {
		return extraSpringHibernateTemplate.findFirstOneByPropEq(poc, propName, object);
	}
	
}
