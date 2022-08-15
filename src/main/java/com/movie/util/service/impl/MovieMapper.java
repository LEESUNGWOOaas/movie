package com.movie.util.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movie.vo.MovieVO;

@Mapper
public interface MovieMapper {
	int insertMovie(MovieVO movieVO)throws Exception;
	
	List<MovieVO> selectMovieReverseList(MovieVO movieVO)throws Exception;

	List<MovieVO> selectMovieScoreList(MovieVO movieVO)throws Exception;
}
