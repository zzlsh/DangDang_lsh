<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/front/css/book_detail.css"/>
		<link href="${ pageContext.request.contextPath }/front/css/public_footer.css" rel="stylesheet" type="text/css" />
		
		<!-- JQuery -->
		<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				//获取照片信息
				console.log($("#thisPic"));
				$("#thisPic").mouseover(function(e){
					//鼠标移入方法
					//获取原图片的大小
					var wid = this.width*2;
					var hei = this.height*2;
					//获取鼠标的位置
					var x = e.pageX+20;
					var y = e.pageY+20;
					//创建div
					var div = $("<div id='bigPic' />").css({
															"position":"absolute",
															"display":"none",
															"width":wid,
															"height":hei,
															"left":x,
															"top":y,
															"border":"2px solid pink"
														});
					//创建img
					var img = $("<img/>").css({
											"width":wid,
											"height":hei
										}).attr({
											"src":this.src
										});
					//将img放进div
					div.append(img);
					//将div放进body中
					$("body").append(div);
					div.show(1000);
				}).mousemove(function(e){
					//鼠标移动方法
					//获取鼠标位置
					var x = e.pageX+20;
					var y = e.pageY+20;
					//将鼠标位置赋值给div
					$("#bigPic").css({
						"left":x,
						"top":y
					});
					
				}).mouseout(function(e){
					//鼠标移出方法
					$("#bigPic").remove();
				});
				
			});
		</script>
	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：${ requestScope.queryBook.book_name }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img id="thisPic" src="${ pageContext.request.contextPath }/back/img/${ requestScope.queryBook.book_cover }" width="240px" height="340px" /></td>
				<td colspan="2">作者：${ requestScope.queryBook.book_author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${ requestScope.queryBook.book_publisher }</td>
			</tr>
			<tr>
				<td>出版时间：${ requestScope.queryBook.book_publish_time } </td>
				<td>字数：${ requestScope.queryBook.book_words }</td>
			</tr>
			<tr>
				<td>版次：${ requestScope.queryBook.book_edition }</td>
				<td>页数：${ requestScope.queryBook.book_pages }</td>
			</tr>
			<tr>
				<td>印刷时间：${ requestScope.queryBook.book_printing_time }</td>
				<td>开本：${ requestScope.queryBook.book_format }</td>
			</tr>
			<tr>
				<td>印次：${ requestScope.queryBook.book_impression }</td>
				<td>纸张：${ requestScope.queryBook.book_paper }</td>
			</tr>
			<tr>
				<td>ISBN：${ requestScope.queryBook.book_isbn }</td>
				<td>包装：${ requestScope.queryBook.book_pack }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${ requestScope.queryBook.book_original_price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${ requestScope.queryBook.book_dangdang_price }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${ requestScope.queryBook.book_original_price - requestScope.queryBook.book_dangdang_price }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${ pageContext.request.contextPath }/buy/myCartAction?needBuyBook.book_id=${ queryBook.book_id }">
						<img src='${ pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐:${ requestScope.queryBook.book_editer_comment }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介:${ requestScope.queryBook.book_introduction }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介:${ requestScope.queryBook.author_introduction }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录:${ requestScope.queryBook.book_catalog }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论:${ requestScope.queryBook.book_media_comment }</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${ pageContext.request.contextPath }/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
