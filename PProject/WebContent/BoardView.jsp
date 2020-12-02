<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
<title>Insert title here</title>
<style>
#image{
	width: 45%;
	float: left;
	border-radius: 10px;
	position: absolute;
}
#content{
	width: 45%;
	float: right;
	font-size: 30px;
}

</style>
<script>
/* function like(){
	location.href="boardlike?bnumber="+${boardView.bnumber};
}

function follow(){
	alert("팔로우하였습니다.");
/* 	location.href="boardfollow?bnumber="+${boardView.bnumber}+"&bwriter="+${boardView.bwriter}; 
} 
*/
</script>
</head>
<body style="padding: 14px 16px;">
		<div id="image">
			<img src="images/${boardView.bfile}"  width="450px" hight="100%" style="border-radius: 5px;">
		</div>
		<div id="content">
	<br> 작성일자 : ${boardView.bdate}	
	<br> 글쓴이 : ${boardView.bwriter}
<%-- 	<c:if test="${sessionScope.loginId != '${sessionScope.loginId' }">
		<!-- <button onclick="follow()">팔로우</button> -->
		
	</c:if> --%>
		<button onclick="location.href='boardfollow?bnumber=${boardView.bnumber}&bwriter=${boardView.bwriter}'">팔로우</button>
	<br> 제목 : ${boardView.btitle}
	<br> 내용 : ${boardView.bcontent}
	<br> 조회수 : ${boardView.bhits}<br>
<a onclick="location.href='boardlike?bnumber=${boardView.bnumber}'" class="fas fa-heart"style="border:none; font-size:40px"><span class="label">&nbsp${boardView.blike}</span></a>
	<br><c:if test="${sessionScope.loginId eq boardView.bwriter}">
		<button onclick="location.href='boardupdate?bnumber=${boardView.bnumber}'">수정하기</button>	
		</c:if> 
		</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.poptrox.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>