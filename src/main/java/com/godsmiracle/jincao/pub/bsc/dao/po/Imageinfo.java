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

import com.godsmiracle.jincao.core.PO;

/**
 * Imageinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "imageinfo", catalog = "jincaodata")
public class Imageinfo extends PO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true,nullable=false)
	private Integer imageId;
	private Integer goodsinfoId;
	private String imageName;
	private String imagePath;
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public Integer getGoodsinfoId() {
		return goodsinfoId;
	}
	public void setGoodsinfoId(Integer goodsinfoId) {
		this.goodsinfoId = goodsinfoId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return imageId;
	}
	
	

}