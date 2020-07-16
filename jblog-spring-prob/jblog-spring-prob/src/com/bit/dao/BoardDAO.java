package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.ConnectionPool;
import com.bit.vo.BoardVO;
import com.bit.vo.FileVO;

public class BoardDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = new StringBuilder();

	// 게시판 전체 조회
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append(" SELECT * FROM board ORDER BY no DESC");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReg_date(rs.getString("reg_date"));
				board.setView_cnt(rs.getInt("view_cnt"));
				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}

		return list;
	}

	// 게시판 등록
	public int boardInsert(BoardVO board) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  INSERT INTO board(no, title, writer, content)  ");
			sql.append("  VALUES(?,?,?,?)   ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getNo());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	// 게시물 등록 시 사용할 no
	public int boardInsertNo() {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append(" SELECT max(no)+1 FROM board ");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	// 특정 게시물 조회
	public BoardVO selectOneBoard(int no) {
		BoardVO board = null;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append(" SELECT no, title, writer, content, ");
			sql.append("  		view_cnt, reg_date ");
			sql.append(" 	FROM board ");
			sql.append("  WHERE no = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			board = new BoardVO();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setView_cnt(rs.getInt("view_cnt"));
			board.setReg_date(rs.getString("reg_date"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}

		return board;
	}

	// 게시물 첨부파일 insert
	public int insertFile(FileVO file) {
		int result = -1;

		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  INSERT INTO board_file ( board_no,  ");
			sql.append("	file_ori_name, file_save_name, file_size) ");
			sql.append(" VALUES(?,?,?,?)  ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, file.getBoardNo());
			pstmt.setString(2, file.getFileOriName());
			pstmt.setString(3, file.getFileSaveName());
			pstmt.setInt(4, file.getFileSize());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}

		return result;
	}

	// 첨부파일 검색
	public List<FileVO> selectFile(int no) {
		List<FileVO> fileList = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append(" SELECT * FROM board_file  ");
			sql.append(" WHERE board_no = ?  ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				FileVO file = new FileVO();
				file.setBoardNo(rs.getInt("board_no"));
				file.setFileOriName(rs.getString("file_ori_name"));
				file.setFileSaveName(rs.getString("file_save_name"));
				file.setFileSize(rs.getInt("file_size"));
				fileList.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}

		return fileList;
	}

	// 조회 수 증가
	public int updateBoardCnt(int no) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append(" UPDATE board  ");
			sql.append(" SET view_cnt = view_cnt+1  ");
			sql.append(" WHERE no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	// 게시물 수정, 업데이트
	public int updateBoard(BoardVO board) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  UPDATE board  ");
			sql.append("  SET title = ? , content = ?, reg_date = now()  ");
			sql.append("  WHERE no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	// 게시물 삭제
	public int boardDelete(int no) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  DELETE FROM board ");
			sql.append("  WHERE no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	// 게시물 제목 검색
	public List<BoardVO> selectSearch(String title) {
		List<BoardVO> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append(" SELECT * FROM board ");
			sql.append(" WHERE title like ? ORDER BY no DESC ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReg_date(rs.getString("reg_date"));
				board.setView_cnt(rs.getInt("view_cnt"));
				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}

		return list;
	}

	// 첨부파일 삭제
	public int[] deleteFile(int no, String[] fileName) {
		int[] result = new int[fileName.length] ;
		
		try {
			con = ConnectionPool.getConnection();
			
			for (int i = 0; i < fileName.length; i++) {
				sql.delete(0, sql.length());
				sql.append(" DELETE FROM board_file ");
				sql.append(" WHERE file_save_name = ? ");
				sql.append(" and board_no = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, fileName[i]);
				pstmt.setInt(2, no);
				result[i] = pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}

	
	// 게시물 삭제 시 첨부파일 삭제
	public int deleteBoardFile(int no) {
		int result = -1;
		try {
			con = ConnectionPool.getConnection();
			sql.delete(0, sql.length());
			sql.append("  DELETE FROM board_file ");
			sql.append("  WHERE board_no = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectionPool.close(con);
		}
		return result;
	}
	
	// 게시물 삭제 시 댓글 삭제
		public int deleteBoardComment(int no) {
			int result = -1;
			try {
				con = ConnectionPool.getConnection();
				sql.delete(0, sql.length());
				sql.append("  DELETE FROM comment ");
				sql.append("  WHERE board_no = ?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, no);

				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				ConnectionPool.close(con);
			}
			return result;
		}
}
