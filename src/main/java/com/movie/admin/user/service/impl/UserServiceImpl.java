package com.movie.admin.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.movie.admin.user.service.UserService;
import com.movie.common.SHA256Util;
import com.movie.vo.PageVO;
import com.movie.vo.UserVO;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper mapper;

	@Override
	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		if(userVO.isPaging()) userVO.setPageVO(new PageVO(userVO.getBlockSize(), userVO.getListSize(), userVO.getPage(), mapper.selectUserListCount(userVO)));
		return mapper.selectUserList(userVO);
	}

	@Override
	public UserVO selectUser(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectUser(userVO);
	}

	@Override
	public int insert(UserVO userVO) throws Exception {
		if(userVO.getUserNo()==0) {
			userVO.setSalt(SHA256Util.generateSalt());
			userVO.setPwd(SHA256Util.getEncrypt(userVO.getPwd(),userVO.getSalt()));
			return mapper.insert(userVO);
		}else {
			if(StringUtils.hasText(userVO.getPwd())) {
				UserVO VO= mapper.selectUserByUserNo(userVO.getUserNo());
				userVO.setPwd(SHA256Util.getEncrypt(userVO.getPwd(), VO.getSalt()));
			}
			return mapper.update(userVO);
		}
	}

	@Override
	public int delete(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(userVO);
	}

	@Override
	public UserVO selectUserById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectUserById(userId);
	}
	
}
