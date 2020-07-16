package com.bit.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bit.MyConfig;

public class BoardDao {
	private SqlSession session = null;
	
	public BoardDao() {
		session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void process() {
		System.out.println("게시판 작업 수행");
		
		
//		insert();// 글 등록
//		select(); // 전체 글 조회
//		selectOne(); // 게시글 번호로 조회
//		selectNos(); // 2개 이상의 게시글 번호 조회
		
		update(); // 게시글 수정
		delete(); // 게시글 삭제
		
		select();
		
		
	}
	
	private void insert() {
		BoardVo board = new BoardVo();
		board.setTitle("MyBatis");
		board.setContent("HELLO WORLD");
		
		/*
		 * board.xml의 매핑을 위해 namespace를 거쳐
		 * 해당 파일에 정의해 놓은 id="insertBoard"의 내용을 수행
		 * <mapper namespace="com.bit">
		 * ...
		 * 	<insert id="insertBoard">
		 * 	...
		 * -> com.bit.insertBoard
		 * -> 전달되는 board 객체의 접근자를 자동 호출하여 매핑
		 */
		session.insert("com.bit.insertBoard", board);
		session.commit();
		System.out.println("글 등록 완료");
	}
	
	private void select() {
		List<BoardVo> list = session.selectList("com.bit.selectBoard");
		System.out.println("게시글 전제 조회");
		for(BoardVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private void selectOne() {
		BoardVo board = new BoardVo();
		board.setNo(2);
		BoardVo vo = session.selectOne("com.bit.selectOneBoard", board);
		System.out.println("검색 결과 : " + vo);
	}
	
	private void selectNos() {
		BoardVo board = new BoardVo();
		board.setNos(new int[] {2, 3});
		List<BoardVo> list = session.selectList("com.bit.selectNos", board);
		System.out.println(list);
	}
	
	private void update() {
		BoardVo board = new BoardVo();
		board.setNo(3);
		board.setContent("Update Content");
		session.update("com.bit.updateBoard", board);
		session.commit();
		System.out.println("글 수정 완료");
	}
	
	private void delete() {
		BoardVo board = new BoardVo();
		board.setNo(2);
		session.delete("com.bit.deleteBoard", board);
		session.commit();
		System.out.println("글 삭제 완료");
	}
	
}













