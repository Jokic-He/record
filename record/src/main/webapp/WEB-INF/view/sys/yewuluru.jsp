<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>录音管理</title>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 12px;">
		<legend>客户信息</legend>
	</fieldset>
	<form class="layui-form" action="">
		<div class="layui-form-item"
			style="border: 1px solid #000; width: 96%; height: 40%;">
			<table>
				<tr>
					<div style="position: absolute; left: 100px; top: 100px">
						<label class="layui-form-label" style="font-size: 20px">来电号码</label>
						<div class="layui-input-block">
							<input type="text" style="width: 200px" name="title"
								class="layui-input">
						</div>
					</div>

					<div style="position: absolute; right: 100px; top: 100px">
						<label class="layui-form-label" style="font-size: 20px">乘客姓名</label>
						<div class="layui-input-block">
							<input type="text" style="width: 200px" name="title"
								class="layui-input">
						</div>
					</div>
				<tr>
					<td>
						<div style="position: absolute; left: 100px; top: 180px">
							<label class="layui-form-label" style="font-size: 20px">性别</label>
							<div class="layui-input-block" style="width: 200px;">
								<select name="interest" lay-filter="aihao">
									<option value="">男</option>
									<option value="0">女</option>
								</select>
							</div>
						</div>

						<div style="position: absolute; right: 100px; top: 180px">
							<label class="layui-form-label" style="font-size: 20px;">时间</label>
							<div class="layui-input-inline">
								<input name="atpstarttime" type="text" class="layui-input" id="start" placeholder="请选择时间">
							</div>
						</div>
					</td>
			</table>
		</div>


	</form>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 12px;">
		<legend>业务信息</legend>
	</fieldset>
	<div class="layui-form-item"
		style="border: 1px solid #000; width: 96%; height: 60%;padding: 30px">
		
		<label class="layui-form-label" style="font-size: 20px;">咨询事宜</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
		</div>


</body>
<script>
	layui
			.use(
					[ 'form', 'layedit', 'laydate' ],
					function() {
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

						//日期
						laydate.render({
							elem : '#date'
						});
						laydate.render({
							elem : '#date1'
						});

						//创建一个编辑器
						var editIndex = layedit.build('LAY_demo_editor');

						//自定义验证规则
						form.verify({
							title : function(value) {
								if (value.length < 5) {
									return '标题至少得5个字符啊';
								}
							},
							pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
							content : function(value) {
								layedit.sync(editIndex);
							}
						});

						//监听指定开关
						form.on('switch(switchTest)', function(data) {
							layer.msg('开关checked：'
									+ (this.checked ? 'true' : 'false'), {
								offset : '6px'
							});
							layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF',
									data.othis)
						});

						//监听提交
						form.on('submit(demo1)', function(data) {
							layer.alert(JSON.stringify(data.field), {
								title : '最终的提交信息'
							})
							return false;
						});

					});
</script>
</html>