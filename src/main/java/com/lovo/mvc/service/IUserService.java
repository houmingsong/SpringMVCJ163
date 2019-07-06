package com.lovo.mvc.service;

import java.util.List;

import com.lovo.mvc.entity.UserEntity;

public interface IUserService {
//    /**
//     * 获取所用用户
//     * @return
//     */
//	public List<UserEntity> getListUser();
	
	public void addUser(UserEntity user);
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public Object login(String userName,String password);
	
	public List<UserEntity> findAllUser();
}
