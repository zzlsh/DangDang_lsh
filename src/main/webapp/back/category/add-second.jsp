<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>index.html</title>
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=GBK">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/back/css/btn.css" />
<style type="text/css">
body {
	text-align: center;
}

select {
	width: 173px;
}
</style>
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function funSort() {
		//获取文本框中的内容
		console.log($("input")[0].value);
		if ($("input")[0].value == "") {
			$("#snameMsg").html("<font style='color:red'>Error ×</font>");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body style="background-color: #f0f9fd;">

	<div style="text-align:center ;font-size:18px">添加商品类别</div>
	<hr />

	<form
		action="${ pageContext.request.contextPath }/admin/addSecondSortAction"
		method="post" onsubmit="return funSort();">
		所属一级类别: <select name="fatherSort.sort_id" class="el-select__inner">
			<c:forEach items="${ allFirstList }" var="firstSort">
				<option value="${ firstSort.sort_id }">${ firstSort.sort_name }</option>
			</c:forEach>
		</select> <br />
		<br /> 二级类别名:<input class="el-input__inner" type="text"
			name="useSort.sort_name" id="sname" onblur="funSort()" /><span
			id="snameMsg"></span><br />
		<br /> <input class="button btn-p" type="submit" value="提交" />&emsp; <input
			class="button btn-p" type="button" value="返回上级"
			onclick="history.go(-1);" />
	</form>
	<span style="color:red;font-size:21px;margin-left:45px;">${ message }</span>

</body>
</html>
