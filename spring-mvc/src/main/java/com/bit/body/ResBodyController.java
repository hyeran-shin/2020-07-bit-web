package com.bit.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody 가 적용되는 형태 , 
// 내부에서는 requestmapping만 해도 body에 응답하는 controller이다.
//@Controller
public class ResBodyController {
	
	@RequestMapping("/resBody.do")
//	@ResponseBody
	public String resStringBody() {
		return "문자열 응답!";
		/**
		 * @ResponseBody
		 * 		- MVC의 View와 관련없이 반환
		 * 		- HTTP Response Body에 직접 표현하기 위한 방법
		 * 		- 쓰여지기 전 MessageConverter의 영향
		 * *Server -> Client(Response)
		 * 
		 * *Client -> Server(Request)
		 * request.setCh("utf-8")
		 * 	-> encoding을 filter로 대체
		 *  -> web.xml의 <filter>...<filter> 이다.
		 */
	}
	
	
	@RequestMapping("resBody.json")
//	@ResponseBody
	public Map<String, String> resJsonBody(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("ID", "Coffee");
		map.put("PW", "qwerty");
		map.put("NAME", "Latte");
		return map;
	}
	
	@RequestMapping("resVOBody.json")
	public MemberVO resJsonVOBody() {
		MemberVO vo = new MemberVO();
		vo.setId("Coffee");
		vo.setPw("qwerty");
		vo.setName("Cafe");
		return vo;
	}
	
	@RequestMapping("resStrListBody.json")
	public List<String> resJsonStrListBody() {
		List<String> list = new ArrayList<>();
		for(int i = 0 ; i < 4 ; i++) {
			list.add(String.valueOf(i));
		}
		return list;
	}
	
	@RequestMapping("resVOListBody.json")
	public List<MemberVO> resVOListBody() {
		List<MemberVO> mlist = new ArrayList<>();
		for(int i = 0 ; i <4; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("Coffee" + i);
			vo.setPw("qwerty" + i);
			vo.setName("Latte" + i);
			mlist.add(vo);
		}
		return mlist;
	}
	
	
	
}
