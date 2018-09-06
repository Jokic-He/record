<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>录音系统登陆</title>
<style>
.layui-form {
	height: 280px;
	left: 50%;
	top: 50%;
	margin-left: -168px;
	margin-top: -140px;
	position: fixed;
}

.back {
	background-color: #43CD80;
	width: 100%;
	height: 100%;
}

i.layui-anim {
	display: inline-block
}
</style>

</head>

<body>
	<div class="back">
		<form class="layui-form" name="loginForm">
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 20px;">
				<!--  <p style="font-size: 50px; color: #000000;">欢迎登录录音系统</p>-->
				<p style="font-size: 50px; color: #000000;">欢迎使用APS系统</p>
			</fieldset>

			<div class="layui-form-item">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-block">
					<input type="text" name="username" lay-verify="title"
						autocomplete="off" placeholder="请输入用户名" class="layui-input"
						style="width: 200px;">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="password" name="password" lay-verify="pass"
						placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
			</div>


			<div class="layui-form-item">
				<div class="layui-input-block">
					<!-- <a href="${pageContext.request.contextPath}/toSign.do"
						class="layui-btn layui-btn-warm">注册</a> -->
					<button class="layui-btn" lay-submit lay-filter="*" id="submit">登录</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>

			</div>

		</form>
	</div>
</body>
<script type="text/javascript" charset="utf-8">
layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;



	  //自定义验证规则
	  form.verify({
	    pass: [/(.+){3,18}$/, '密码必须6到12位']
	    ,content: function(value){
	      layedit.sync(editIndex);
	    }
	  });
	  
	  
	  form.on('submit(*)', function(data){
			  $.ajax({
				  url:'${pageContext.request.contextPath}/toLogin.do',
				  data:$(data.form).serialize(),
				//  beforeSend: function () {
				//        // 禁用按钮防止重复提交，发送前响应
				 //       $("#submit").attr({ disabled: "disabled" });
				 //       layer.msg('<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop" style="font-size: 30px;"/> <span style="font-size: 30px;">正在登陆</span>',{anim:1});
				//  },
				  async:false,
				  success:function(suc){
					  var s=$.parseJSON(suc);
					if(s.success){
						  layer.msg('<i class="layui-icon layui-icon-ok" style="font-size: 30px;"/><span style="font-size: 30px;">'+s.msg+'</span>');
					      setTimeout(function(){window.location.href = "${pageContext.request.contextPath}/toMain.do"},1500);
					  }else{
						  layer.msg('<i class="layui-icon layui-icon-close" style="font-size: 30px;"/><span style="font-size: 30px;">'+s.msg+'</span>',{time:1500});
					  }
				  }
				  });
			  return false;
			  
			});



	});
	

    

</script>

</html>