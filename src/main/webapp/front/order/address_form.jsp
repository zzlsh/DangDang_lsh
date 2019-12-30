<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${ pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			function changeDefault(add_id){
				if(add_id != "") {
					console.log("下拉框值发生改变，需要默认值");
					window.location.href="${ pageContext.request.contextPath }/frontOrder/queryAllAddressByIdAction?address="+add_id;
				} else {
					console.log("下拉框不变");
				}
			}
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address" onchange="changeDefault(this.value)">
						<option>
							填写新地址
						</option>
					<c:forEach items="${ allAddress }" var="oneInAddress">
						<option value="${ oneInAddress.add_id }" ${ oneAddress.add_id eq oneInAddress.add_id ? "selected" : "" }>
							${ oneInAddress.add_local }
						</option>
					</c:forEach>
				</select>
			</p>
			<form name="ctl00" method="get" action="${ pageContext.request.contextPath }/frontOrder/placeOrderAction" id="f">
				<input type="hidden" name="oneAddress.add_id" id="add_id" value="${oneAddress.add_id}" />
				<input type="hidden" name="oneAddress.user_id" id="user_id" value="${oneAddress.user_id}"/>

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="oneAddress.add_recipients" id="receiveName" value="${oneAddress.add_recipients}" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="oneAddress.add_local" class="text_input" id="fullAddress" value="${ oneAddress.add_local }" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="oneAddress.add_postcode" id="postalCode" value="${ oneAddress.add_postcode }" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="oneAddress.add_tel" id="phone" value="${ oneAddress.add_tel }" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<a href="${ pageContext.request.contextPath }/front/order/order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

