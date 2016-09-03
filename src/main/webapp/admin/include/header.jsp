<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="navbar clearfix" id="header">
	<div class="container">
		<div class="navbar-brand">
			<!-- COMPANY LOGO -->
			<a href="index.html">
				<img src="../img/logo/logo.png" alt="Cloud Admin Logo" class="img-responsive" height="30" width="120">
			</a>
			<!-- /COMPANY LOGO -->
			<!-- SIDEBAR COLLAPSE -->
			<div id="sidebar-collapse" class="sidebar-collapse btn">
				<i class="fa fa-bars" 
					data-icon1="fa fa-bars" 
					data-icon2="fa fa-bars" ></i>
			</div>
			<!-- /SIDEBAR COLLAPSE -->
		</div>
		<!-- BEGIN TOP NAVIGATION MENU -->					
		<ul class="nav navbar-nav pull-right">
			<!-- BEGIN USER LOGIN DROPDOWN -->
			<li class="dropdown user" id="header-user">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<img alt="" src="../img/avatars/avatar3.jpg" />
					<span class="username">${sessionScope.loginedUser.account}</span>
					<i class="fa fa-angle-down"></i>
				</a>
				<ul class="dropdown-menu">
					<li><a href=admin_user_update_my_pwd.jsp><i class="fa fa-key"></i> 修改我的密码</a></li>
					<li><a href="#" ng-click="logout()"><i class="fa fa-power-off"></i> 退出</a></li>
				</ul>
			</li>
			<!-- END USER LOGIN DROPDOWN -->
		</ul>
		<!-- END TOP NAVIGATION MENU -->
	</div>
</header>