<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.pony.util.*"%>
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
					<tr>
						<td width="15" height="30"></td>
						<td width="281"><table border="0" align="left" cellpadding="0" cellspacing="0">
								<tr>
									<td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<a href="<%=path%>/content/houseadd.jsp"><img src="<%=path%>/content/images/tj_1.jpg" name="Image3" width="60" height="22" border="0"> </a>
											</tr>
										</table></td>

								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="9">&nbsp;</td>
						<td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#54B0E9"
								onmouseover="changeto()" onmouseout="changeback()">
								<tr>
									<td width="10%" height="38" class="STYLE1"><div align="center" class="STYLE2 STYLE1">编号</div></td>
									<td width="10%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">留言用户</div></td>
									<td width="30%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">留言内容</div></td>
									<td width="30%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">回复内容</div></td>
									<td width="10%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">回复</div></td>
									<td width="10%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">删除</div></td>

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
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("mUserName") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("mMessage") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
									
									<%=map.get("mReMessage") %>
									
									
									</div></td>
										<td height="18" bgcolor="#FFFFFF"><div align="center">
											<img src="<%=path%>/content/images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="<%=path%>/content/repAdd.jsp?mid=<%=map.get("mid") %>">回复</a><span class="STYLE1">]</span>
										</div></td>
										<td height="18" bgcolor="#FFFFFF"><div align="center">
											<img src="<%=path%>/content/images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="<%=path%>/servlet/MessageAction?action_flag=deleteMessage&mid=<%=map.get("mid") %>">删除</a><span class="STYLE1">]</span>
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
