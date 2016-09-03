package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.godsmiracle.jincao.core.PO;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderinfo", catalog = "jincaodata")
public class Order extends PO {

	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer OrderId;
	private Integer userId;
	private Integer orderdetailId;
	private String orderTel;
	private String orderAdd;
	private Integer orderTota;
	private Timestamp orderDate;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return OrderId;
	}
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderdetailId() {
		return orderdetailId;
	}
	public void setOrderdetailId(Integer orderdetailId) {
		this.orderdetailId = orderdetailId;
	}
	public String getOrderTel() {
		return orderTel;
	}
	public void setOrderTel(String orderTel) {
		this.orderTel = orderTel;
	}
	public String getOrderAdd() {
		return orderAdd;
	}
	public void setOrderAdd(String orderAdd) {
		this.orderAdd = orderAdd;
	}
	public Integer getOrderTota() {
		return orderTota;
	}
	public void setOrderTota(Integer orderTota) {
		this.orderTota = orderTota;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

}