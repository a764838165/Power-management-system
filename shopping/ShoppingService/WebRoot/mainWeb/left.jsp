<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'left.jsp' starting page</title>
<script language="JavaScript" src="../js/jquery.js"></script>
<link href="../css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(function() {
		//导航颜色切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active");
			$(this).addClass("active");
		});
		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
		//------------------
	});
</script>
</head>

<body style="background:#f0f9fd;">
	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="../images/leftico01.png" /></span>管理信息
			</div>
			<ul class="menuson">
				<!-- 在li标签里面添加（class="active"）会变为选中 -->
				<li><cite></cite><a href="<%=path%>/servlet/RegisterAction?action_flag=listUserAdmin" target="rightFrame">注册验证</a><i></i></li>
				<li><cite></cite><a href="<%=path%>/servlet/RegisterAction?action_flag=listUser&utype=2" target="rightFrame">注册用户</a><i></i></li>
				<li><cite></cite><a href="<%=path%>/servlet/ShopAction?action_flag=listMessagePc&pageNum=1" target="rightFrame">商品信息</a><i></i></li>
				<li><cite></cite><a href="<%=path%>/content/categoryAdd.jsp" target="rightFrame">添加分类 </a><i></i></li>
				<li><cite></cite><a href="<%=path%>/servlet/ShopAction?action_flag=listCategoryPc" target="rightFrame">分类列表</a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>
