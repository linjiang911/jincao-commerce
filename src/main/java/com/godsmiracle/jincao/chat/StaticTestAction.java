package com.godsmiracle.jincao.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godsmiracle.jincao.adminuser.AdminUserServiec;
import com.godsmiracle.jincao.common.util.CommonResp;
import com.godsmiracle.jincao.pub.bsc.dao.po.AdminUser;

@Controller
@RequestMapping(value="staticTestAction",produces={"text/json;charset=UTF-8"})
public class StaticTestAction {
	
	private Class<?> poc=AdminUser.class;
	@Autowired
	private AdminUserServiec adminUserServiec;
	
	@ResponseBody
	@RequestMapping(value="test")
	public String login() throws Exception{
		StaticTest.b=12;
		return CommonResp.buildSuccessResp().toJsonString();
	}
	@ResponseBody
	@RequestMapping(value="test1")
	public String login1() throws Exception{
		int c=StaticTest.b;
		return CommonResp.buildSuccessResp(c).toJsonString();
	}
}