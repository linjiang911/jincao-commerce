package com.godsmiracle.jincao.pub.bsc.dao.po;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.godsmiracle.jincao.core.PO;

/**
 * Goodsinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table
public class Goodsinfo extends PO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer goodsId;
	private Integer imageinfo; 	//图片信息
	private String goodsName;		//商品名字
	@Lob
	private String goodsPrice;		//商品图片
	private Long goodsDate;			//商品创建时间
	private Integer userId;			//用户信息
	@Override
	public Serializable getId() {
		return goodsId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getImageinfo() {
		return imageinfo;
	}
	public void setImageinfo(Integer imageinfo) {
		this.imageinfo = imageinfo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Long getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Long goodsDate) {
		this.goodsDate = goodsDate;
	}
	
}