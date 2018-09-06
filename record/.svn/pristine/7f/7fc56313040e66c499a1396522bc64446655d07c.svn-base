package com.sunwin.sys.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwin.sys.dao.sysDao;
import com.sunwin.sys.entity.Department;
import com.sunwin.sys.entity.Permission;
import com.sunwin.sys.entity.Role;
import com.sunwin.sys.entity.User;
import com.sunwin.sys.entity.role_permission;
import com.sunwin.sys.utils.DateUtil;
import com.sunwin.sys.utils.EmptyUtils;
import com.sunwin.sys.utils.GetDepartment;
import com.sunwin.sys.utils.JiamiUtil;

/**
 * 
 * 
 * <p>
 * Description: 系统方法类
 * </p>
 * 
 * @author 何培赟
 * @date 2018年6月21日
 */
@Service(value = "loginService")
public class LoginService {

	@Autowired
	private sysDao sysDao;

	@Autowired
	GetDepartment getDepartment;

	@Autowired
	private SessionDAO sessionDAO;

	// 注册
	public int sign(User user) {
		try {
			user.setId(UUID.randomUUID().toString().replace("-", ""));
			String password = user.getPassword();
			user.setPassword(JiamiUtil.generate(password));
			user.setCreateDate(new Date());
			user.setState(2);
			sysDao.signup(user);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 2;
		}
	}

	// 登陆(验证用户名密码)
	public User login(User user) {
		try {
			if (EmptyUtils.checkStrNotNull(user.getUsername()) && EmptyUtils.checkStrNotNull(user.getPassword())) {
				User loginUser = sysDao.getUserByName(user.getUsername());
				if (JiamiUtil.verify(user.getPassword(), loginUser.getPassword())) {
					return loginUser;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// 根据用户名验证用户名是否重复
	public boolean checkUsername(User user) {
		User loginUser = sysDao.getUserByName(user.getUsername());
		if (loginUser == null) {
			return true;
		}
		return false;
	}

	// 根据用户的roleid获取权限集合
	public Set<String> getPermissions(String roleid) {
		try {
			if (roleid != null) {
				Set<String> permissions = new HashSet<String>();
				List<role_permission> rplist = sysDao.findPermissionByRoleid(roleid);
				if (rplist.size() > 0 && rplist != null) {
					List<String> ls = new ArrayList<String>();
					for (role_permission rp : rplist) {
						ls.add(rp.getPermissionId());
					}
					List<Permission> lps = sysDao.findPermissionByIds(ls);
					for (Permission p : lps) {
						permissions.add(p.getPermission());
					}
				}
				return permissions;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	// 获取所有部门
	public List<Department> getDepartment() {
		List<Department> list = new ArrayList<Department>();
		list = sysDao.findAllDepartment();
		return list;
	}

	// 获取所有非5级部门
	public List<Department> getDepartmentEx5() {
		List<Department> list = new ArrayList<Department>();
		list = sysDao.findAllDepartmentEx5();
		return list;
	}

	// 获取所有用户
	public List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		list = sysDao.getUsers();
		String str = "";
		for (User u : list) {
			str = "坐席";
			if (EmptyUtils.checkStrNotNull(u.getRoleId())) {
				if (u.getRoleId().equals("00713dc3274b45d990f8bd947bf4d8ff")) {
					str = "管理员";
				}
				if (u.getRoleId().equals("0ca7e94dfd0b41bc852d3f9f3a8af5e7")) {
					str = "班长";
				}
			}
			u.setRoleId(str);
		}
		return list;
	}

	// 退出登录改变登录状态
	public void updateLogin(String id, String state, Date date) {
		sysDao.updateLogin(id, state, date);
	}

	// 获取虚拟路径地址
	public String getUrl() {
		return sysDao.getUrl();
	}

	// 修改用户信息
	public int modifyUser(User user) {
		String password = "";
		if (user != null && EmptyUtils.checkStrNotNull(user.getId())) {
			password = JiamiUtil.generate(user.getPassword());
			sysDao.modifyUser(user.getId(), user.getUsername(), password, user.getDepartment());
			return 1;
		} else {
			return 2;
		}
	}

	// 删除用户
	public String deleteUser(String id) {
		if (EmptyUtils.checkStrNotNull(id)) {
			sysDao.deleteUser(id);
			return "删除成功";
		} else if (!EmptyUtils.checkStrNotNull(id)) {
			return "请选择一条数据。。。";
		}
		return "删除失败，系统异常";

	}

	// 组装树
	public List<Department> getDepartments() {
		List<Department> roottree = sysDao.findAllDepartment();
		List<Department> trees = getDepartment.getTrees(roottree);
		return trees;
	}

	// 获取在线坐席数量
	public int getOnline() {
		return sysDao.getOnline();
	}

	// 获取非删除用户数量
	public int getUpline() {
		return sysDao.getUpLine();
	}

	/**
	 * 
	 * Description: 检测是否超时
	 * 
	 * @author 何培赟
	 * @return
	 */
	public boolean checkTimeout(String id) {
		Date nowtime = new Date();
		Date lasttime = sysDao.getLastLogin(id);
		if (DateUtil.getDistanceTimestamp(lasttime, nowtime) > 10000) {
			return true;
		}
		return false;
	}

	// 更新用户最后在线时间
	public void updateOnline(String id, Date date) {
		try {
			sysDao.updateLastLogin(id, date);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 获取在线用户数量
	public int getOnlines() {
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		return sessions.size();
	}

	// 创建一个部门
	public void createD(Department d) {
		try {
			d.setId(UUID.randomUUID().toString().replace("-", ""));
			if (EmptyUtils.checkStrNotNull(d.getParentid())) {
				d.setLevel(Integer.parseInt(sysDao.findDepartmentById(d.getParentid()).getLevel()) + 1 + "");
			} else {
				d.setLevel("1");
			}
			d.setState(0);
			sysDao.addDepartment(d);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 查询所有角色
	public List<Role> getRoles() {
		try {
			List<Role> roles = new ArrayList<Role>();
			roles = sysDao.getRoles();
			if (EmptyUtils.checkListNotNull(roles)) {
				return roles;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
