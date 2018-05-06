<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("listCourse");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'content1.jsp' starting page</title>
<link href="../css/content.css" rel="stylesheet" type="text/css" />



<script type="text/javascript">



   
   
   
 function dosubmit(){
 
 
    var th = document.form1;
   if(th.courseId.value==""){
      alert("所属课程不能为空！！");
      th.username.focus();
      return ;
   }
   
   
   th.action="<%=path%>/servlet/HouseAction?action_flag=addHouse";
		th.submit();
	}
</script>


</head>

<body>

	<form name="form1" action="" method="post" enctype="multipart/form-data">

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
										<td width="75%" height="50" class="STYLE1"><div align="left" class="STYLE2 STYLE1">添加信息</div></td>


									</tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">视频标题</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<INPUT style="width:350px;height: 40px" class=text2 size=18 name="videoName" minLength="1">
											</div></td>
									</tr>

									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">所属课程</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<select class="ui-select" style="width:350px;height: 40px" name="courseId" id="balanceWay" onmouseover="">
													<option value="" a>请选择课程</option>

													<%
														if (!list.isEmpty()) {
															/*  for(Map<String,Object> map:list){ */
															for (int i = 0; i < list.size(); i++) {
																Map<String, Object> map = list.get(i);
													%>
													<option value="<%=map.get("cid")%>"><%=map.get("cName")%></option>

													<%
														}
														}
													%>

												</select>
											</div></td>

									</tr>
									<tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">视频简介</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<INPUT style="width:350px;height: 40px" class=text2 size=18 name="videoContent" minLength="1">
											</div></td>
									</tr>
									<tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">视频时长</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<INPUT style="width:350px;height: 40px" class=text2 size=18 name="videoTime" minLength="1">
											</div></td>
									</tr>
									<tr>
										<td height="45" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">视频文件</div></td>
										<td height="45" bgcolor="#FFFFFF"><div align="left" class="STYLE2 STYLE1">
												<input name="gimage" type="file" class="text2" size="60">
											</div></td>
									</tr>

									<TR>
										<TD bgcolor="#FFFFFF" colspan="2" height="55" align="center" vAlign="middle"><a href="javascript:dosubmit();"><img
												src="<%=path%>/content/images/ok_1.jpg" name="Image3" width="60" height="22" border="0"></a> <a href="javascript:history.back();"><img
												src="<%=path%>/content/images/fh_1.jpg" name="Image4" width="60" height="22" border="0"></a></TD>



									</TR>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>

	</form>
</body>
</html>
