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

import com.pony.data.dao.MessageeDao;

public class MessageAction extends HttpServlet {

	private MessageeDao messageeDao;

	public MessageAction() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("addMessage")) {
			addMessage(request, response);
		} else if (action_flag.equals("listMessage")) {
			listMessage(request, response);
		}else if (action_flag.equals("listMessagePhone")) {
			listMessagePhone(request, response);
		}else if (action_flag.equals("updataMessage")) {
			String mid = request.getParameter("mid");
			updataMessage(request, response,mid);
		}else if (action_flag.equals("deleteMessage")) {
			deleteCMessage(request, response);
		}
		
		//
		// else if (action_flag.equals("deleteCourse")) {
		// deleteCourse(request, response);
		// } else if (action_flag.equals("listVideo")) {
		// listVideo(request, response);
		// } else if (action_flag.equals("listVideoPhone")) {
		// listVideoPhone(request, response);
		// }
	}
	
	private void deleteCMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String mid = request.getParameter("mid");
		List<Object> params = new ArrayList<Object>();
		params.add(mid);
		boolean flag = messageeDao.deleteMessage(params);

		if (flag) {
			response.sendRedirect(path + "/servlet/MessageAction?action_flag=listMessage");

		}

	}
	
	
	
	private void updataMessage(HttpServletRequest request, HttpServletResponse response,String mid) throws ServletException, IOException {
		String path = request.getContextPath();

		// mMessage,mUid,mUserName,mCreateTim
		String repId = request.getParameter("mid");
		String repContent = request.getParameter("repContent");
		
		System.out.println(repId);
		System.out.println(repContent);
		

		List<Object> params = new ArrayList<Object>();
		params.add(repContent);
		params.add(repId);
		boolean flag = messageeDao.updataMessage(params);
		if (flag) {
			System.out.println("flag:ok");
			response.sendRedirect(path + "/servlet/MessageAction?action_flag=listMessage");
		} else {
			System.out.println("flag:no");
		}
	}
	
	
	
	private void listMessagePhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getContextPath();
		String cid = request.getParameter("uid");
		List<Object> params = new ArrayList<Object>();
		params.add(cid);
		List<Map<String, Object>> list = messageeDao.listMessageUser(params);

		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端
	}
	
	private void listMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 已经进行分页之后的数据集合
		List<Map<String, Object>> list = messageeDao.listMessage();
		request.setAttribute("listMessage", list);
		request.getRequestDispatcher("/content/messageMessage.jsp").forward(request, response);

	}
	

	public void init() throws ServletException {
		messageeDao = new MessageeDao();
	}

	private void addMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();

		// mMessage,mUid,mUserName,mCreateTim
		String mMessage = request.getParameter("mMessage");
		String mUid = request.getParameter("mUid");
		String mUserName = request.getParameter("mUserName");

		List<Object> params = new ArrayList<Object>();
		params.add(mMessage);
		params.add(mUid);
		params.add(mUserName);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		params.add(df.format(new Date()));
		boolean flag = messageeDao.addMessage(params);
		if (flag) {

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "添加成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
			System.out.println("flag:ok");
			// response.sendRedirect(path +
			// "/servlet/CourseAction?action_flag=courseListMessage");
		} else {

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "添加失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端

			System.out.println("flag:no");
		}
	}

}
