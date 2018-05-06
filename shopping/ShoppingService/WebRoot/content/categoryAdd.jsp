<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'content1.jsp' starting page</title>
<link href="../css/content.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">

	<%
		String flag = request.getParameter("mid");
		out.print(flag);
	%>

 function dosubmit(){
   var th = document.formCourse;
   th.action="<%=path%>/servlet/ShopAction?action_flag=addCategory";
		th.submit();
	}
</script>


</head>

<body>



	<form name="formCourse" action="" method="post">

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="50"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
					</table></td>
			</tr>
			<tr>
				<td><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="9">&nbsp;</td>
							<td bgcolor="#f3ffe3"><table width="99%" border="0"
									align="center" cellpadding="0" cellspacing="1"
									bgcolor="#54B0E9" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<td width="25%" height="50" class="STYLE1"><div
												align="center" class="STYLE2 STYLE1">名称</div></td>
										<td width="75%" height="50" class="STYLE1"><div
												align="left" class="STYLE2 STYLE1">分类信息</div></td>


									</tr>
									<tr>
							
											<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center"
												class="STYLE2 STYLE1">分类名称 </div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left"
												class="STYLE2 STYLE1">
												<INPUT style="width:350px;height: 40px" class=text2 size=18
													name="categoryName" minLength="1">
											</div></td>
									</tr>
									<tr>
									<TR>
										<TD bgcolor="#FFFFFF" colspan="2" height="55" align="center"
											vAlign="middle"><a href="javascript:dosubmit();"><img
												src="images/ok_1.jpg" name="Image3" width="60" height="22"
												border="0"></a> <a href="javascript:history.back();"><img
												src="images/fh_1.jpg" name="Image4" width="60" height="22"
												border="0"></a></TD>



									</TR>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>

	</form>
</body>
</html>
