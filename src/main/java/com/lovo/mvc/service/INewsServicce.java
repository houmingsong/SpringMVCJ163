package com.lovo.mvc.service;

import java.sql.Date;
import java.util.List;

import com.lovo.mvc.entity.NewsEntity;

public interface INewsServicce {
	
	/**
	 * 发布新闻
	 * @param news
	 */
	public void add(NewsEntity news);
	
	/**
	 * 按id查看新闻详情
	 * @param id
	 * @return
	 */
	public List<NewsEntity> findById(String id);
	
	/**
	 * 动态查询
	 * @param startDate 起始时间
	 * @param endDate 结束时间
	 * @param type 新闻类型
	 * @param title 新闻标题
	 * @return
	 */
	public List<NewsEntity> findByItem(Date startDate,Date endDate,String type,String title);
	
	/**
	 * 按id修改新闻类型
	 * @param type
	 * @param newsId
	 */
	public void update(String type,String newsId);
	
}
