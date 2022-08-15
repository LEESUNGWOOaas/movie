package com.movie.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.admin.board.service.BoardService;
import com.movie.vo.BoardVO;
import com.movie.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		if(boardVO.isPaging()) boardVO.setPageVO(new PageVO(boardVO.getBlockSize(), boardVO.getListSize(), boardVO.getPage(), mapper.selectBoardListCount(boardVO)));
		return mapper.selectBoardList(boardVO);
	}
	@Override
	public BoardVO selectBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoard(boardVO);
	}
	@Override
	public int insert(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.insert(boardVO);
	}
	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(boardVO);
	}

}
