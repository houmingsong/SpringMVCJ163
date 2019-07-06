package com.lovo.mvc.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.lovo.mvc.entity.PowerEntity;
import com.lovo.mvc.service.IPowerService;
import com.lovo.mvc.service.ImgPath;


@Controller
@RequestMapping("user")
public class PowerController{
	@Autowired
	private IPowerService powerService;

	@RequestMapping("/findPower.lovo")
	public ModelAndView findPowerByUserId(String userId) {
		ModelAndView mv = new ModelAndView("power");
		List<PowerEntity> list = powerService.findPowerByUserId(userId);
		mv.addObject("list", list);
		return mv;	
	}
}
