package com.bit.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.GalleryDao;
import com.bit.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;
	
	public List<GalleryVo> selectImageList(int no){
		return galleryDao.getImageList(no);
	}
	
	public void deleteFile(int pNo, List<String> dFileName) {
		galleryDao.deleteFile(pNo, dFileName);
	}
}
