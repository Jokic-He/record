package com.sunwin.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunwin.dao.baseDaoI;
import com.sunwin.model.TPermission;
import com.sunwin.model.TRole;
import com.sunwin.model.TRole_Permission;
import com.sunwin.pageModel.Role;
import com.sunwin.service.permissionI;
import com.sunwin.tools.EmptyUtils;

@Service("perI")
@Transactional
public class permissionIm implements permissionI {

	@Autowired
	private baseDaoI<TRole> dao;

	@Autowired
	private baseDaoI<TPermission> pdao;

	@Autowired
	private baseDaoI<TRole_Permission> tpdao;

	public void deletePermission(String permissionId) {
		// TODO Auto-generated method stub

	}

	public void createRole(TRole role) {
		dao.save(role);
	}

	public void deleteRole(String roleId) {
		// TODO Auto-generated method stub

	}

	public void correlationPermissions(String roleId, String permissionIds) {
		// TODO Auto-generated method stub

	}

	public void uncorrelationPermissions(String roleId, String permissionIds) {
		// TODO Auto-generated method stub

	}

	public List<Role> getRoles() {
		List<TRole> troles = dao.find("from TRole");
		List<Role> roles = new ArrayList<Role>();
		Role role = null;
		for (TRole t : troles) {
			role = new Role();
			BeanUtils.copyProperties(t, role);
			roles.add(role);
		}
		return roles;
	}

	public TRole findRoleById(String id) {
		TRole t = dao.findById(TRole.class, id);
		return t;
	}

	public void createPermission(Role role) {
		TPermission tp = new TPermission();
		tp.setId(UUID.randomUUID().toString().replace("-", ""));
		tp.setPname(role.getPname());
		tp.setPermission(role.getPermission());
		tp.setAvailable(true);
		pdao.save(tp);
		this.fuyuquanxian(role, tp);
	}

	public void fuyuquanxian(Role role, TPermission tp) {
		TRole_Permission trp = new TRole_Permission();
		if (EmptyUtils.checkStrNotNull(role.getRole())) {
			TRole t = new TRole();
			t = dao.findById(TRole.class, role.getRole());
			trp.setRoles(t);
			trp.setPermissions(tp);
			tpdao.save(trp);

		}

	}

	public Set<TPermission> getPermissions(String roleid) {
		try {
			String hql = "from TRole_Permission t where t.roles='"+roleid+"'";
			List<TRole_Permission> list = tpdao.find(hql);
//			List<TRole_Permission> list = tpdao.find("from TRole_Permission");
			Set<TPermission> tps = new HashSet<TPermission>();
			for (TRole_Permission trp : list) {
				tps.add(trp.getPermissions());
			}
			return tps;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
