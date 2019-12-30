<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${ pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			function changeNum(book_id){
				//var count = $("#book_id").val();
				console.log($("#"+book_id).val());
				//需要传递变更的数量changeNum还有书籍对象的book_id
				var changeNum = $("#"+book_id).val();
				if(changeNum > 0) {
					window.location.href="${ pageContext.request.contextPath }/buy/changeNumAction?changeNum="+changeNum+"&needBuyBook.book_id="+book_id;
				}
			}
			function deleteOne(book_id){
				console.log("删除");
				window.location.href="${ pageContext.request.contextPath }/buy/changeNumAction?changeNum=0"+"&needBuyBook.book_id="+book_id;
			}
			
		</script>
	
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="${ pageContext.request.contextPath }/front/images/pic_myshopping.gif" />
		</div>
		<c:if test="${ sessionScope.thisCart == null }">
			<div id="div_no_choice">
				<div class="choice_title"></div>
				<div class="no_select">
					您还没有挑选商品[<a href='${ pageContext.request.contextPath }/show/showMainAction'> 继续挑选商品&gt;&gt;</a>]
				</div>
			</div>
		</c:if>
		
		<!-- 购物车中存在商品 -->
		<c:if test="${ sessionScope.thisCart != null }">
			<div id="div_choice" class="choice_merch">
				<h2 id="cart_tips">
					您已选购以下商品
				</h2>
				<div class="choice_bord">
					<table class="tabl_buy" id="tbCartItemsNormal">
						<tr class="tabl_buy_title">
							<td class="buy_td_6">
								<span>&nbsp;</span>
							</td>
							<td>
								<span class="span_w1">商品名</span>
							</td>
							<td class="buy_td_5">
								<span class="span_w2">市场价</span>
							</td>
							<td class="buy_td_4">
								<span class="span_w3">当当价</span>
							</td>
							<td class="buy_td_1">
								<span class="span_w2">数量</span>
							</td>
							<td class="buy_td_2">
								<span>变更数量</span>
							</td>
							<td class="buy_td_1">
								<span>删除</span>
							</td>
						</tr>
						<tr class='objhide' over="no">
							<td colspan="8">
								&nbsp;
							</td>
						</tr>
						
						<!-- 购物列表开始 -->
						<c:forEach items="${ sessionScope.thisCart.books }" var="oneBook">
							<tr class='td_no_bord'>
								<td style='display: none'>
									${ oneBook.key.book_id }
								</td>
								<td class="buy_td_6">
									<span class="objhide">
										<img src="" /> 
									</span>
								</td>
								<td>
									<a href="">${ oneBook.key.book_name }</a>
								</td>
								<td class="buy_td_5">
									<span class="c_gray">￥${ oneBook.key.book_original_price }</span>
								</td>
								<td class="buy_td_4">
									&nbsp;&nbsp;
									<span>￥${ oneBook.key.book_dangdang_price }</span>
								</td>
								<td class="buy_td_1">
									&nbsp;&nbsp;${ oneBook.value }
								</td>
		
								<td >
									<input id="${ oneBook.key.book_id }" class="del_num" type="number" size="3" maxlength="4" />
									<a href="#" onclick="changeNum('${ oneBook.key.book_id }')" >变更</a>
								</td>
								<td>
									<a href="#" onclick="deleteOne('${ oneBook.key.book_id }')">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table>
	
					<div class="choice_balance">
						<div class="select_merch">
							<a href='${ pageContext.request.contextPath }/show/showMainAction'> 继续挑选商品</a>
						</div>
						<div class="total_balance">
							<div class="save_total">
								您共节省：
								<span class="c_red"> ￥<span id="total_economy">${ sessionScope.thisCart.discounts }</span> </span>
								<span style="font-size: 14px">|</span>
								<span class="t_add">商品金额总计：</span>
								<span class="c_red_b"> ￥<span id='total_account'>${ sessionScope.thisCart.total }</span>
								</span>
							</div>
							<div id="balance" class="balance">
								<a name='checkout' href='${ pageContext.request.contextPath }/front/order/order_info.jsp' > 
									<img src="${ pageContext.request.contextPath }/front/images/butt_balance.gif" alt="结算" border="0" title="结算" />
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<!--页尾开始 -->
		<div style="position:absolute;bottom: 10px;width:100%;">
			<%@include file="../common/foot.jsp"%>
		</div>
		<!--页尾结束 -->
	</body>
</html>



