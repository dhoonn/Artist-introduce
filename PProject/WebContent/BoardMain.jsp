<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<style>
body {
	/* margin: 0; */
	/* font-size: 28px; */
	font-family: Arial, Helvetica, sans-serif;
}

#navbar {
	overflow: hidden;
	/* background-color: white; */
	padding: 20px;
}

#navbar a {
	float: left;
	display: block;
	/* color: black; */
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 20px;
	border: none;
}

#navbar a:hover {
	/* background-color: #ddd; */
	/* color: black; */
	/* border-radius: 40px; */
	
}

#navbar a.active {
	/* background-color: black; */
	/* border-radius: 40px; */
	color: white;
}

.sticky {
	position: fixed;
	top: 0;
	width: 100%;
}

.sticky+.content {
	padding-top: 60px;
}

/* img {
	border-radius: 20px;
} */
#columns {
	column-width: 252px;
	column-gap: 15px;
	padding: 40px;
	padding-top: 10%;
}

#columns figure {
	display: inline-block;
	border: none;
	margin: 0;
	margin-bottom: 15px;
	padding: 3px;
}

#columns figure img {
	width: 273px;
}

#columns figure figcaption {
	padding: 10px;
	margin-top: 11px;
}

#columns a {
	border: none;
}

li {
	float: left;
	list-style: none;
}

#keword {
	background-image: url(images/search-icon.png);
	background-position: 5px center;
	padding-left: 40px;
	/* border: 1px solid #2e3238; */
	width: 100%;
	height: 30px;
	box-sizing: border-box;
	outline: none;
	background-repeat: no-repeat;
	font-size: 20px;
}

.navbar input[type=text] {
	float: right;
	padding: 6px;
	border: none;
	margin-top: 8px;
	margin-right: 16px;
	font-size: 17px;
}
</style>
<script>


	function showPopup(number) {
var popupX = (window.screen.width / 2) - (1000 / 2);
//만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

var popupY= (window.screen.height /2) - (500 / 2);
//만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

		window.open("boardview?bnumber=" + number, "a",
				"status=no, height=600, width=1000, left="+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
				
	}
	
	function followlist(){
		location.href="followlist";
	}
	
	function search(){
		var keyword = document.getElementById("keyword").value;
		location.href="boardsearch?keyword="+keyword;
	}
</script>

</head>

<body>



	<div id="navbar">
		<ul>
			<li><a class="active" href="boardmain">Home</a></li>
			<li><a onclick="followlist()">Follow</a></li>
			<li><a href="BoardWrite.jsp">New</a></li>
		</ul>
		<div class="search-container">
				<input type="text"placeholder="Search.." id="keyword"
					style="width: 65%; border-radius: 10px;" autocapitalize="off"
					autocomplete="off">
					<button onclick="search()">검색</button>
		</div>
	</div>
	<div>
		<p>${sessionScope.loginId}님 환영합니다.</p>
	</div>
	<!-- <div class="header">
		<h2>Scroll Down</h2>
		<p>Scroll down to see the sticky effect.</p>
	</div> -->
	<div id="columns">
		<c:forEach var="board" items="${boardList}">
			<figure class="thumbnails">
				<a href="" onclick="showPopup('${board.bnumber}');"> <img src="images/${board.bfile}">
				</a>
			</figure>
		</c:forEach>
		<figure class="thumbnails">
		<a href="images/fulls/05.jpg"> <img src="images/thumbs/05.jpg">
		</a>
		</figure>
		
	</div>


	<script>
		window.onscroll = function() {
			myFunction()
		};

		var navbar = document.getElementById("navbar");
		var sticky = navbar.offsetTop;

		function myFunction() {
			if (window.pageYOffset >= sticky) {
				navbar.classList.add("sticky")
			} else {
				navbar.classList.remove("sticky");
			}
		}
	</script>
	<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/main.js"></script>
</body>

</html>