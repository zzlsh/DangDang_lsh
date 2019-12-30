<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <title>order</title>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
  </head>
  <body style="background-color: #f0f9fd;">
  <div align=center style="font-size:25px">订单管理</div><hr/>
  	 <table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px">
          <tr bgcolor="lightblue" align="center"> 
              <td>订单id</td>
			  <td>订单编号</td>
			  <td>订单金额</td>
			  <td>订单状态</td>
              <td>收件人</td>
			  <td>收货地址</td>
			  <td>创建日期</td>
              <td>操作</td>
          </tr>
          <c:forEach items="${ requestScope.allOrder }" var="oneOrder">
			  <tr align='center'> 
				  <td>${ oneOrder.order_id }</td>
				  <td>${ oneOrder.order_serial }</td>
				  <td>${ oneOrder.order_total }</td>
				  <td>${ oneOrder.order_status }</td>
				  <td>${ oneOrder.add_recipients }</td>
				  <td>${ oneOrder.add_local }</td>
				  <td>${ oneOrder.order_date }</td>
				  <td> 
					<input class="button btn-order" onclick="location.href='${ pageContext.request.contextPath }/order/queryOneOrderAction?order_id=${ oneOrder.order_id }'" value="订单详细信息 &raquo;" />
				  </td>
			  </tr>
		  </c:forEach>
          
     </table> 
  </body>
</html>
