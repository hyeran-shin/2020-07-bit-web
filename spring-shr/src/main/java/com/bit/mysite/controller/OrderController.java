package com.bit.mysite.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.mysite.service.OrderService;
import com.bit.mysite.service.ProductService;
import com.bit.mysite.vo.UserVo;
import com.bit.security.Auth;
import com.bit.security.AuthUser;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;

	@Auth
	@RequestMapping(value = "")
	public String orderform(
			@RequestParam(value = "p", required = true, defaultValue = "1") int page,
			@RequestParam(value = "op", required = true, defaultValue = "1") int oPage,
			@RequestParam(value = "pCount", required = true, defaultValue = "1") int productCount,
			@AuthUser UserVo authUser,
			Model model
			) {
		Map<String, Object> map = productService.allList(page);
		
		Map<String, Object> order_map = orderService.OrderUserList( Integer.toString(authUser.getUsersNo()) , oPage, null);
		
		
		model.addAttribute("map", map);
		model.addAttribute("order_map", order_map);

		
		return "order/orderform";
	}

	@Auth
	@RequestMapping(value = "/ok")
	public String orderformOK(
			@RequestParam(value = "pNo", required = true, defaultValue = "") String pNo,
			@RequestParam(value = "pName", required = true, defaultValue = "") String pName,
			@RequestParam(value = "pCount", required = true, defaultValue = "") String pCount,
			@RequestParam(value = "price", required = true, defaultValue = "") String price,
			@AuthUser UserVo authUser
			) {
	
		orderService.insertOrder(pNo, pName, pCount, price, authUser.getUsersNo());		
		return "redirect:/order";
	}

	
	@Auth
	@RequestMapping(value = "/status")
	public String orderStatus(
			@RequestParam(value = "p", required = true, defaultValue = "1") int page,
			@RequestParam(value = "kwd", required = true, defaultValue = "") String keyword,
			Model model
			) {
		
		Map<String, Object> order_map = orderService.OrderUserList(null ,page, keyword);
		
		model.addAttribute("order_map", order_map);
		return "order/status";
	}
	

	@RequestMapping("/view")
	public String view(
			@RequestParam(value = "oNo", required = true, defaultValue = "") int oNo,
			@RequestParam(value = "uNo", required = true, defaultValue = "") int uNo,
			Model model
			){
		
		 List<Object> list = orderService.totalList(oNo, uNo);
		 model.addAttribute("list", list);
		 
		return "order/view";
	}
	
	@Auth
	@RequestMapping(value = "/delete")
	public String orderDelete(
			@RequestParam(value = "pNo", required = true, defaultValue = "") String pNo,
			@RequestParam(value = "p", required = true, defaultValue = "1") int page,
			@RequestParam(value = "no", required = true, defaultValue = "1") int no,
			Model model
			) {
		
		orderService.delete(pNo, no);
		return "redirect:/order";
	}
	
	
}
