/**@author: 李正义
 * @date: 2016年11月23日
 * @version: 1.0
 * @description: 
 */
/** easyui 消息提示 **/
function showMsg(title,msg){
	$.messager.show({
		title:title == null ? '消息提示' : title,
		msg:msg,
		timeout:2000,
		showType:'slide'
	});
}

/** 弹出提示窗 **/
function showAlert(title,msg,type){
	$.messager.alert(title,msg,type);
}

/** 获取时间戳 **/
function genTimestamp() {
	var time = new Date();
	return time.getTime();
}

/**格式化查询的开始时间**/
function findStartDate(date){
	var day = date.getDate()>9 ? date.getDate() : '0'+date.getDate();
	var month = (date.getMonth()+1) > 9 ? (date.getMonth()-1) : '0'+(date.getMonth()-1);
	return date.getFullYear() + '-' + month + '-' + day;
}

/**格式化查询的开始时间含时间**/
function findStartDateTime(date){
	var day = date.getDate()>9 ? date.getDate() : '0'+date.getDate();
	var month = (date.getMonth()+1) > 9 ? (date.getMonth()-1) : '0'+(date.getMonth()-1);
	var startDay = ' 00:00:00';
	return date.getFullYear() + '-' + month + '-' + day+startDay;
}

/** 格式化datagrid列上的日期时间为日期 **/
function fdate(value,rowData,rowIndex){
	if(value==null || value==""){
		return "";
	} else {
		return value.substring(0,value.lastIndexOf("-")+3);
	}
}

/**格式化查询的结束时间**/
function findEndDate(date){
	var day = date.getDate()>9 ? date.getDate() : '0'+date.getDate();
	var month = (date.getMonth()+1) > 9 ? (date.getMonth()+1) : '0'+(date.getMonth()+1);
	return date.getFullYear() + '-' + month + '-' + day;
}

/**格式化查询的结束时间包含时间**/
function findEndDateTime(date){
	var day = date.getDate()>9 ? date.getDate() : '0'+date.getDate();
	var month = (date.getMonth()+1) > 9 ? (date.getMonth()+1) : '0'+(date.getMonth()+1);
	var endDay = ' 23:59:59';
	return date.getFullYear() + '-' + month + '-' + day+endDay;
}


/**
 * @author: 李正义
 * @date: 2017年4月2日
 * @version: 1.0
 * @description: 自动生成数据列表
 * @param datagridId : 生成数据列表的 <table> id, 必须指定的参数
 * @param url : 获取数据库列表的url地址, 必须指定的参数
 * @param sortName : 排序的名称 ,可以为空,为空时以 createDate 进行排序
 * @param sortOrder : 指定升序/降序 ,可以为空,为空时以 desc 指定为降序
 * @param columns : 指定显示的数据列表字段 , 必须指定的参数
 * @param toolbarId : 数据列表上的功能按钮, 可以为空,为空时将没有功能按钮,可以在 columns 中用一列来表示
 */
function getDataGrid(datagridId,url,sortName,sortOrder,columns,toolbarId){
	datagrid = $('#'+datagridId).datagrid({
		 url: url,
		 method:'post',
		 nowrap:true,
		 loadMsg:'数据加载中,请稍候...',
		 pagination:true,
		 pageNumber:1,
		 pageSize:10,
		 pageList:[10,20,30],
		 sortName: sortName == null ? 'createDate' : ''+sortName,
		 sortOrder: sortOrder == null ? 'desc' : ''+sortOrder,
		 checkOnSelect:false,
		 selectOnCheck:false,
		 idField:'id',    
		 columns:[columns] ,
		 toolbar: toolbarId == null ? '' : '#'+toolbarId
	});
	return datagrid;
}

/**
 * @author: 李正义
 * @date: 2017年4月2日
 * @version: 1.0
 * @description: 根据ID的集合删除数据
 * @param datagrid : 指定要删除那个 datagrid 的数据
 * @param deleteUrl : 指定删除提交的 URL 地址
 */
function remove(datagrid,deleteUrl){
	var ids = [];
	var rows = datagrid.datagrid('getChecked');
	if(rows.length>0){
		$.messager.confirm('提示', '您确定要删除吗？', function(r){
			if (r){
			    for(var i=0; i<rows.length; i++){
			    	ids.push(rows[i].id);
			    }
					//发起ajax请求
					$.ajax({
						url : deleteUrl,
						method : 'post',
						data : {
							ids : ids.join(','),
						},
						dataType : 'json',
						success : function(r) {
							datagrid.datagrid('reload');
							datagrid.datagrid('unselectAll');
							datagrid.datagrid('uncheckAll');
						},
						error:function (r){
							var obj = $.parseJSON(r);
							showMsg("错误提示", obj.msg);
						}
					}); 	
			}
		});	
	}else{
		showAlert("错误提示", "至少选中【一条】数据", "error");
	}
}

/**
 * @author: 李正义
 * @date: 2017年4月2日
 * @version: 1.0
 * @description: 在datagrid 列上格式化,显示指定的值
 * @param rowColumn : boolean 类型的表达式
 * @param formateValue : 需要格式化显示的值,它是一个数组
 */
function formatYesOrNo(rowColumn,formateValue){
	if(rowColumn ){
		return formateValue == null || formateValue[0] == null ? '是' : ''+formateValue[0];
	} else if(rowColumn){
		return  formateValue == null || formateValue[1] == null ? '否' : ''+formateValue[1];;
	}else {
		return '未知';
	}
}

/**
 * @author: 李正义
 * @date: 2017年4月2日
 * @version: 1.0
 * @description: 保存或修改页面 
 * @param varTemp : 被打开的DIV的临时变量
 * @param type : 判断弹出框的类型。 0: 代表添加, 1:代表修改
 * @param width : 窗口的宽度,可以为null
 * @param height : 窗口的高度,可以为null
 * @param hrefUrl : 被加载页面的URL地址
 * @param submitFormId : 表单的ID
 * @param submitUrl : 表单提交的URL地址
 * @param gridType :  0：代表datagrid, 1：代表treegrid
 * @param datagridObj : 表单添加成功后要刷新的 datagrid
 */
function addOrEditDialog(varTemp,type,width,height,hrefUrl,submitFormId,submitUrl,onSubmitParam,gridType,gridObj){
	var varTemp = parent.$('<div />').dialog({
		title: type==0?"添加页面":"修改页面", 
		iconCls: type==0?'icon-save':'icon-edit',
		width: width != null ? width : 650,    
		height: height != null ? height : 410,    
		closed: false,      
		href: hrefUrl,    
		modal: true ,  
		toolbar:[{
			text: type==0?"添加":"修改",
			iconCls:type==0?'icon-add':'icon-edit',
			handler:function(){
				parent.$('#'+submitFormId).form('submit',{
					url : submitUrl,
					onSubmit: function(param){
						if(onSubmitParam != null){
							return true;
						}else{
							return parent.$(this).form('enableValidation').form('validate');
						}
					},
					success:function(r){ 
						var obj = $.parseJSON(r);
						if(obj.success){
							varTemp.dialog('close');
							treegridOrDatagrid(gridType,gridObj);
						}
						showMsg('添加提示',obj.msg);
					},
				});
			}
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				varTemp.dialog('close');
			}
		}],
		onClose:function(){ //销毁div
			varTemp.dialog('destroy');
		},
	}).show();
}

/**
 * @author: 李正义
 * @date: 2017年4月5日
 * @version: 1.0
 * @description: 一个简单的添加或修改页面,所有的参数都非空,gridObj为 datagrid
 */
function simpleAddOrEditDialog(varTemp,type,hrefUrl,submitFormId,submitUrl,gridObj){
	var varTemp = parent.$('<div />').dialog({
		title: type==0?"添加页面":"修改页面", 
		iconCls: type==0?'icon-save':'icon-edit',
		width: 650,    
		height: 410,    
		closed: false,      
		href: hrefUrl,    
		modal: true ,  
		toolbar:[{
			text: type==0?"添加":"修改",
			iconCls:type==0?'icon-add':'icon-edit',
			handler:function(){
				parent.$('#'+submitFormId).form('submit',{
					url : submitUrl,
					onSubmit: function(param){
						return parent.$(this).form('enableValidation').form('validate');
					},
					success:function(r){ 
						var obj = $.parseJSON(r);
						if(obj.success){
							varTemp.dialog('close');
							if(gridObj != null && gridObj != ''){
								datagridReload(gridObj);
							}
						}
						showMsg('添加提示',obj.msg);
					},
				});
			}
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				varTemp.dialog('close');
			}
		}],
		onClose:function(){ //销毁div
			varTemp.dialog('destroy');
		},
	}).show();
}

/**
 * @author: 李正义
 * @date: 2017年4月5日
 * @version: 1.0
 * @description: 根据类型判断是treegrid 还是 datagrid
 * @param gridType : 0：代表datagrid, 1：代表treegrid
 */
function treegridOrDatagrid(gridType,gridObj){
	gridType == 0 ? datagridReload(gridObj) : treegridReload(gridObj);
}

/**
 * @author: 李正义
 * @date: 2017年4月5日
 * @version: 1.0
 * @description: 重新加载 treegrid
 */
function treegridReload(gridObj){
	gridObj.treegrid('reload');
	gridObj.treegrid('unselectAll');
	gridObj.treegrid('uncheckAll');
}

/**
 * @author: 李正义
 * @date: 2017年4月5日
 * @version: 1.0
 * @description: 重样加载datagrid
 */
function datagridReload(gridObj){
	gridObj.datagrid('reload');
	gridObj.datagrid('unselectAll');
	gridObj.datagrid('uncheckAll');
}

function unCheck(gridObj){
	gridObj.datagrid('unselectAll');
	gridObj.datagrid('uncheckAll');
}

var lzyKind = Kindeditor = {
	// 编辑器参数
	kingEditorParams : {
		//指定上传文件参数名称
		filePostName : "uploadFile",
		
		//指定上传文件请求的url。
		uploadJson : 'inform/uploadPicuter.do',
		
		//上传类型，分别为image、flash、media、file
		dir : "image"
	},
}

/**
 * @author: 李正义
 * @date: 2017年5月11日
 * @version: 1.0
 * @description:删除JS内所有HTML标签 
 */
function replaceHtml(value,row,index){
	return row.note.replace(/<[^<>]+?>/g,'');//删除所有HTML标签 
}