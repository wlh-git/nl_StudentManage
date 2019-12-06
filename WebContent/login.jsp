<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@ page import="java.net.URLDecoder" %>
<html>
<head>
<style>
body {
	background: url("img/01.jpg") repeat fixed center;
}

#main {
	border: 2px double red;
	width: 400px;
	margin: auto;
}
</style>
<script type="text/javascript">
window.onload=function(){
	document.getElementById("id").focus();
}
function $(id){return document.getElementById(id);}
function slogincheck(){
	if (form.ID.value == "") {
		alert("学号不能为空，请输入用户名！");
		form.ID.focus();
		return false;
	}else if (form.identify.value == "") {
		alert("身份证号不能为空，请输入用户名！");
		form.identify.focus();
		return false;
	}else if (form.name.value == "") {
		alert("名字不能为空，请输入用户名！");
		form.name.focus();
		return false;
	}else{
		$("login").action="s_loginServlet";
	}
	return true ;
}
function tlogincheck(){
	if (form.username.value == "") {
		alert("用户名不能为空，请输入用户名！");
		form.id.focus();
		return false;
	}else if (form.password.value == "") {
		alert("名字不能为空，请输入用户名！");
		form.name1.focus();
		return false;
	}else{
		$("login").action="t_loginServlet";
	}
}
function changediv(i){
	if(i===0){
		$("student").style.display="block";
		$("t_student").style.display="block";
		$("teacher").style.display="none";
		$("t_teacher").style.display="none";
	}else{
		$("student").style.display="none";
		$("t_student").style.display="none";
		$("teacher").style.display="block";
		$("t_teacher").style.display="block";
	}
}
</script>
<meta charset="utf-8">
<title>学生登录</title>
</head>
<body style="padding-top: 160px;">
	<center>
	<div style="display:block;" id="t_student">
		<h1>学生登录</h1>
	</div>
	<div style="display:none;" id="t_teacher">
		<h1>教师登录</h1>
	</div>
	</center>
	<div id="main" >
		<form action="s_loginServlet" method="post" name="form" id="login">
			<center>
			<div style="display:block;" id="student">
				<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号: <input type="text" id="ID"
					name="ID" autocomplete="off"/><br /> <br /> 
					身份证号:  <input type="text" name="identify" id="identify" autocomplete="off"/><br />
				<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名:<input type="text" name="name" id="name" autocomplete="off"/><br />
				<br />
				<input type="submit" value="登录" onclick="return slogincheck()" />
			</div>
			<div style="display:none;" id="teacher">
				<br /> 用户名: <input type="text" id="username"
					name="username" autocomplete="off"/><br /> <br /> &nbsp;&nbsp;&nbsp;&nbsp;密码: <input type="text" name="password" id="password" autocomplete="off"/><br />
				<br /> 
				<input type="submit" value="登录" onclick="return tlogincheck()" />
			</div>
			</center>
		</form>
		<center>
			<input type="button" name="sel"  onclick="changediv(0)" value="学生登录" /> &nbsp;&nbsp; 
			 <input type="button" name="adm"  onclick="changediv(1)" value="教师登录" /><br /> <br />
		</center>
	</div>
</body>
</html>