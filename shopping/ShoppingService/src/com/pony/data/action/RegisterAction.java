package com.pony.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.pony.data.dao.RegisterDao;
import com.pony.util.DividePage;

public class RegisterAction extends HttpServlet {

	private RegisterDao registerDao;

	public RegisterAction() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("add")) {
			registerMessage(request, response);
		} else if (action_flag.equals("listUser")) {
			listUser(request, response);
		} else if (action_flag.equals("login")) {
			loginMessage(request, response);
		} else if (action_flag.equals("deleteUser")) {
			deleteUserPc(request, response);
		} else if (action_flag.equals("updateName")) {
			updateName(request, response);
		} else if (action_flag.equals("updatePhone")) {
			updatePhone(request, response);
		} else if (action_flag.equals("loginPc")) {
			login(request, response);
		} else if (action_flag.equals("queryMsg")) {
			queryMsg(request, response);
		} else if (action_flag.equals("updateState")) {
			updateState(request, response);
		} else if (action_flag.equals("listUserAdmin")) {
			listUserAdmin(request, response);
		}

	}

	private void updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String state = request.getParameter("state");

		System.out.println(state);
		System.out.println(uid);
		List<Object> params_check_login = new ArrayList<Object>();
		params_check_login.add(state);
		params_check_login.add(uid);
		boolean flag_zhuce = registerDao.updateState(params_check_login);
		// 注册成功处理
		if (flag_zhuce) {
			listUserAdmin(request, response);
		} else {
		}

	}

	private void queryMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("uid");
		List<Object> params_check_login = new ArrayList<Object>();
		params_check_login.add(type);
		Map<String, Object> map = registerDao.queryUsers(params_check_login);
		request.setAttribute("queryMsg", map);
		request.getRequestDispatcher("/content/ApplyMessage.jsp").forward(request, response);

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.sendRedirect(path + "/mainWeb/main.jsp");
		// String path = request.getContextPath();
		// String name = request.getParameter("name");
		// String pswd = request.getParameter("pswd");
		// System.out.println("-------name----"+name);
		// System.out.println("-------pswd----"+pswd);
		// List<Object> params = new ArrayList<Object>();
		// params.add(name);
		// params.add(pswd);
		// boolean flag = registerDao.Login(params);
		// if(flag){
		// response.sendRedirect(path+"/mainWeb/main.jsp");
		// }else{
		// request.setAttribute("message", "用户名或密码错误");
		// // request.getRequestDispatcher("/login.jsp").forward(request,
		// response);
		// }
	}

	private void updateName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String uname = request.getParameter("uname");
		String uid = request.getParameter("uid");
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		params.add(uid);
		boolean flag = registerDao.updateName(params);
		if (flag) {

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "更新成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端

		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "更新失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}

	}

	private void updatePhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String uphone = request.getParameter("uphone");
		String uid = request.getParameter("uid");
		List<Object> params = new ArrayList<Object>();
		params.add(uphone);
		params.add(uid);
		boolean flag = registerDao.updatePhone(params);
		if (flag) {

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "更新成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端

		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "更新失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}

	}

	private void deleteUserPc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String uid = request.getParameter("uid");
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		boolean flag = registerDao.deleteUser(params);
		if (flag) {
			System.out.println("成功了");
			response.sendRedirect(path + "/servlet/RegisterAction?action_flag=listUser&uid=" + uid);
		} else {
			System.out.println("失败了");
		}

	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void registerMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String upswd = request.getParameter("upswd");
		String uphone = request.getParameter("uphone");

		List<Object> params_check_login = new ArrayList<Object>();
		params_check_login.add(uname);
		params_check_login.add(upswd);

		boolean flag = registerDao.resgisterCheck(params_check_login);
		if (flag == true) {
			Map<String, Object> user_model = registerDao.queryOne(params_check_login);

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "此用户已经注册");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		} else {
			List<Object> params = new ArrayList<Object>();
			params.add(uname);
			params.add(uphone);
			params.add(upswd);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
			params.add(df.format(new Date()));
			JSONObject jsonmsg = new JSONObject();
			// 数据的注册
			boolean flag_zhuce = registerDao.resgisterPhone(params);

			// 注册成功处理
			if (flag_zhuce) {
				jsonmsg.put("repMsg", "注册成功");
				jsonmsg.put("repCode", "666");
				response.getWriter().print(jsonmsg);// 将路径返回给客户端
				System.out.println(jsonmsg);
			} else {
				jsonmsg.put("repMsg", "注册失败");
				jsonmsg.put("repCode", "111");
				response.getWriter().print(jsonmsg);// 将路径返回给客户端
				System.out.println(jsonmsg);
			}

			System.out.println(flag_zhuce);

		}

	}

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listUserAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = registerDao.listUserAdmin();
		request.setAttribute("listMessage", list);
		request.getRequestDispatcher("/content/adminmessage.jsp").forward(request, response);

	}

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("utype");
		List<Object> params_check_login = new ArrayList<Object>();
		params_check_login.add(type);
		List<Map<String, Object>> list = registerDao.listUser(params_check_login);
		request.setAttribute("listMessage", list);
		request.getRequestDispatcher("/content/usermessage.jsp").forward(request, response);

	}

	private void loginMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_phone = request.getParameter("uphone");
		String user_pswd = request.getParameter("pswd");

		List<Object> params_check_login = new ArrayList<Object>();
		params_check_login.add(user_phone);
		params_check_login.add(user_pswd);
		boolean flag = registerDao.Login(params_check_login);
		if (flag) {
			Map<String, Object> map = registerDao.queryOne(params_check_login);

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "登录成功");
			jsonmsg.put("repCode", "666");
			jsonmsg.put("data", map);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
			System.out.println(jsonmsg);

		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "用户名或密码不正确");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}
	}

	public void init() throws ServletException {
		registerDao = new RegisterDao();
	}

}
