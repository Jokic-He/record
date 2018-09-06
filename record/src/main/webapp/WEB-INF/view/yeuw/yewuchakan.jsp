<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui1.5/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui1.5/locale/easyui-lang-zh_CN.js"
	charset="utf-8"></script>
<html>
<head>
<title>系统配置</title>
<style type="text/css">
.layui-form-label{
    font-size:18px;
}
</style>
</head>


<body>
	<form class="layui-form" action="" style="position: absolute;left:30%;width:600px;">
		<div class="layui-form-item">
			<label class="layui-form-label">考勤方式</label>
			<div class="layui-input-block">
      <select name="interest" lay-filter="aihao">
        <option value="0">考勤机</option>
        <option value="1" selected="">阅读</option>
        <option value="2">游戏</option>
        <option value="3">音乐</option>
        <option value="4">旅行</option>
      </select>
    </div>
		</div>
		<i class="layui-icon layui-icon-date" style="font-size:25px;></i>  
		<div class="layui-form-item">
		
    <div class="layui-inline">
      <label class="layui-form-label">考勤时间</label>
      <div class="layui-input-inline" style="width: 130px;">
       
        <input type="text" name="price_min" placeholder="开始时间" autocomplete="off" class="layui-input">
      </div>
      <div class="layui-form-mid">-</div>
      <div class="layui-input-inline" style="width: 130px;">
      
        <input type="text" name="price_max" placeholder="结束时间" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>


	</form>
	<button class="layui-btn layui-btn-lg" style="position:absolute;left:30%;top:200px; ">添加考勤方式</button>
	<button class="layui-btn layui-btn-lg" style="position:absolute;left:60%;top:200px; ">保存</button>

</body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">本月详情</a>
</script>
<script>
	layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel', 'upload',
			'element', 'form', 'tree' ], function() {
		var laydate = layui.laydate //日期
		, laypage = layui.laypage //分页
		, layer = layui.layer //弹层
		, table = layui.table //表格
		, carousel = layui.carousel //轮播
		, upload = layui.upload //上传
		, element = layui.element, form = layui.form;//元素操作

	})
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	app.title = '堆叠条形图';

	option = {
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend : {
			data : [ '1001', '1002', '1003', '1004', '1005' ]
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : {
			type : 'value'
		},
		yAxis : {
			type : 'category',
			data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
		},
		series : [ {
			name : '1001',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 320, 302, 301, 334, 390, 330, 320 ]
		}, {
			name : '1002',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 120, 132, 101, 134, 90, 230, 210 ]
		}, {
			name : '1003',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 220, 182, 191, 234, 290, 330, 310 ]
		}, {
			name : '1004',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 150, 212, 201, 154, 190, 330, 410 ]
		}, {
			name : '1005',
			type : 'bar',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'insideRight'
				}
			},
			data : [ 82, 83, 91, 93, 120, 130, 130 ]
		} ]
	};
	;
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
</script>
</html>