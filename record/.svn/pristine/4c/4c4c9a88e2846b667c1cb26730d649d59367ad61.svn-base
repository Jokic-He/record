package com.sunwin.talent.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.kevinsawicki.http.HttpRequest;
import com.sunwin.sys.utils.Const;
import com.sunwin.sys.utils.DateUtil;
import com.sunwin.sys.utils.EmptyUtils;
import com.sunwin.sys.utils.Json;
import com.sunwin.talent.entity.openAndSession;
import com.sunwin.talent.entity.talent;
import com.sunwin.talent.service.talentService;

/**
 * 
 * 
 * <p>
 * Description: 该类为简历操作控制类
 * </p>
 * 
 * @author 何培赟
 * @date 2018年7月10日
 */
@RequestMapping(value = "talent")
@Controller
public class talentController {

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private talentService talentService;

	

	/**
	 * 
	 * Description: 保存简历
	 * 
	 * @author 何培赟
	 * @param talent
	 * @return
	 */
	@RequestMapping(value = "/saveResume")
	@ResponseBody
	public Json saveResume() {
		Json j = new Json();
		String name = req.getParameter("name");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String address = req.getParameter("address");
		String birth = req.getParameter("birth")+" 00:00:00";
		Date birth1 = DateUtil.parseStrToDate(birth, "yyyy-MM-dd HH:mm:ss");
		String email = req.getParameter("email");
		String introduce = req.getParameter("introduce");
		String major = req.getParameter("major");
		String resume = req.getParameter("resume");
		String school = req.getParameter("school");
		String tel = req.getParameter("tel");
		String xueli = req.getParameter("xueli");
		String openid = req.getParameter("openid");
		if (EmptyUtils.checkStrNotNull(name) && EmptyUtils.checkStrNotNull(tel) && EmptyUtils.checkStrNotNull(email)
				&& EmptyUtils.checkStrNotNull(school) && EmptyUtils.checkStrNotNull(major)) {
			try {
				talent t = new talent();
				t.setAddress(address);
				t.setBirth(birth1);
				t.setEmail(email);
				t.setIntroduce(introduce);
				t.setOpenid(openid);
				t.setMajor(major);
				t.setName(name);
				t.setResume(resume);
				t.setSchool(school);
				t.setSex(sex);
				t.setTel(tel);
				t.setXueli(xueli);
				talentService.saveResume(t);
				j.setMsg("保存成功");
				j.setSuccess(true);
				return j;
			} catch (Exception e) {
				j.setMsg("系统异常！！");
				j.setSuccess(false);
				return j;
			}
		} else {
			j.setMsg("请不要输入空值！！");
			j.setSuccess(false);
			return j;
		}
	}

	/**
	 * 
	 * Description: 根据wxid读取简历
	 * 
	 * @author 何培赟
	 * @param talent
	 * @return
	 */
	public talent getResume(String wxid) {
		return null;
	}

	/**
	 * 
	 * Description: 获取所有简历
	 * 
	 * @author 何培赟
	 * @param
	 * @return
	 */
	public List<talent> getAll() {
		return null;
	}

	/**
	 * 
	 * Description: 获取软件的openid和sessionkey
	 * 
	 * @author 何培赟
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getOpenid")
	@ResponseBody
	public openAndSession getOpenid() {
		String code = req.getParameter("code");
		String openid = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session", true, "appid", Const.appid, "secret",
				Const.secret, "js_code", code, "grant_type", "authorization_code").body();
		String session = openid.split(",")[0];
		session = session.substring(1, session.length()).split(":")[1];
		openid = openid.split(",")[1].substring(0, openid.split(",")[1].length() - 1).split(":")[1];
		openAndSession o = new openAndSession();
		o.setOpenid(openid);
		o.setSession_key(session);
		return o;
	}

}
