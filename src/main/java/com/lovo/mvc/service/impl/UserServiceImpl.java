package com.lovo.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.lovo.mvc.dao.BasicDao;
import com.lovo.mvc.dao.UserDaoImpl;
import com.lovo.mvc.dao.UserInfoDaoImpl;
import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.entity.UserInfoEntity;
import com.lovo.mvc.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDaoImpl userDao;

	// @Autowired
	// private UserInfoDaoImpl userInfoDao;
	//
	// @Override
	// public List<UserEntity> getListUser() {
	//
	// return userDao.findHQLList();
	// }
	//
	// @Override
	// public List<UserInfoEntity> getListUserInfoByUserId(String userId) {
	// // 让代码健壮必须进行验证，其实还可以提高效率
	// if (null == userId || userId.equals("")) {
	// return null;
	// }
	// String hql = "from UserInfoEntity where user.userId=?";
	//
	// return userInfoDao.findHQLList(hql, new String[] { userId });
	// }
	//
	// @Override
	// public void addUser(UserEntity user) {
	// userDao.savaObject(user);
	//
	// }

	@Override
	public UserEntity login(String userName, String password) {
		String hql = " from UserEntity where userName=? and password=?";
		UserEntity user = userDao.findHQLObject(hql, new String[] {userName,password});
		
		return user;
		
	}

	@Override
	public void addUser(UserEntity user) {
		userDao.savaObject(user);

	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		IUserService service = (IUserService) app.getBean("userService");
//		service.addUser(new UserEntity(null,"张三","123456"));
//		System.out.println(service.login("张三", "123456"));
//		List<UserEntity> list = service.findAllUser();
//		for (UserEntity u : list) {
//			System.out.println(u.getUserId()+"/"+u.getUserName());
//		}
	}

	@Override
	public List<UserEntity> findAllUser() {	
		return userDao.findHQLList();
	}
}
