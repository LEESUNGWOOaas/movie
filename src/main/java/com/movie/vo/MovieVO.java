package com.movie.vo;

import org.apache.ibatis.type.Alias;

@Alias("movieVO")
public class MovieVO extends CommonVO{
	private String movieNo;//넘버
	private String movieRank;//영화순위
	private String movieName;//영화이름
	private String movieReverse;//영화 예매율
	private String score;//평점
	private String openDay;//개봉일
	private String regId;//최초 등록자
	private String regDt;//최초등록일
	private String chgId;//최근수정자
	private String chgDt;//최근수정일
	private String rankCheckTime;//수집시간
	private String thumbImage;
	
	public String getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(String movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieRank() {
		return movieRank;
	}
	public void setMovieRank(String movieRank) {
		this.movieRank = movieRank;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieReverse() {
		return movieReverse;
	}
	public void setMovieReverse(String movieReverse) {
		this.movieReverse = movieReverse;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getOpenDay() {
		return openDay;
	}
	public void setOpenDay(String openDay) {
		this.openDay = openDay;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getChgId() {
		return chgId;
	}
	public void setChgId(String chgId) {
		this.chgId = chgId;
	}
	public String getChgDt() {
		return chgDt;
	}
	public void setChgDt(String chgDt) {
		this.chgDt = chgDt;
	}
	public String getRankCheckTime() {
		return rankCheckTime;
	}
	public void setRankCheckTime(String rankCheckTime) {
		this.rankCheckTime = rankCheckTime;
	}
	public String getThumbImage() {
		return thumbImage;
	}
	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}
	
	
	
}
