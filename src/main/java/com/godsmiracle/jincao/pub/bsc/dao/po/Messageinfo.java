package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.godsmiracle.jincao.core.PO;

/**
 * 邮件信息
 */
@Entity
@Table
public class Messageinfo extends PO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer messageId;
	private Integer userId;
	private String messageCon;
	private Long messageDate;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return messageId;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMessageCon() {
		return messageCon;
	}
	public void setMessageCon(String messageCon) {
		this.messageCon = messageCon;
	}
	public Long getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Long messageDate) {
		this.messageDate = messageDate;
	}

}