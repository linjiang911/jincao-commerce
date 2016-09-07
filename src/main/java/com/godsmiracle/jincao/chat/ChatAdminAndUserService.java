package com.godsmiracle.jincao.chat;

import java.util.List;

import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.ChatAdminAndUser;
/**
 * Chat
 * @author linjiang
 *
 */
public interface ChatAdminAndUserService {
	
	Paging<ChatAdminAndUser> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(ChatAdminAndUser entity);

	void saveAll(List<ChatAdminAndUser> listChat);
	
	List<ChatAdminAndUser> findALL();

	List<ChatAdminAndUser> findALLByHQL(String hql, Object...object);

	ChatAdminAndUser findByFristOneHQL(String hql, Object...object)throws Exception;

	ChatAdminAndUser findOneFrist(String propName, Object object);

	void remove(ChatAdminAndUser entity);

	void removeAll(List<ChatAdminAndUser> entityList);

	void update(ChatAdminAndUser entity);

	void updateAll(List<ChatAdminAndUser> list);
}
