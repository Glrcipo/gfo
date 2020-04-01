package com.gfo.gfo.controller;

import javax.servlet.http.HttpSession;

/**
 * 控制器类的基类
 */
abstract class BaseController {
	
	/**
	 * 响应正确时使用的状态码
	 */
	public static final Integer OK = 2000;

	/**
	 * 从Session中获取当前登录的用户的id
	 * @param session HttpSession对象
	 * @return 当前登录的用户的id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}

	/**
	 * 从Session中获取当前登录的用户的用户名
	 * @param session HttpSession对象
	 * @return 当前登录的用户的用户名
	 */
	protected final String getUsernameFromSession(HttpSession session) {
		return session.getAttribute("username").toString();
	}
	
}
