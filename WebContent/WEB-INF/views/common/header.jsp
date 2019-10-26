<%@page import="kr.co.tomato.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/header/header.css">


<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script>
	$(function(){
		$("#navFunc").hover(function(){
			$("#cate").slideToggle();
		});
		$(window).scroll(function() {
		        if ($(this).scrollTop() > 400) {
		            $('.cate-go').fadeIn();
		        } else {
		            $('.cate-go').fadeOut();
		        }
		    });	   
	    $(window).scroll(function() {
	        if ($(this).scrollTop() > 300) {
	            $('.page-top').fadeIn();
	        } else {
	            $('.page-top').fadeOut(); 
	        }
	    });
	    
	        
	    $(".page-top").click(function() {
	        $('html').animate({scrollTop : 0}, 600);
	    });
	    
	    $(".sort").hover(function() {
	    	$(".header-searchBox").slideToggle();
	    });
	    
	    $("#header-alarm").hover(function() {
	    	$(".header-alarmBox").slideToggle();
	    });
	});

/* 	$(".page-top").hide();

	// 스크롤이 되면 버튼이 나타남 
	$(function () {
	   $(window).scroll(function () {
	        if ($(this).scrollTop() > 100) {
	              $('.page-top').fadeIn();
	         } else {
	              $('.page-top').fadeOut();
	         }
	});	 */

</script>

	<header id="header">
		<div class="header1">
			<div class="con">
				<a href="https://apps.apple.com/app/id395672275" class="header-a" target="_blank"><img id="download" src="/img/download.png"><span>앱다운로드</span></a>
				<span id="head1">
				<a href="/mypage?email=${sessionScope.member.email }" class="header-a">마이페이지</a>
				<a href="#" class="header-a" id="header-alarm">알림 <img id="arrow" src="/img/arrow.png"></a>
				<a href="/logout" class="header-a" id="logout">로그아웃</a>
				</span>
			</div>
			<div class="header-alarmBox"></div>
		</div>
		<div class="header2">  
			<div class="con">
				<a href="#" class="a"><img id="logo" src="/img/tomatoLogo.png"></a>
				<input type="text" id="searchBox" placeholder="지역, 상품, 업체 등을 검색하세요" >
				<button type="button" class="searchIcon"><img class="searchIcon-img" src="/img/search.png"></button>
				<div class="my-menu">
					<span><a href="/views/enroll.jsp" class="header-a"><img src="/img/money.png" id="money">판매하기</a></span>
					<span><a href="#" class="header-a"><img src="/img/myMarket.png" id="myMarket">내 상점</a></span>
					<span><a href="#" class="header-a" id="talk-a"><img src="/img/talk.png" id="talk">토마톡</a></span>
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
						<div id="searchCount" style="display:inline-block; width:170px; text-align:left;">
							<p style="display:inline-block; width: 30px; margin: 0px; text-align: center;">1.</p>
							<p style="display:inline-block; width: 120px; margin: 0px;">아이패드</p>
							<p style="display:inline-block; width: 10px; margin: 0px; font-size:5px; padding-botton: 5px;">▼</p>
						</div>
				</div>
				<div class="header-searchBox"></div>
			</div>
			
			<div id="cate">  
				<ul class="cate1-ul">
					<li class="cate1-li"><a href="#" class="header-a">여성의류</a></li>
					<li class="cate1-li"><a href="#" class="header-a">남성의류</a></li>
					<li class="cate1-li"><a href="#" class="header-a">뷰티/미용</a></li>
					<li class="cate1-li"><a href="#" class="header-a">디지털/가전</a></li>
					<li class="cate1-li"><a href="#" class="header-a">도서/티켓</a></li>
					<li class="cate1-li"><a href="#" class="header-a">스타굿즈</a></li>
					<li class="cate1-li"><a href="#" class="header-a">생활/가구</a></li>
					<li class="cate1-li"><a href="#" class="header-a">기타</a></li>
				</ul>
				<ul class="cate2-ul" id="cate2-ul1">
					<li class="cate2-li"><a href="#"class="header-a">상의</a></li>
					<li class="cate2-li"><a href="#"class="header-a">하의</a></li>
					<li class="cate2-li"><a href="#"class="header-a">원피스</a></li>
					<li class="cate2-li"><a href="#"class="header-a">스포츠</a></li>
					<li class="cate2-li"><a href="#"class="header-a">아우터</a></li>
					<li class="cate2-li"><a href="#"class="header-a">신발</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="header-a">상의</a></li>
					<li class="cate2-li"><a href="#"class="header-a">하의</a></li>
					<li class="cate2-li"><a href="#"class="header-a">스포츠</a></li>
					<li class="cate2-li"><a href="#"class="header-a">아우터</a></li>
					<li class="cate2-li"><a href="#"class="header-a">신발</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="header-a">색조화장품</a></li>
					<li class="cate2-li"><a href="#"class="header-a">기초화장품</a></li>
					<li class="cate2-li"><a href="#"class="header-a">남성화장품</a></li>
					<li class="cate2-li"><a href="#"class="header-a">식품</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="header-a">PC/노트북</a></li>
					<li class="cate2-li"><a href="#"class="header-a">카메라</a></li>
					<li class="cate2-li"><a href="#"class="header-a">가전제품</a></li>
					<li class="cate2-li"><a href="#"class="header-a">게임</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="header-a">상품권</a></li>
					<li class="cate2-li"><a href="#"class="header-a">도서</a></li>
					<li class="cate2-li"><a href="#"class="header-a">티켓</a></li>
					<li class="cate2-li"><a href="#"class="header-a">기프티콘</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="header-a">보이그룹</a></li>
					<li class="cate2-li"><a href="#"class="header-a">걸그룹</a></li>
					<li class="cate2-li"><a href="#"class="header-a">기타</a></li>
				</ul>
				<ul class="cate2-ul">
					<li class="cate2-li"><a href="#"class="header-a">생활용품</a></li>
					<li class="cate2-li"><a href="#"class="header-a">주방용품</a></li>
					<li class="cate2-li"><a href="#"class="header-a">가구</a></li>
					<li class="cate2-li"><a href="#"class="header-a">식품</a></li>
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
	
	
	<script>
	 $(function(){
         $("#talk-a").click(function(event){
             event.preventDefault();
             
             
             var status = "left=500px, top=100px, width=400px,  height=590px, menubar=no, status=no, scrollbar=yes, resizable=no";
             window.open("/chatList?memberNo="+${sessionScope.member.memberNo}, "토마톡", status);
             
             
         });
     });
	</script>
