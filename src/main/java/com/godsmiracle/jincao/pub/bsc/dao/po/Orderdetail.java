package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;
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

import org.springframework.beans.factory.annotation.Configurable;

import com.godsmiracle.jincao.core.PO;

/**
 * Orderdetail 订单详情
 */
@Entity
@Table
public class Orderdetail extends PO {

	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer OrderdetailId;
	private Integer orderinfoId;
	private String detailSum;
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return OrderdetailId;
	}
	public Integer getOrderdetailId() {
		return OrderdetailId;
	}
	public void setOrderdetailId(Integer orderdetailId) {
		OrderdetailId = orderdetailId;
	}
	public Integer getOrderinfoId() {
		return orderinfoId;
	}
	public void setOrderinfoId(Integer orderinfoId) {
		this.orderinfoId = orderinfoId;
	}
	public String getDetailSum() {
		return detailSum;
	}
	public void setDetailSum(String detailSum) {
		this.detailSum = detailSum;
	}
	
}