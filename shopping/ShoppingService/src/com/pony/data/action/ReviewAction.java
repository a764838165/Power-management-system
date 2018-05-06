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

import com.pony.data.dao.ReviewDao;

public class ReviewAction extends HttpServlet {

	private ReviewDao reviewDao;

	public ReviewAction() {
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
		}else if (action_flag.equals("listNoticesMessage")) {
			listNoticesMessage(request, response);
		}else if (action_flag.equals("updateReview")) {
			updateReview(request, response);
		}
	}

	public void init() throws ServletException {

		reviewDao = new ReviewDao();
	}

	

	private void updateReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid = request.getParameter("rid");
		String replyContent = request.getParameter("replyContent");
		String rNoticeId = request.getParameter("rNoticeId");
		
		List<Object> params = new ArrayList<Object>();
		params.add(replyContent);
		params.add(rid);
		boolean flag = reviewDao.updateMessage(params);
		if(flag){
			List<Object> paramsReview = new ArrayList<Object>();
			paramsReview.add(rNoticeId);
			// 已经进行分页之后的数据集合
			List<Map<String, Object>> list = reviewDao.listReviewMessage(paramsReview);
			// studentDao.listMessageTeacher(list);
			request.setAttribute("listMessage", list);
			request.getRequestDispatcher("../reviewMessage.jsp").forward(request, response);
		}
		
		
		
	}
	
	
	private void listNoticesMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rNoticeId = request.getParameter("rNewsId");
		List<Object> params = new ArrayList<Object>();
		params.add(rNoticeId);
		
		List<Map<String, Object>> list = reviewDao.listNoticesMessage(params);
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端
		
	}
	
	
	private void listMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		
		String nid = request.getParameter("nid");
		
		System.out.println(nid);
		List<Object> params = new ArrayList<Object>();
		params.add(nid);
		// 已经进行分页之后的数据集合
		List<Map<String, Object>> list = reviewDao.listReviewMessage(params);
		// studentDao.listMessageTeacher(list);
		request.setAttribute("listMessage", list);
		request.getRequestDispatcher("../reviewMessage.jsp").forward(request, response);
		
	}
	
	private void addMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		
		
		String rUserId = request.getParameter("rUserId");
		String rUserName = request.getParameter("rUserName");
		String rShopId = request.getParameter("rShopId");
		String rReviewContent = request.getParameter("rReviewContent");

		List<Object> params = new ArrayList<Object>();
		params.add(rUserId);
		params.add(rUserName);
		params.add(rShopId);
		params.add(rReviewContent);
		params.add("");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		params.add(df.format(new Date()));
		
		
		boolean flag = reviewDao.addMessage(params);

		if (flag) {

			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "提交成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
//			response.sendRedirect(path + "/servlet/NoticeAction?action_flag=listMessage");

		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "提交失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
//			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}

	}

}
