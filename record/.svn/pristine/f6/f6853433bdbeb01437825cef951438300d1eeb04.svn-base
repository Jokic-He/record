<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<script>
	//JavaScript代码区域
	layui.use('element', function() {
		var $ = layui.jquery;
		var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
	})
</script>

<body>

	<div class="layui-side-scroll">
		<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		<ul class="layui-nav layui-nav-tree" lay-failter="record">
			<li class="layui-nav-item layui-nav-itemed"><a
				href="javascript:;">录音管理</a>
				<dl class="layui-nav-child">
					<dd>
						<a data-url="toSign.do" data-id="11" data-title="线路监控" href="#"
							class="site-demo-active" data-type="tabAdd">线路监控</a>
					</dd>
					<dd>
						<a href="#" data-url="toTest.do" data-title="录音查看" data-id="22"
							class="site-demo-active" data-type="tabAdd">录音查看</a>
					</dd>
				</dl></li>
		</ul>
	</div>


<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<div class="layui-tab" lay-filter="demo" lay-allowclose="true" >
					<ul class="layui-tab-title">
					</ul>
					<div class="layui-tab-content">
					</div>
				</div>
			</div>
		</div>
</body>
<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var $ = layui.jquery;
		    var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

		    //触发事件
		    var active = {
		        //在这里给active绑定几项事件，后面可通过active调用这些事件
		        tabAdd: function(url,id,name) {
		            //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
		            //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
		            console.log(url);
		            element.tabAdd('demo', {
		                title: name,
		                content:'<iframe scrolling="auto" frameborder="0"  src="${pageContext.request.contextPath}/'+url+'.do" style="width:99%;height:99%;"></iframe>',
		                id: id //规定好的id
		            })
		        },
		        tabChange: function(id) {
		            //切换到指定Tab项
		            element.tabChange('demo', id); //根据传入的id传入到指定的tab项
		        }, 
		        tabDelete: function (id) {
		        element.tabDelete("demo", id);//删除
		        }
		        
		    };


		    //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
		    $('.site-demo-active').on('click', function() {
		        var dataid = $(this);

		        //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
		        if ($(".layui-tab-title li[lay-id]").length <= 0) {
		            //如果比零小，则直接打开新的tab项
		            active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
		        } else {
		            //否则判断该tab项是否以及存在

		            var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
		            $.each($(".layui-tab-title li[lay-id]"), function () {
		                //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
		                if ($(this).attr("lay-id") == dataid.attr("data-id")) {
		                    isData = true;
		                }
		            })
		            if (isData == false) {
		                //标志为false 新增一个tab项
		                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
		            }
		        }
		        //最后不管是否新增tab，最后都转到要打开的选项页面上
		        active.tabChange(dataid.attr("data-id"));
		    });


		});
	</script>
</html>