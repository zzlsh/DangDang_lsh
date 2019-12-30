<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="${ pageContext.request.contextPath }/admin/updateOneBookAction" method="post" enctype="multipart/form-data">
			<input type="hidden" name="DMLBook.book_id" value="${ requestScope.DMLBook.book_id }"/>
			<input type="hidden" name="DMLBook.book_sales_volume" value="${ requestScope.DMLBook.book_sales_volume }"/>
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="DMLBook.book_name" class="el-input__inner" value="${ requestScope.DMLBook.book_name }"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="DMLBook.book_pages" class="el-input__inner" value="${ requestScope.DMLBook.book_pages }" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="DMLBook.sort_id" class="el-select__inner inner2">
							<c:forEach items="${ requestScope.secondIdAndNameList }" var="thisSort">
								<option value="${ thisSort.sort_id }" ${ thisSort.sort_id eq DMLBook.sort_id ? "selected" : ""} >${ thisSort.sort_name }</option>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="DMLBook.book_words" class="el-input__inner" value="${ requestScope.DMLBook.book_words }" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="DMLBook.book_original_price" class="el-input__inner" value="${ requestScope.DMLBook.book_original_price }"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${ pageContext.request.contextPath }/back/img/${ DMLBook.book_cover }" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="cover" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="DMLBook.book_dangdang_price" class="el-input__inner" value="${ requestScope.DMLBook.book_dangdang_price }"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="DMLBook.book_inventory" class="el-input__inner" value="${ requestScope.DMLBook.book_inventory }"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="DMLBook.book_author" class="el-input__inner" value="${ requestScope.DMLBook.book_author }"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="DMLBook.book_editer_comment">${ requestScope.DMLBook.book_editer_comment }</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="DMLBook.book_publisher" class="el-input__inner" value="${ requestScope.DMLBook.book_publisher }"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="DMLBook.book_publish_time" class="el-input__inner" value="${ requestScope.DMLBook.book_publish_time }"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="DMLBook.book_introduction" >${ requestScope.DMLBook.book_introduction }</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="DMLBook.book_edition" class="el-input__inner" value="${ requestScope.DMLBook.book_edition }"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="DMLBook.book_printing_time" class="el-input__inner" value="${ requestScope.DMLBook.book_printing_time }" /></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="DMLBook.author_introduction">${ requestScope.DMLBook.author_introduction }</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="DMLBook.book_impression" class="el-input__inner" value="${ requestScope.DMLBook.book_impression }"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="DMLBook.book_isbn" class="el-input__inner" value="${ requestScope.DMLBook.book_isbn }"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="DMLBook.book_catalog" >${ requestScope.DMLBook.book_catalog }</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="DMLBook.book_format" class="el-input__inner" value="${ requestScope.DMLBook.book_format }"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="DMLBook.book_paper" class="el-input__inner" value="${ requestScope.DMLBook.book_paper }"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="DMLBook.book_media_comment">${ requestScope.DMLBook.book_media_comment }</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="DMLBook.book_pack" class="el-input__inner" value="${ requestScope.DMLBook.book_pack }"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

