<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/WEB-INF/pub/inc.jsp"%>
<title>测试角色和权限</title>
</head>
<body>

<shiro:hasPermission name="admin:update">
<div>
     这是管理员角色能够看到的界面
</div>
</shiro:hasPermission>


<shiro:hasPermission name="zuoxi:update">
<div>
     这是坐席角色能够看到的界面
</div>
</shiro:hasPermission>


<shiro:hasPermission name="banzhang:update">
<div>
     这是班长角色能够看到的界面
</div>
</shiro:hasPermission>

</body>
</html>