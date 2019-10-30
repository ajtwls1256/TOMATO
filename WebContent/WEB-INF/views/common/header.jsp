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

		
		timer = setInterval(function () {
			//----------------------------------------------------------------------------------
			$.ajax ({
				url : "/headerSearchBox",
				type : "get",
				cache : false,
				success : function (data) { 					
						var searchDiv = $(".header-searchList");
						var searchUl = $("#ticker");
						searchDiv.empty();
					for(var i=0;i<10;i++){
						/* console.log(decodeURIComponent(data[i].searchContent)); */
						var searchP = $("<p>");
						var searchSpan = $("<span class='searchNum'>").html(i+1);
						var searchA = $("<a href='#' class='searchListA'>").html(decodeURIComponent(data[i].searchContent));
						searchP.append(searchSpan).append(searchA);
						searchDiv.append(searchP);
						
						var searchLi = $("<li>");
						var searchA1 = $("<a href='#'>").html(decodeURIComponent(data[i].searchContent));
						var searchSpan1 = $("<span class='sort-num'>").html(i+1);
						searchLi.append(searchA1).prepend(searchSpan1);
						searchUl.append(searchLi);
						
						
					}
					$(".b-navbar").append(searchDiv);
					$(".searchBox").append(searchUl);
				}
			});
			//----------------------------------------------------------------------------------
		}, 2000); // 30초에 한번씩 받아온다.		

	    //인기검색어
   		var ticker = function()
	    {
	        setTimeout(function(){
	            $('#ticker li:first').animate( {marginTop: '-20px'}, 400, function()
	            {
	                $(this).detach().appendTo('ul#ticker').removeAttr('style');
	            });
	            ticker();
	        }, 3000);
	    };
	    ticker();
	    
	    //인기검색어 hover/slideToggle()
/* 	    
	    $(".list").hover(function() {
	    	$(".header-searchList").slideToggle();
	    });
	 */	
		//nav mouse event
		$("#navFunc").mouseenter(function(){
			$("#cate").slideDown();
		});

		$("#cate").mouseleave(function(){
			$("#cate").slideUp();
		});
		//인기검색어
		$(".list").mouseenter(function(){
			$(".header-searchList").slideDown();
		});

		$(".header-searchList").mouseleave(function(){
			$(".header-searchList").slideUp();
		});
		//연관검색어
		//header-searchBox 클릭
		//header-searchBox-list
		$("#header-searchBox").click(function(){
			$(".header-searchBox-list").slideDown();
		});
		$(".header-searchBox-list").mouseleave(function(){
			$(".header-searchBox-list").slideUp();
		});
		
		//top버튼
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
	    
	    //TOP버튼
	    $(".page-top").click(function() {
	        $('html').animate({scrollTop : 0}, 600);
	    });
/* 
	    //알림 버튼 슬라이드 토글
	    $("#header-alarm").hover(function() {
	    	$(".header-alarmBox").slideToggle();
	    });
 */	    
	});
</script>

	<header id="header">
		<div class="header1">
			<div class="con">
				<a href="https://apps.apple.com/app/id395672275" class="header-a" target="_blank"><img id="download" src="/img/download.png"><span>앱다운로드</span></a>
				<span id="head1">
				<a href="/mypage?email=${sessionScope.member.email }" class="header-a">마이페이지</a>
<!-- 				<a href="#" class="header-a" id="header-alarm">알림 <img id="arrow" src="/img/arrow.png"></a>-->
				<a href="/logout" class="header-a" id="logout">로그아웃</a>
				</span>
			</div>
			<div class="header-alarmBox"></div>
		</div>
		<div class="header2">  
			<div class="con" style="position: relative">
				<a href="/login?email=${sessionScope.member.email }&pw=${sessionScope.member.memberPw }" class="a"><img id="logo" src="/img/tomatoLogo.png"></a>
				<input type="text" id="header-searchBox" placeholder="지역, 상품, 업체 등을 검색하세요" >
				<button type="button" class="searchIcon"><img class="searchIcon-img" src="/img/search.png"></button>
				<div class="my-menu">
					<span><a href="/views/enroll.jsp" class="header-a"><img src="/img/money.png" id="money">판매하기</a></span>

					<span><a href="/myshopView?email=${sessionScope.member.email }&memberNo=${sessionScope.member.memberNo }" class="header-a"><img src="/img/myMarket.png" id="myMarket">내 상점</a></span>
					<span><a href="/chatList" class="header-a" id="talk-a"><img src="/img/talk.png" id="talk">토마톡</a></span>

				</div> 
				<div class="header-searchBox-list">
					<!-- 최근검색어 -->
					<p style="font-weight: bold; margin-bottom: 18px; font-size: 16px;">최근검색어</p>  
					<div class="searchBox-list-con">
						<p>바나나<span class="searchList-delete"><button type="button">x</button></span></p> 
						<p>당산역김밥<span class="searchList-delete"><button type="button">x</button></span></p>
						<p>바나나<span class="searchList-delete"><button type="button">x</button></span></p>
						<p>당산역김밥<span class="searchList-delete"><button type="button">x</button></span></p>
						<p>바나나<span class="searchList-delete"><button type="button">x</button></span></p>
						<p>당산역김밥<span class="searchList-delete"><button type="button">x</button></span></p>
					</div>
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
				<div class="block-div" style="float:right;width: 280px;">
				<span style="line-height:40px;font-weight:bold;float:left;">인기검색어</span>
					<div class="searchBox" style="position: relative;">
					    <ul id="ticker">
					        <!-- <li><a href="#"><span class="sort-num"></span></a></li> -->
					    </ul>
					   	<div class="list">▼</div>
					</div>
				</div>
				<div class="header-searchList">
						<!-- <p><span class="SearchNum"></span><a href="#" class="searchListA"></a></p> -->
				</div>
			
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

	<script>
	 $(function(){
         $("#talk-a").click(function(event){
             event.preventDefault();
             
             
             var status = "left=500px, top=100px, width=400px,  height=612px, menubar=no, status=no, scrollbar=yes, resizable=no";
             window.open("/chatList?memberNo="+'${sessionScope.member.memberNo}', "토마톡", status);
             
             
         });
     });
	</script>
	
	<script>
		$(".searchIcon").click(function(){
			
			var search = $("#header-searchBox").val();
			
			// 비어있지않을때만
			if(search != ""){
				
				//alert(search);
				location.href="/search?keyword="+search;
			}
		
		});
	</script>

	

