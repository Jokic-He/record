<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>其他设置页面</title>
<style>
 .luyin {
    position: absolute;
    margin-left: 30%;
    margin-top: 10%;
 }

</style>

</head>

<body>
<div class="luyin">
	<span style="font-size: 30px;">录音读取路径:</span>
	</br></br></br>
	<input type="text" name="url" id="url1" lay-verify="title" autocomplete="off"
			placeholder="请输入新路径（X:/xx/xx...）" class="layui-input"
			style="width: 400px;">
    </br></br></br>
	<button class="layui-btn layui-btn-lg layui-btn-warm layui-btn-radius"
		onclick="submit()">确认修改</button>
		&nbsp	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	
		<a href="${pageContext.request.contextPath}/toSetting.do"
	                    class="layui-btn layui-btn-normal layui-btn-radius"><i class="layui-icon layui-icon-return"></i>返回</a> 
</div>
</body>
<script type="text/javascript" charset="utf-8">
	layui.use('form', function() {
		var form = layui.form;
		//自定义验证规则
		form.verify({
			title : [ /(.+){4,40}$/, '新地址不能为根目录' ],
			content : function(value) {
				layedit.sync(editIndex);
			}
		});

		
	})
	function submit() {
			var url = document.getElementById("url1").value;
			$.ajax({
				url : '${pageContext.request.contextPath}/record/toUpdateUrl.do?url='
						+ url,
				success : function(suc) {
					var s = $.parseJSON(suc);
					if (s.success) {
						layui.layer.msg('&nbsp&nbsp<span style="font-size:20px">'+s.msg+'</span>',{icon: 1,area: ['100px', '50px'],offset:['200px','400px'],anim: 5});
					
						setTimeout(function(){window.location.href = "${pageContext.request.contextPath}/toSetting.do"},3000)
					} else {
						layui.layer.msg('&nbsp&nbsp<span style="font-size:20px">'+s.msg+'</span>',{icon: 2,area: ['100px', '50px'],offset:['200px','400px'],anim: 5});
					}
				}
			});
		}
</script>

</html>