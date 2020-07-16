package com.bit.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.mysite.service.GuestService;
import com.bit.mysite.vo.GuestVo;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(
			@RequestParam(value="p", required = true, defaultValue = "1" ) int page ,
			Model model) {
		
		Map<String, Object> map = guestService.selectAllList(page);
				
		model.addAttribute("map",map);
		return "guest/index";
	}
	
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String index(@ModelAttribute GuestVo guestVo) {
		
		guestService.insert(guestVo);
		
		return "redirect:guest";
	}
	
}
