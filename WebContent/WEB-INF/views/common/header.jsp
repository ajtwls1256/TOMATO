<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/header/header.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(function(){
		$("#navFunc").click(function(){
			$("#cate").slideToggle();
		});
	});
</script>

	<header>
		<div class="header1">
			<div class="con">
				<a href="https://apps.apple.com/app/id395672275"><img id="download" src="/img/download.png"><span>앱다운로드</span></a>
				<span id="head1">
				<a href="#">마이페이지</a>
				<a href="#">알림 <img id="arrow" src="/img/arrow.png"></a>
				<a href="#" id="logout">로그아웃</a>
				</span>
			</div>
		</div>
		<div class="header2"> 
			<div class="con">
				<a href="#"><img id="logo" src="/img/tomatoLogo.png"></a>
				<input type="text" id="searchBox" placeholder="지역, 상품, 업체 등을 검색하세요" >
				<!-- <div id="searchIcon"></div> --> 
				<div class="my-menu">
					<span><a href="#"><img src="/img/money.png" id="money">판매하기</a></span>
					<span><a href="#"><img src="/img/myMarket.png" id="myMarket">내 상점</a></span>
					<span><a href="#"><img src="/img/talk.png" id="talk">토마톡</a></span>
				</div>
			</div>
		</div>
	</header>
	<nav>
		<div class="navbar">
			<span id="navFunc">
				<img src="/img/menu.png">
				<span id="cate-span">카테고리 선택 > </span>
			</span>
			<div class="sort"><!-- http://blog.naver.com/PostView.nhn?blogId=nonamed0000&logNo=220861656041 -->
					<span>인기검색어</span>
					<div id="searchCount">
						<span></span>
					</div>
			</div>
		</div>
		
		<div id="cate">  
			<ul class="cate1-ul">
				<li class="cate1-li"><a href="#">여성의류</a></li>
				<li class="cate1-li"><a href="#">남성의류</a></li>
				<li class="cate1-li"><a href="#">뷰티/미용</a></li>
				<li class="cate1-li"><a href="#">디지털/가전</a></li>
				<li class="cate1-li"><a href="#">도서/티켓</a></li>
				<li class="cate1-li"><a href="#">스타굿즈</a></li>
				<li class="cate1-li"><a href="#">생활/가구</a></li>
				<li class="cate1-li"><a href="#">기타</a></li>
			</ul>
			<ul class="cate2-ul" id="cate2-ul1">
				<li class="cate2-li"><a href="#">상의</a></li>
				<li class="cate2-li"><a href="#">하의</a></li>
				<li class="cate2-li"><a href="#">원피스</a></li>
				<li class="cate2-li"><a href="#">스포츠</a></li>
				<li class="cate2-li"><a href="#">아우터</a></li>
				<li class="cate2-li"><a href="#">신발</a></li>
			</ul>
			<ul class="cate2-ul">
				<li class="cate2-li"><a href="#">상의</a></li>
				<li class="cate2-li"><a href="#">하의</a></li>
				<li class="cate2-li"><a href="#">스포츠</a></li>
				<li class="cate2-li"><a href="#">아우터</a></li>
				<li class="cate2-li"><a href="#">신발</a></li>
			</ul>
			<ul class="cate2-ul">
				<li class="cate2-li"><a href="#">색조화장품</a></li>
				<li class="cate2-li"><a href="#">기초화장품</a></li>
				<li class="cate2-li"><a href="#">남성화장품</a></li>
				<li class="cate2-li"><a href="#">식품</a></li>
			</ul>
			<ul class="cate2-ul">
				<li class="cate2-li"><a href="#">PC/노트북</a></li>
				<li class="cate2-li"><a href="#">카메라</a></li>
				<li class="cate2-li"><a href="#">가전제품</a></li>
				<li class="cate2-li"><a href="#">게임</a></li>
			</ul>
			<ul class="cate2-ul">
				<li class="cate2-li"><a href="#">상품권</a></li>
				<li class="cate2-li"><a href="#">도서</a></li>
				<li class="cate2-li"><a href="#">티켓</a></li>
				<li class="cate2-li"><a href="#">기프티콘</a></li>
			</ul>
			<ul class="cate2-ul">
				<li class="cate2-li"><a href="#">보이그룹</a></li>
				<li class="cate2-li"><a href="#">걸그룹</a></li>
				<li class="cate2-li"><a href="#">기타</a></li>
			</ul>
			<ul class="cate2-ul">
				<li class="cate2-li"><a href="#">생활용품</a></li>
				<li class="cate2-li"><a href="#">주방용품</a></li>
				<li class="cate2-li"><a href="#">가구</a></li>
				<li class="cate2-li"><a href="#">식품</a></li>
			</ul>
		</div>
	</nav>
	<div class="nav-border"></div>