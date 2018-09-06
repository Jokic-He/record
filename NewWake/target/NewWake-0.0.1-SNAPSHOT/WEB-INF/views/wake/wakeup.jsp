<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/WEB-INF/pub/inc.jsp"%>
<title>叫醒记录统计</title>
<style type="text/css">
.wake_zhuti {
	position: absolute;
	width: 1250px;
}

.User {
	position: absolute;
	right: 400px;
}

.out {
	position: absolute;
	right: 50px;
}
</style>
</head>
<body>
	<div class="User">欢迎登录：${user.username } </div>
	<div class="personal"><a href="${pageContext.request.contextPath}/personal.do">个人中心<a></a></div>

	<div class="out">
		<form id="loginOut1" type="hidden">
			<a href="${pageContext.request.contextPath}/loginOut.do" id="btn"
				class="easyui-linkbutton" data-options="iconCls:'icon-delete'">退出登录</a>
		</form>
	</div>

	<div class="wake_zhuti">
		<form id="wakeup_find_form" method="post">
			<div>
				<label>叫醒房号：</label> <input id="wakeup_roomNum" name="roomNum">
			</div>

			<div>
				<label>成功与否：</label> <input id="wakeup_success_type" name="success"
					class="easyui-combobox" value=10> <label>开始时间：</label> <input
					id="wakeup_start_time" name="startDate"> <label>结束时间：</label>
				<input id="wakeup_end_time" name="endDate"> <a
					href="javascript:;" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="wakeSearch()">查询</a>
				&nbsp;&nbsp;
			</div>
		</form>
		<a href="${pageContext.request.contextPath}/wakeup/saveDataFive.do"
			id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">存库5min</a>
		<a href="${pageContext.request.contextPath}/wakeup/saveDataHalf.do"
			id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">存库30min</a>
		<a href="${pageContext.request.contextPath}/wakeup/saveDataHour.do"
			id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">存库1h</a>
		<a href="${pageContext.request.contextPath}/wakeup/saveData.do"
			id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-save'">数据全存库</a>
		<a href="${pageContext.request.contextPath}/wakeup/deleteData.do"
			id="btn" class="easyui-linkbutton"
			data-options="iconCls:'icon-delete'">数据清除</a> <a href="javascript:;"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'"
			onclick="toExcel()">导出excel</a> </br> </br> 
			
			<a
			href="${pageContext.request.contextPath}/wakeup/toSendMail.do"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">发送邮件</a>
			<a
			href="${pageContext.request.contextPath}/toRp.do"
			class="easyui-linkbutton" data-options="iconCls:'icon-save'">角色权限测试页面</a>
		<div>
			<table id="dg"></table>
		</div>

	</div>
</body>
<script type="text/javascript">
	var wakeupList;
	/*查询记录展示*/
	$(function() {
		wakeupList = $('#dg').datagrid({
			url : '${pageContext.request.contextPath}/wakeup/toFindAll.do',
			method : 'post',
			nowrap : true,
			loadMsg : '数据加载中,请稍候...',
			pagination : true,
			pageNumber : 1,
			pageSize : 10,
			pageList : [ 10, 20, 30 ],
			checkOnSelect : false,
			selectOnCheck : false,
			columns : [ [ {
				field : 'setDate',
				title : '记录时间',
				width : 250
			}, {
				field : 'setNum',
				title : '话务台',
				width : 250
			}, {
				field : 'wakeTime',
				title : '叫醒时间',
				width : 250
			}, {
				field : 'roomNum',
				title : '叫醒房号',
				width : 250
			}, {
				field : 'success',
				title : '是否成功',
				width : 250,
				formatter : function(value, row, index) {
					if (row.success == 5) {
						return '失败';
					} else if (row.success == 1) {
						return '成功';
					} else if (row.success == 2) {
						return '设置成功';
					} else if (row.success == 3) {
						return '修改成功';
					} else if (row.success == 4) {
						return '删除成功';
					}
				}
			} ] ]
		});
	});

	/*时间ui工具*/
	$(function() {
		$('#wakeup_start_time').datetimebox({
			editable : false,
		});

		$('#wakeup_end_time').datetimebox({
			editable : false,
		});

	});
	/*成功下拉框选项*/
	$(function() {
		$('#wakeup_success_type').combobox({
			url : '${pageContext.request.contextPath}/wakeup/getCombobox.do',
			valueField : 'id',
			textField : 'text'
		});
	});

	/*查询条件传送*/
	//用户查询
	function wakeSearch() {
		var opt = wakeupList.datagrid('options');
		opt.url = '${pageContext.request.contextPath}/wakeup/toFindData.do';
		//初始化为datagrid
		wakeupList.datagrid('load', sy.serializeObject($('#wakeup_find_form')));
	}
	/*导出excel条件传送*/
	//导出excel
	function toExcel() {
		var opt = wakeupList.datagrid('options');
		opt.url = '${pageContext.request.contextPath}/wakeup/toExcel.do';
		//初始化为datagrid
		wakeupList.datagrid('load', sy.serializeObject($('#wakeup_find_form')));
	}
	function send() {
		$('#sendMail').form('submit', {
			onSubmit : function() {
				return $(this).form('enableValidation').form('validate');
			},
			url : '${pageContext.request.contextPath}/send.do',
			success : function(r) {
				if (r == "1") {
					alter("成功");
				} else {
					alter("失败");
				}
			}
		});
	}

	function loginOut() {
		$.ajax(
		{
			type: "post",
			url: '${pageContext.request.contextPath}/loginOut.do',
			success:function(data){
				if(data==null){
					alert('登出成功');
					console.log('123123');
				}else{
					alert('登出失败');
					console.log('444');
				}
			}
		});
	
	}
</script>
</html>