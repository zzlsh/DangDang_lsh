<%@ page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
		<c:forEach items="${ requestScope.firstWithSecond }" var="firstSort">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${ pageContext.request.contextPath }/show/FirstOrSecondSortBooksAction?fid=${ firstSort.sort_id }&pageNow=1'>${ firstSort.sort_name }</a>]
				</h3>
				<ul class="ul_left_list">

					<!--2级分类开始-->
					<c:forEach items="${ firstSort.secondOnFirst }" var="secondSort">
						<li>
							<a href='${ pageContext.request.contextPath }/show/FirstOrSecondSortBooksAction?fid=${ firstSort.sort_id }&sid=${ secondSort.sort_id }&pageNow=1'>${ secondSort.sort_name }</a>
						</li>
					</c:forEach>
					<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		</c:forEach>
		<!--1级分类结束-->
		


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
