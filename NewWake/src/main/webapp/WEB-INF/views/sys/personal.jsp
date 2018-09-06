<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/WEB-INF/pub/inc.jsp"%>
<title>个人中心</title>

</head>
<body>

	<div class="mail">
		<form id="update" method="post">
			<div>


				请选择当前用户角色：<input id="cc" name="dept"> <a
					class="easyui-linkbutton" onclick="useRole()">确定</a>


			</div>
		</form>
		<form id="addRole" method="post">

			<div>添加角色：</div>
			<div>
				角色名:<input name="roleName" type="text"> 角色描述:<input
					name="description" type="text">
			</div>
			<!--  <button onclick="add()">提交</button>-->
			<a class="easyui-linkbutton" onclick="add()">提交</a>
		</form>
		<div>
			<form id="addPer" method="post">
				权限名：<input name="pname" type="text"> 权限:<input
					name="permission" type="text"> 所属角色:<input id="role1"
					name="role">
			</form>
			<a class="easyui-linkbutton" onclick="fuyu()">赋予权限</a>
		</div>
	</div>

</body>

<script type="text/javascript">
	$(function() {

		$('#cc').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
		$('#role1').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
	})

	function send() {
		$('#sendMail').form('submit', {
			onSubmit : function() {
				return $(this).form('enableValidation').form('validate');
			},
			url : '${pageContext.request.contextPath}/send.do',
			success : function(r) {
				var s = $.parseJSON(r);
				if (s.success) {
					showMsg('发送提示', s.msg);
				} else {
					showMsg('发送提示', '发送失败');
				}
			}
		});
		$('#cc').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
		$('#role1').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
	}

	function add() {

		$('#addRole').form('submit', {
			url : '${pageContext.request.contextPath}/addRole.do',
			success : function(r) {
				var s = $.parseJSON(r);
				if (s.success) {
					showMsg('提示', s.msg);
				} else {
					showMsg('提示', s.msg);
				}
			}
		})
		$('#cc').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
		$('#role1').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
	}

	function useRole() {
		var role = $('#cc').combobox('getValue');
		console.log(role);
		$.ajax({
			type : 'post',
			data : {
				'role' : role
			},
			url : '${pageContext.request.contextPath}/useRole.do',
			success : function(r) {
				if (r) {
					showMsg('提示', '更改成功');
				} else {
					showMsg('提示', '更改失败');
				}
			}
		});
		$('#cc').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
		$('#role1').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
	}

	function fuyu() {
		var role = $('#role1').combobox('getValue');

		$('#addPer').form('submit', {
			onSubmit : function() {
				role = role;
				return $(this).form('enableValidation').form('validate');
			},
			url : '${pageContext.request.contextPath}/addPer.do',
			success : function(r) {
				if (r) {
					showMsg('发送提示', 'ok');
				} else {
					showMsg('发送提示', 'no');
				}
			}
		});
		$('#cc').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
		$('#role1').combobox({
			url : '${pageContext.request.contextPath}/toGetRoles.do',
			valueField : 'valueField',
			textField : 'textField'
		});
	}
</script>
</html>