<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${ pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			function funSub(){
				var user_email = $("#txtEmail").val();
				console.log(user_email);
				//要求邮箱不能为空
				if(user_email == "") {
					$("#email").html("<font style='color:red'>邮箱不能为空</font>");
					return false;
				} else if (!user_email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
					//利用正则表达式，判断邮箱格式是否正确
					//邮箱格式不正确
					$("#email").html("<font style='color:red'>邮箱格式错误</font>");
					return false;
				}
				if($("#txtPassword").val() == "") {
					$("#email").html("<font style='color:red'>密码不能为空</font>");
					return false;
				}
				console.log("邮箱和密码都可行");
				return true;
			}
		</script>
	</head>
	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
					
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="${ pageContext.request.contextPath }/user/loginAction" id="ctl00" onsubmit="return funSub();">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="loginUser.user_email" id="txtEmail" class="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="loginUser.user_password" id="txtPassword" class="textbox" />
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter" value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="" />
							<span id="email"><c:if test="${ requestScope.message != null }"><font style='color:red'>${ requestScope.message }</font></c:if></span>
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${ pageContext.request.contextPath }/front/user/register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

