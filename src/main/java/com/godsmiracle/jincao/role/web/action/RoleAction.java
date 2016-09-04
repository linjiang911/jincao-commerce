package com.godsmiracle.jincao.role.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godsmiracle.jincao.common.util.BackendErrorCode;
import com.godsmiracle.jincao.common.util.CommonResp;
import com.godsmiracle.jincao.pub.bsc.dao.po.Permission;
import com.godsmiracle.jincao.pub.bsc.dao.po.Role;
import com.godsmiracle.jincao.pub.bsc.dao.po.RolePermission;
import com.godsmiracle.jincao.role.PermissionService;
import com.godsmiracle.jincao.role.RolePermissionService;
import com.godsmiracle.jincao.role.RoleService;

@Controller
@RequestMapping(value="roleAction",produces={"text/json;charset=UTF-8"})
public class RoleAction {
	
	private Class<?> poc=Role.class;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@ResponseBody
	@RequestMapping(value="see")
	public String see(Integer roleId) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Role role = roleService.findOneFrist("roleId", roleId);
		List<Role> roleAll = roleService.findALL();
		List<Permission> permissionList = permissionService.findALLByHQL("From Permission p where p.permissionId in (select rp.permissionId From RolePermission rp where rp.roleId=?)", roleId);
		List<Permission> permissionALL = permissionService.findALL();
		map.put("roleAll", roleAll);
		map.put("role", role);
		map.put("permissionList", permissionList);
		map.put("permissionALL", permissionALL);
		return CommonResp.buildSuccessResp(map).toJsonString();
	}
	@ResponseBody
	@RequestMapping(value="add")
	public String add(@RequestParam("PermissionId[]")int[] PermissionIds ,String name,String describe) throws Exception{
		Role role = new Role();
		role.setName(name);
		role.setDescr(describe);
		String uuid=UUID.randomUUID().toString();
		role.setUuid(uuid);
		roleService.sava(role);
		Role roleUuid = roleService.findOneFrist("uuid", uuid);
		Integer roleId = roleUuid.getRoleId();
		List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
		for(int PermissionId:PermissionIds ){
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(PermissionId);
			rolePermissionList.add(rolePermission);
		}
		rolePermissionService.saveAll(rolePermissionList);
		return CommonResp.buildSuccessResp().toJsonString();
	}
	
	@ResponseBody
	@RequestMapping(value="remove")
	public String remove(int id) throws Exception{
		Role role = roleService.findOneFrist("roleId", id);
		if(role==null){
			return CommonResp.buildErrorResp(BackendErrorCode.DATA_EXCEPTION).toJsonString();
		}
		List<RolePermission> rolePermissionLst = rolePermissionService.findALLByHQL("From RolePermission where roleId=?", id);
		if(rolePermissionLst.size()>0){
			rolePermissionService.removeAll(rolePermissionLst);
		}
		roleService.remove(role);
		return CommonResp.buildSuccessResp().toJsonString();
	}
	@ResponseBody
	@RequestMapping(value="update")
	public String update(@RequestParam("permissionIds[]")Integer[] permissionIds,@RequestParam("id")Integer[] ids,String name,String oper,String descr) throws Exception{
		if("del".equals(oper)){
			List<Role> roleList = new ArrayList<>();
			for(int id:ids){
				Role role = roleService.findOneFrist("roleId", id);
				roleList.add(role);
				List<RolePermission> rolePermissionLst = rolePermissionService.findALLByHQL("From RolePermission where roleId=?", id);
				rolePermissionService.removeAll(rolePermissionLst);
			}
			roleService.removeAll(roleList);
			return CommonResp.buildSuccessResp("删除成功").toJsonString();
		}
		if("edit".equals(oper)){
			List<Role> roleList = new ArrayList<>();
			for(int id:ids){
				Role role = roleService.findOneFrist("roleId", id);
				role.setDescr(descr);
				role.setName(name);
				roleList.add(role);
				List<RolePermission> rolePermissionList1 = rolePermissionService.findALLByHQL("From RolePermission where roleId=?", id);
				rolePermissionService.removeAll(rolePermissionList1);
				List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
				for(int permissionId:permissionIds ){
					RolePermission rolePermission = new RolePermission();
					rolePermission.setRoleId(id);
					rolePermission.setPermissionId(permissionId);
					rolePermissionList.add(rolePermission);
				}
				rolePermissionService.saveAll(rolePermissionList);
			}
			roleService.updateAll(roleList);
			return CommonResp.buildSuccessResp("修改成功").toJsonString();
		}
		return CommonResp.buildSuccessResp().toJsonString();
	}
	@ResponseBody
	@RequestMapping(value="all")
	public String all() throws Exception{
		List<Object> list=new ArrayList<>();
		List<Role> roleList = roleService.findALL();
		for(Role r:roleList){
			Map<String, Object> map=new HashMap<String, Object>();
			Integer roleId = r.getRoleId();
			List<Permission> permissionList = permissionService.findALLByHQL("From Permission p where p.permissionId in (select rp.permissionId From RolePermission rp where rp.roleId=?)", roleId);
			String[] permissionNames=new String[permissionList.size()];
			for(int i=0;i<permissionList.size();i++){
				permissionNames[i]=permissionList.get(i).getName();
			}
			map.put("permissionNames", permissionNames);
			map.put("id", r.getId());
			map.put("roleId", r.getRoleId());
			map.put("descr", r.getDescr());
			map.put("name", r.getName());
			list.add(map);
		}
		
		return CommonResp.buildSuccessResp(list).toJsonString();
	}
	
	@ResponseBody
	@RequestMapping(value="addall")
	public String addall() throws Exception{
		List<Role> roleList = roleService.findALL();
		for(int i=0;i<1000;i++){
			Role role = new Role();
			role.setDescr("dsad"+i);
			role.setName("dsasd"+i+i);
			roleList.add(role);
		}
		roleService.saveAll(roleList);
		return CommonResp.buildSuccessResp().toJsonString();
	}
}
