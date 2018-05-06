<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.pony.util.*"%>
<%
	String path = request.getContextPath();
	String proname = (String)request.getAttribute("proname");
	proname = (proname==null?"":proname);
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("listorder");
	DividePage pUtil = (DividePage)request.getAttribute("pUtil");
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
						<td width="9">&nbsp;</td>
						<td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#54B0E9"
								onmouseover="changeto()" onmouseout="changeback()">
								<tr>
									<td width="5%" height="40" class="STYLE1"><div align="center" class="STYLE2 STYLE1">编号</div></td>
									<td width="8%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户</div></td>
									<td width="15%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">预约民宿名称</div></td>
									<td width="10%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">房间类型</div></td>
									<td width="20%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">位置</div></td>
									<td width="10%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">价位</div></td>
									<td width="20%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">下单时间</div></td>
									<td width="10%" height="18" class="STYLE1"><div align="center" class="STYLE2 STYLE1">预订状态</div></td>
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
									<td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1"><%=map.get("ouser") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("ohousename") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("ohoursetype") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("ohourseaddress") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center"><%=map.get("ohourseprice") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><%=map.get("ousertime") %></div></td>
									<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
											<%   
									     	if(map.get("ostate").equals("0")){
											out.print("未支付");
									   		 %>
											<%
											}else if(map.get("ostate").equals("1")){
											out.print("已支付");
										
											%>

											<%
											}
										%>


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
