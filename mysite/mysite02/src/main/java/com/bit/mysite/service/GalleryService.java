package com.bit.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit.mysite.exception.GalleryUploadException;
import com.bit.mysite.repository.GalleryDao;
import com.bit.mysite.vo.GalleryVo;
@Service
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;

	private static final String SAVE_PATH = "C:\\Users\\qweqwe\\Desktop\\web-workspace\\spring-mysite\\webapp\\upload";
	public static final String BASE_URL = "/upload";
	
	
	public List<GalleryVo> getImageList(){
		return galleryDao.getList();
	}

	
	public void store(GalleryVo galleryVo, MultipartFile multipartfile) throws GalleryUploadException {
		try {
			if (multipartfile.isEmpty() == true) {
				throw new GalleryUploadException("MultipartFile is Empty");
			}

			String orgFileName = multipartfile.getOriginalFilename();
			String fileExtName = orgFileName.substring(orgFileName.lastIndexOf('.') + 1, orgFileName.length());
			String saveFileName = generateSaveFileName(fileExtName);
			Long fileSize = multipartfile.getSize();
			
			writeFile(multipartfile, saveFileName);
			
			galleryVo.setOrgFilrName(orgFileName);
			galleryVo.setSaveFileName(saveFileName);
			galleryVo.setFileExtName(fileExtName);
			galleryVo.setFileSize(fileSize);
			
			galleryDao.insert(galleryVo);

		} catch (IOException ex) {
			throw new GalleryUploadException("Save File Uploaded");
		}
	}

	
	private String generateSaveFileName(String extName) {
		String fileName="";
		Calendar calendar = Calendar.getInstance();
		
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH + 1);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);
		
		return fileName;
	}
	
	private void writeFile(MultipartFile multipartfile, String saveFileName) throws IOException{
		byte[] fileData = multipartfile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.close();
		
	}
	
	public boolean deleteImage(Long usersNo, Long no) {
		GalleryVo galleryVo = new GalleryVo();
		galleryVo.setUsersNo(usersNo);
		galleryVo.setNo(no);
	
		
		return galleryDao.delete(galleryVo) == 1;
	}
	
	
}
