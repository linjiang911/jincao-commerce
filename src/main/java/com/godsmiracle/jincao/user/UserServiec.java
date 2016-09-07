package com.godsmiracle.jincao.user;

import java.util.List;

import com.godsmiracle.jincao.common.util.Paging;
import com.godsmiracle.jincao.pub.bsc.dao.po.User;
import com.godsmiracle.jincao.pub.bsc.dao.po.User;
/**
 * User
 * @author linjiang
 *
 */
public interface UserServiec {
	
	Paging<User> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(User entity);

	void saveAll(List<User> listUser);
	
	List<User> findALL();

	List<User> findALLByHQL(String hql, Object...object);

	User findByFristOneHQL(String hql, Object...object)throws Exception;

	User findOneFrist(String propName, Object object);

	void remove(User entity);

	void removeAll(List<User> entityList);

	void update(User entity);

	void updateAll(List<User> list);
}
