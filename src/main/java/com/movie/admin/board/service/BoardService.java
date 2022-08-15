package com.movie.admin.board.service;

import java.util.List;

import com.movie.vo.BoardVO;

public interface BoardService {

	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;

	BoardVO selectBoard(BoardVO boardVO)throws Exception;

	int insert(BoardVO boardVO)throws Exception;

	int delete(BoardVO boardVO)throws Exception;

}
