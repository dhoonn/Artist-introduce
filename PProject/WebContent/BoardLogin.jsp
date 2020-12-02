<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Insert title here</title>
<script>
function goLogin(){
	loginform.submit();
}
</script>
<style>
#main {
	box-sizing: border-box;
	line-height: 140%;
	top: 30%;
	transform: translate(-50%, -50%);
	left: 50%;
	position: absolute;
	padding: 10px;
	font-family: 'Do Hyeon', sans-serif;
	display: block;
	margin: auto;
}

#main h1 {
	text-align: center;
	font-size: 50px;
}

#main input {
	height: 50px;
}

body {
	background-color: #f5f6f7;

}
#btn {
	font-family: 'Do Hyeon', sans-serif;
	left: 0;
	width: 100%;
	height: 50px;
	/* background: linear-gradient(to right, #ff105f, #ffad06); */
	size: 50px;
	transition: .5s;
}

#main a {
	float: right;
	display: block;
	padding: 14px 16px;
	padding: 5px;
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="main">
<form action="boardlogin" method="post" name="loginform">
		<h1>LOGIN</h1>
		<input type="text" name="mid" id="mid" placeholder="아이디" maxlength="20" size="50px">
		<p></p>
		<input type="password" name="mpassword" id="mpassword" placeholder="비밀번호" maxlength="20" size="50px">
		<p></p>
</form>
		<button id="btn" onclick="goLogin()" style="color:white;">로그인</button>
		<p></p>
		<a href="BoardJoin.jsp">회원가입</a> 
		<a href="#">비밀번호 찾기</a> 
		<a href="#">아이디 찾기</a>
	</div>

</body>
</html>