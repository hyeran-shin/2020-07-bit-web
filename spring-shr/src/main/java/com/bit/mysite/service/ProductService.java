package com.bit.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit.mysite.exception.GalleryUploadException;
import com.bit.mysite.repository.GalleryDao;
import com.bit.mysite.repository.ProductDao;
import com.bit.mysite.vo.GalleryVo;
import com.bit.mysite.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private GalleryDao galleryDao;
	
	private static final String SAVE_PATH = "C:\\SHR\\web-workspace\\spring-shr\\webapp\\upload";
	public static final String BASE_URL = "/upload";
	private static final int LIST_SIZE = 5; // 게시물 개수
	private static final int PAGE_SIZE = 5; // 페이지 개수
	
	public ProductVo selectOneNo(int pNo) {
		return productDao.selectOneNo(pNo);
	}

	public void updateProduct(ProductVo vo, MultipartFile file) {

		productDao.updateProduct(vo);
		
		if(file!=null) {
			// 상품 등록 시 사진 업로드했던코드 재사용/
			uploadProduct(vo, file, Integer.toString(vo.getProductNo()));
		}
	}
		
	public Map<String, Object> allList(int cPage){	
		int totalCount = productDao.selectProductNo();
		int pageCount = (int) Math.ceil((double)totalCount / LIST_SIZE);
		int blockCount = (int) Math.ceil((double)pageCount / PAGE_SIZE);
		int currentBlock = (int) Math.ceil((double)cPage / PAGE_SIZE);
		
		if(cPage < 1) {
			cPage = 1;
			currentBlock = 1;
		}else if(cPage > pageCount ) {
			cPage = pageCount;
			currentBlock = (int) Math.ceil((double)cPage / PAGE_SIZE);
		}
		
		int beginPage = (currentBlock == 0) ? 1 : (currentBlock -1) * PAGE_SIZE + 1;
		int prevPage = (currentBlock > 1) ? (currentBlock-1) * PAGE_SIZE : 0;
		int nextPage = (currentBlock < blockCount) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = (nextPage > 0 ) ? (beginPage-1) + LIST_SIZE : pageCount;
		
		List<ProductVo> list = productDao.allList(cPage,LIST_SIZE);
		
		Set<Integer> a = new LinkedHashSet<>();
		for (int i = 0; i < list.size(); i++) {
			a.add(list.get(i).getProductNo());
		}
	
		List<GalleryVo> imageList = new ArrayList<GalleryVo>(a.size());
		
		for(Integer aa : a) {
			int number = Integer.parseInt(aa.toString());
			imageList.add(galleryDao.getImageOneList(number) );
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("imageList", imageList);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("currentPage", cPage);
		map.put("beginPage", beginPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("endPage", endPage);
		return map;
	}
	
	public void uploadProduct(ProductVo vo, MultipartFile multipartfile, String productNo) {
		try {
			if (multipartfile.isEmpty() == true) {
				
				throw new GalleryUploadException("MultipartFile is Empty");
			}

			
			String orgFileName = multipartfile.getOriginalFilename();
			String fileExtName = orgFileName.substring(orgFileName.lastIndexOf('.') + 1, orgFileName.length());
			String saveFileName = generateSaveFileName(fileExtName);
			Long fileSize = multipartfile.getSize();
			
			writeFile(multipartfile, saveFileName);
			
			GalleryVo galleryVo = new GalleryVo();
			galleryVo.setOrgFileName(orgFileName);
			galleryVo.setSaveFileName(saveFileName);
			galleryVo.setFileExtName(fileExtName);
			galleryVo.setFileSize(fileSize);

			
			//상품사진등록
			if(vo.getProductNo() == 0) {
				int no = productDao.selectMax(); // product count(*)
				galleryVo.setProductNo(no + 1);
				productDao.insertGallery(galleryVo);
				productDao.insertProduct(vo);
		
			//상품사진수정(업로드)
			}else if(productNo != null && vo.getProductNo() != 0) {
				galleryVo.setProductNo(Integer.parseInt(productNo));
				productDao.insertGallery(galleryVo);
			}
			
		}catch (IOException ex) {
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
	
	
}
