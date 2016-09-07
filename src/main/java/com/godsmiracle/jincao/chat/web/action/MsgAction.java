package com.godsmiracle.jincao.chat.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.godsmiracle.jincao.common.util.Sessions;
import com.godsmiracle.jincao.pub.bsc.dao.po.Chat;
import com.godsmiracle.jincao.pub.bsc.dao.po.User;
import com.godsmiracle.jincao.user.UserServiec;
import com.godsmiracle.jincao.web.socket.MyWebSocketHandler;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(value="msgAction",produces={"text/json;charset=UTF-8"})
public class MsgAction {

	@Autowired
	private MyWebSocketHandler handler;
	@Autowired
	private UserServiec userServiec;
	Map<Integer, User> users = new HashMap<Integer, User>();

	// 模拟一些数据
	@ModelAttribute
	public void setReqAndRes() {
		User u1 = new User();
		u1.setUserId(1);
		u1.setName("张三");
		users.put(u1.getUserId(), u1);

		User u2 = new User();
		u2.setUserId(1);
		u2.setName("李四");
		users.put(u2.getUserId(), u2);

	}

	// 用户登录
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(Integer id,HttpServletRequest request,HttpSession session) {
		User user = userServiec.findOneFrist("userId", id);
		Sessions.setLoginedUser(user, session);
		request.getSession().setAttribute("uid", user.getUserId());
		request.getSession().setAttribute("name", user.getName());
		return "redirect:talk.jsp";
	}

	// 跳转到交谈聊天页面
	@RequestMapping(value = "talk", method = RequestMethod.GET)
	public ModelAndView talk() {
		return new ModelAndView("talk.jsp");
	}

	// 跳转到发布广播页面
	@RequestMapping(value = "broadcast", method = RequestMethod.GET)
	public ModelAndView broadcast() {
		return new ModelAndView("broadcast");
	}

	// 发布系统广播（群发）
	@ResponseBody
	@RequestMapping(value = "broadcast", method = RequestMethod.POST)
	public void broadcast(String text) throws IOException {
		Chat msg = new Chat();
		msg.setDtCreate(System.currentTimeMillis());
		msg.setFrom(1);
		msg.setFromName("系统广播");
		msg.setTo(2);
		msg.setText(text);
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

}