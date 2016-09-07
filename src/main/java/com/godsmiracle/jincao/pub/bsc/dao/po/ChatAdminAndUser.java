package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.godsmiracle.jincao.core.PO;

@Entity
@Table
public class ChatAdminAndUser extends PO{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer chatAdminUserId;
	private Integer userId;
	private Integer adminUserId;
	@Lob
	private String 	context;
	private Long 	dtCreate;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return chatAdminUserId;
	}
	public Integer getChatAdminUserId() {
		return chatAdminUserId;
	}

	public void setChatAdminUserId(Integer chatAdminUserId) {
		this.chatAdminUserId = chatAdminUserId;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Long getDtCreate() {
		return dtCreate;
	}
	public void setDtCreate(Long dtCreate) {
		this.dtCreate = dtCreate;
	}
	
}
