<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="../css/main.css" rel="stylesheet" type="text/css" />
  </head>
  
<body style="background:url(../images/topbg.gif) repeat-x;">
    <div class="topleft">
    	<a href="main.html" target="_parent"><img src="../images/logo.png" title="系统首页" /></a>
    </div>

    <div class="topright">    
	    <ul>
		    <li><span><img src="../images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
		    <li><a href="../login.jsp" target="_parent">退出</a></li>
	    </ul>
	    <div class="user">
	    	<span>admin</span>
	    	<i>消息</i>
	    	<b>5</b>
	    </div>   
    </div>
</body>
</html>
