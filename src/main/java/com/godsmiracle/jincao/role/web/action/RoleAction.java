package com.godsmiracle.jincao.role.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godsmiracle.jincao.common.util.CommonResp;
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
	@RequestMapping(value="add")
	public String login(@RequestParam("PermissionId[]")int[] PermissionIds ,String name,String describe) throws Exception{
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
	
}
