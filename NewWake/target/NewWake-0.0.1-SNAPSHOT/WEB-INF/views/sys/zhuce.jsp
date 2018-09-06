<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
<%@include file="/WEB-INF/pub/inc.jsp"%>
<title>叫醒系统注册</title>

</head>
<body>

	<div class="zhuceda">

		<form id="zhuce" method="post">
			<div class="zhuce">
				<label>用户名: </label> <input name="username"
					class="easyui-validatebox" data-options="required:true">
			</div>
			<div class="zhuce">
				<label>密码: </label> <input name="password" type="password"
					class="easyui-validatebox" data-options="required:true">
			</div>
			<div class="zhuce">
				<label>部门: </label> <input name="department"
					class="easyui-validatebox" data-options="required:false">
			</div>
			<div class="zhuce">
				<label>邮箱账号: </label> <input name="myEmailAccount"
					class="easyui-validatebox" data-options="required:false">
			</div>
			<div class="zhuce">
				<label>邮箱密码: </label> <input name="myEmailPassword"
					class="easyui-validatebox" data-options="required:false">
			</div>
			<div class="zhuce">
				<label>邮箱smpt服务器地址: </label> <input name="myEmailSMTPHost"
					class="easyui-validatebox" data-options="required:false">
			</div>
			<div class="zhuce">
				<label>权限: </label> <input name="role"
					class="easyui-validatebox" data-options="required:false">
			</div>

			<div class="regist-btn">
				<img src="${pageContext.request.contextPath}/images/sys/regist.jpg"
					onclick="zhuce()"> &nbsp;&nbsp; <a
					href="${pageContext.request.contextPath}/login.do"><img
					src="${pageContext.request.contextPath}/images/sys/login_cancle.jpg"
					style="-moz-border-radius: 10px; -webkit-border-radius: 10px; border-radius: 10px;"></a>
			</div>
		</form>

	</div>

	<script type="text/javascript">
		function zhuce() {
			$('#zhuce')
					.form(
							'submit',
							{
								onSubmit : function() {
									return $(this).form('enableValidation')
											.form('validate');
								},
								url : '${pageContext.request.contextPath}/zhuce.do',
								success : function(r) {
									var obj = $.parseJSON(r);
									if (obj.success) {
										window.location.href = "${pageContext.request.contextPath}/login.do";
										showMsg('注册提示', obj.msg);
									} else {
										showMsg('注册提示', obj.msg);
									}
								}
							});
		}
	</script>



</body>
<style>
.zhuceda {
	position: absolute;
	top: 300px;
	left: 500px;
}
</style>
</html>