<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>录音管理</title>
<style>
#backTime {
	width: 500px;
	position: absolute;
	left: 600px;
	height: 30px;
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">
				<!--  <span style="font-size: 23px">录音管理系统</span>-->
				 <span style="font-size: 23px">APS轨道管理系统</span>
			</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item">
					<!-- 此处出现首页 --> <a data-url="toState.do" data-id="11"
					data-title="坐席状态" href="#" class="site-demo-active"
					data-type="tabAdd"><i class="layui-icon layui-icon-layer"
						style="font-size: 25px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
						style="font-size: 16px"><!-- 坐席状态查看 -->我的办公</span></a>
				</li>
				<shiro:hasPermission name="sys:setting"><li class="layui-nav-item"><a id="set1" data-url="toSetting.do"
					data-id="22" data-title="系统设置" href="#" class="site-demo-active"
					data-type="tabAdd"><i class="layui-icon layui-icon-util"
						style="font-size: 25px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
						style="font-size: 16px">系统设置</span></a></li></shiro:hasPermission>
			</ul>
			<blockquote class="layui-elem-quote layui-bg-green" id="backTime">
				<div id="nowTime"></div>
			</blockquote>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item" pc><a href="javascript:;"
					class="clearCache"><i class="layui-icon" data-icon="&#xe640;">&#xe640;</i><cite>清除缓存</cite></a></li>
				<li class="layui-nav-item"><a href="javascript:;"> <span
						style="font-size: 18px">${user.username }</span>
				</a> <input value="${user.id}" id="userId" hidden="true">
					<dl class="layui-nav-child">
						<dd>
							<a data-url="toPersonalMyself" data-id="33" data-title="个人资料"
								href="javascript:;" class="site-demo-active" data-type="tabAdd">个人资料</a>

						</dd>
						<dd>
							<a
								href="${pageContext.request.contextPath}/loginOut.do?id=${user.id}"
								class="site-demo-active" data-id="13">退出</a>
						</dd></li>
				</dl>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<!-- 
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">业务录入</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="record/toLine" data-id="55" data-title="线路监控"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">线路监控</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">录音查看</span></a>
							</dd>
						</dl></li>
				</ul>  -->
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">业务管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="toYewuluru" data-id="55" data-title="新建工单"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">新建工单</span></a>
							</dd>
							<dd>
								<a href="#" data-url="toYewuchakan" data-title="业务查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">工单查询</span></a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">惠民管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="record/toLine" data-id="55" data-title="线路监控"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">乘客表扬</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">拾遗物品登记</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">乘客咨询</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">乘客投诉</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">乘客建议</span></a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">地铁基本信息查询</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="record/toLine" data-id="55" data-title="线路监控"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">线路监控</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">录音查看</span></a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">短消息管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="record/toLine" data-id="55" data-title="短信发送"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">短信发送</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="内部消息管理"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">内部信息管理</span></a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">留言管理</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="record/toLine" data-id="55" data-title="线路监控"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">线路监控</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">录音查看</span></a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav layui-nav-tree" lay-failter="record">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;"><span style="font-size: 20px">统计报表</span></a>
						<dl class="layui-nav-child">
							<dd>
								<a data-url="record/toLine" data-id="55" data-title="线路监控"
									href="#" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-console" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">系统人员查看</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">客户信息查看</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">系统考勤日志</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">呼出质量统计</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">呼入质量统计</span></a>
							</dd>
							<dd>
								<a href="#" data-url="record/toRecord" data-title="录音查看"
									data-id="66" class="site-demo-active" data-type="tabAdd"><i
									class="layui-icon layui-icon-speaker" style="font-size: 18px;"></i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span
									style="font-size: 18px">业务工单处理统计</span></a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">

				<div class="layui-tab" lay-filter="demo" lay-allowclose="true">
					<ul class="layui-tab-title">
						<li class="layui-this" data-id="11">录音查询</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<iframe scrolling="auto" frameborder="0"
								src="${pageContext.request.contextPath}/record/toRecord.do"
								style="width: 99%; height: 99%;"></iframe>
						</div>
					</div>
				</div>
			</div>



			<div class="layui-footer">
				<!-- 底部固定区域 -->
				© 宁波小安信息有限公司
			</div>
		</div>
		<script>
			//JavaScript代码区域
			var baseUrl = '${pageContext.request.contextPath}/login.do';

			//	$.ajaxSetup({
			//		statusCode:{
			//			302:function(){alert('请重新登录');location.href=baseUrl;}
			//		}
			//	});
			//获取系统时间
			var newDate = '';
			getLangDate();
			//值小于10时，在前面补0
			function dateFilter(date) {
				if (date < 10) {
					return "0" + date;
				}
				return date;
			}
			function getLangDate() {
				var dateObj = new Date(); //表示当前系统时间的Date对象
				var year = dateObj.getFullYear(); //当前系统时间的完整年份值
				var month = dateObj.getMonth() + 1; //当前系统时间的月份值
				var date = dateObj.getDate(); //当前系统时间的月份中的日
				var day = dateObj.getDay(); //当前系统时间中的星期值
				var weeks = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
				var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
				var hour = dateObj.getHours(); //当前系统时间的小时值
				var minute = dateObj.getMinutes(); //当前系统时间的分钟值
				var second = dateObj.getSeconds(); //当前系统时间的秒钟值
				var timeValue = ""
						+ ((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午"); //当前时间属于上午、晚上还是下午
				newDate = dateFilter(year) + "年" + dateFilter(month) + "月"
						+ dateFilter(date) + "日 " + " " + dateFilter(hour)
						+ ":" + dateFilter(minute) + ":" + dateFilter(second);
				document.getElementById("nowTime").innerHTML = timeValue
						+ "好！ 欢迎使用录音系统。当前时间为： " + newDate + "　" + week;
				setTimeout("getLangDate()", 1000);
			}

			layui
					.use(
							[ 'element', 'layer' ],
							function() {
								var $ = layui.jquery;
								var element = layui.element, layer = layui.layer; //Tab的切换功能，切换事件监听等，需要依赖element模块
								//触发事件
								var active = {
									//在这里给active绑定几项事件，后面可通过active调用这些事件
									tabAdd : function(url, id, name) {
										//新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
										//关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
										console.log(url);
										if (id != '13') {
											element
													.tabAdd(
															'demo',
															{
																title : name,
																content : '<iframe scrolling="auto" frameborder="0"  src="${pageContext.request.contextPath}/'
																		+ url
																		+ '.do" style="width:99%;height:99%;"></iframe>',
																id : id
															//规定好的id
															})
										}
									},
									tabChange : function(id) {
										//切换到指定Tab项
										element.tabChange('demo', id); //根据传入的id传入到指定的tab项
									},
									tabDelete : function(id) {
										element.tabDelete("demo", id);//删除
									}

								};

								//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
								$('.site-demo-active')
										.on(
												'click',
												function() {
													var dataid = $(this);

													//这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
													if ($(".layui-tab-title li[lay-id]").length <= 0) {
														//如果比零小，则直接打开新的tab项
														active
																.tabAdd(
																		dataid
																				.attr("data-url"),
																		dataid
																				.attr("data-id"),
																		dataid
																				.attr("data-title"));
													} else {
														//否则判断该tab项是否以及存在

														var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
														$
																.each(
																		$(".layui-tab-title li[lay-id]"),
																		function() {
																			//如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
																			if ($(
																					this)
																					.attr(
																							"lay-id") == dataid
																					.attr("data-id")) {
																				isData = true;
																			}
																		})
														if (isData == false) {
															//标志为false 新增一个tab项
															active
																	.tabAdd(
																			dataid
																					.attr("data-url"),
																			dataid
																					.attr("data-id"),
																			dataid
																					.attr("data-title"));
														}
													}
													//最后不管是否新增tab，最后都转到要打开的选项页面上
													active.tabChange(dataid
															.attr("data-id"));
												});
								//清除缓存
								$(".clearCache").click(function() {
									window.sessionStorage.clear();
									window.localStorage.clear();
									var index = layer.msg('清除缓存中，请稍候', {
										icon : 16,
										time : false,
										shade : 0.8,
										offset : [ '50%', '50%' ]
									});
									setTimeout(function() {
										layer.close(index);
										layer.msg("缓存清除成功！", {
											offset : [ '50%', '50%' ]
										});
									}, 1000);
								});

							});
			//心跳功能，用于监听用户是否在线
			/*	     $(function(){
				    	 var dateObj1=new Date();
				    	 var year1 = dateObj1.getFullYear(); //当前系统时间的完整年份值
						 var month1 = dateObj1.getMonth() + 1; //当前系统时间的月份值
						 if(month1<10){
							 month1='0'+month1;
						 }
						 var date1= dateObj1.getDate(); //当前系统时间的月份中的日
						 if(date1<10){
							 date1='0'+date1;
						 }
						 var hour1 = dateObj1.getHours(); //当前系统时间的小时值
						 if(hour1<10){
							 hour1='0'+hour1;
						 }
						 var minute1 = dateObj1.getMinutes(); //当前系统时间的分钟值
						 if(minute1<10){
							 minute1='0'+minute1;
						 }
						 var second1 = dateObj1.getSeconds(); //当前系统时间的秒钟值
						 if(second1<10){
							 second1='0'+second1;
						 }
						 var now=year1+'/'+month1+'/'+date1+' '+hour1+':'+minute1+':'+second1;
				    	 
				    	 console.log(now);
				    	 console.log(id);
				    	 setInterval(function(){
				    		 $.post('${pageContext.request.contextPath}/checkOnline.do',{date:now,id:id},function(){}
				    				 )
				    	 },10000);
				     })  */
		</script>
</body>
</html>