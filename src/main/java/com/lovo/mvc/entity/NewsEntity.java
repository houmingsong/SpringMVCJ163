package com.lovo.mvc.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_news")
public class NewsEntity {
	
	@Id
	@GenericGenerator(name="useruuid",strategy="uuid")
	@GeneratedValue(generator="useruuid")
	@Column(length=32)
	private String newsId;
	
	@Column(length=32)
	private String type;
	
	@Column(length=32)
	private Date typeTime;
	
	@Column(length=32)
	private String publisher;
	
	@Column(length=32)
	private String content;
	
	@Column(length=32)
	private String title;
	
	@Column(length=32)
	private Date displayTime;
	
	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTypeTime() {
		return typeTime;
	}

	public void setTypeTime(Date typeTime) {
		this.typeTime = typeTime;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(Date displayTime) {
		this.displayTime = displayTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NewsEntity(String newsId, String type, Date typeTime, String publisher, String content, String title,
			Date displayTime) {
		super();
		this.newsId = newsId;
		this.type = type;
		this.typeTime = typeTime;
		this.publisher = publisher;
		this.content = content;
		this.title = title;
		this.displayTime = displayTime;
	}

	public NewsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
