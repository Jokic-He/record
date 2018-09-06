<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>線路監控</title>
</head>
<body>

      <table class="layui-hide" id="user" lay-filter="users"></table>


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
  
  
  
  //执行一个 table 实例
  setInterval(function(){table.render({
    elem: '#user'
    ,id: 'id'
    ,width:'80%'
    ,url: '${pageContext.request.contextPath}/record/getLine.do' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'atpworkstate', title: '线路状态', width:'24%',  fixed: 'left'}
      ,{field: 'atpconstate', title: '线路方式', width:'24%'}
      ,{field: 'atpdtmf', title: 'dtmf', width:'24%'}
      ,{field: 'atpcallerid', title: '呼入号码', width:'24%'} 
      ,{field: 'atpchn', title: '通道号', width: '24%'}
    ]]
  });},5000);
  
})
  </script>
</html>