<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客后台管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var url;

function openTab(text,url,iconCls){
	if($("#tabs").tabs("exists",text)){
		$("#tabs").tabs("select",text);
	}else{
		var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
		$("#tabs").tabs("add",{
			title:text,
			iconCls:iconCls,
			closable:true,
			content:content
		});
	}
}
function openPasswordDialog(){
	$("#dlg").dialog("open").dialog("setTitle","修改密码");
}
function editPassword(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			var newPassword=$("#newPassword").val();
			var newPassword2=$("#newPassword2").val();
			if(!$(this).form("validate")){
				return false;
			}
			if(newPassword!=newPassword2){
				$.messager.alert("系统提示","确认密码输入错误");
				return false;
			}
			return true;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.success){
				$.messager.alert("系统提示","密码修改成功！");
				resetValue();
				$("#dlg").dialog("close");
			}else{
				$.messager.alert("系统提示","密码修改失败");
				return;
			}
		}
	});
}
function closePassword(){
	resetValue();
	$("#dlg").dialog("close");
}
function resetValue(){
	$("#newPassword").val("");
	$("#newPassword2").val("");
}
function logout(){
	$.messager.confirm("系统提示","您确定要退出系统吗？",function(r){
		if(r){
			window.location.href="${pageContext.request.contextPath}/admin/user/logout.do";
		}
	})
}
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 78px;background-color: #E0ECFF">
		<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.userName }</font>
	</div>
	<div region="center">
		<div class="easyui-tabs" data-options="fit:true,border:false" id="tabs">
			<div data-options="title:'首页',iconCls:'icon-home'">
				<div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px" title="导航菜单" split="true">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div data-options="title:'常用操作',selected:true,iconCls:'icon-item'" style="padding:10px">
				<a href="javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">写博客</a>
			</div>
			<div data-options="title:'个人信息',iconCls:'icon-item'" style="padding:10px">
				<a href="javascript:openTab('个人信息','editUser.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">个人信息</a>
				<a href="javascript:openPasswordDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">修改密码</a>
				<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">退出</a>
			</div>
			<div data-options="title:'友情链接',iconCls:'icon-item'" style="padding:10px">
				<a href="javascript:openTab('友情链接','linkManage.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">友情链接</a>
			</div>
			<div data-options="title:'博客管理',iconCls:'icon-item'" style="padding:10px">
				<a href="javascript:openTab('写博客','writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">写博客</a>
				<a href="javascript:openTab('博客类别管理','blogTypeManage.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">博客类别</a>
				<a href="javascript:openTab('博客管理','blogManage.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width:150px">博客管理</a>
			</div>
		</div>
	</div>
	<div region="south" style="height: 25px;padding: 5px" align="center">
		Copyright © 2012-2016 Java知识分享网 版权所有
	</div>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:200px;padding:10px 20px"
		data-options="closed:true,buttons:'#dlg-buttons'">
		<form id="fm" method="post" action="${pageContext.request.contextPath}/admin/user/editPassword.do?id=${currentUser.id}">
			<table cellspacing="8px">
				<tr>
					<td>用户名:</td>
					<td><input type="text" id="userName" value="${currentUser.userName }" name="userName" readonly="readonly" style="width:200px"/></td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input type="text" id="newPassword" name="newPassword" class="easyui-validatebox" required="true" style="width:200px"/></td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input type="text" id="newPassword2" name="newPassword2" class="easyui-validatebox" required="true" style="width:200px"/></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:editPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closePassword()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>