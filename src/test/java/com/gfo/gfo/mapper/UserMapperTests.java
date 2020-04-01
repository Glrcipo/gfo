package com.gfo.gfo.mapper;


import com.gfo.gfo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	@Autowired
	private UserMapper mapper;

	@Test
	public void insert() {
		User user = new User();
		user.setUsername("project");
		user.setPassword("1234");
		System.err.println(user);
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
		System.err.println(user);
	}

	@Test
	public void updateAvatarByUid() {
		Integer uid = 24;
		String avatar = "jgfbjghgkuygv";
		String modifiedUser = "密码管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updatePasswordByUid() {
		Integer uid = 24;
		String password = "1234";
		String modifiedUser = "密码管理员";
		Date modifiedTime = new Date();
		Integer rows = mapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateInfoByUid() {
		User user = new User();
		user.setUid(24);
		user.setPhone("13100131001");
		user.setEmail("root@163.com");
		user.setGender(1);
		Integer rows = mapper.updateInfoByUid(user);
		System.err.println("rows=" + rows);
	}

	@Test
	public void findByUid() {
		Integer uid = 24;
		User result = mapper.findByUid(uid);
		System.err.println(result);
	}

	@Test
	public void findByUsername() {
		String username = "root";
		User result = mapper.findByUsername(username);
		System.err.println(result);
	}
}












