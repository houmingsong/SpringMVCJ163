package com.lovo.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lovo.mvc.dao.PowerDaoImp;
import com.lovo.mvc.entity.PowerEntity;
import com.lovo.mvc.service.IPowerService;
@Service(value = "powerService")
public class PowerServiceImpl implements IPowerService{
	@Autowired
	private PowerDaoImp powerDao;
	@Override
	public List<PowerEntity> findPowerByUserId(String userId) {
		String hql = "select p.powerName from UserEntity u,PowerEntity p where u.userId=p.user.userId and u.userId=?";
		return powerDao.findHQLList(hql, new String[] {userId});
	}
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		IPowerService service = (IPowerService) app.getBean("powerService");
		System.out.println( service.findPowerByUserId("1"));
		
		
	}
}
