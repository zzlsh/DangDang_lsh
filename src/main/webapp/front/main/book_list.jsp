<%@ page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${ pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${ pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${ pageContext.request.contextPath }/show/showMainAction'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${ requestScope.allSorts.sort_name }</strong></font>
				<c:if test="${ requestScope.sid != null }">
					&gt;&gt;<font style='color: #cc3300'><strong>${ requestScope.thisSecondSort.sort_name }</strong> </font>
				</c:if>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;全部&nbsp;(23)
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach items="${ requestScope.allSorts.secondOnFirst }" var="secondSort">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											<a href="${ pageContext.request.contextPath }/show/FirstOrSecondSortBooksAction?fid=${ oneParam.sort_id }&sid=${ secondSort.sort_id }&pageNow=1">${ secondSort.sort_name }&nbsp;(10)</a>
										</div>
									</div>
								</li>
							    <div class="clear"></div>
						    </c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<c:if test="${ requestScope.pageNow != 1 }">
									<a name=link_page_next href="${ pageContext.request.contextPath }/show/FirstOrSecondSortBooksAction?fid=${ requestScope.fid }&sid=${ requestScope.sid }&pageNow=${ pageNow - 1 }">
										<img src='${ pageContext.request.contextPath }/front/images/page_up.gif' /> 
									</a>
								</c:if>
								<c:if test="${ requestScope.pageNow == 1 }">
									<img src='${ pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</c:if>
							</div>
	
							<div class='list_r_title_text3a'>
								<img src='${ pageContext.request.contextPath }/front/images/page_up_gray.gif' />
							</div>
				
							<div class='list_r_title_text3b'>
								第${ pageNow }页/共${ pageSum }页
							</div>
							
							<div class='list_r_title_text3a'>
								<c:if test="${ requestScope.pageNow != requestScope.pageSum }">
									<a name=link_page_next href="${ pageContext.request.contextPath }/show/FirstOrSecondSortBooksAction?fid=${ requestScope.fid }&sid=${ requestScope.sid }&pageNow=${ pageNow + 1 }">
										<img src='${ pageContext.request.contextPath }/front/images/page_down.gif' /> 
									</a>
								</c:if>
								<c:if test="${ requestScope.pageNow == requestScope.pageSum }">
									<img src='${ pageContext.request.contextPath }/front/images/page_down.gif' /> 
								</c:if>
							</div>
			
							<div class='list_r_title_text3a'>
								<img src='${ pageContext.request.contextPath }/front/images/page_down_gray.gif' />
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
					<c:forEach items="${ requestScope.sortBooks }" var="oneBook">
						<div class="list_r_line"></div>
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${ pageContext.request.contextPath }/show/queryOneBook?queryBook.book_id=${ oneBook.book_id }'>
										<img src="${ pageContext.request.contextPath }/back/img/${ oneBook.book_cover }" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${ pageContext.request.contextPath }/show/queryOneBook?queryBook.book_id=${ oneBook.book_id }'>${ oneBook.book_name }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${ oneBook.book_author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${ oneBook.book_publisher }</a>
								</h4>
								<h4>
									出版时间：${ oneBook.book_publish_time }
								</h4>
								<h5>
									${ oneBook.book_editer_comment }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${ oneBook.book_original_price }</span>
									<span class="red">￥${ oneBook.book_dangdang_price }</span>
									节省：￥${ oneBook.book_original_price - oneBook.book_dangdang_price }
								</h6>
								<span class="list_r_list_button"> 
								<a href="${ pageContext.request.contextPath }/buy/myCartAction?needBuyBook.book_id=${ oneBook.book_id }"> 
									<img src='${ pageContext.request.contextPath }/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>

						<div class="clear"></div>
						</c:forEach>
						
					<!--商品条目结束-->



					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
