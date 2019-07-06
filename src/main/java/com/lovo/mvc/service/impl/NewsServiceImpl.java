package com.lovo.mvc.service.impl;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lovo.mvc.dao.NewsDaoImpl;
import com.lovo.mvc.entity.NewsEntity;
import com.lovo.mvc.service.INewsServicce;

@Service(value = "newsServicce")
public class NewsServiceImpl implements INewsServicce {

	@Autowired
	private NewsDaoImpl newsDao;

	@Override
	public void add(NewsEntity news) {
		newsDao.savaObject(news);

	}

	@Override
	public List<NewsEntity> findById(String id) {
		if(null==id||id.equals("")) {
			return null;
		}
		String hql = "from NewsEntity where newsId=?";
		return newsDao.findHQLList(hql, new String[] {id});

		
	}

	@Override
	public List<NewsEntity> findByItem(Date startDate, Date endDate, String type, String title) {
		String hql = "from NewsEntity where 1=1";
		if (!(startDate == null || "".equals(startDate))) {
			hql += "and typeTime>='" + startDate + "'";
		}
		if (!(endDate == null || "".equals(endDate))) {
			hql += "and typeTime<='" + endDate + "'";
		}
		if (!(type == null || "".equals(type))) {
			hql += "and type='" + type + "'";
		}
		if (!(title == null || "".equals(title))) {
			hql += "and title like'%" + title + "%'";
		}
		return newsDao.findHQLList(hql, null);
	}
	
	@Override
	public void update(String type, String newsId) {
		newsDao.update(type, newsId);
		
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		INewsServicce service = (INewsServicce) app.getBean("newsServicce");
//		 service.add(new
//		 NewsEntity(null,"历史",Date.valueOf("2018-12-28"),"张三","123","qqq",Date.valueOf("2018-12-29")));
//		 System.out.println(service.findById("4028ab1b67f3e6950167f3e72d6c0000"));
		List<NewsEntity> list = service.findByItem(null, null, null, null);
		for (NewsEntity n : list) {
			System.out.println(n.getContent());
		}
//		service.update("医疗", "4028ab1b67f3ba250167f3ba28a70000");
	}

	

}
