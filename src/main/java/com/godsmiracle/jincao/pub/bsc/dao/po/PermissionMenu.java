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
	private Integer permissionMenuId; 			//权限菜单Id
	private Integer permissionId;					//权限Id
	private Integer menuId;						//菜单Id
	@Override
	public Serializable getId() {
		return permissionMenuId;
	}
	public Integer getPermissionMenuId() {
		return permissionMenuId;
	}
	public void setPermissionMenuId(Integer permissionMenuId) {
		this.permissionMenuId = permissionMenuId;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
}
