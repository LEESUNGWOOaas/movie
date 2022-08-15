package com.movie.admin.user.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movie.vo.UserVO;

@Mapper
public interface UserMapper {
	List<UserVO> selectUserList(UserVO userVO)throws Exception;
	
	UserVO selectUser(UserVO userVO)throws Exception;
	
	int insert(UserVO userVO)throws Exception;
	
	int delete(UserVO userVO)throws Exception;

	int selectUserListCount(UserVO userVO)throws Exception;
	
	UserVO selectUserById(String userId)throws Exception;

	UserVO selectUserByUserNo(int userNo)throws Exception;

	int update(UserVO userVO)throws Exception;
}
