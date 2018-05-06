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

import com.pony.data.dao.ShopDao;

public class ShopAction extends HttpServlet {
	
	private ShopDao shopDao;
	
	public ShopAction() {
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
			addCourse(request, response);
		}else if (action_flag.equals("listMessage")) {
			listMessage(request, response);
		}else if (action_flag.equals("listMessagePerson")) {
			listMessagePerson(request, response);
		}else if (action_flag.equals("listMyMessage")) {
			listMyMessage(request, response);
		}else if (action_flag.equals("delete")) {
			delete(request, response);
		}else if (action_flag.equals("listSearchShop")) {
			listSearchShop(request, response);
		}else if (action_flag.equals("listMessagePc")) {
			listMessagePc(request, response);
		}else if (action_flag.equals("deleteShop")) {
			deleteShop(request, response);
		}else if (action_flag.equals("listReviewMessage")) {
			listReviewMessage(request, response);
		}else if (action_flag.equals("listReviewUser")) {
			listReviewUser(request, response);
		}else if (action_flag.equals("updateState")) {
			updateState(request, response);
		}else if (action_flag.equals("addCategory")) {
			addCategory(request, response);
		}else if (action_flag.equals("listCategoryPc")) {
			listCategoryPc(request, response);
		}else if (action_flag.equals("deleteCategory")) {
			deleteCategory(request, response);
		}else if (action_flag.equals("lisCategorytMessage")) {
			lisCategorytMessage(request, response);
		}else if (action_flag.equals("listMessageSearch")) {
			listMessageSearch(request, response);
		}else if (action_flag.equals("collectMsg")) {
			collectMsg(request, response);
		}else if (action_flag.equals("deleteCollect")) {
			deleteCollect(request, response);
		}else if (action_flag.equals("listMessageCollect")) {
			listMessageCollect(request, response);
		}
	}
	private void listMessageCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String userId = request.getParameter("UserId");
		List<Object> params = new ArrayList<Object>();
		params.add(userId+"");
		List<Map<String, Object>> list = shopDao.listMessageMsgCollect(params);
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	private void deleteCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String sId = request.getParameter("cShopId");
		String pUserId = request.getParameter("cUserId");
		
		System.out.println(sId);
		List<Object> params = new ArrayList<Object>();
		params.add(sId+"");
		params.add(pUserId+"");
		boolean flag = shopDao.deleteCollect(params);
		if (flag) {
			
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "收藏取消成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		} else {
			
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "收藏取消失败");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}
	}
	
	private void collectMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String fUserId = request.getParameter("cUserId");
		String fUserName = request.getParameter("cUserName");
		String fWeiBoId = request.getParameter("cShopId");
		
		System.out.println(fWeiBoId);
		List<Object> params = new ArrayList<Object>();
		params.add(fUserId+"");
		params.add(fUserName+"");
		params.add(fWeiBoId+"");
		
		boolean flag = shopDao.addCollect(params);
		if (flag) {
			
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "收藏成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
			
		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "收藏失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}
	}
	
	
	private void lisCategorytMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		List<Map<String, Object>> list = shopDao.listCateMesasgeMsg();
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	public void init() throws ServletException {
		
		shopDao = new ShopDao();
	}
	
	private void updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String sPayUsererId = request.getParameter("sPayUsererId");
		String sPayUserName = request.getParameter("sPayUserName");
		String sState = request.getParameter("sState");
		String sId = request.getParameter("sId");
		
		System.out.println(sId);
		List<Object> params = new ArrayList<Object>();
		params.add(sPayUsererId+"");
		params.add(sPayUserName+"");
		params.add(sState+"");
		params.add(sId+"");
		
		boolean flag = shopDao.updateState(params);
		if (flag) {
			
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "申请成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
			
		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "申请失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}
	}
	
	private void listReviewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String rShopId = request.getParameter("rShopId");
		List<Object> params = new ArrayList<Object>();
		params.add(rShopId+"");
		List<Map<String, Object>> list = shopDao.listReviewUser(params);
		
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	private void listReviewMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String rUserId = request.getParameter("rUserId");
		List<Object> params = new ArrayList<Object>();
		params.add(rUserId+"");
		List<Map<String, Object>> list = shopDao.listReviewMessageMsg(params);
		
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	private void deleteShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String sId = request.getParameter("sId");
		
		System.out.println(sId);
		List<Object> params = new ArrayList<Object>();
		params.add(sId+"");
		
		boolean flag = shopDao.deleteShop(params);
		if (flag) {
			
			listMessagePc(request, response);
			
		} else {
		}
	}
	
	
	
	private void listSearchShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String sName = request.getParameter("sName");
		List<Map<String, Object>> list = shopDao.listSearchShop(sName);
		
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String sImage = request.getParameter("sImage");
		String sId = request.getParameter("sId");
		
		System.out.println(sId);
		List<Object> params = new ArrayList<Object>();
		params.add(sImage+"");
		params.add(sId+"");
		
		boolean flag = shopDao.deleteImage(params);
		if (flag) {
			
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "删除成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
			
		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "删除失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}
	}
	
	
	
	private void listMyMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String userId = request.getParameter("userId");
		List<Object> params = new ArrayList<Object>();
		params.add(userId+"");
		List<Map<String, Object>> list = shopDao.listMyMessageMsg(params);
		
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	
	private void listMessagePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		List<Map<String, Object>> list = shopDao.listMessagePerson();
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	private void listMessagePc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		List<Map<String, Object>> list = shopDao.listMessageMsgPc();
		request.setAttribute("listMessage", list);
		request.getRequestDispatcher("/content/shopMessage.jsp").forward(request, response);

	}
	private void listMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		
		String userId = request.getParameter("userId");
		List<Map<String, Object>> list = shopDao.listMessageMsg(userId);

		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	private void listMessageSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		
		
		String sCategory = request.getParameter("sCategory");
		
		System.out.println(sCategory);
		List<Object> params = new ArrayList<Object>();
		params.add(sCategory+"");
		List<Map<String, Object>> list = shopDao.listMessageSearchMsg(params);

		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "请求成功");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// 将路径返回给客户端

	}
	
	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String sName = request.getParameter("sName");
		String sMoney = request.getParameter("sMoney");
		String sPhone = request.getParameter("sPhone");
		String sMessage = request.getParameter("sMessage");
		String userId = request.getParameter("userId");
		
		System.out.println(sName);
		List<Object> params = new ArrayList<Object>();
		params.add(sName+"");
		params.add(sMoney+"");
		params.add(sPhone+"");
		params.add(sMessage+"");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		params.add(df.format(new Date()));
		System.out.println(df.format(new Date()));
		params.add(userId+"");
		boolean flag = shopDao.addMessage(params);
		if (flag) {
			
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "申请成功");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
			
		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "申请失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// 将路径返回给客户端
		}
	}
	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		
		String categoryName = request.getParameter("categoryName");

		List<Object> params = new ArrayList<Object>();
		params.add(categoryName);
		
		
		boolean flag = shopDao.addCategory(params);

		if (flag) {
			listCategoryPc(request, response);

		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "提交失败");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
		}

	}	
	private void listCategoryPc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		List<Map<String, Object>> list = shopDao.listCateMesasgeMsg();
		request.setAttribute("listMessage", list);
		request.getRequestDispatcher("/content/categoryMessage.jsp").forward(request, response);

	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String cgId = request.getParameter("cgId");
		System.out.println(cgId);
		List<Object> params = new ArrayList<Object>();
		params.add(cgId+"");
		
		boolean flag = shopDao.deleteCategory(params);
		if (flag) {
			
			listCategoryPc(request, response);
			
		} else {
		}
	}
	
}
