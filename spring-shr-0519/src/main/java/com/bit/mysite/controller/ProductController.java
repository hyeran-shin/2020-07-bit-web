package com.bit.mysite.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit.mysite.service.GalleryService;
import com.bit.mysite.service.ProductService;
import com.bit.mysite.vo.GalleryVo;
import com.bit.mysite.vo.ProductVo;
import com.bit.security.Auth;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private GalleryService galleryService;	
	
	
	@Auth	
	@RequestMapping(value="" , method=RequestMethod.GET)
	public String index(
			@ModelAttribute ProductVo vo,
			@RequestParam(value="p", required = true, defaultValue = "1" ) int page,
			Model model
			) {
		Map<String, Object> map = productService.allList(page);
		model.addAttribute("map" , map);
		return "product/index";
	}
	
	@Auth	
	@RequestMapping(value="",method=RequestMethod.POST)
	public String index(
			@RequestParam("file") MultipartFile multipartfile,
			@ModelAttribute @Valid ProductVo vo,
			BindingResult result
			) {
	
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError oe : list) {
				System.out.println("Object Error : " + oe);
			}
			//수정필요
			return "redirect:/product"; 
		}
		
		//상품 등록
		productService.uploadProduct(vo, multipartfile, null);
		
		return "redirect:/product";
	}
	
	@Auth
	@RequestMapping(value = "/view" , method=RequestMethod.GET)
	public String productView(
			@RequestParam(value="p", required = true, defaultValue = "1" ) int page,
			@RequestParam(value="productNo", required=true, defaultValue="") int pNo,
			Model model
			) {
		ProductVo vo = productService.selectOneNo(pNo);
				
		List<GalleryVo> imageList = galleryService.selectImageList(pNo);
		
		model.addAttribute("imageList" , imageList);
		model.addAttribute("vo",vo);
		return "product/view";
	}
	
	@Auth
	@RequestMapping(value = "/view" , method=RequestMethod.POST)
	public String productView(
			@ModelAttribute ProductVo vo,
			@RequestParam(value="productNo", required=true, defaultValue="") int pNo,
			@RequestParam("file") MultipartFile multipartfile
			) {
		
		
		if(multipartfile.isEmpty()) {
			multipartfile=null;
		}
		productService.updateProduct(vo, multipartfile);
		
		return "redirect:/product";
	}
	

	@Auth	
	@RequestMapping(value="/deletefile")
	public String delete(
			@RequestParam(value="deleteFileName[]") List<String> deleteFileName,
			@RequestParam(value="productNo", required=true, defaultValue="") int pNo,
			@ModelAttribute ProductVo vo,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		
		System.out.println("filename: " + deleteFileName);
		System.out.println("pNo : " + pNo);
		
		galleryService.deleteFile(pNo, deleteFileName);
		

		return "redirect:/product/view?productNo="+pNo;
	}
	
	
	  
}
   
  
 



