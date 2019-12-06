<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="read" class="com.execl.ReadExcel"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试答题界面</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css"/>
</head>
<%
	//获取传入的学生信息
	String userName = "administrator";
	String identify = "170102055555";
	String subject = "高等数学";
	//获取选择题
	String[][] info = read.readExcelOptions();
	String[] answe = {"A", "B", "C", "D"};
%>
<script type="text/javascript" src="JS/demo.js" charset="utf-8"></script>
<script type="text/javascript">
	function onsubmit() {
		document.answer.submit();
	}
</script>
<body>
	<div id="header">
		<h1>随机抽题：在线考试</h1>
	</div>
	<div id="content">
		<div id="message">
			<p>
				姓名：<%=userName%>&nbsp;&nbsp;学号：<%=identify%>&nbsp;&nbsp;学科：<%=subject%>&nbsp;&nbsp;&nbsp;&nbsp;
			</p>
		</div>
		<table id="main" width="100%" height="100%">
			<tr>
				<td class="menu" width="12% height="100% ">
					<ul>
						<li
							style="border-bottom: none; color: white; background-color: #165a90;">考试倒计时</li>
						<li
							style="border-bottom: none; color: white; background-color: #165a90; margin-bottom: 5px;">
							<input id="timeh" type="text " disabled="" value=""
							style="color: red; width: 20px;" />时 <input id="timem"
							type="text " disabled="" value=""
							style="color: red; width: 20px;" />分 <input id="times"
							type="text " disabled="" style="color: red; width: 20px;"
							value="" />秒
						</li>
						<li
							style="border-bottom: none; color: white; background-color: #165a90;">题目列表</li>
						<li><a href="#opt">选择题</a></li>
						<li><a href="#opt">填空题</a></li>
						<li><a href="#opt">判断题</a></li>
						<li><a href="#opt">简答题</a></li>
						<li><a href="#opt">程序题</a></li>
					</ul>
				</td>
				<td class="test " width="88% height="100%">
					<form id="answer" name="answer"
						action="test.jsp"
						method="post">
						<h1 name="opt" id="opt">一、选择题</h1>
						<%
							for (int i = 0; i < info.length; i++)
								for (int j = 0; j < 5; j++)
									if (j == 0) {
						%>
						<div>
							<h3><%=i + 1%>、<%=info[i][j]%></h3>
						</div>
						<%
							} else {
						%>
						<div id="logo">
							<input type="radio" name=<%="option" + (i + 1)%>
								value=<%=answe[j - 1]%>>
							<%=info[i][j]%>
						</div>
						<br />
						<%
							}
						%>
						<input style="font-size:18px; color:white; background-color:#165aa1; width: 100px;height:40px; margin:20px 0 20px 400px; " type="submit" id="submit" name="submit" value="交  卷"/>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>