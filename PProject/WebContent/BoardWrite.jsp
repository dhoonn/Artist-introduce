<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<title>Insert title here</title>
<style>
.sign {
	display: block;
	margin: auto;
}

#main {
	box-sizing: border-box;
	line-height: 140%;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	position: absolute;
	padding: 10px;
	font-family: 'Do Hyeon', sans-serif;
}

option {
	position: absolute;
	background-color: #FF6382;
	top: 100%;
	left: 0;
	right: 0;
	z-index: 99;
}
</style>
<script>
	function boardWrite() {
		writeform.submit();
	}
</script>
</head>
<body>
	<form action="boardwrite" method="post" name="writeform"
		enctype="multipart/form-data">
		<div id="main">
			<h1>NEW PROJECT</h1>
			작성자<br> <input type="text" name="bwriter" id="bwriter"
				size="50px" value="${sessionScope.loginId}" readonly><br>
			제목<br> <input type="text" name="btitle" id="btitle" size="50px"><br>
			카테고리<br> <select name="bcategory" id="bcategory">
				<option value="디자인">디자인</option>
				<option value="사진">사진</option>
				<option value="일러스트">일러스트</option>
				<option value="스타일">스타일</option>
				<option value="동물">동물</option>
				<option value="인물">인물</option>
				<option value="스포츠">스포츠</option>
				<option value="연예인">연예인</option>
				<option value="자연">자연</option>
				<option value="여행">여행</option>
				<option value="문신">문신</option>
				<option value="웨딩">웨딩</option>
				<option value="음식">어린이</option>
				<option value="캐릭터">캐릭터</option>
			</select> <br> 내용<br>
			<textarea rows="10" cols="10" type="text" size="50px"
				name="bcontent" id="bcontent"></textarea>
			첨부파일<br> <input type="file" name="bfile" id="bfile"><br>
			<br> 
			<input type="button" style="width: 100%;" onclick="boardWrite()" value="작성하기">

		</div>
	</form>

</body>
</html>