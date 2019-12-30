<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach items="${ requestScope.randomBooks }" var="oneBook">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${ pageContext.request.contextPath }/show/queryOneBook?queryBook.book_id=${ oneBook.book_id }' target='_blank'>
					<img id="thisPic" src="${ pageContext.request.contextPath }/back/img/${ oneBook.book_cover }" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${ pageContext.request.contextPath }/show/queryOneBook?queryBook.book_id=${ oneBook.book_id }' target='_blank' title='输赢'>${ oneBook.book_name }</a>
				</h3>
				<h4>
					作者：${ oneBook.book_author } 著
					<br />
					出版社：${ oneBook.book_publisher }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：${ oneBook.book_publish_time }
				</h4>
				<h5>
					简介:${ onebook.book_introduction }
				</h5>
				<h6>
					定价：￥${ oneBook.book_original_price }&nbsp;&nbsp;
					当当价：￥${ oneBook.book_dangdang_price }
					销量：<font color="red">${ oneBook.book_sales_volume }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
