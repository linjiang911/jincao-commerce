package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godsmiracle.jincao.core.PO;
/**
 * 权限菜单类
 * @author linjiang
 *
 */
@Entity
@Table
public class PermissionMenu extends PO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer PermissionMenuId; 			//权限菜单Id
	private Integer PermissionId;					//权限Id
	private Integer MenuId;						//菜单Id
	@Override
	public Serializable getId() {
		return PermissionMenuId;
	}
	public Integer getPermissionMenuId() {
		return PermissionMenuId;
	}
	public void setPermissionMenuId(Integer permissionMenuId) {
		PermissionMenuId = permissionMenuId;
	}
	public Integer getPermissionId() {
		return PermissionId;
	}
	public void setPermissionId(Integer permissionId) {
		PermissionId = permissionId;
	}
	public Integer getMenuId() {
		return MenuId;
	}
	public void setMenuId(Integer menuId) {
		MenuId = menuId;
	}
	
}
