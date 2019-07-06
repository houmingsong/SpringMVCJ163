package com.lovo.mvc.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.mvc.entity.NewsEntity;
import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.service.INewsServicce;
import com.lovo.mvc.service.IUserService;
import com.lovo.mvc.util.DateChange;

@Controller
@RequestMapping("user")
public class NewsController {

	@Autowired
	private IUserService userservice;

	@Autowired
	private INewsServicce newsServicce;

	@RequestMapping("/login.lovo")
	public ModelAndView login(String userName, String password, UserEntity user) {
		if (userservice.login(userName, password) != null) {
			ModelAndView mv = new ModelAndView();
			RedirectView rv = new RedirectView("findAllNews.lovo");
			mv.setView(rv);
			return mv;	
		}
		return new ModelAndView("login");

	}

	@RequestMapping("/release.lovo")
	public ModelAndView release(String title,String type,String content,Date typeTime,Date displayTime,String publisher,NewsEntity news) {		 
		newsServicce.add(news);
		ModelAndView mv = new ModelAndView();
		RedirectView rv = new RedirectView("news.lovo");
		mv.setView(rv);
		return mv;		
	}
	
	@RequestMapping("/news.lovo")
	public ModelAndView news(Date startDate,Date endDate,String type,String title) {
		ModelAndView mv = new ModelAndView("news");
		List<NewsEntity> newsList = newsServicce.findByItem(startDate, endDate, type, title);
		mv.addObject("newsList", newsList);
		return mv;		
	}
	
	@RequestMapping("/backstage.lovo")
	public ModelAndView news1(String startDate,String endDate,String type,String title) {
		ModelAndView mv = new ModelAndView("backstage");
		Date start = DateChange.getDate(startDate);
		Date end = DateChange.getDate(endDate);
		List<NewsEntity> list = newsServicce.findByItem(start, end, type, title);
		mv.addObject("list", list);
		return mv;		
	}
	
	@RequestMapping("getNewsListById.lovo")
	@ResponseBody
	public List<NewsEntity> getNewsListByUserId(String newsId){
		List<NewsEntity> list = newsServicce.findById(newsId);
		return list;	
	}
	
	@RequestMapping("/getNews.lovo")
	public ModelAndView gotoUserInfo(String newsId) {
		List<NewsEntity> list = newsServicce.findById(newsId);
		ModelAndView mv = new ModelAndView("show1");		
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/update.lovo")
	public ModelAndView update(String type,String newsId) {
		ModelAndView mv = new ModelAndView();
		newsServicce.update(type, newsId);
		RedirectView rv = new RedirectView("findAllNews.lovo");
		mv.setView(rv);
		return mv;		
	}
	
	@RequestMapping("/findAllNews.lovo")
	public ModelAndView findAllNews() {
		ModelAndView mv = new ModelAndView("backstage");
		List<NewsEntity> list = newsServicce.findByItem(null, null, null, null);
		mv.addObject("list", list);
		return mv;			
	}
	
}
