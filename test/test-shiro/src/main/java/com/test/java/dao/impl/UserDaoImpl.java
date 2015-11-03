package com.test.java.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.java.dao.UserDao;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Map> selectAllUser() {
		return sqlSessionTemplate.selectList("selectUser");
	}

}
