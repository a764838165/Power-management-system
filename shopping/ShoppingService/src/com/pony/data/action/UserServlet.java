package com.pony.data.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pony.data.dao.ImageUploadDao;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304 * 2L;// 4*2MB
	private String filedir = null;

	private ImageUploadDao imageUploadDao;

	public UserServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String uname = request.getParameter("uname");
		String upswd = request.getParameter("upswd");
		String uphone = request.getParameter("uphone");
		String utype = request.getParameter("utype");
		String uimage = request.getParameter("uimage");
		
		System.out.println("title:"+uphone);
		System.out.println("content:"+utype);
		
		String imagePath = null;
		if(uname==null){
			try {
				List<FileItem> items = this.upload.parseRequest(request);
				if (items != null && !items.isEmpty()) {
					for (FileItem fileItem : items) {
						String filename = fileItem.getName();
						String filepath = filedir + File.separator + filename;
						System.out.println("文件保存路径为:" + filepath);
						File file = new File(filepath);
						InputStream inputSteam = fileItem.getInputStream();
						BufferedInputStream fis = new BufferedInputStream(inputSteam);
						FileOutputStream fos = new FileOutputStream(file);
						int f;
						while ((f = fis.read()) != -1) {
							fos.write(f);
						}
						fos.flush();
						fos.close();
						fis.close();
						inputSteam.close();
						System.out.println("文件：" + filename + "上传成功!");
						imagePath = filename;

					}
				}
				
//				out.write("上传文件成功!");
			} catch (FileUploadException e) {
				e.printStackTrace();
				out.write("上传文件失败:" + e.getMessage());
			}
		}else{

			List<Object> params = new ArrayList<Object>();
			params.add(uname+"");
			params.add(uphone+"");
			params.add(upswd+"");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
			params.add(df.format(new Date()));
			params.add(utype);
			params.add("1");
			params.add(uimage);
			
			boolean flag = imageUploadDao.resgisterUser(params);
			System.out.println(flag+"");
			if (flag) {
				JSONObject jsonmsg = new JSONObject();
				jsonmsg.put("repMsg", "注册成功");
				jsonmsg.put("repCode", "666");
				response.getWriter().print(jsonmsg);// 将路径返回给客户端
			} else {
				JSONObject jsonmsg = new JSONObject();
				jsonmsg.put("repMsg", "注册失败");
				jsonmsg.put("repCode", "666");
				response.getWriter().print(jsonmsg);// 将路径返回给客户端
			}
			
		
		}
		
	

	}

	public void init(ServletConfig config) throws ServletException {

		FileItemFactory factory = new DiskFileItemFactory();// Create a factory
		this.upload = new ServletFileUpload(factory);// Create a new file upload
		this.upload.setSizeMax(this.MAXSize);// Set overall request size
		filedir = config.getServletContext().getRealPath("upload");
		System.out.println("filedir=" + filedir);
		imageUploadDao = new ImageUploadDao();

	}

}
