package com.movie.admin.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movie.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;
	
	BoardVO selectBoard(BoardVO boardVO)throws Exception;
	
	int insert(BoardVO boardVO)throws Exception;

	int delete(BoardVO boardVO)throws Exception;

	int selectBoardListCount(BoardVO boardVO)throws Exception;
}
