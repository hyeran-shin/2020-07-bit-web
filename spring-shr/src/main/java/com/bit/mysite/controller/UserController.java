package com.bit.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mysite.service.UserService;
import com.bit.mysite.vo.UserVo;
import com.bit.security.Auth;
import com.bit.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform(@ModelAttribute UserVo userVo) {
		return "user/joinform";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError oe : list) {
				System.out.println("Object Error : " + oe);
			}
			return "user/joinform"; // 오류 있으면 현재 페이지 그대로
		}
		
		userService.join(userVo);
		
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() { 
		return "user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String loginform(@ModelAttribute UserVo userVo) { 
		return "user/loginform";
	}
	
	@Auth
	@RequestMapping("/modifyform")
	public String modifyform(@AuthUser UserVo authUser, Model model) {
	
		UserVo vo = userService.getUser(authUser.getUsersNo());
		model.addAttribute("userVo", vo); 
		
		return "user/modifyform"; 
	}
	
	@Auth
	@RequestMapping("/modify")
	public String modify(@AuthUser UserVo authUser ,@ModelAttribute @Valid UserVo vo, BindingResult result) {
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError oe : list) {
				System.out.println("modify Error : " + oe);
			}
			return "user/modifyform";
		}
		
		int r = userService.updateUser(vo);
		System.out.println("업데이트 결과 : " + r );
		authUser.setUsersName(vo.getUsersName());
		return "/user/modifysuccess";
	}
	
	@Auth
	@RequestMapping("/delete")
	public String delete(@AuthUser UserVo authUser, 
			HttpSession session, Model model) {
		
		if(authUser != null) {
			userService.deleteUser(authUser);
			session.removeAttribute("authUser");
			session.invalidate();
		}
		
		
		return "user/deleteform"; 
	}
	
}
