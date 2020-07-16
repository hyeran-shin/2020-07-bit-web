package com.bit;

import com.bit.board.BoardDao;

public class Program {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		dao.process();
	}
}
