package com.movie.util.service.impl;




import java.awt.color.CMMException;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.util.CmmUtil;
import com.movie.util.DateUtil;
import com.movie.util.service.MovieService;
import com.movie.vo.MovieVO;



@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieMapper mapper;
	
	@Override
	public int getMovieInfo() throws Exception {
		// TODO Auto-generated method stub
		// 크롤링결과 (0보다 크면 크롤링성공)
		 int result = 0;
		 //CGV 영화 순위 가져올 사이트
		 String url = "http://www.cgv.co.kr/movies/";
		 //JSoup 라이브러리 통해 사이트 접속되면,그 사이트의  전체 html 소스 저장 할 변수(초기화)
		 Document doc = null;
		 //사이트 접속( http만 가능 <https는 보안상 안된다고한다>)
		 doc = Jsoup.connect(url).get();
		 //CGV 웹 페이지의 전체 소스중 일부 태그 선택 
		 Elements element = doc.select("div.sect-movie-chart");
		 
		 //Iterator를 이용해 영화 순위 정보 가져온다.
		 //영화 순위는 기본적으로 복수 개 이기 때문에 반복해야한다.
		 Iterator<Element> movie_rank = element.select("strong.rank").iterator();//영화순위
		 Iterator<Element> movie_name = element.select("strong.title").iterator();//영화제목
		 Iterator<Element> movie_reserve = element.select("strong.percent span").iterator();//영화예매율
		 Iterator<Element> score = element.select("strong.percent").iterator();//영화평점
		 Iterator<Element> open_day = element.select("strong.txt-info").iterator();//영화개봉일	
		 Iterator<Element> thumb_image = element.select("a.img span").iterator();//영화개봉일	
		 
		 MovieVO movieVO = null;
		 while(movie_rank.hasNext()) {
			 movieVO =  new MovieVO();//수집된 영화 정보를 DTO에 저장하기 위해 메모리영역에 올리기
			 //수집을 위한 기본키 사용
			 movieVO.setRankCheckTime(DateUtil.getDateTime("yyyyMMdd24hmmss"));
			 //영화 순위(trim 함수 사용)
			 /* * trim 함수 사용 이유 - trim 함수는 글자의 앞,뒤 공백 삭제 역할을 수행하여, 
			 					데이터 수집시, 홈페이지 개발자들을 앞뒤 공백 집어넣을 수 있어서 추가*/
			 String rank = CmmUtil.nvl(movie_rank.next().text().trim());//no.1 데이터 가져옴
			 movieVO.setMovieRank(rank.substring(3,rank.length()));
			//영화 제목
			 movieVO.setMovieName(CmmUtil.nvl(movie_name.next().text().trim()));
				
				//영화 예매율
			 movieVO.setMovieReverse(CmmUtil.nvl(movie_reserve.next().text().trim()));
				
			
			/*
			 * movieVO.setThumbImage(CmmUtil.nvl(thumb_image.next().text().trim())); //영화 점수
			 * 
			 * movieVO.setScore(CmmUtil.nvl(score.next().text().trim()));
			 * 
			 * //수집되는 데이터가 'yyyy-mm-dd 개봉'이기 때문에 앞에 10자리 (yyyy-mm-dd)만 저장
			 * movieVO.setOpenDay(CmmUtil.nvl(open_day.next().text().trim().substring(0,10))
			 * );
			 */
				
				// 등록자 (admin 고정)
			 movieVO.setRegId("admin");
			 //영화 한개씩 추가함
			 result += mapper.insertMovie(movieVO);
		 }
		 return result;
	}

	@Override
	public List<MovieVO> selectMovieReverseList(MovieVO movieVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectMovieReverseList(movieVO);
	}

	@Override
	public List<MovieVO> selectMovieScoreList(MovieVO movieVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectMovieScoreList(movieVO);
	}

	
}
