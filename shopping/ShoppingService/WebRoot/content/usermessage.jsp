<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.pony.util.*" %>
<%
	String path = request.getContextPath();
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("listMessage");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'content1.jsp' starting page</title>
<link href="../css/content.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="50"><table width="100%" border="0" cellspacing="0" cellpadding="0">
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="9" >&nbsp;</td>
						<td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#54B0E9"
								onmouseover="changeto()" onmouseout="changeback()">
								<tr>
									<td width="5%" height="40" class="STYLE1"><div align="center" class="STYLE2 STYLE1">编号</div></td>
									<td width="15%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户名称</div></td>
										<td width="20%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户密码</div></td>
									<td width="17%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">手机号码</div></td>
								<td width="17%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">注册时间</div></td>
						
									<td width="8%" height="18" class="STYLE1"><div align="center" class="STYLE2">删除</div></td>
								</tr>
								
								
								<% 
								int houseNumber = 0;
													 if(!list.isEmpty()){
													/*  for(Map<String,Object> map:list){ */
													 for(int i=0;i<list.size();i++){
													 houseNumber = i+1;
													 Map<String,Object> map = list.get(i);
													%>
								<tr>
								
										<td height="38" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1"><%=houseNumber%></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("uname") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("upswd") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("uphone") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("utime") %></div></td>
									
									<td height="18" bgcolor="#FFFFFF"><div align="center">
											<span class="STYLE2"> </span><span class="STYLE1">[</span><a href="<%=path%>/servlet/RegisterAction?action_flag=deleteUser&uid=<%=map.get("uid") %>">删除</a><span
												class="STYLE1">]</span>
										</div></td>
								</tr>

	<% 
													}
													}
													%>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
