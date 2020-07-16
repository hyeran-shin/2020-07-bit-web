package com.bit.file;

import java.io.File;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class UploadController {
	
	@Autowired //자동으로 생성되게 할 수 있음?
	ServletContext servletContext;
	
	// index.jsp의 요청 경로
	//	-> /file/uploadForm.do
	// 클래스 매핑 + 메소드 매핑
	//	-> /file + /uploadForm.do
	@RequestMapping("/uploadForm.do")
	public String uploadForm() {
		return "file/fileUploadForm";
	}
	
	@RequestMapping(value="upload.do" , method=RequestMethod.POST)
	public ModelAndView fileUpload(
			MultipartHttpServletRequest mRequest) throws Exception{
		// 실행되는 웹 어플리케이션 실제 경로
		String uploadDir = servletContext.getRealPath("/upload");
		System.out.println("실제 경로 : " + uploadDir);
		
		// 저장 경로
		ModelAndView mav = new ModelAndView("file/uploadResult");
		String id = mRequest.getParameter("id");
		System.out.println("전달 파라미터 : " + id);
		
		// getFileNames() : 반환 타입이 Iterator<String>
		Iterator<String> ite = mRequest.getFileNames();
		while(ite.hasNext()) {
			String formFileName = ite.next();
			MultipartFile mFile = mRequest.getFile(formFileName);
			String oriFileName = mFile.getOriginalFilename();
			System.out.println("원본 파일명 : " + oriFileName);
			
			if(oriFileName != null && !oriFileName.equals("")) {
				// 확장자 처리
				String ext = "";
				// 확장자를 의미하는 뒤쪽 기준으로부터의 "."의 위치
				int index = oriFileName.lastIndexOf(".");
				if(index != -1) { //EOF == -1, 존재한다면,
					// 파일명에서 확장자 추출
					ext = oriFileName.substring(index);
				}
				// 파일 사이즈
				long fileSize = mFile.getSize();
				System.out.println("파일 사이즈 : " + fileSize);
						
				// 고유한 파일명(UUID)
				String saveFileName = "bit-" + UUID.randomUUID().toString() + ext;
				System.out.println("저장 파일명 : " + saveFileName);
					
				// 임시 저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(uploadDir + "/" + saveFileName));
			}
		}
		
		return mav;
	}
}













