<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.pony.util.*"%>
<%
	String path = request.getContextPath();
	Map<String, Object> map = (Map<String, Object>)request.getAttribute("queryMsg");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'content1.jsp' starting page</title>
<link href="../css/content.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">
		

 function dosubmit(){
   var th = document.formCourse;
   th.action="<%=path%>/servlet/RegisterAction?action_flag=updateState&uid=<%=map.get("uid")%>&state=2";
		th.submit();
	}
	
	 function doNosubmit(){
   var th = document.formCourse;
   th.action="<%=path%>/servlet/RegisterAction?action_flag=updateState&uid=<%=map.get("uid")%>&state=3";
		th.submit();
	}
</script>


</head>

<body>



	<form name="formCourse" action="" method="post">

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
										<td width="25%" height="50" class="STYLE1"><div align="center" class="STYLE2 STYLE1">名称</div></td>
										<td width="75%" height="50" class="STYLE1"><div align="left" class="STYLE2 STYLE1">信息</div></td>


									</tr>
									<tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">用户名称</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="c" class="STYLE2 STYLE1">
												<%=map.get("uname")%>
											</div></td>
									</tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">登录密码</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<%=map.get("upswd")%>
											</div></td>
									</tr>

									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">手机号码</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<%=map.get("uphone")%>
											</div></td>
									</tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">提交时间</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<%=map.get("utime")%>
											</div></td>
									</tr>

									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">证件照片</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">

												<%
													String imageUrl = (String)map.get("uimage");

													for (int i = 0; i < imageUrl.split(",").length; i++) {
													
													%>
													<img height="200" width="200" src="http://192.168.1.168:1010/ShoppingService/upload/<%=imageUrl.split(",")[i]%>"/>
													<%
													}
												%>

												
											</div></td>
									</tr>
									<tr>
									<TR>
										<TD bgcolor="#FFFFFF" colspan="2" height="55" align="center" vAlign="middle"><a href="javascript:dosubmit();">审核通过</a> <a
											href="javascript:doNosubmit();">不予通过</a></TD>



									</TR>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>

	</form>
</body>
</html>
