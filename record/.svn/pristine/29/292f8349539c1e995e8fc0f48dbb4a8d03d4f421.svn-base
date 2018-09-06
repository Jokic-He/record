<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>部门添加</title>
<style>
.layui-form {
	height: 400px;
	left: 50%;
	top: 50%;
	margin-left: -168px;
	margin-top: -140px;
	position: fixed;
}
.layui-unselect dl { 
    max-height:240px; 
}


</style>
<script>
	layui.use([ 'form' ], function() {
		var form = layui.form, layer = layui.layer;

	});
</script>
</head>
<body >

<div style="position:absolute;z-index:-1;width:100%;height:100%;">
    	<img src="image/signback.jpg" width="100%" height="100%" />
    
	<form class="layui-form" action="">
		<div class="layui-form-item">
			<label class="layui-form-label" style="font-size:20px;font-weight: bold;">部门名</label>
			
			<div class="layui-input-block">
				<input type="text" name="name" required lay-verify="title"
					 autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="font-size:20px;font-weight: bold;">部门描述</label>
			<div class="layui-input-block">
				<input type="text" name="description" 
					 autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="font-size:20px;font-weight: bold;">归属部门</label>
			<div class="layui-input-block">
				<select id="rrr" name="parentid">
                    <option value="">请选择</option>
                    <option value="">无</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="*">添加</button>
				<a class="layui-btn layui-btn-warm" id="fanhui" href="${pageContext.request.contextPath}/toDepartment.do">返回</a>
			</div>

		</div>
	</form>
	</div>
</body>
<script type="text/javascript" charset="utf-8">
	layui.use([ 'form', 'layedit', 'layer','laydate', 'jquery' ],function() {
						var $ = layui.jquery;
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
						//自定义验证规则
						form.verify({
							title : [ /(.+){2,8}$/, '部门名为2-10位' ],
							content : function(value) {
								layedit.sync(editIndex);
							}
						});

						$(function(){
							aa();
						});
						function aa(){
							var select = $('#rrr');
							$.get('${pageContext.request.contextPath}/toGetDEx5.do',function(res){
								var j=$.parseJSON(res).obj;
								for ( var i in j) {
									select.append("<option value='"+j[i].id+"'>"+ j[i].name+ "</option>");
									form.render('select');
								}
							});
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

						form.on('submit(*)',function(data) {
							$.ajax({
									url : '${pageContext.request.contextPath}/toAddDeparment.do',
									data : $(data.form).serialize(),
									success : function(suc) {
										var s=$.parseJSON(suc);
										console.log(s.msg);
										if (s.success) {
											layer.msg('&nbsp&nbsp<span style="font-size:20px">'+s.msg+'</span>',{icon: 1,area: ['100px', '50px'],offset:['200px','400px'],anim: 5});
										
											setTimeout(function(){window.location.href = "${pageContext.request.contextPath}/toDepartment.do"},3000)
										} else {
											layer.msg('&nbsp&nbsp<span style="font-size:20px">'+s.msg+'</span>',{icon: 2,area: ['100px', '50px'],offset:['200px','400px'],anim: 5});
										}
									}
								});
						return false;

						});
					})
</script>
</html>