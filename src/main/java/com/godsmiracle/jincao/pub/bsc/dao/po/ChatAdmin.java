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
public class ChatAdmin extends PO{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer chatAdminId;
	private Integer adminUserId1;
	private Integer adminUserId2;
	@Lob
	private String 	context;
	private Long 	dtCreate;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return chatAdminId;
	}
	public Integer getChatAdminId() {
		return chatAdminId;
	}
	public void setChatAdminId(Integer chatAdminId) {
		this.chatAdminId = chatAdminId;
	}
	public Integer getAdminUserId1() {
		return adminUserId1;
	}
	public void setAdminUserId1(Integer adminUserId1) {
		this.adminUserId1 = adminUserId1;
	}
	public Integer getAdminUserId2() {
		return adminUserId2;
	}
	public void setAdminUserId2(Integer adminUserId2) {
		this.adminUserId2 = adminUserId2;
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
