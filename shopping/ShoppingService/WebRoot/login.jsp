<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<% String errorinfo = (String)request.getAttribute("message");%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script language="JavaScript" src="js/yunduo.js"></script>


<script type="text/javascript">



 function login(){
   var th = document.formLogin;
   if(th.name.value==""){
      alert("用户名不能为空！！");
      th.username.focus();
      return ;
   }
   if(th.pswd.value==""){
      alert("密码不能为空！！");
      th.pswd.focus();
      return ;
   }
   
  
   th.action="<%=path%>/servlet/RegisterAction?action_flag=loginPc";
			th.submit();

	}
</script>

</head>

<body
	style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">




   
	<FORM name="formLogin" action="" method="post">
		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>
		<div class="logintop">
			<span>欢迎登录信息管理中心</span>
			<ul>
				<li><a href="#">帮助</a></li>
				<li><a href="#">关于</a></li>
			</ul>
		</div>
		<div class="loginbody">
			<span class="systemlogo"></span>
			<div class="loginbox">
				<ul>
					<li><input name="name" type="text" class="loginuser" value="请输入用户名" onclick="JavaScript:this.value=''" /></li>
					<li><input name="pswd" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''" /></li>
					<li><input name="" type="submit" class="loginbtn" value="登录" onclick="javascript:login();" /> <label> </label></li>
				</ul>
			</div>
		</div>
		<div class="loginbm">
			版权所有 2015 <a href="#">www.esqabc.com</a>仅供学习交流，勿用于任何商业用途
		</div>
	</FORM>
</body>
</html>
