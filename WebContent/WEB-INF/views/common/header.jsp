<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/header/header.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script>
	$(function(){
		$(".nav-hover").hover(function(){
			$("#cate").slideToggle();
		});
	});
</script>

	<header id="header">
		<div class="header1">
			<div class="con">
				<a href="https://apps.apple.com/app/id395672275" class="a" target="_blank"><img id="download" src="/img/download.png"><span>앱다운로드</span></a>
				<span id="head1">
				<a href="#" class="a">마이페이지</a>
				<a href="#" class="a">알림 <img id="arrow" src="/img/arrow.png"></a>
				<a href="#" class="a" id="logout">로그아웃</a>
				</span>
			</div>
		</div>
		<div class="header2"> 
			<div class="con">
				<a href="#" class="a"><img id="logo" src="/img/tomatoLogo.png"></a>
				<input type="text" id="searchBox" placeholder="지역, 상품, 업체 등을 검색하세요" >
				<!-- <div id="searchIcon"></div> --> 
				<div class="my-menu">
					<span><a href="#" class="a"><img src="/img/money.png" id="money">판매하기</a></span>
					<span><a href="#" class="a"><img src="/img/myMarket.png" id="myMarket">내 상점</a></span>
					<span><a href="#" class="a"><img src="/img/talk.png" id="talk">토마톡</a></span>
				</div> 
			</div>
		</div>
	</header>
	<nav>    
	 	<div class="nav-hover">
			<div class="b-navbar">
				<span id="navFunc">
					<img class="nav-img" src="/img/menu.png">
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
					<li class="cate1-li"><a href="#" class="a">여성의류</a></li>
					<li class="cate1-li"><a href="#" class="a">남성의류</a></li>
					<li class="cate1-li"><a href="#" class="a">뷰티/미용</a></li>
					<li class="cate1-li"><a href="#" class="a">디지털/가전</a></li>
					<li class="cate1-li"><a href="#" class="a">도서/티켓</a></li>
					<li class="cate1-li"><a href="#" class="a">스타굿즈</a></li>
					<li class="cate1-li"><a href="#" class="a">생활/가구</a></li>
					<li class="cate1-li"><a href="#" class="a">기타</a></li>
				</ul>
				<ul class="cate2-ul" id="cate2-ul1">
					<li class="cate2-li"><a href="#"class="a">상의</a></li>
					<li class="cate2-li"><a href="#"class="a">하의</a></li>
					<li class="cate2-li"><a href="#"class="a">원피스</a></li>
					<li class="cate2-li"><a href="#"class="a">스포츠</a></li>
					<li class="cate2-li"><a href="#"class="a">아우터</a></li>
					<li class="cate2-li"><a href="#"class="a">신발</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="a">상의</a></li>
					<li class="cate2-li"><a href="#"class="a">하의</a></li>
					<li class="cate2-li"><a href="#"class="a">스포츠</a></li>
					<li class="cate2-li"><a href="#"class="a">아우터</a></li>
					<li class="cate2-li"><a href="#"class="a">신발</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="a">색조화장품</a></li>
					<li class="cate2-li"><a href="#"class="a">기초화장품</a></li>
					<li class="cate2-li"><a href="#"class="a">남성화장품</a></li>
					<li class="cate2-li"><a href="#"class="a">식품</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="a">PC/노트북</a></li>
					<li class="cate2-li"><a href="#"class="a">카메라</a></li>
					<li class="cate2-li"><a href="#"class="a">가전제품</a></li>
					<li class="cate2-li"><a href="#"class="a">게임</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="a">상품권</a></li>
					<li class="cate2-li"><a href="#"class="a">도서</a></li>
					<li class="cate2-li"><a href="#"class="a">티켓</a></li>
					<li class="cate2-li"><a href="#"class="a">기프티콘</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="a">보이그룹</a></li>
					<li class="cate2-li"><a href="#"class="a">걸그룹</a></li>
					<li class="cate2-li"><a href="#"class="a">기타</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="a">생활용품</a></li>
					<li class="cate2-li"><a href="#"class="a">주방용품</a></li>
					<li class="cate2-li"><a href="#"class="a">가구</a></li>
					<li class="cate2-li"><a href="#"class="a">식품</a></li>
				</ul>
			</div>
		</div>	
	</nav>
	<div class="nav-border"></div>
	 
	<div class="page-top">
		<div class="page-top-div"><a href="#header" class="page-top-a">TOP</a></div>
	</div> 
	<div class="cate-go">
		<!-- <div class="cate-go-div-title">바로가기</div> -->		
		<div class="cate-go-div"><a href="#cate1"><img class="cate-go-img" src="/img/cate1.png"></a></div>
		<div class="cate-go-div"><a href="#cate2"><img class="cate-go-img" src="/img/cate2.png"></a></div>
		<div class="cate-go-div"><a href="#cate3"><img class="cate-go-img" src="/img/cate3.png"></a></div>
		<div class="cate-go-div"><a href="#cate4"><img class="cate-go-img" src="/img/cate4.png"></a></div>
		<div class="cate-go-div"><a href="#cate5"><img class="cate-go-img" src="/img/cate5.png"></a></div>
		<div class="cate-go-div"><a href="#cate6"><img class="cate-go-img" src="/img/cate6.png"></a></div>
		<div class="cate-go-div"><a href="#cate7"><img class="cate-go-img" src="/img/cate7.png"></a></div>		
	</div>