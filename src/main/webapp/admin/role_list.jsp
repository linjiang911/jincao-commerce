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

<link href="../../js/plugins/gritter/jquery.gritter.css"
	rel="stylesheet">
<link rel="shortcut icon" href="favicon.ico">
<link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<!-- jqgrid-->
<link href="../css/plugins/jqgrid/ui.jqgridffe4.css?0820"
	rel="stylesheet">

<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">

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
	<script>
		$(document).ready(function() {
			$.jgrid.defaults.styleUI = "Bootstrap";
			var mydata = [ {
				id : "1",
				invdate : "2010-05-24",
				name : "test",
			}, {
				id : "2",
				invdate : "2010-05-25",
				name : "test2",
			}];
			$("#table_list_2").jqGrid({
				data : mydata,
				datatype : "local",
				height : 450,
				autowidth : true,
				shrinkToFit : true,
				rowNum : 20,
				rowList : [ 10, 20, 30 ],
				colNames : [ "角色名称", "角色描述", "权限"],
				colModel : [ {
					name : "id",
					index : "id",
					editable : true,
					width : 60,
					sorttype : "int",
					search : true
				},{
					name : "invdate",
					index : "invdate",
					editable : true,
					width : 90,
					sorttype : "date",
					formatter : "date"
				}, {
					name : "name",
					index : "name",
					editable : true,
					width : 100
				}],
				pager : "#pager_list_2",
				viewrecords : true,
				edit : true,
				edittext : "Edit",
				hidegrid : false
			});
			$("#table_list_2").setSelection(4, true);
			$("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
				edit : true,
				del : true,
				search : true
			}, {
				height : 200,
				reloadAfterSubmit : true
			});
			$(window).bind("resize", function() {
				var width = $(".jqGrid_wrapper").width();
				$("#table_list_2").setGridWidth(width)
			})
		});
	</script>
	<script type="text/javascript" src="../js/stats.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../js/util.js"></script>
	<script type="text/javascript" src="../js/jincaoutil.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".btn").click(function() {
				var name = $(".name").val();
				var describe = $(".describe").val();
				var arr = packageCheckboxPath("PermissionId");
				if (arr.length == 0 || arr.length < 0) {
					showMsg("至少选一个权限");
					return;
				}
				if (!verifys(name, "notNull")) {
					verifyClass(".name", "名字不能为空");
					return;
				}
				if (!verifys(describe, "notNull")) {
					verifyClass(".describe", "介绍不能为空");
					return;
				}
				var reqdata = {
					"name" : name,
					"describe" : describe,
					"PermissionId" : arr
				};
				$.post("../api/roleAction/add", reqdata, function(data) {
					if (data.code == 0) {
						showMsg("添加成功");
						refresh(".name", ".describe");
					}
				});
			});
		});
		function ready() {
			$.post("../api/permissionAction/all", function(data) {
				for (i = 0; i < data.response.length; i++) {
					addCheckbox(".province", data.response[i].id,
							data.response[i].name);
				}
			});
		}
		$(document).ready(function() {
			setTimeout(function() {
				ready();
			}, 500);
		});
	</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
</html>

