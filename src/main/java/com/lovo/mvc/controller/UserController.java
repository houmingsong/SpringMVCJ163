package com.lovo.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lovo.mvc.entity.UserEntity;
import com.lovo.mvc.entity.UserInfoEntity;
import com.lovo.mvc.service.IUserService;
import com.lovo.mvc.service.ImgPath;
import com.lovo.mvc.util.StaticTool;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private ImgPath imgPath; // 图片地址

	@RequestMapping("/savaUser.lovo")
	public ModelAndView sava(String userName, String userTel,UserEntity user,
			@RequestParam("fileNameImg") MultipartFile file) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView("show");
		// 1、验证文件类型
		String fileType = file.getContentType();
		boolean bl = StaticTool.blImg(fileType);
		if (!bl) {
			mv.addObject("errorMsg", StaticTool.IMGERROR);
			return mv;
		}
		// 2、可以任意改变存放的路径
		String filePath = imgPath.getPathImg();
		// 3、重命名图片名字以防覆盖，组装全部路径
		String imgNewPath = System.currentTimeMillis() + StaticTool.getSuffixImg(fileType);
		filePath = filePath + imgNewPath;

		File f = new File(filePath); // 存放的文件
		if (!f.exists()) {
			f.mkdirs(); // 如果文件没有就创建
		}
		file.transferTo(f);
		

		// 4、把路径保存到数据库，不变的部分
		List<UserEntity> listUser = new ArrayList<UserEntity>();
//		user.setImgPath(imgNewPath);
//		userService.addUser(user);
		listUser.add(user);
		mv.addObject("userList", listUser);
		return mv;
	}

	@RequestMapping("/savaRedirect.lovo")
	public ModelAndView savaRedirect(String userName, String password, UserEntity user, HttpServletRequest rq) {
		System.out.println(userName);
		ModelAndView mv = new ModelAndView();
		// 重定向视图
		RedirectView rv = new RedirectView("findUserList.lovo");
		mv.setView(rv);
		return mv;
	}

	@RequestMapping("/findUserList.lovo")
	public String findUserList(HttpServletRequest rq) {
		List<UserEntity> listUser = new ArrayList<UserEntity>();
		for (int i = 0; i < 10; i++) {
			UserEntity u = new UserEntity();
			u.setUserName("赵云" + i);
			// u.setUserPassword("12345"+i);
			listUser.add(u);
		}
		// 放入到request环境
		rq.setAttribute("listUser", listUser);
		return "show";
	}

	@RequestMapping("/findUserListMV.lovo")
	public ModelAndView findUserList(@RequestParam("t") String tag) {
		System.out.println(tag);
		List<UserEntity> listUser = new ArrayList<UserEntity>();
		for (int i = 0; i < 10; i++) {
			UserEntity u = new UserEntity();
			u.setUserName("赵云" + i);
			// u.setUserPassword("12345"+i);
			listUser.add(u);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("listUser", listUser);
		mv.setViewName("show");

		return mv;
	}

	@RequestMapping("getJson.lovo")
	@ResponseBody // 不返回视图，只返回数据
	public UserEntity getJson() {
		UserEntity user = new UserEntity();
		user.setUserId("1");
		user.setUserName("赵云");
		// user.setUserPassword("123456");
		return user;
	}

	@RequestMapping("/{userName}/{age}/getJsonRestfull.lovo")
	@ResponseBody // 不返回视图，只返回数据
	public UserEntity getJsonRestfull(@PathVariable String userName, @PathVariable int age) {
		System.out.println(userName + "/" + age);
		UserEntity user = new UserEntity();
		if (userName.equals("a")) {

			user.setUserId("1");
			user.setUserName("赵云");
			// user.setUserPassword("123456");
		} else if (userName.equals("b")) {
			user.setUserId("2");
			user.setUserName("关羽");
			// user.setUserPassword("123456876");
		}
		return user;
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/findListUser.lovo")
	public ModelAndView findListUser() {
		ModelAndView mv = new ModelAndView("userList");
//		List<UserEntity> listUser = userService.getListUser();
		// 获取用户集合
//		mv.addObject("userList", listUser);
		return mv;
	}

	/**
	 * 根据用户ID获取用户详细信息
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUserInfoListByUserId.lovo")
	@ResponseBody
	public List<UserInfoEntity> getUserInfoListByUserId(String userId) {
		List<UserInfoEntity> listUserInfo = null;
//		listUserInfo = userService.getListUserInfoByUserId(userId);
		return listUserInfo;
	}

	/**
	 * 跳转到用户详细界面
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/gotoUserInfo.lovo")
	public ModelAndView gotoUserInfo(String userId) {
		ModelAndView mv = new ModelAndView("userInfo");
		mv.addObject("userId", userId);
		return mv;
	}
	
	@RequestMapping("/AllUser.lovo")
	public ModelAndView AllUser() {
		ModelAndView mv = new ModelAndView("user");
		List<UserEntity> list = userService.findAllUser();
		mv.addObject("list", list);
		return mv;
	}

}
