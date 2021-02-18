<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
<%@ include file="/pages/shared/header.jsp" %>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/bookLogo.jpg" >
			<span class="wel_word">購書網</span>
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">歡迎登入</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>會員登入</h1>
								<a href="pages/user/regist.jsp">立即註冊</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
									<%=request.getAttribute("msg")==null?"請輸入用戶名稱和密碼":request.getAttribute("msg") %>
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
								<input type="hidden" name="action" value="login">
									<label>用戶名稱：</label>
									<input class="itxt" type="text" placeholder="請輸入用戶名稱" name="username" value="${requestScope.username } "/>
									<br />
									<br />
									<label>用戶密碼：</label>
									<input class="itxt" type="password" placeholder="請輸入密碼" name="password" value="11111"/>
									<br />
									<br />
									<input type="submit" value="登入" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
	<%@ include file="/pages/shared/footer.jsp" %>
</body>
</html>