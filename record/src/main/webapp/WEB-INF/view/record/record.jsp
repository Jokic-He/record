<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<title>系统配置</title>
</head>
<body>
	<div class="demoTable">

		<div class="layui-inline">
			<form class="layui-form" action="">
				<audio src="#" id="audio"></audio>
				<br> <input type="hidden" value="${url}" id="aaa" />
				<table>
					<tbody>
						<tr>
							<td>
								<div class="layui-form-item">
									<label class="layui-form-label">呼入方向</label>
									<div class="layui-input-block">
										<select name="atpdirect" lay-filter="fangxiang"
											id="atpdirectId" style="width: 100px">
											<option value="2"></option>
											<option value="0">呼入</option>
											<option value="1">呼出</option>
										</select>
									</div>
								</div>
							</td>
							<td>
								<div class="layui-form-item">
									<label class="layui-form-label">主叫号码</label>
									<div class="layui-input-block">
										<input type="text" name="atpdtmf" id="atpdtmfId"
											class="layui-input" style="width: 190px;">
									</div>
								</div>
							</td>
							<td>
								<div class="layui-form-item">
									<label class="layui-form-label">被叫号码</label>
									<div class="layui-input-block">
										<input type="text" name="atpcaller" id="atpcallerId"
											class="layui-input" style="width: 190px;">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="layui-form-item">
									<label class="layui-form-label">通道号</label>
									<div class="layui-input-block">
										<input type="text" name="atpchnum" id="atpchnumId"
											class="layui-input" style="width: 220px;">
									</div>
								</div>
							</td>
							<td>
								<div class="layui-form-item">
									<label class="layui-form-label"><span
										style="font-size: 13px">录音开始时间</span></label>
									<div class="layui-input-inline">
										<input name="atpstarttime" type="text" class="layui-input"
											id="start" placeholder="请选择开始时间">
									</div>
								</div>
							</td>
							<td>
								<div class="layui-form-item">
									<label class="layui-form-label"><span
										style="font-size: 13px">录音结束时间</span></label>
									<div class="layui-input-block">
										<div class="layui-input-inline">

											<input name="atpendtime" type="text" class="layui-input"
												id="end" placeholder="请选择结束时间">
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<i class="layui-icon layui-icon-search"
											style="font-size: 27px;"></i>
										<div class="layui-btn" data-type="reload" id="demoReload">搜索</div>
										<button type="reset" class="layui-btn layui-btn-primary"
											onclick="chongzhi()">重置</button>
										<a class="layui-btn layui-btn-normal"
											href="${pageContext.request.contextPath}/record/toExcel.do">导出EXCEl</a>
									</div>

								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<table class="layui-hide" id="user" lay-filter="users"></table>


</body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-play" style="font-size: 14px;"></i>播放</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">暂停</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit" id="download">下载</a>
</script>
<script>
	var atpdirect = 2;
	var rurl = document.getElementById('aaa').value;
	layui
			.use(
					[ 'laydate', 'laypage', 'layer', 'table', 'carousel',
							'upload', 'element', 'form' ],
					function() {
						var laydate = layui.laydate //日期
						, laypage = layui.laypage //分页
						, layer = layui.layer //弹层
						, table = layui.table //表格
						, carousel = layui.carousel //轮播
						, upload = layui.upload //上传
						, element = layui.element, form = layui.form;//元素操作

						//日期时间选择器
						laydate.render({
							elem : '#start',
							type : 'datetime'

						});

						laydate.render({
							elem : '#end',
							type : 'datetime'

						});

						//执行一个 table 实例
						table
								.render({
									elem : '#user',
									id : 'id',
									url : '${pageContext.request.contextPath}/record/getRecords.do' //数据接口
									,
									page : true //开启分页
									,
									cols : [ [ //表头
									{
										type : 'checkbox'
									}, {
										field : 'atpdirect',
										title : '呼入方向',
										width : '10%',
										sort : true
									}, {
										field : 'atpdtmf',
										title : '主叫号码',
										width : '10%',
										sort : true
									}, {
										field : 'atpcaller',
										title : '被叫号码',
										width : '10%',
										sort : true
									}, {
										field : 'atpchnum',
										title : '通话分机号',
										width : '10%'
									}, {
										field : 'atpstarttime',
										title : '录音开始时间',
										width : '18%',
										sort : true
									}, {
										field : 'atpendtime',
										title : '录音结束时间',
										width : '18%',
										sort : true
									}, {
										fixed : 'right',
										width : '20%',
										align : 'center',
										toolbar : '#barDemo'
									} ] ]
								});

						//监听工具条
						table
								.on(
										'tool(users)',
										function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
											var data = obj.data //获得当前行数据
											, layEvent = obj.event; //获得 lay-event 对应的值
											if (layEvent === 'detail') {
												var url = data.atprecordurl;
												var urls = url.split('/');
												url = '/music' + '/' + urls[2]
														+ '/' + urls[3];
												var media = document
														.getElementById('audio');
												media.src = url;
												media.play();

											} else if (layEvent === 'del') {
												var media = document
														.getElementById('audio');
												media.pause();

											} else if (layEvent === 'edit') {
												var url = data.atprecordurl;
												var urls = url.split('/');
												url = urls[2] + '/' + urls[3];
												//$('#download').attr('href','${pageContext.request.contextPath}/record/download.do?url='+url); 
												location.href = '${pageContext.request.contextPath}/record/downloadrecord.do?url='
														+ url;
											}
										});

						//  form.on('submit(form)', function(data){
						//	  console.log($(data.form).serialize());
						//	  $.ajax({
						//			url : '${pageContext.request.contextPath}/record/getRecords.do',
						//			data : $(data.form).serialize(),
						//			success :function(data){

						//			}
						//		});
						//  });

						form.on('select(fangxiang)', function(data) {
							console.log(data.value); //得到被选中的值
							atpdirect = data.value;
						});
						console.log(atpdirect);
						var $ = layui.$, active = {
							reload : function() {

								var atpdtmf = $('#atpdtmfId'), atpcaller = $('#atpcallerId'), atpchnum = $('#atpchnumId'), atpstarttime = $('#start'), atpendtime = $('#end')

								console.log(atpdirect);

								//执行重载
								table
										.reload(
												'id',
												{
													url : '${pageContext.request.contextPath}/record/getRecords.do',
													page : {
														curr : 1
													//重新从第 1 页开始
													},
													where : {
														key : {
															atpdirect : atpdirect,
															atpdtmf : atpdtmf
																	.val(),
															atpcaller : atpcaller
																	.val(),
															atpchnum : atpchnum
																	.val(),
															atpstarttime : atpstarttime
																	.val(),
															atpendtime : atpendtime
																	.val()
														}
													}
												});
							}
						};

						$('#demoReload').on('click', function() {
							var type = $(this).data('type');
							active[type] ? active[type].call(this) : '';
						});

					})

	function chongzhi() {
		atpdirect = 2;
	}
</script>
</html>