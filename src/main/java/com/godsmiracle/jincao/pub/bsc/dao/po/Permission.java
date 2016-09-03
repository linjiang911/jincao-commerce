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
 * 权限
 * @author linjiang
 */
@Entity
@Table
public class Permission extends PO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer PermissionId;
	private String name;
	@Override
	public Serializable getId() {
		return PermissionId;
	}

	public Integer getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(Integer permissionId) {
		PermissionId = permissionId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
