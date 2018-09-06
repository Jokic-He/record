package com.sunwin.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author as hepieyun
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sunwin.model.TPermission;
import com.sunwin.model.TRole;
import com.sunwin.pageModel.Mail;
import com.sunwin.pageModel.Role;
import com.sunwin.pageModel.User;
import com.sunwin.service.permissionI;
import com.sunwin.service.sysI;
import com.sunwin.tools.Const;
import com.sunwin.tools.EmptyUtils;
import com.sunwin.tools.JiamiUtil;
import com.sunwin.tools.Json;
import com.sunwin.tools.MailSend;

@Controller
public class sysController {

	@Autowired
	private sysI sysI;

	@Autowired
	private permissionI perI;

	@RequestMapping(value = { "/", "login" })
	public ModelAndView login() {
		try {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/sys/login");
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping(value = "toZhuce")
	public ModelAndView toZhuce() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/zhuce");
		return mv;
	}

	@RequestMapping(value = "toWake")
	public ModelAndView toWake() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/wake/wakeup");
		return mv;
	}

	@RequestMapping(value = "/zhuce")
	@ResponseBody
	public Json zhuce(User user) {
		Json j = new Json();
		if (EmptyUtils.checkStrNotNull(user.getUsername()) && EmptyUtils.checkStrNotNull(user.getPassword())) {
			sysI.add(user);
			j.setSuccess(true);
			j.setMsg("注册成功");
			return j;
		} else {
			j.setSuccess(false);
			j.setMsg("注册失败");
			return j;
		}
	}

	@RequestMapping(value = "/toLogin")
	@ResponseBody
	public Json toLogin(User user, HttpServletRequest req, HttpServletResponse res) {
		Json j = new Json();
		Set<String> permissions=new HashSet<String>();
		if (EmptyUtils.checkStrNotNull(user.getUsername()) && EmptyUtils.checkStrNotNull(user.getPassword())) { // &&
			User loginUser = sysI.findUserByUsername(user.getUsername());
			Session s = SecurityUtils.getSubject().getSession();
			if (loginUser != null && JiamiUtil.verify(user.getPassword(), loginUser.getPassword())) {
				try {
					j.setSuccess(true);
					HttpSession session = req.getSession();
					session.setAttribute("user", loginUser);
					s.setAttribute(Const.SESSION_USER, loginUser);
					s.setAttribute(Const.SESSION_USER_ID, loginUser.getId());
					//赋予权限
					Set<TPermission> tps=perI.getPermissions(loginUser.getRoleId());
					for(TPermission tp:tps){
						permissions.add(tp.getPermission());
						System.out.println(tp.getPermission());
					}
					s.setAttribute(Const.ROLE, permissions);
					Subject subject = SecurityUtils.getSubject();
					UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

					try {
						subject.login(token);
						token.setRememberMe(true);
						j.setSuccess(true);
						j.setMsg("登录成功");
					} catch (Exception e) {
						j.setSuccess(false);
						j.setMsg("身份认证验证错误!");
						System.out.println(e);
					}

				} catch (Exception e) {
					j.setSuccess(false);
					j.setMsg("登陆失败");
				}
			} else {
				j.setSuccess(false);
				j.setMsg("密码错误!");
			}
		} else {
			j.setSuccess(false);
			j.setMsg("密码错误!");
		}

		return j;

	}

	// 退出登录
	@RequestMapping(value = "/loginOut")
	public ModelAndView loginOut() {
		ModelAndView mv = new ModelAndView();
		try {

			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
			mv.setViewName("/sys/login");
			return mv;

		} catch (Exception e) {

			mv.setViewName("/sys/login");
			return mv;

		}
	}

	// 发送邮件
	@RequestMapping(value = "/send")
	@ResponseBody
	public Json send(Mail mail) {
		// 发送0代表失败，1代表成功
		Json json = new Json();
		MailSend ms = new MailSend();
		try {
			ms.send(mail);
			json.setSuccess(true);
			json.setMsg("发送成功");
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return json;
		}
	}

	@RequestMapping(value = "/to500")
	public ModelAndView to500() {
		try {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/sys/500");
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping(value = "/personal.do")
	public ModelAndView personal() {
		try {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/sys/personal");
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping(value = "toGetRoles.do")
	@ResponseBody
	public List<Map<String, String>> toGetRoles() {
		List<Role> roles = perI.getRoles();
		Map<String, String> map = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Role s : roles) {
			map = new HashMap<String, String>();
			map.put("valueField", s.getId());
			map.put("textField", s.getRoleName());
			list.add(map);
		}
		return list;
	}

	@RequestMapping(value = "/addRole")
	@ResponseBody
	public Json addRole(Role role) {
		Json j = new Json();
		if (role != null) {
			TRole t = new TRole();
			t.setRoleName(role.getRoleName());
			t.setDescription(role.getDescription());
			t.setAvailable(true);
			t.setId(UUID.randomUUID().toString().replace("-", ""));
			try {
				perI.createRole(t);
				j.setMsg("添加成功");
				j.setSuccess(true);
				return j;
			} catch (Exception e) {
				j.setMsg("添加失败");
				j.setSuccess(false);
				System.out.println(e);
				return j;
			}
		} else {
			j.setMsg("添加失败");
			j.setSuccess(false);
			return j;

		}

	}

	// 更改用户角色
	@RequestMapping(value = "/useRole")
	@ResponseBody
	public boolean useRole(HttpServletRequest req) {
		String roleid = (String) req.getParameter("role");
		User user = (User) req.getSession().getAttribute("user");
		try {
			TRole tr=perI.findRoleById(roleid);
			sysI.updateRole(user.getId() + "", tr);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	//添加并赋予角色权限
	@RequestMapping(value="/addPer")
	@ResponseBody
	public boolean addPer(Role role){
		try{
			
			perI.createPermission(role);
			return true;
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	//跳转到角色权限测试界面
	@RequestMapping(value="/toRp")
	public ModelAndView toRp(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/sys/testRp");
		return mv;
	}

}
