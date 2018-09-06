package com.sunwin.sys.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sunwin.sys.entity.Department;
import com.sunwin.sys.entity.Page;
import com.sunwin.sys.entity.Role;
import com.sunwin.sys.entity.State;
import com.sunwin.sys.entity.User;
import com.sunwin.sys.service.LoginService;
import com.sunwin.sys.utils.Const;
import com.sunwin.sys.utils.EmptyUtils;
import com.sunwin.sys.utils.Json;

/**
 * 
 * 
 * <p>
 * Description: 系统控制类
 * </p>
 * 
 * @author 何培赟
 * @date 2018年6月21日
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = { "/", "login" })
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/login");
		return mv;
	}

	@RequestMapping(value = "toSign")
	public ModelAndView toSign() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/signup");
		return mv;
	}

	@RequestMapping(value = "toLogin")
	@ResponseBody
	public Json toLogin(User user, HttpServletRequest req, HttpServletResponse res) {
		Json json = new Json();
		Set<String> permissions;
		String url;
		try {
			if (EmptyUtils.checkStrNotNull(user.getUsername()) && EmptyUtils.checkStrNotNull(user.getPassword())) {
				User loginUser = loginService.login(user);
				Session s = SecurityUtils.getSubject().getSession();
				if (loginUser != null) {
					HttpSession session = req.getSession();
					url = loginService.getUrl();
					session.setAttribute("user", loginUser);
					session.setAttribute("url", url);
					s.setAttribute(Const.SESSION_USER, loginUser);
					permissions = loginService.getPermissions(loginUser.getRoleId());
					s.setAttribute(Const.PERMISSIONS, permissions);
					Subject subject = SecurityUtils.getSubject();
					UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
					try {
						subject.login(token);

						token.setRememberMe(true);
						loginService.updateLogin(loginUser.getId(), "1", new Date());
						loginUser.setLastLoginDate(new Date());
						json.setSuccess(true);
						json.setMsg("登录成功");
						return json;
					} catch (Exception e) {
						json.setSuccess(false);
						json.setMsg("身份认证验证错误!");
						System.out.println(e);
						return json;
					}
				} else {
					json.setMsg("用户名或密码错误");
					json.setSuccess(false);
					return json;
				}
			} else {
				json.setMsg("请输入规定的用户名和密码");
				json.setSuccess(false);
				return json;
			}
		} catch (Exception e) {
			json.setMsg("系统异常请联系管理员");
			json.setSuccess(false);
			return json;
		}
	}

	@RequestMapping(value = "toMain")
	@RequiresAuthentication
	public ModelAndView toMain() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/main");
		return mv;
	}

	@RequestMapping(value = "toOtherSetting")
	@RequiresAuthentication
	public ModelAndView toOtherSetting() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/otherSetting");
		return mv;
	}

	@RequestMapping(value = "toSetting")
	public ModelAndView toSetting() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/setting");
		return mv;
	}

	@RequestMapping(value = "toState")
	public ModelAndView toState() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/state");
		return mv;
	}

	@RequestMapping(value = "toUser")
	public ModelAndView toUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/user");
		return mv;
	}

	@RequestMapping(value = "toAddD")
	public ModelAndView toAddD() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/department");
		return mv;
	}

	@RequestMapping(value = "toDepartment")
	public ModelAndView toDepartment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/DepartmentSetting");
		return mv;
	}

	// 用户注册
	@RequestMapping(value = "Sign")
	@ResponseBody
	public Json Sign(User user) {
		Json json = new Json();
		if (user != null) {
			int i;
			if (loginService.checkUsername(user)) {
				// if (true) {
				i = loginService.sign(user);
				if (i == 1) {
					json.setSuccess(true);
					json.setMsg("注册成功");
					return json;
				} else {
					json.setMsg("注册失败，系统异常");
					json.setSuccess(false);
					return json;
				}
			} else {
				json.setMsg("注册失败，用户名已存在");
				json.setSuccess(false);
				return json;
			}
		} else {
			json.setMsg("注册失败，请输入用户名");
			json.setSuccess(false);
			return json;
		}
	}

	// 获得非5级部门部门
	@RequestMapping(value = "toGetDEx5")
	@ResponseBody
	public Json toGetDEx5() {
		Json j = new Json();
		try {
			List<Department> list = loginService.getDepartmentEx5();
			j.setSuccess(true);
			j.setObj(list);
			return j;
		} catch (Exception e) {
			j.setSuccess(false);
			System.out.println(e);
			return j;
		}
	}

	// 获得部门树
	@RequestMapping(value = "toTreeD")
	@ResponseBody
	public Json toTreeD() {
		Json j = new Json();
		try {
			List<Department> list = loginService.getDepartments();
			j.setSuccess(true);
			j.setObj(list);
			return j;
		} catch (Exception e) {
			j.setSuccess(false);
			System.out.println(e);
			return j;
		}
	}

	// 获得部门
	@RequestMapping(value = "toGetD")
	@ResponseBody
	public Json toGetD() {
		Json j = new Json();
		try {
			List<Department> list = loginService.getDepartment();
			j.setSuccess(true);
			j.setObj(list);
			return j;
		} catch (Exception e) {
			j.setSuccess(false);
			System.out.println(e);
			return j;
		}
	}

	@RequestMapping(value = "toGetR")
	@ResponseBody
	public Json toGetR() {
		Json j = new Json();
		try {
			List<Role> roles = loginService.getRoles();
			j.setSuccess(true);
			j.setObj(roles);
			return j;

		} catch (Exception e) {
			j.setSuccess(false);
			System.out.println(e);
			return j;
		}
	}

	// 创建（修改）一个部门
	@RequestMapping(value = "toAddDeparment")
	@ResponseBody
	public Json toCreateD(Department d) {
		Json j = new Json();
		try {
			loginService.createD(d);
			j.setMsg("创建成功");
			j.setSuccess(true);
			return j;
		} catch (Exception e) {
			j.setMsg("创建失败");
			j.setSuccess(false);
			return j;
		}
	}

	// 获取用户列表
	@RequestMapping(value = "toGetUser")
	@ResponseBody
	public Page toGetUser() {
		List<User> list = loginService.getUsers();
		Page page = new Page();
		page.setCode(0);
		page.setCount(list.size());
		page.setData(list);
		return page;
	}

	// 删除一个用户
	
	@RequestMapping(value = "/deleteUser")
	public String deleteUser(String id) {
		return loginService.deleteUser(id);
	}

	// 退出登录
	@RequestMapping(value = "/loginOut")
	public ModelAndView loginOut(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		try {

			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
			loginService.updateLogin(req.getParameter("id"), "2", new Date());
			mv.setViewName("/sys/login");
			return mv;

		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("/sys/login");
			return mv;

		}
	}

	/**
	 * 
	 * Description: 该方法是返回用户信息修改界面
	 * 
	 * @author 何培赟
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/toPersonal")
	public ModelAndView toPersonal(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		// 判定是否传id，如果传了表示修改他人的信息，没传就是修改自己的
		if (EmptyUtils.checkStrNotNull(req.getParameter("id"))) {
			mv.addObject("id", req.getParameter("id"));
			mv.setViewName("/sys/personal");
		} else {
			mv.setViewName("/sys/personal1");
		}
		return mv;
	}

	// 修改自己的用户信息
	@RequestMapping(value = "/toPersonalMyself")
	public ModelAndView toPersonalMyself(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/sys/personal1");
		return mv;
	}

	// 修改用户
	@RequestMapping(value = "modifyUser")
	@ResponseBody
	public String modifyUser(User user) {
		if (user != null) {
			try {
				int n = loginService.modifyUser(user);
				if (n == 1) {
					return "修改成功";
				}
				return "修改失败";
			} catch (Exception e) {
				System.out.println(e);
				return "系统异常";
			}

		} else {
			return "请输入正确的信息。。";
		}
	}

	// 获取坐席状态图表
	@RequestMapping(value = "getState")
	@ResponseBody
	public List<State> getState() {
		List<State> list = new ArrayList<State>();
		list.add(new State("在线坐席", loginService.getOnlines()));
		list.add(new State("注销坐席", loginService.getUpline() - loginService.getOnlines()));
		return list;
	}

	/**
	 * 
	 * Description: 心跳监听用户登录状态
	 * 
	 * @author 何培赟
	 * @param req
	 */
	@RequestMapping(value = "checkOnline")
	public ModelAndView checkOnline(HttpServletRequest req, HttpServletResponse res) {
		if (EmptyUtils.checkStrNotNull(req.getParameter("id"))) {
			res.setStatus(302);
			ModelAndView mv = new ModelAndView("/sys/login");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value="toYewuluru")
    @ResponseBody
	public ModelAndView toYewu(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/sys/yewuluru");
		return mv;
		
	}
	
	@RequestMapping(value="toYewuchakan")
	@ResponseBody
	public ModelAndView toYewuchakan(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/yeuw/yewuchakan");
		return mv;
		
	}

}
