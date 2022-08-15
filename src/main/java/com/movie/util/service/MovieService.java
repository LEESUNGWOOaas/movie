package com.movie.util.service;

import java.util.List;

import com.movie.vo.MovieVO;

public interface MovieService {

	int getMovieInfo()throws Exception;

	List<MovieVO> selectMovieReverseList(MovieVO movieVO)throws Exception;

	List<MovieVO> selectMovieScoreList(MovieVO movieVO)throws Exception;
}
