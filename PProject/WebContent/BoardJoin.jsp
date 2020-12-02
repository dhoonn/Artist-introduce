<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />

<script>
	function pwdCheck() {
		//비밀번호 검증을 위한 정규식
		var exp = /^[A-Za-z0-9]{8,16}$/;
		var pwd = document.getElementById("mpassword").value;
		var pwdch = document.getElementById("pwdch");
		if (pwd.match(exp)) {
			pwdch.style.color = "green";
			pwdch.innerHTML = "비밀번호 형식 맞음";
		} else {
			pwdch.style.color = "red";
			pwdch.innerHTML = "비밀번호 형식 틀림";
		}
	}
	function idCheck() {
		var exp = /^[a-z]+[a-z0-9]{4,19}$/g;
		var id = document.getElementById("mid").value;
		if (id.match(exp)) {
			alert('완료되었습니다.');
		} else if (id.length == 0) {
			alert('아이디를 입력하세요');

		} else {
			alert('아이디를 5~20자로 입력하세요');
		}
	}
	function phoneCheck() {
		//전화번호 유효성 검증
		var exp = /^\d{3}-\d{4}-\d{4}$/;
		var phoned = document.getElementById("mphone").value;
		var phonech = document.getElementById("phonech");
		if (phoned.match(exp)) {
			phonech.style.color = "green";
			phonech.innerHTML = "핸드폰번호 형식 맞음";
		} else {
			phonech.style.color = "red";
			phonech.innerHTML = "핸드폰번호 형식 틀림";
		}
	}
	function disapper() {
		document.getElementById("phonech").innerHTML = "";
	}
	function boardJoin() {
		joinform.submit();
	}
</script>
<style>
        .sign {
            
            display: block;
            margin: auto;
        
        }
        #main{
            box-sizing: border-box;
            line-height: 140%;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            position: absolute;
            padding: 10px; 
            font-family: 'Do Hyeon', sans-serif;
            
        }
     
</style>
</head>	
<body>
	<form action="boardjoin" method="post" name="joinform"
		enctype="multipart/form-data">
		<div id="main" class="sign">
		<h1>SIGN UP</h1>
		아이디<br> <input type="text" name="mid" id="mid"
			placeholder="아이디를 입력하세요" maxlength="20" size="50px">
		<!-- <button id="btn" onclick="idCheck()">아이디체크</button> -->
		<input type="button" onclick="idCheck()" value="아이디체크">

		<p></p>
		비밀번호<br> <input type="text" name="mpassword" id="mpassword"
			maxlength="20" placeholder="비밀번호를 입력하세요" size="50px"
			onkeyup="pwdCheck()"><br> <span id="pwdch"></span><br>
		<p></p>
		닉네임<br> <input type="text" name="mname" id="mname" size="50px"><br>
		<p></p>
		이메일<br> <input type="text" name="memail" id="memail" size="50px"><br>
		<p></p>
		휴대전화<br> <input type="text" id="mphone" name="mphone"
			placeholder="휴대폰 번호를 입력하세요" size="50px" onkeyup="phoneCheck()"
			onblur="disapper()"><br> <span id="phonech"></span>
		<p></p>
		프로필 사진<br> <input type="file" name="mprofile" id="mprofile"><br>
		<p></p>
		<button id="btn" onclick="boardJoin()" style="width:100%; color:white;" >가입하기</button>
		</div>
	</form>

</body>
</html>

