package com.bit.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDAO;
import com.bit.dao.CommentDAO;
import com.bit.framework.ModelAndView;
import com.bit.framework.annotation.RequestMapping;
import com.bit.util.MyFileRenamePolicy;
import com.bit.vo.BoardVO;
import com.bit.vo.CommentVO;
import com.bit.vo.FileVO;
import com.oreilly.servlet.MultipartRequest;

public class BoardController {
	
	@RequestMapping("/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ServletContext sc = request.getServletContext();
		BoardDAO dao = (BoardDAO) sc.getAttribute("boardDAO");
		List<BoardVO> list = dao.selectAllBoard();

		ModelAndView mav = new ModelAndView();
		mav.addAttribute("list", list);
		mav.setView("/WEB-INF/views/board/list.jsp");
		return mav;
	}

	@RequestMapping("/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/board/writeForm.jsp");
		return mav;
	}

	@RequestMapping("/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveFolder = "C:\\Users\\qweqwe\\Desktop\\web-workspace\\jblog-spring-prob\\jblog-spring-prob\\WebContent\\upload";
		

		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3, "utf-8",
				new MyFileRenamePolicy());
		ServletContext sc = request.getServletContext();
		BoardDAO dao = (BoardDAO) sc.getAttribute("boardDAO");
		int boardNo = dao.boardInsertNo();

		if (boardNo == 0) {
			boardNo++;
		}
		BoardVO board = new BoardVO();
		board.setNo(boardNo);
		board.setTitle(multi.getParameter("title"));
		board.setWriter(multi.getParameter("writer"));
		board.setContent(multi.getParameter("content"));
		
		int board_result = dao.boardInsert(board);
		int file_result = 0;

		Enumeration files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String fileName = (String) files.nextElement();
			File f = multi.getFile(fileName);
			if (f != null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int) f.length();

				FileVO file = new FileVO();
				file.setBoardNo(boardNo);
				file.setFileOriName(fileOriName);
				file.setFileSaveName(fileSaveName);
				file.setFileSize(fileSize);
				file_result = dao.insertFile(file);
			}

		}
		String msg = "";
		String url = "";
		if (board_result != -1 && file_result != -1) {
			msg = "게시글 등록을 완료하였습니다.";
			url = "/jblog-spring-prob/boardList.do";
		} else {
			msg = "게시글 등록을 실패하였습니다.";
			url = "/jblog-spring-prob/boardWriteForm.do";
		}
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg", msg);
		mav.addAttribute("url", url);
		mav.setView("/WEB-INF/views/board/write.jsp");
		return mav;
	}

	@RequestMapping("/boardDetail.do")
	public ModelAndView boardDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String type = request.getParameter("type");
		int no = Integer.parseInt(request.getParameter("no")); //실제 board_no
		int list_idx = Integer.parseInt(request.getParameter("list_idx")); //list index
		ServletContext sc = request.getServletContext();
		BoardDAO dao = (BoardDAO) sc.getAttribute("boardDAO");

		if (type != null && type.equals("list")) {
			dao.updateBoardCnt(no);// no 게시물 조회수 증가
		}

		BoardVO board = dao.selectOneBoard(no); // no 해당 게시물
		List<FileVO> fileList = dao.selectFile(no); // no 해당 파일
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		session.setAttribute("fileList", fileList);
		CommentDAO cdao = (CommentDAO) sc.getAttribute("commentDAO");
		CommentVO vo = new CommentVO();
		vo.setBoardNo(no);
		List<CommentVO> commentList = cdao.selectAllComment(vo); // no 해당 댓글
	
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("commentList", commentList);
		mav.addAttribute("list_idx", list_idx);
		mav.setView("/WEB-INF/views/board/detail.jsp");
		return mav;
	}

	@RequestMapping("/boardModifyForm.do")
	public ModelAndView boardModifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int list_idx = Integer.parseInt(request.getParameter("list_idx"));

		ModelAndView mav = new ModelAndView();
		mav.addAttribute("list_idx", list_idx);
		mav.setView("/WEB-INF/views/board/detailModifyForm.jsp");
		return mav;
	} 

	@RequestMapping("/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveFolder = "C:\\Users\\qweqwe\\Desktop\\web-workspace\\jblog-spring-prob\\jblog-spring-prob\\WebContent\\upload";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024 * 1024 * 3, "utf-8",
				new MyFileRenamePolicy());
		int list_idx = Integer.parseInt(multi.getParameter("list_idx"));
		
		BoardVO board = new BoardVO();
		int no = Integer.parseInt(multi.getParameter("no"));
		board.setNo(no);
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		
		
		ServletContext sc = request.getServletContext();
		BoardDAO dao = (BoardDAO) sc.getAttribute("boardDAO");
		int result = dao.updateBoard(board);
		
		// 파일 등록
		Enumeration files = multi.getFileNames();
		int file_result = 0;
		while (files.hasMoreElements()) {
			String fileName = (String) files.nextElement();
			File f = multi.getFile(fileName);
			if (f != null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int) f.length();
				
				FileVO file = new FileVO();
				file.setBoardNo(no);
				file.setFileOriName(fileOriName);
				file.setFileSaveName(fileSaveName);
				file.setFileSize(fileSize);
				file_result = dao.insertFile(file);
			}

		}
		// 파일 삭제 
		// 해당 저장이름을 넘겨받음.
		
//		   String fileName = "test.html"; //지울 파일명
//		   String fileDir = "fileDir"; //지울 파일이 존재하는 디렉토리
//		   String filePath = request.getRealPath(fileDir) + "/"; //파일이 존재하는 실제경로
//		   filePath += fileName;
//
//		   File f = new File(filePath); // 파일 객체생성
//		   if( f.exists()) f.delete(); // 파일이 존재하면 파일을 삭제한다.
//		   
		   
		String[] deleteFileName = multi.getParameterValues("deleteFileName");
		int dfresult = 0;
		File df = null;
		
		if (deleteFileName != null) {
			int[] dfResult = dao.deleteFile(no, deleteFileName);
			for (int r : dfResult) {
				if (r == -1) {
					System.out.println("파일 삭제 실패");
					dfresult = -1;
				} else {
					dfresult = 1;
					System.out.println("파일 삭제 들어와아ㅏ아ㅏㅏㅏㅏ");
					for(String dfileName : deleteFileName) {
						System.out.println("ddddddddddfileName : " + dfileName);
						saveFolder= saveFolder + "\\" + dfileName;
						System.out.println("삭제 파일 명!!!!!!!!!!!!!!!!!! : " + saveFolder);
						df = new File(saveFolder);
						if(df.exists()) df.delete();
						System.out.println(dfileName + "의 파일이름 삭제 완료!!!!!!!!!!!!!!");
					}
				}
			}
		}

		String msg = "";
		String url = "";
		if (result != -1 && file_result !=-1 && dfresult != -1) {
			msg = "수정 완료하였습니다.";
			url = "/jblog-spring-prob/boardDetail.do?no=" + no + "&type=list&list_idx="+list_idx;
		} else {
			msg = "수정 실패하였습니다.";
			url = "/jblog-spring-prob/boardModifyForm.do";
		}

		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg", msg);
		mav.addAttribute("url", url);
		mav.setView("/WEB-INF/views/board/detailModify.jsp");
		return mav;
	}

	@RequestMapping("/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		int list_idx = Integer.parseInt(request.getParameter("list_idx"));
		ServletContext sc = request.getServletContext();
		BoardDAO dao = (BoardDAO) sc.getAttribute("boardDAO");
		// board 삭제
		int result = dao.boardDelete(no);
		// file 삭제
		int fResult = dao.deleteBoardFile(no);
		// 댓글 삭제
		int cResult = dao.deleteBoardComment(no);
		String msg="";
		String url="";
		if (result != -1 && fResult != -1 && cResult!=-1) {
			msg = "삭제 완료하였습니다.";
			url = "/jblog-spring-prob/boardList.do";
		} else {
			msg = "삭제 실패하였습니다.";
			url = "/jblog-spring-prob/boardModify.do?no="+no+"&list_idx="+list_idx;
		}
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg", msg);
		mav.addAttribute("url", url);
		mav.setView("/WEB-INF/views/board/detailDelete.jsp");
		return mav;
	}

	
	@RequestMapping("/selectSearch.do")
	public ModelAndView selectSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title_search = request.getParameter("title_search");
		ServletContext sc = request.getServletContext();
		BoardDAO dao = (BoardDAO) sc.getAttribute("boardDAO");
		List<BoardVO> list = dao.selectSearch(title_search);
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("list", list);
		mav.setView("/WEB-INF/views/board/listSearch.jsp");
		return mav;
	}

}
