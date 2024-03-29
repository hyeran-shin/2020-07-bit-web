package com.bit.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.mysite.service.BoardService;
import com.bit.mysite.vo.BoardVo;
import com.bit.mysite.vo.UserVo;
import com.bit.security.Auth;
import com.bit.security.AuthUser;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(
			@RequestParam(value="p", required=true, defaultValue="1") int page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword,
			Model model
			) {
		
		Map<String, Object> map = boardService.getMessageList(page, keyword);
		model.addAttribute("map", map);
		
		return "board/index";
	}
	

	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(
			@AuthUser UserVo authUser,
			@ModelAttribute BoardVo vo,
			@RequestParam(value="p", required=true, defaultValue="1") int page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword,
			@RequestParam(value="uNo", required=true, defaultValue="") String uNo
			) {

		if(authUser.getUsersType().equals("admin")) {
			if(uNo.equals("")) {
				vo.setUsersNo(authUser.getUsersNo());
				vo.setUsersType(authUser.getUsersType());
			}else {
				vo.setUsersNo(Integer.parseInt(uNo));
				vo.setUsersType(authUser.getUsersType());
			}
		}else {
			vo.setUsersNo(authUser.getUsersNo());
			vo.setUsersType(authUser.getUsersType());
		}
		
		boardService.writeMessage(vo);
		
		return "redirect:/board";
	}
	
	
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(
			@RequestParam(value="no", required=true, defaultValue="0") int no,
			@RequestParam(value="p", required=true, defaultValue="1") Integer page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword,
			Model model
			) {
		BoardVo boardVo = boardService.getMessage(no);
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		
		return "board/view";
	}
	
	@Auth
	@RequestMapping("/reply")
	public String reply(
			@RequestParam(value="no", required=true, defaultValue="0") int no,
			@RequestParam(value="p", required=true, defaultValue="1") Integer page,
			@RequestParam(value="uNo", required=true, defaultValue="") int uNo,
			Model model
			) {
		
		BoardVo boardVo = boardService.getMessage(no);
		
		model.addAttribute("boardVo",boardVo);
		model.addAttribute("page",page);
		model.addAttribute("uNo",uNo);
		
		return "board/reply";
	}
	
	@Auth
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(
			@RequestParam(value="no", required=true, defaultValue="0") int no,
			@RequestParam(value="p", required=true, defaultValue="1") int page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword,
			Model model
			) {
		BoardVo boardVo = boardService.getMessage(no);
		
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("page", page);
		model.addAttribute("keyword", keyword);
		
		return "board/modify";
	}
	
	@Auth
	@RequestMapping(value="/modify", method=RequestMethod.POST)	
	public String modify(
			@AuthUser UserVo authUser,
			@ModelAttribute BoardVo boardVo,
			@RequestParam(value="p", required=true, defaultValue="1") int page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword
			) {
		boardVo.setUsersNo(authUser.getUsersNo());
		boardService.updateMessage(boardVo);
		
		return "redirect:/board/view"
			 + "?no=" + boardVo.getNo()
			 + "&p=" + page
			 + "&kwd=" +keyword;
	}
}
