<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>角色列表</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="favicon.ico">
<link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<!-- jqgrid-->
<link href="../css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">
<!-- Morris -->
<link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.min862f.css" rel="stylesheet">

<!-- Gritter -->
<link href="../js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

<style>
/* Additional style to fix warning dialog position */
#alertmod_table_list_2 {
	top: 900px !important;
}
</style>

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox ">
					<div class="ibox-title">
						<h5>角色列表</h5>
						<div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="role_list.jsp">刷新</a>
                                </li>
                            </ul>
                        </div>
					</div>
					<div class="ibox-content">
						<div class="jqGrid_wrapper">
							<table id="table_list_2"></table>
							<div id="pager_list_2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/plugins/peity/jquery.peity.min.js"></script>
	<script src="../js/plugins/jqgrid/i18n/grid.locale-cnffe4.js"></script>
	<script src="../js/plugins/jqgrid/jquery.jqGrid.minffe4.js"></script>
	<script src="../js/content.min.js"></script>
	<script type="text/javascript" src="../js/stats.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/util.js"></script>
	<script type="text/javascript" src="../js/jincaoutil.js"></script>
	<script>
		function ready() {
			$.post("../api/roleAction/all", function(data) {
				mydata = data.response;
				$.jgrid.defaults.styleUI = "Bootstrap";
				$("#table_list_2").jqGrid({
					data : mydata,
					datatype : "local",
					height : 280,
					autowidth : true,
					shrinkToFit : true,
					rowNum : 20,
					rowList : [ 10, 20, 30 ],
					colNames : [ "操作","角色Id", "角色名", "角色描述","权限"],
					colModel : [ {
						name : "act",
						index : "act",
						width : 75,
						sortable : false,
						editable : false,
						search:false,
					}, {
						name : "roleId",
						index : "roleId",
						editable : true,
						width : 60,
					}, {
						name : "name",
						index : "name",
						editable : true,
						width : 90,
					}, {
						name : "descr",
						index : "descr",
						editable : true,
						width : 100
					},{
						name : "permissionNames",
						index : "permissionNames",
						width : 120,
						sortable : false,
						editable : false,
						search:false
					}],
					gridComplete : function() { 
					var ids = jQuery("#table_list_2").jqGrid('getDataIDs');
					 for ( var i = 0; i < ids.length; i++) { 
					 var cl = ids[i];
					  be = "<input type='button' class='btn btn-primary btn-xs' value='查看' onclick=\"see(" + cl + ");\" />&nbsp;";
					  ce = "<input type='button' class='btn btn-primary btn-xs dim' value='删除' onclick=\"remove('" + cl + "');\" />&nbsp;";
					  se = "<input type='button' class='btn btn-primary btn-xs dim' value='修改' onclick=\"edit('" + cl + "');\" />";
					  jQuery("#table_list_2").jqGrid('setRowData', ids[i], { act : be  + ce +se});
					   	}
					  },
					pager : "#pager_list_2",
					multiselect : true,
					viewrecords : true,
					edit : false,
					add:false,
					editurl:"../api/roleAction/update",
					edittext : "Edit",
					hidegrid : false
				});
				$("#table_list_2").setSelection(4, true);
				$("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
					edit : false,
					del : true,
					add:false,
					search : true
				}, {
					reloadAfterSubmit : true
				});
				$(window).bind("resize", function() {
					var width = $(".jqGrid_wrapper").width();
					$("#table_list_2").setGridWidth(width)
				});
			});
		};
		function see(path){
			httpJump("role_see.jsp?roleId="+path);
		};
		function edit(path){
			httpJump("role_edit.jsp?roleId="+path);
		};
		function remove(path){
			var reqData={
				"id":path
			};
			if(window.confirm('你确定要删除该角色吗？')){
                 $.post("../api/roleAction/remove",reqData,function(data){
                 if(data.code==0){
             		$("#"+path).remove();
                	 showMsg("删除成功");
                 }
			});
                 return true;
              }else{
                 return false;
             }
			
		};
		$(document).ready(function(){
			ready();
		});
	</script>
	
</body>


</html>

