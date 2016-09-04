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
 * 角色权限类
 * @author linjiang
 *
 */
@Entity
@Table
public class RolePermission extends PO{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(unique = true, nullable = false)
		private Integer rolePermissionId; 			//角色权限Id
		private Integer roleId;						//角色Id
		private Integer permissionId;					//权限Id
		@Override
		public Serializable getId() {
			return rolePermissionId;
		}
		public Integer getRolePermissionId() {
			return rolePermissionId;
		}
		public void setRolePermissionId(Integer rolePermissionId) {
			this.rolePermissionId = rolePermissionId;
		}
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public Integer getPermissionId() {
			return permissionId;
		}
		public void setPermissionId(Integer permissionId) {
			this.permissionId = permissionId;
		}
}
