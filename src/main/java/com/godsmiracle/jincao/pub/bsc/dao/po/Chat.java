package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.godsmiracle.jincao.core.PO;

@Entity
@Table
public class Chat extends PO{
	public final static Integer TYPE_ADMINTOADMIN=4;
	public final static Integer TYPE_USERTOUSER=3;
	public final static Integer TYPE_ADMINTOUSER=2;
	public final static Integer TYPE_USERTOADMIN=1;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer chatId;
	//发送者
	public Integer from;
	//发送者名称
	public String fromName;
	//接收者
	public Integer to;
	//发送的文本
	public String text;
	//发送日期
	private Long dtCreate;
	//发生类型
	private Integer type;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return chatId;
	}
	public Integer getChatId() {
		return chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getDtCreate() {
		return dtCreate;
	}
	public void setDtCreate(Long dtCreate) {
		this.dtCreate = dtCreate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
	
