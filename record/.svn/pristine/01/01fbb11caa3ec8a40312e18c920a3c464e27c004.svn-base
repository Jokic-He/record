<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>角色管理</title>
</head>
<body>
     <button class="layui-btn layui-btn-lg layui-btn-normal">添加角色</button>
      <table class="layui-hide" id="role" lay-filter="roles"></table>
</body>
 <script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
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
  table.render({
    elem: '#user'
    ,id: 'id'
    ,height: 500
    ,url: '${pageContext.request.contextPath}/toGetUser.do' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'username', title: '用户名', width:200,  fixed: 'left'}
      ,{field: 'department', title: '部门', width:200}
      ,{field: 'role', title: '角色', width:200}
      ,{field: 'lastLoginDate', title: '最后登录日期', width:200} 
      ,{field: 'phoneCode', title: '分机号', width: 200}
      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
    ]]
  });
  
  //监听工具条
  table.on('tool(users)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'detail'){
      layer.msg('查看操作');
    } else if(layEvent === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del(); //删除对应行（tr）的DOM结构
        console.log(data.id);
        layer.close(index);
        //向服务端发送删除指令
      });
    } else if(layEvent === 'edit'){
      layer.msg('编辑操作');
    }
  });
  
  
})
  </script>
</html>