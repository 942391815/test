package com.test.java.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
	public List<Map> selectAllUser();

	public Set<String> findPermissions(String username);

	public Set<String> findRoles(String username);
	
}
