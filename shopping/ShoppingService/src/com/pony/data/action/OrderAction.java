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

import com.pony.data.dao.OrderDao;
import com.pony.util.DividePage;

public class OrderAction extends HttpServlet {

	private OrderDao orderDao;

	public OrderAction() {
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
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("addOrder")) {
			addOrderMessage(request, response);
		} else if (action_flag.equals("updatePayState")) {
			updateState(request, response);
		} else if (action_flag.equals("orderList")) {
			listOrderMessage(request, response);
		} else if (action_flag.equals("houseListPhone")) {
			listOrderPhoneMessage(request, response);
		} else if (action_flag.equals("orderListMessage")) {
			listOrderMsgMessage(request, response);
		} else if (action_flag.equals("orderListMessagePhone")) {
			listOrderMsgMessagePhone(request, response);
		} else if (action_flag.equals("deleteOrderPc")) {
			deleteOrderPc(request, response);
		} else if (action_flag.equals("deleteOrderPhone")) {
			deleteOrderPhone(request, response);
		}

	}
	
	
	/**
	 * ���״̬
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addState(HttpServletRequest request, HttpServletResponse response,	String hid,	String oid,	String uid) throws ServletException, IOException {
	
		List<Object> params= new ArrayList<Object>();
		params.add(Integer.valueOf(hid));
		params.add(Integer.valueOf(oid));
		params.add(1);
		params.add(Integer.valueOf(uid));
		boolean flag = orderDao.addState(params);
		if (flag) {
			System.out.println("״̬�ɹ���");
		} else {
			System.out.println("״̬ʧ����");
		}

	}

	/**
	 * ����֧��״̬
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String oid = request.getParameter("oid");
		String hid = request.getParameter("hid");
		String uid = request.getParameter("uid");
		String ostate = request.getParameter("ostate");
		List<Object> params = new ArrayList<Object>();
		params.add(ostate);
		params.add(oid);
		boolean flag = orderDao.updateState(params);
		if (flag) {
			
			/**
			 * �����û��ͷ�Դ�����ݹ�ϵ
			 */
			addState(request, response,hid,oid,uid);
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "Ԥ���ɹ�");
			jsonmsg.put("repCode", "666");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���

		} else {
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "Ԥ��ʧ��");
			jsonmsg.put("repCode", "111");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���
		}

	}

	/**
	 * ��Դ�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addOrderMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getContextPath();
		String ouser = request.getParameter("ouser");
		String ohousename = request.getParameter("ohousename");
		String ohoursetype = request.getParameter("ohoursetype");
		String ohourseaddress = request.getParameter("ohourseaddress");
		String ohourseprice = request.getParameter("ohourseprice");
		String ousertime = request.getParameter("ousertime");
		String uid = request.getParameter("uid");
		String ostate = request.getParameter("ostate");
		String hid = request.getParameter("hid");

		List<Object> params = new ArrayList<Object>();
		params.add(ouser);
		params.add(ohousename);
		params.add(ohoursetype);
		params.add(ohourseaddress);
		params.add(ohourseprice);
		params.add(ousertime);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// �������ڸ�ʽ
		params.add(df.format(new Date()));
		params.add(uid);
		params.add(ostate);
		params.add(hid);

		boolean flag = orderDao.addOrder(params);
		JSONObject jsonmsg = new JSONObject();
		if (flag) {
			List<Object> paramsOrder = new ArrayList<Object>();
			paramsOrder.add(uid);
			paramsOrder.add(hid);
			Map<String, Object> ordermsg = orderDao.queryOne(paramsOrder);

			jsonmsg.put("repMsg", "������ӳɹ�");
			jsonmsg.put("repCode", "666");
			jsonmsg.put("data",ordermsg);
			response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���
			System.out.println(jsonmsg);
		} else {
			jsonmsg.put("repMsg", "�������ʧ��");
			jsonmsg.put("repCode", "111");
			response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���
			System.out.println(jsonmsg);
		}

	}

	private void listOrderMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String proname = request.getParameter("proname");
		int recordCount = orderDao.getItemCount();// ��ü�¼��������
		int currentPage = 1;// ��ǰҳ�ǵ�һҳ
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		DividePage pUtil = new DividePage(15, recordCount, currentPage);
		int start = pUtil.getFromIndex();
		int end = pUtil.getToIndex();
		// �Ѿ����з�ҳ֮������ݼ���
		List<Map<String, Object>> list = orderDao.listOrder(proname, start, end);
		request.setAttribute("pUtil", pUtil);
		request.setAttribute("listorder", list);
		request.setAttribute("proname", proname);
		request.getRequestDispatcher("/content/contentorder.jsp").forward(request, response);
	}

	/**
	 * �û�����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void listOrderMsgMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		System.out.println("uid:" + uid);
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		// �Ѿ����з�ҳ֮������ݼ���
		List<Map<String, Object>> list = orderDao.listOrderMessage(params);
		request.setAttribute("listorderMesage", list);
		request.getRequestDispatcher("/content/contentordermessage.jsp").forward(request, response);
	}

	private void listOrderMsgMessagePhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String ostate = request.getParameter("ostate");
		System.out.println("uid:" + uid);
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		params.add(ostate);
		// �Ѿ����з�ҳ֮������ݼ���
		List<Map<String, Object>> list = orderDao.listOrderMessagePhone(params);
		// ����json�ַ���
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "����ɹ�");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���
	}

	private void deleteOrderPc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String uid = request.getParameter("uid");
		String oid = request.getParameter("oid");
		List<Object> params = new ArrayList<Object>();
		params.add(oid);
		boolean flag = orderDao.deleteOrder(params);

		if (flag) {
			boolean flagState = orderDao.deleteState(params);
			if(flagState){
				System.out.println("�ɹ���");
				response.sendRedirect(path + "/servlet/OrderAction?action_flag=orderListMessage&uid=" + uid);
			}else{
				System.out.println("flagStateʧ����");
			}
			
		} else {
			System.out.println("flagʧ����");
		}

	}

	private void deleteOrderPhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getContextPath();
		String uid = request.getParameter("uid");
		String oid = request.getParameter("oid");
		List<Object> params = new ArrayList<Object>();
		params.add(oid);
		boolean flag = orderDao.deleteOrder(params);

		if (flag) {
			boolean flagState = orderDao.deleteState(params);
			
			if(flagState){
				// ����json�ַ���
				JSONObject jsonmsg = new JSONObject();
				jsonmsg.put("repMsg", "ɾ���ɹ�");
				jsonmsg.put("repCode", "666");
				jsonmsg.put("data", "");
				System.out.println(jsonmsg);
				response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���
			}
			
	

		} else {
			// ����json�ַ���
			JSONObject jsonmsg = new JSONObject();
			jsonmsg.put("repMsg", "ɾ��ʧ�� ");
			jsonmsg.put("repCode", "666");
			jsonmsg.put("data", "");
			System.out.println(jsonmsg);
			response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���
		}

	}

	private void listOrderPhoneMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String proname = request.getParameter("proname");
		int recordCount = orderDao.getItemCount();// ��ü�¼��������
		int currentPage = 1;// ��ǰҳ�ǵ�һҳ
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		DividePage pUtil = new DividePage(15, recordCount, currentPage);
		int start = pUtil.getFromIndex();
		int end = pUtil.getToIndex();
		// �Ѿ����з�ҳ֮������ݼ���
		List<Map<String, Object>> list = orderDao.listOrder(proname, start, end);
		// ����json�ַ���
		JSONObject jsonmsg = new JSONObject();
		jsonmsg.put("repMsg", "����ɹ�");
		jsonmsg.put("repCode", "666");
		jsonmsg.put("data", list);
		System.out.println(jsonmsg);
		response.getWriter().print(jsonmsg);// ��·�����ظ��ͻ���

	}

	public void init() throws ServletException {
		orderDao = new OrderDao();
	}

}