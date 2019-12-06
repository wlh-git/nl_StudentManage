
var maxtime;
if (window.name == '') {
	maxtime = 60 *60 * 60;
} else {
	maxtime = window.name;
}
function $(id) {
	return document.getElementById(id);
}
function CountDown() {
	if (maxtime >= 0) {
		hours = Math.floor(maxtime / 3600);
		minutes = Math.floor((maxtime - 3600 * hours) / 60);
		seconds = Math.floor(maxtime % 60);
		if(minutes<10)
			minutes = "0" + minute;
		if(seconds<10)
			seconds = "0" + seconds;
		$("timeh").value = hours;
		$("timem").value = minutes;
		$("times").value = seconds;
		if (maxtime == 5 * 60)
			alert('注意，还有5分钟!');
		--maxtime;
		window.name = maxtime;
	} else {
		clearInterval(timer);
		alert("考试时间到，结束!");// 提醒时间到
		document.getElementById("submit").click(); // 规定时间结束后自动提交按钮
															// 提交试卷

	}
}
timer = setInterval("CountDown()", 1000);
function closedate() {
	timer = 0;
}
