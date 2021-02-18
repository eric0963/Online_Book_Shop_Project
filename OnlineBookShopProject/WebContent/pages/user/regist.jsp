<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊頁面</title>
<%@ include file="/pages/shared/header.jsp" %>
<script type="text/javascript">
	$(function(){
		
		$("#token").click(function(){
			this.src="${basePath}kaptcha.jpg";
		});
		$("#sub_btn").click(function(){
			
			var username=$("#username").val();
			var spanMsg=$("span.errorMsg");
			var patt=/^\w{5,12}$/;
			if(!patt.test(username)){
				spanMsg.text("帳號格式不正確");
				return false;
			}
			
			var password=$("#password").val();
			var patt=/^\w{5,12}$/;
			if(!patt.test(password)){
				spanMsg.text("密碼格式不正確");
				return false;
			}
			
			var repwd=$("#repwd").val();
			if(repwd !=password ){
				spanMsg.text("確認密碼不正確");
				return false;
			}
			
			var email=$("#email").val();
			var patt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			if(!patt.test(email)){
				spanMsg.text("郵箱格式不正確");
				return false;
			}
			
			var code=$("#code").val();
			code=$.trim(code);
			if(code ==null || code==""){
				spanMsg.text("驗證碼不能為空");
				return false;
			}
			
			spanMsg.text("");
		});
	});
</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/bookLogo.jpg" >
			<span class="wel_word">購書網</span>
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">歡迎註冊</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>註冊會員</h1>
								<span class="errorMsg">
									${requestScope.msg }
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
								<input type="hidden" name="action" value="regist">
									<label>用戶名稱：</label>
									<input class="itxt" type="text" placeholder="請輸入用戶名稱" name="username" id="username" 
										value="${requestScope.username }"/>
									<br />
									<br />
									<label>用戶密碼：</label>
									<input class="itxt" type="password" placeholder="請輸入密碼" name="password" id="password" 
										value="11111"/>
									<br />
									<br />
									<label>確認密碼</label>
									<input class="itxt" type="password" placeholder="請再輸入一次密碼" name="repwd" id="repwd" 
										value="11111"/>
									<br />
									<br />
									<label>郵箱地址：</label>
									<input class="itxt" type="text" placeholder="請輸入郵箱地址" name="email" id="email" 
										value="erc@qq.com"/>
									<br />
									<br />
									<label>驗證碼：</label>
									<input class="itxt" type="text" style="width: 150px;" placeholder="再按一次驗證碼可更新" name="code" id="code"/>
									<img id="token" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:80px;height:40px">									
									<br />
									<br />
									<input type="submit" value="註冊" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>