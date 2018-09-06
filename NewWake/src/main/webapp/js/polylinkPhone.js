/**@author: 李正义
 * @date: 2017年3月2日
 * @version: 1.0
 * @description: 连接 polylink 电话的公共JS文件
 */

/**
 * 定义的全局变量,作用是获取 polylink 电话的工具条
 */
var phoneAttrObj = document.getElementById("AgentBar");

/**
 * 签入电话的方法
 * 
 * @param serverIp
 *            连接PBX服务器的IP地址
 * @param serverPort
 *            连接PBX服务器的端口
 * @param agentId
 *            连接PBX服务器的坐席工号
 * @param agentPwd
 *            连接PBX服务器的坐席密码
 * @param phoneType
 *            分机类型,0:代表外置话机。 1:代表内置软件电话
 * @param agentExtNum
 *            连接PBX服务器的分机号
 * @param agentExtPwd
 *            连接PBX服务器的密码,此密码由 ipbx 系统提供
 * @param agentExtPort
 *            连接PBX服务器的端口,此端口由 ipbx 系统提供
 */
function doSignIn(serverIp,serverPort,agentId,agentPwd,phoneType,agentExtNum,agentExtPwd,agentExtPort){
	phoneAttrObj.ServerIP = serverIp;
	phoneAttrObj.ServerPort = serverPort;
	phoneAttrObj.AgentID = agentId;
	phoneAttrObj.AgentPwd = agentPwd;
	phoneAttrObj.AgentStatus = 6;
	phoneAttrObj.BindExten = true;
	phoneAttrObj.AgentExten = agentExtNum;
	phoneAttrObj.SipAutoSignIn = false;
	
	if(phoneType == 1){ //如果是内置软电话需要如下信息
		phoneAttrObj.SipPwd = agentExtPwd;
		phoneAttrObj.SipServer = serverIp;
		phoneAttrObj.SipPort = agentExtPort;
		phoneAttrObj.SoftPhoneAnswerCmd = 80;
		phoneAttrObj.SoftPhoneLogoffCmd = 90;
		phoneAttrObj.SoftPhoneAppName = "视频通话";
		phoneAttrObj.SoftPhoneAppClassName = "Qt5QwindowIcon";
		phoneAttrObj.SoftPhoneMsgValue = 256; 
		phoneAttrObj.SoftPhoneEnable2 = true;
		phoneAttrObj.SipNum = agentExtNum;
		phoneAttrObj.AgentExten = agentExtNum;
	}
	//alert(serverIp+','+serverPort+','+agentId+','+agentPwd+','+','+phoneType+','+agentExtNum);
	//签入 polylink PBX系统
	 if (phoneAttrObj.DoSignInWithConnect()) {
		 parent.showMsg("签入提示", "签入成功！");
		 return true;
     } else {
         parent.showAlert("签入提示", "签入失败!", "error");
         return false;
     }
	
}

/**
 * 签出 polylink PBX 系统
 */
function doSignOut() {
    if (!phoneAttrObj.DoSignOut()) {
    	parent.showAlert("签出提示", "签出失败!", "error");
    }
}

/**
 * 设置内置软电话的自动接听,外置话机不生效
 */
function doSetAutoAnswer() {
    if (phoneAttrObj.visible) {
        if (phoneAttrObj.SetSoftphoneIsAutoAnswer(false) == 0)
        	parent.showMsg("设置提示", "设置成功！");
    }else {
    	phoneAttrObj.SetSoftphoneIsAutoAnswer = true;
    }
}




