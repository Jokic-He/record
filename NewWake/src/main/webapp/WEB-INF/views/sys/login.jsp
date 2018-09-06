<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
<%@include file="/WEB-INF/pub/inc.jsp"%>
<title>叫醒系统登陆</title>
</head>
<body >
	<div class="index-login-box">
		<form id="index_login_form" method="post">
			<div class="login-div">
				<label>用户名: </label> <input name="username"
					class="easyui-validatebox" data-options="required:true">
			</div>
			<div class="login-div">
				<label>密 码: </label> <input id="login_pass" type="password"
					name="password" class="easyui-validatebox"
					data-options="required:true">
			</div>
			<div class="login-btn">
				<img
					src="${pageContext.request.contextPath}/images/sys/login_btn.png"
					onclick="login();"> &nbsp;&nbsp; <a
					href="${pageContext.request.contextPath}/toZhuce.do"><img
					src="${pageContext.request.contextPath}/images/sys/regist.jpg"></a>
				&nbsp;&nbsp; <img
					src="${pageContext.request.contextPath}/images/sys/login_cancle.jpg"
					style="-moz-border-radius: 10px; -webkit-border-radius: 10px; border-radius: 10px;"
					onclick="cancel();">
			</div>
		</form>
	</div>

	<div class="login_copyright">
		<span>Copyright © 2017 阿何 - Powered By <a
			href="http://sunwin.cn.com/" target="_blank">宁波小安信息科技有限公司</a> V1.0
		</span>
	</div>

	<script type="text/javascript" charset="utf-8">
		//登录
		function login() {
			$('#index_login_form')
					.form(
							'submit',
							{
								onSubmit : function() {
									return $(this).form('enableValidation')
											.form('validate');
								},
								url : '${pageContext.request.contextPath}/toLogin.do',
								success : function(r) {
									var obj = $.parseJSON(r);
									if (obj.success) {
										window.location.href = "${pageContext.request.contextPath}/toWake.do";
										showMsg('登录提示', obj.msg);
									} else {
										showMsg('登录提示', obj.msg);
										changeCode();
									}
								}
							});
		}

		//回车时，默认是登陆
		$("body").keydown(function(e) {
			e = e||event; 
			if (e.keyCode == "13") {//keyCode=13是回车键
                console.log(e.keyCode);
				login();

			}
			;

		});
	</script>
</body>
</html>