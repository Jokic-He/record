package com.sunwin.sys.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sunwin.sys.entity.Department;

/**
 * 获取树
 * 
 * @author as 何
 * 
 */
@Component
public class GetDepartment {

	/**
	 * 组装树
	 * 
	 * @param roottrees
	 *            所有节点
	 * @return
	 */
	public List<Department> getTrees(List<Department> roottrees) {

		List<Department> trees1 = new ArrayList<Department>();
		// List<Department> trees2=new ArrayList<Department>();
		// List<Department> trees3=new ArrayList<Department>();

		// 获取所有1级菜单
		// for(Department tree1:roottrees){
		// if("1".equals(tree1.getLevel())){
		// trees1.add(tree1);
		// for(Department tree2:roottrees){
		// if("2".equals(tree2.getLevel()) &&
		// tree2.getParentid().equals(tree1.getId())){
		// trees2.add(tree2);
		// for(Department tree3:roottrees){
		// if("3".equals(tree3.getLevel()) &&
		// tree3.getParentid().equals(tree2.getId())){
		// trees3.add(tree3);
		// }
		// }
		// tree2.setChildren(trees3);
		// }
		// }
		// tree1.setChildren(trees2);
		// }
		// }

		// 获取1级菜单
		for (Department d : roottrees) {
			if ("1".equals(d.getLevel())) {
				trees1.add(d);
				d.setChildren(getChild(d.getId(), roottrees));
			}
		}
		return trees1;
	}

	/**
	 * 查找子节点的方法
	 * 
	 * @param id
	 *            上级节点的id
	 * @param roottree
	 *            所有子节点
	 * @return
	 */
	public List<Department> getChild(String id, List<Department> roottree) {
		int level = 5;
		// 寻找父节点id对应的等级
		for (Department d : roottree) {
			if (d.getId().equals(id)) {
				level = Integer.parseInt(d.getLevel());
				break;
			}
		}
		// 如何父节点为5，直接返回null
		if (level == 5) {
			return null;
		}
		// 最终结果
		List<Department> child = new ArrayList<Department>();
		// 将所有子节点存入集合
		for (Department d : roottree) {
			if (d.getParentid().equals(id)) {
				d.setChildren(getChild(d.getId(), roottree));
				child.add(d);
			}
		}
		if (child.size() == 0) {
			return null;
		}
		return child;

	}

}
