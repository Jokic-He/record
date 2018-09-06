<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>个人界面</title>
<style type="text/css">
.form {
	margin-top: 100px;
}
</style>
</head>

<body>
	</br>
	</br>
	</br>
	</br>
	<form class="layui-form" action="" lay-filter="example">

		<input name="id" hidden="true" value="${id}" id="ids">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input name="username" autocomplete="off" lay-verify="title"
					class="layui-input" placeholder="请输入新的用户名" type="text">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input name="password" autocomplete="off" lay-verify="pass"
					class="layui-input" type="password">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">用户部门</label>
			<div class="layui-input-block">
				<select id="ddd" name="department">
					<option value="">请选择</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-block">
				<select id="rrr" name="role">
					<option value="">请选择</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-warm" lay-submit lay-filter="*">修改</button>
				<button type="reset" class="layui-btn layui-btn-primary" id="cz">重置</button>
			</div>

		</div>



	</form>

</body>
<script>
	layui
			.use(
					[ 'form', 'layedit', 'layer', 'laydate', 'jquery' ],
					function() {
						var $ = layui.jquery;
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

						//自定义验证规则
						form.verify({
							pass : [ /(.+){6,18}$/, '密码必须6到12位' ],
							title : [ /(.+){2,10}$/, '用户名为2-10位' ],
							content : function(value) {
								layedit.sync(editIndex);
							}
						});

						$(function() {
							var ids = document.getElementById("ids").value;
							console.log(ids);
							aa();
						});
						function aa() {
							var select = $('#ddd');
							var select2 = $('#rrr');
							$
									.get(
											'${pageContext.request.contextPath}/toGetD.do',
											function(res) {
												var j = $.parseJSON(res).obj;
												for ( var i in j) {
													select
															.append("<option value='"+j[i].name+"'>"
																	+ j[i].name
																	+ "</option>");
												}
											});
							$
									.get(
											'${pageContext.request.contextPath}/toGetR.do',
											function(res) {
												var x = $.parseJSON(res).obj;
												for ( var i in x) {
													select2
															.append("<option value='"+x[i].id+"'>"
																	+ x[i].roleName
																	+ "</option>");
												}
												form.render('select');
											});
							form.render('select');

							/* var select = document.getElementById("department");
							console.log(1);
							$.get('${pageContext.request.contextPath}/toGetD.do',function(suc){
							console.log(suc);
							var s = JSON.parse(suc);
							console.log(2);
							for ( var i in s) {
								
							}
							
							}); */
						}

						form
								.on(
										'submit(*)',
										function(data) {
											$
													.ajax({
														url : '${pageContext.request.contextPath}/modifyUser.do',
														data : $(data.form)
																.serialize(),
														success : function(suc) {
															var s = $
																	.parseJSON(suc);
															$('#cz').click();
															layer.msg(s);
														}
													});
											return false;

										});
					})
</script>
</html>