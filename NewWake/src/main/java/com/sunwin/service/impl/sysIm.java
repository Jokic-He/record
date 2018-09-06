package com.sunwin.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunwin.dao.baseDaoI;
import com.sunwin.model.TRole;
import com.sunwin.model.TUser;
import com.sunwin.pageModel.User;
import com.sunwin.service.sysI;
import com.sunwin.tools.EmptyUtils;
import com.sunwin.tools.JiamiUtil;

@Service("sysI")
public class sysIm implements sysI {

	@Autowired
	private baseDaoI<TUser> baseDaoI;

	@Transactional
	public User findUserByUsername(String username) {
		if (EmptyUtils.checkStrNotNull(username)) {
			Map<String, Object> param = new HashMap<String, Object>();
			String hql = "from TUser where username=?1  ";
			param.put("1", username);
			TUser t = baseDaoI.get(hql, param);
			if (t != null) {
				User user = new User();
				BeanUtils.copyProperties(t, user);
				if(t.getRoleId()!=null){
				  user.setRoleId(t.getRoleId().getId());
				}
				return user;
			}
		}
		return null;
	}

	@Transactional
	public User findUserByUsernameAndPassword(String username, String password) {
		if (EmptyUtils.checkStrNotNull(username) && EmptyUtils.checkStrNotNull(password)) {
			Map<String, Object> param = new HashMap<String, Object>();
			String hql = "from TUser where username=?1 and password=?2 ";
			param.put("1", username);
			param.put("2", password);
			TUser t = baseDaoI.get(hql, param);
			if (t != null) {
				User user = new User();
				BeanUtils.copyProperties(t, user);
				return user;
			}
		}
		return null;
	}

	@Transactional
	public void add(User user) {
		if (EmptyUtils.checkStrNotNull(user.getUsername()) && EmptyUtils.checkStrNotNull(user.getPassword())) {
			TUser t1 = new TUser();
			BeanUtils.copyProperties(user, t1);
			t1.setId(UUID.randomUUID().toString().replace("-", ""));
			String hql = "from TUser where username=?3";
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("3", user.getUsername());
			TUser t2 = baseDaoI.get(hql, param);
			if (t2 == null) {
				t1.setPassword(JiamiUtil.generate(t1.getPassword()));
				baseDaoI.save(t1);
			}
		}

	}

	@Transactional
	public void update(User user) {
		if (EmptyUtils.checkStrNotNull(user.getUsername()) && EmptyUtils.checkStrNotNull(user.getPassword())) {
			TUser t = new TUser();
			BeanUtils.copyProperties(user, t);
			baseDaoI.update(t);
		}
	}

	@Transactional
	public void deleteById(int id) {
		TUser t = baseDaoI.findById(TUser.class, id);
		baseDaoI.delete(t);
	}

	public void correlationRoles(String userId, String roleIds) {
		// TODO Auto-generated method stub

	}

	public void uncorrelationRoles(String userId, String roleIds) {
		// TODO Auto-generated method stub

	}

	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void updateRole(String userId, TRole role) {
		TUser user = baseDaoI.findById(TUser.class, userId);
		user.setRoleId(role);
		baseDaoI.save(user);
	}


}
