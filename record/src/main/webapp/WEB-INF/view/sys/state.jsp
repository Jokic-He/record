<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/public/inc.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>坐席状态</title>
</head>
<body>
<table>
<tr>
<td><div id="main1" style="width: 500px;height:400px;"></div></td>

<td><div id="main2" style="width: 500px;height:400px;"></div></td>
</tr>
</table>

</body>
<script >

var myChart1 = echarts.init(document.getElementById('main1'));
var myChart2 = echarts.init(document.getElementById('main2'));

// 指定图表的配置项和数据
 myChart1.setOption({
	 title : {
	        text: '坐席在线情况',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	        data: []
	    },
	    series : [
	        {
	            name: '',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:[],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
});
 myChart1.showLoading();    //数据加载完之前先显示一段简单的loading动画
 var names=[];    //类别数组（实际用来盛放X轴坐标值）
 var nums=[];    //销量数组（实际用来盛放Y坐标值）
 $.ajax({
     type : "post",
     url : "${pageContext.request.contextPath}/getState.do",    //请求发送到TestServlet处
     success : function(data) {
         //请求成功时执行该函数内容，result即为服务器返回的json对象
         var result=$.parseJSON(data);
         if (result) {
                for(var i=0;i<result.length;i++){       
                   names.push(result[i].name); 
                   nums.push({value:result[i].num,name:result[i].name})//挨个取出类别并填入类别数组
                 }
                myChart1.hideLoading();    //隐藏加载动画
                myChart1.setOption({        //加载数据图表
                	legend: {
                        data: names
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        data: nums
                    }]
                });
                
         }
     
    },
     error : function(errorMsg) {
         //请求失败时执行该函数
     alert("图表请求数据失败!");
     myChart1.hideLoading();
     }
})

myChart2.setOption({
		    title : {
		        text: '当日来电数量'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['来电量']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : ['0-2','2-4','4-6','6-8','8-10','10-12','12-14','14-16','16-18','18-20','20-22','22-0']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'来电量',
		            type:'bar',
		            data:[],
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        },
		    ]
	
});
 myChart2.showLoading(); 
 var value=[];    //销量数组（实际用来盛放Y坐标值）
 $.ajax({
     type : "post",
     url : "${pageContext.request.contextPath}/record/toGetDayRecord.do",    //请求发送到TestServlet处
     success : function(data) {
         //请求成功时执行该函数内容，result即为服务器返回的json对象
         var result=$.parseJSON(data);
         if (result) {
                for(var i=0;i<result.length;i++){       
                   value.push(parseInt(result[i])); 
                 }
                myChart2.hideLoading();    //隐藏加载动画
                myChart2.setOption({        //加载数据图表
                    series: [{
                        // 根据名字对应到相应的系列
                        data: value
                    }]
                });
                
         }
     
    },
     error : function(errorMsg) {
         //请求失败时执行该函数
     alert("图表请求数据失败!");
     myChart2.hideLoading();
     }
})



</script>
</html>