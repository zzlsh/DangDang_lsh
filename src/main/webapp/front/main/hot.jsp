<%@ page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${ requestScope.maxSaleBooks }" var="oneBook">
		<div class="second_d_wai">
			<div class="img">
				<a href="${ pageContext.request.contextPath }/show/queryOneBook?queryBook.book_id=${ oneBook.book_id }" target='_blank'>
					<img id="thisPic" src="${ pageContext.request.contextPath }/back/img/${ oneBook.book_cover }" border=0 /> 
				</a>
			</div>
			<div class="shuming">
				<a href="${ pageContext.request.contextPath }/show/queryOneBook?queryBook.book_id=${ oneBook.book_id }" target="_blank">${ oneBook.book_name }</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				定价：￥${ oneBook.book_original_price }
			</div>
			<div class="price">
				当当价：￥${ oneBook.book_dangdang_price }
			</div>
			<div class="price">
				销量：<font color="red">${ oneBook.book_sales_volume }</font>
			</div>
		</div>
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>