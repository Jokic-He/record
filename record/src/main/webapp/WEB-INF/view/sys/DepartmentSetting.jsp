<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui1.5/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui1.5/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<html>
<head>
<title>部门管理</title>
<style>
#department {
   margin-left: 10%;
   margin-top: 5%;
}
.layui-tree li a cite {
font-size: 20px;
}

.layui-tree li a i {
font-size: 30px;
}
</style>
</head>
<body>

     <a href="${pageContext.request.contextPath}/toAddD.do"
						class="layui-btn layui-btn-warm layui-btn-radius ">添加部门</a>
	&nbsp	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp				
	 <a href="${pageContext.request.contextPath}/toSetting.do"
	                    class="layui-btn layui-btn-normal layui-btn-radius"><i class="layui-icon layui-icon-return"></i><span style="font-size: 20px;">返回</span></a>  
	                    </br></br>
	<ul id="department"></ul>
    <div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <col width="150">
      <col width="150">
      <col width="200">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>籍贯</th>
      </tr> 
    </thead>
    <tbody>
      <tr>
        <td>王强</td>
        <td>29</td>
        <td>男</td>
        <td>宁波</td>
      </tr>
      <tr>
        <td>张飞</td>
        <td>26</td>
        <td>男</td>
        <td>杭州</td>
      </tr>
      <tr>
        <td>刘瑶</td>
        <td>30</td>
        <td>女</td>
        <td>北京</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
<script>
	layui.use('tree', function() {
		$(function() {
			aa();
			
		});
		function aa() {
			$.ajax({
				url : '${pageContext.request.contextPath}/toTreeD.do',
				success : function(data) {
					var n = $.parseJSON(data);
					 layui.tree({
						  elem:'#department',
						  nodes:n.obj
					  });
				}
			})
		}
		;

		
	});
	
</script>
</html>