<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>系统配置</title>
</head>
<body >
</br></br></br></br></br></br>
<div class="layui-row layui-col-space10 panel_box">
</br></br>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="${pageContext.request.contextPath}/toUser.do"  target="_self" >
				<div class="panel_icon layui-bg-orange">
					<i class="layui-anim layui-anim-scale layui-icon layui-icon-user"></i>
				</div>
				<div class="panel_word">
					<span>用户管理</span>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="${pageContext.request.contextPath}/toDepartment.do"  target="_self">
				<div class="panel_icon layui-bg-blue">
					<i class="layui-anim layui-anim-scale layui-icon layui-icon-group"></i>
				</div>
				<div class="panel_word">
					<span>部门管理</span>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="${pageContext.request.contextPath}/toYewuluru.do"  target="_self">
				<div class="panel_icon layui-bg-cyan">
					<i class="layui-anim layui-anim-scale layui-icon layui-icon-util"></i>
				</div>
				<div class="panel_word">
					<span>短信服务器配置</span>
				</div>
			</a>
		</div>
		</br></br></br></br></br></br>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="${pageContext.request.contextPath}/toYewuluru.do"  target="_self">
				<div class="panel_icon layui-bg-red">
					<i class="layui-anim layui-anim-scale layui-icon layui-icon-home"></i>
				</div>
				<div class="panel_word">
					<span>考勤设置</span>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="${pageContext.request.contextPath}/toOtherSetting.do"  target="_self">
				<div class="panel_icon layui-bg-green">
					<i class="layui-anim layui-anim-scale layui-icon layui-icon-app"></i>
				</div>
				<div class="panel_word">
					<span>权限配置</span>
				</div>
			</a>
		</div>
		<div class="panel layui-col-xs12 layui-col-sm6 layui-col-md4 layui-col-lg2">
			<a href="${pageContext.request.contextPath}/toOtherSetting.do"  target="_self">
				<div class="panel_icon " style="background-color:#B22222">
					<i class="layui-anim layui-anim-scale layui-icon layui-icon-set"></i>
				</div>
				<div class="panel_word">
					<span>路径设置</span>
				</div>
			</a>
		</div>
	</div>




</body>
<script>


 
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element'], function(){
  var laydate = layui.laydate //日期
  ,laypage = layui.laypage //分页
  layer = layui.layer //弹层
  ,table = layui.table //表格
  ,carousel = layui.carousel //轮播
  ,upload = layui.upload //上传
  ,element = layui.element; //元素操作
  
  
  
})

  </script>
</html>