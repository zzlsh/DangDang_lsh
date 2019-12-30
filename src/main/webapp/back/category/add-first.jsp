<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/btn.css" />
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=GBK">
<script type="text/javascript" src="${ pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function funJudge() {
		//获取标签内容
		//console.log($("input")[0].value);
		//空字符串拦截在前端页面
		if ($("input")[0].value == "") {
			$("#fnameMsg").html("<font style='color:red'>Error ×</font>");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="text-align: center;font-size: 18px">添加商品类别</div>
	<hr />
	<form action="${ pageContext.request.contextPath }/admin/addFirstSortAction"
		method="post" onsubmit="return funJudge();">
		类别名:<input class="el-input__inner" type="text"
			name="useSort.sort_name" id="fname" onblur="funJudge()" /><span
			id="fnameMsg"></span><br />
		<br /> <input class="button btn-p" type="submit" value="提交">&emsp;
		<div class="button btn-p" onclick="history.go(-1);">返回上级</div>
	</form>
	<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>

</body>
</html>
