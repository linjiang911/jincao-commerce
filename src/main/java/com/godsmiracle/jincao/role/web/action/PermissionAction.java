package com.godsmiracle.jincao.role.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godsmiracle.jincao.common.util.CommonResp;
import com.godsmiracle.jincao.pub.bsc.dao.po.Permission;
import com.godsmiracle.jincao.role.PermissionService;

@Controller
@RequestMapping(value="permissionAction",produces={"text/json;charset=UTF-8"})
public class PermissionAction {
	
	@Autowired
	private PermissionService permissionService;
	
	@ResponseBody
	@RequestMapping(value="all")
	public String all() throws Exception{
		List<Permission> permissionALL = permissionService.findALL();
		return CommonResp.buildSuccessResp(permissionALL).toJsonString();
	}
	
}
