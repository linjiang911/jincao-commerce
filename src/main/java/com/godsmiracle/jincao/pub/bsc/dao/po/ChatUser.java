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
public class ChatUser extends PO{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer chatUserId;
	private Integer userId1;
	private Integer userId2;
	@Lob
	private String 	context;
	private Long 	dtCreate;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return chatUserId;
	}
	public Integer getChatUserId() {
		return chatUserId;
	}
	public void setChatUserId(Integer chatUserId) {
		this.chatUserId = chatUserId;
	}
	public Integer getUserId1() {
		return userId1;
	}
	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}
	public Integer getUserId2() {
		return userId2;
	}
	public void setUserId2(Integer userId2) {
		this.userId2 = userId2;
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
