//添加checkbox
function addCheckbox(element,data1,data2){
	$(element).append("<label class='checkbox-inline i-checks'>"
			+"<input type='checkbox' name='PermissionId'  value='"+data1+"'/>"
			+data2+"</label>");
}
//封装checkbox参数 携带name参数
function packageCheckboxPath(name){
	var items=document.getElementsByName(name);
	var arr=new Array();
	var i=0;
	for(var x=0;x<items.length;x++){
		if(items[x].checked){
			 arr[i] = items[x].value;
				i++;
			}
		}
	return arr;
}

//信息显示
$(document).ready(function(){
	setTimeout(function(){
		$("body").append('<div id="gritter-notice-wrapper"></div>');
	},500);
	i=0;
});
var i=0;
function showMsg(message){
	setTimeout(function(){
		$('#gritter-notice-wrapper').append('<div id="gritter-item-4'+i+'" class="gritter-item-wrapper" role="alert" style="">'
				+'<div class="gritter-top"></div>'
				+'<div class="gritter-item">'
				+'<a class="gritter-close" tabindex="1" href="#" style="display: none;">Close Notification</a>'
				+'<div class="gritter-without-image">'
				+'<p>'+message+'</p>'
				+'</div>'
				+'<div style="clear:both"></div>'
				+'</div>'
				+'<div class="gritter-bottom"></div>'
				+'</div>');
				deleteMsg(i);
		},1000);
		i++;
	}
function deleteMsg(data){
	setTimeout(function(){
		$("#gritter-item-4"+data).hide();
		},5000);
}
