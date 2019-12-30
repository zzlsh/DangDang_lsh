<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${ pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${ pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			//更换验证码
			function changeImage() {
				//获取系统当前秒数
				var t = new Date();
				console.log(t.getMinutes());
				//路径中加入一个随机数，使每次点击时，路径都不同
				//浏览器检测到验证码的路径改变了，会重新进行加载
				$("#imgVcode").attr("src","/DangDang_lsh/user/getCode?num=" + Math.random());
			}
			
			//邮箱
			function funEmail(){
				var user_email = $("#txtEmail").val();
				if(user_email == "") {
					$("#emailInfo").html("<font id='email' style='color:red'>邮箱不能为空</font>");
					return false;
				} else {
					$("#email").remove();
				}
				if (!user_email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
					//邮箱格式错误
					$("#emailInfo").html("<font id='email' style='color:red'>邮箱格式错误</font>");
					return false;
				} else {
					$("#email").remove();
				}
				return true;
			}
			
			//昵称
			function funNickName(){
				//计算中文/字符的个数
				var pattern_char = /[a-zA-Z]/g;//字符的数组
				var pattern_chin = /[\u4E00-\u9FFF]/;//中文的数组
				var pattern_num = /[0-9]/ig;//数字的数组
				
				var nickName = $("#txtNickName").val();
				console.log("输入的昵称："+nickName);
				if(nickName == "") {
					$("#nameInfo").html("<font id='nickName' style='color:red'>昵称不能为空</font>");
					return false;
				} else {
					$("#nickName").remove();
				}
				//输入的内容的长度
				var charLength = nickName.match(pattern_char);//字符的长度 
				console.log("字符："+charLength);
				var chinLength = nickName.match(pattern_chin);//中文的长度（一个汉字算两个单位的长度）
				console.log("汉字："+chinLength);
				var numLength = nickName.match(pattern_num);
				console.log("数字："+numLength);
				var nickNameLength = 0;
				if(numLength != null) {
					nickNameLength += numLength.length;
				}
				if(charLength != null) {
					nickNameLength += charLength.length;
				}
				if(chinLength != null) {
					nickNameLength += (chinLength.length * 2);
				}
				
				console.log("昵称长度："+nickNameLength);
				if (nickNameLength < 4 || nickNameLength > 20) {
					$("#nameInfo").html("<font id='nickName' style='color:red'>昵称格式错误</font>");
					return false;
				} else {
					$("#nickName").remove();
				}
				return true;
			}
			
			//第一次密码
			function funFirstPass(){
				var password1 = $("#txtPassword").val();
				console.log("设置的密码："+password1);
				if(password1 == "") {
					$("#passwordInfo").html("<font id='password1' style='color:red'>密码不能为空</font>");
					return false;
				} else {
					$("#password1").remove();
				}
				//判断输入密码的长度
				var pattern_char = /[a-zA-Z]/g;//字符的个数
				var pattern_num = /[0-9]/ig;//数字的数组
				
				var charLength = password1.match(pattern_char);//字符的长度 
				console.log("密码的字符长度："+charLength);
				var numLength = password1.match(pattern_num);//数字的长度 
				console.log("密码的数字长度："+numLength);
				var password1Length = 0;
				if(charLength != null) {
					password1Length += charLength.length;
				}
				if(numLength != null) {
					password1Length += numLength.length;
				}
				console.log("第一个密码的长度："+password1Length);
				if (password1Length < 6 || password1Length > 20) {
					$("#passwordInfo").html("<font id='password1' style='color:red'>密码格式有误</font>");
					return false;
				} else {
					$("#password1").remove();
				}
				return true;
			}
			
			//第二次密码
			function funSecondPass(){
				var password1 = $("#txtPassword").val();
				var password2 = $("#txtRepeatPass").val();
				if(password2 == ""){
					$("#password1Info").html("<font id='password2' style='color:red'>请再次输入密码</font>");
					return false;
				} else {
					$("#password2").remove();
				}
				if(password2 != password1){
					$("#password1Info").html("<font id='password2' style='color:red'>两次输入的密码不同</font>");
					return false;
				} else {
					$("#password2").remove();
				}
				return true;
			}
			
			//表单验证
			function funSubmit(){
				return funEmail()&&funNickName()&&funFirstPass()&&funSecondPass();
			}
		</script>
		
		
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${ pageContext.request.contextPath }/user/registAction" id="f" onsubmit="return funSubmit();">
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="newUser.user_email"  type="text" id="txtEmail" class="text_input" onblur="funEmail()"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="newUser.user_nickname"  type="text" id="txtNickName" class="text_input" onblur="funNickName()"/>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="newUser.user_password" type="password" id="txtPassword" class="text_input" onblur="funFirstPass()"/>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" class="text_input" onblur="funSecondPass()"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${ pageContext.request.contextPath }/user/getCode" />
							<input name="thisCode" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="#" id="change" onClick="changeImage()" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

