<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加角色</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css" rel="stylesheet">

    <!-- Morris -->
 	<link rel="shortcut icon" href="favicon.ico"> 
 	<link href="../css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min862f.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="../js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>角色添加 </h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="role_add.jsp">刷新</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form class="fom1 form-horizontal">
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色名</label>

                                <div class="col-sm-10">
                                    <input type="text" name="name" placeholder="输入角色名" class="name form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择权限</label>
                                <div class="province checkbox col-sm-10">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                             <div class="form-group">
                                <label class="col-sm-2 control-label">角色描述</label>

                                <div class="col-sm-10">
                                    <input type="text" name="describe" placeholder="角色描述" class="describe form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <input type="button" class="btn btn-primary" value="提交">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/content.min.js"></script>
    <script src="../js/plugins/iCheck/icheck.min.js"></script>
    <script src="../js/plugins/gritter/jquery.gritter.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="../js/stats.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../js/util.js" ></script>
    <script type="text/javascript" src="../js/jincaoutil.js"></script>
    <script src="../js/plugins/flot/jquery.flot.js"></script>
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    <script src="../js/demo/peity-demo.min.js"></script>
    <script src="../js/content.min.js?v=1.0.0"></script>
    <script src="../js/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="../js/plugins/gritter/jquery.gritter.min.js"></script>
    <script src="../js/plugins/easypiechart/jquery.easypiechart.js"></script>
    <script src="../js/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="../js/demo/sparkline-demo.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$(".btn").click(function(){
    			var name=$(".name").val();
    			var describe=$(".describe").val();
    			var arr=packageCheckboxPath("PermissionId");
    			if(arr.length==0||arr.length<0){
    				showMsg("至少选一个权限");
    				return;
    			}
    			if(!verifys(name,"notNull")){
    				verifyClass(".name","名字不能为空");
    				return;
    			}
    			if(!verifys(describe,"notNull")){
    				verifyClass(".describe","介绍不能为空");
    				return;
    			}
    			var reqdata={
    				"name":name,
    				"describe":describe,
    				"PermissionId":arr
    			};
    			$.post("../api/roleAction/add",reqdata,function(data){
    				if(data.code==0){
    					showMsg("添加成功");
    					refresh(".name",".describe");
    				}
    			});
    		});
    	});
    	function ready(){
    		$.post("../api/permissionAction/all",function(data){
    			for(var i=0;i<data.response.length;i++){
    				addCheckbox(".province",data.response[i].id,data.response[i].name);
    			}
    		});
    	}
    	$(document).ready(function(){
    		  setTimeout(function(){
    			 ready();
    		  }, 500);
    		});
    </script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
</html>

