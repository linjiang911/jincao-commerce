package com.godsmiracle.jincao.pub.bsc.dao.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderinfoGoodsinfoId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class OrderinfoGoodsinfoId implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer goodsId;

	// Constructors

	/** default constructor */
	public OrderinfoGoodsinfoId() {
	}

	/** full constructor */
	public OrderinfoGoodsinfoId(Integer orderId, Integer goodsId) {
		this.orderId = orderId;
		this.goodsId = goodsId;
	}

	// Property accessors

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderinfoGoodsinfoId))
			return false;
		OrderinfoGoodsinfoId castOther = (OrderinfoGoodsinfoId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this
				.getOrderId() != null && castOther.getOrderId() != null && this
				.getOrderId().equals(castOther.getOrderId())))
				&& ((this.getGoodsId() == castOther.getGoodsId()) || (this
						.getGoodsId() != null && castOther.getGoodsId() != null && this
						.getGoodsId().equals(castOther.getGoodsId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		return result;
	}

}