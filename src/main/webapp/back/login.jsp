<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	import="java.util.*" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录 - 当当网</title>
<link href="${ pageContext.request.contextPath }/back/css/login.css"
	rel="stylesheet" type="text/css" />
<link href="${ pageContext.request.contextPath }/back/css/pop_cheat.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/back/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function changeImage() {
		//获取系统当前秒数
		var t = new Date();
		console.log(t.getMinutes());
		//路径中加入一个随机数，使每次点击时，路径都不同
		//浏览器检测到验证码的路径改变了，会重新进行加载
		$("#imgVcode").attr("src",
				"/DangDang_lsh/admin/getCode?num=" + Math.random());
	}

	//验证用户名，密码，验证码不能为空
	function funUs() {
		console.log($("input")[0].value);
		console.log($("input")[1].value);
		console.log($("input")[2].value);
		if ($("input")[0].value == "") {
			$("#fuv").html("<font style='color:red'>用户名不能为空</font>");
			return false;
		} else {
			$("font").empty();
		}
		return true;
	}
	function funPas() {
		if ($("input")[1].value == "") {
			$("#fuv").html("<font style='color:red'>密码不能为空</font>");
			return false;
		} else {
			$("font").empty();
		}
		return true;
	}
	function funCod() {
		if ($("input")[2].value == "") {
			$("#fuv").html("<font style='color:red'>验证码不能为空</font>");
			return false;
		} else {
			$("font").empty();
		}
		return true;
	}

	//表单验证
	function funSub() {
		return funUs() && funPas() && funCod();
	}
</script>

</head>
<body>
	<div class="head">
		<a href="http://www.dangdang.com"> <img
			src="${ pageContext.request.contextPath }/back/images/signin_logo.png" /></a>
		<div class="improve">
			<img src="${ pageContext.request.contextPath }/back/images/bz.jpg"
				width="178" height="61" />
		</div>
	</div>

	<div class="login_bg" style="width:960px; margin:0 auto;">
		<img src="http://a.dangdang.com/api/data/cpx/img/38930001/1"
			style="display: none;">
		<div id="J_cheatProofTop" class="new_tip">
			<div id="component_2747856"></div>
			<div>
				为保障账户安全，请勿设置与邮箱及其他网站相同的账户登录密码或支付密码，<a href="javascript:;">谨防诈骗</a>！
			</div>
		</div>
		<div class="set_area clearfix">
			<div class="wrap clearfix">
				<div id="J_loginDiv">
					<form
						action="${ pageContext.request.contextPath }/admin/adminLoginAction"
						method="post" onsubmit="return funSub();">
						<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
						<div id="J_loginCoreWrap" class="infro">
							<div class="username" id="username_div">
								<span></span> <input class="user" id="txtUsername"
									name="admin.admin_username" type="text" onblur="funUs()" />
							</div>
							<br /> <br />

							<div class="password" id="password_div">
								<span></span> <input class="pass" id="txtPassword"
									name="admin.admin_password" type="password" onblur="funPas()" />
							</div>
							<br /> <br />
							<div id="J_captchVcodeWrap" style="" class="Captcha">
								<div class="code" style="width:100px;">
									<input type="text" name="thiscode" onblur="funCod()" />
								</div>
								<div class="Captcha-operate">
									<div class="Captcha-imageConatiner">
										<a class="code_pic" id="vcodeImgWrap" name="change_code_img"
											href="javascript:void(0);"> <img
											src="${ pageContext.request.contextPath }/admin/getCode"
											id="imgVcode" class="Ucc_captcha Captcha-image"
											onClick="changeImage()">
										</a> <a id="vcodeImgBtn" name="change_code_link"
											class="code_picww" href="javascript:changeImage()">换张图</a> <span
											id="spn_vcode_ok" class="icon_yes pin_i"
											style="display: none;"></span> <span id="J_tipVcode"
											class="cue warn"></span>
									</div>
								</div>
							</div>
							<br /> <br />

							<p class="btn">
								<input id="submitLoginBtn" type="submit" value="登&nbsp;录" />
							</p>
						</div>
					</form>
					<span id="fuv"></span>
				</div>
			</div>
		</div>
</body>
</html>