<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<link rel="stylesheet" href="/css/admin/adminHeader.css"/>
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
     <script>
        $(function(){
            $("#menu3").click(function(){
                $("#menu3_ul").slideToggle();
                if($("#menu3_s").html()=="▼"){
                    $("#menu3_s").html("▲");
                }else{
                    $("#menu3_s").html("▼");
                }
            });
            $("#menu5").click(function(){
                $("#menu5_ul").slideToggle();
                if($("#menu6_s").html()=="▼"){
                    $("#menu6_s").html("▲");
                }else{
                    $("#menu6_s").html("▼");
                }
            });
        });
    </script>	
	
	<header>
		<div class="admin-header">
			<div class="admin-con1"> 
				<span style="font-weight: bold;" class="admin-con1-span">TOMATOMARKET</span> <span style="font-weight: nomal;">ADMINPAGE</span>
				<span style="float: right; line-height: 14px;"><a href="#" style="text-decoration:none;color:white;padding-right: 10px;line-height:20px;">LOGOUT</a></span>
			</div>
		</div>	
	</header>
	
	<nav>			
		<div class="admin-nav"> 
			<div class="admin-profile">
				<div class="admin-profile-img"></div>
				<p class="admin-nav-id">admin</p>
			</div>
		
			<ul class="admin-nav-ul">
	            <li class="admin-nav-li">
		            <img class="admin-nav-img" src="/img/admin/menu1.png">
		            <a class="admin-header-a" href="#">메인</a>
	            </li>
	            <li class="admin-nav-li">
		            <img class="admin-nav-img" src="/img/admin/menu2.png">
		            <a class="admin-header-a" href="/admin/adminMember.jsp">회원관리</a>
	            </li>
	            <li class="admin-nav-li" id="menu3">
		            <img class="admin-nav-img" src="/img/admin/menu3.png">
		            <a class="admin-header-a" href="#">상품관리</a> <span class="li-list" id="menu3_s">▼</span>
	            </li>
	                <ul class="admin-nav-li-ul" id="menu3_ul" style="display: none">
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="/admin/adminMdList.jsp">상품목록</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="/admin/adminMdQuestion.jsp">상품문의</a></li>
	                </ul>
	            <li class="admin-nav-li">
		            <img class="admin-nav-img" src="/img/admin/menu4.png">
		            <a class="admin-header-a" href="/admin/adminReview.jsp">상점관리</a>
	            </li>
	            <li class="admin-nav-li">
		            <img class="admin-nav-img" src="/img/admin/menu5.png">
		            <a class="admin-header-a" href="/admin/adminPayment.jsp">결제관리</a>
	            </li>
	            <li class="admin-nav-li" id="menu5">
		            <img class="admin-nav-img" src="/img/admin/menu6.png">
		            <a class="admin-header-a" href="#">게시판관리</a> <span class="li-list" id="menu6_s">▼</span>
	            </li>
	                <ul class="admin-nav-li-ul" id="menu5_ul" style="display: none">
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="#">공지사항 작성</a></li>
	                    <li class="admin-nav-li-li"><a class="admin-header-a" href="#">1:1 문의 답변</a></li>
	                </ul>
	        </ul>
		</div>
	</nav>