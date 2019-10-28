<%@page import="kr.co.tomato.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>토마토마켓</title>	
<link rel="stylesheet" href="/css/index.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <style>
.kakao-button-div{
    border-bottom : 1px solid #ededed;
}
.kakao-button{
	background-color : #fff;
	width:100%;
    height:38px;
    line-height:38px;
    box-shadow: 0 1px 7px 0 rgba(0,0,0,.05);
	margin-bottom:30px;
    border-radius: 4px;
    border:0;
}
.modal-header,.modal-body,.modal-footer{
	background: #f7f7f7;
}
.btn.btn-success.btn-block{
	background-color :#c42026;
	border-color: #fff;
	border:0;
	margin-top:20px;
}
.password{
	font-size:13px; 
	text-align:center;
	margin-top:10px;
}
.password,a{
	color:black;
}
.modal-footer{
	margin:auto;
}
.joinMember{
	display:inline-box;
	text-align:center;
	margin-top:10px;
	margin-bottom:10px;
}
</style> 
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

	<section>
	<div class="con">

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
			    <li data-target="#myCarousel" data-slide-to="3"></li>
			    <li data-target="#myCarousel" data-slide-to="4"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner">
			    <div class="item active">
			      <img src="/img/slider/slider4.png" alt="">
			    </div>
			
			    <div class="item">
			      <img src="/img/slider/slider2.png" alt="">
			    </div>
			
			    <div class="item">
			      <img src="/img/slider/slider3.png" alt="">
			    </div>
			    
			    <div class="item">
			      <img src="/img/slider/slider1.png" alt="">
			    </div>
			
			    <div class="item">
			      <img src="/img/slider/slider3.png" alt="">
			    </div>
			  </div>
<!-- 			
			  Left and right controls
			  <a class="left" href="#myCarousel" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right" href="#myCarousel" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right"></span>
			    <span class="sr-only">Next</span>
			  </a>
 -->
			</div>			

	  		<div class="con1"> 
	  			<div class="title"><span>우리동네 인기 매물</span></div>
		  			<div class="conSlider">
			  			<div class="mdSlider1">
				  			<c:choose>
					  			<c:when test="${ empty size }" ><%--선호하는 지역이 없을 때 --%>
					  				<div class="md md1" style="margin-right:16px">
					  					<div class="md-div"><div class="md-img md-img1"></div></div>
					  					<p class="md-name md-name1">베이지색 숏패딩</p>
					  					<span class="md-price md-price1">28,000</span>
					  					<span class="md-region md-region1">영등포구</span>
					  				</div>   
					  				<div class="md md2" style="margin-right:16px">
					  					<div class="md-div"><div class="md-img md-img2"></div></div>
					  					<p class="md-name md-name1">i5-2500 ram8G</p>
					  					<span class="md-price md-price2">220,000원</span>
					  					<span class="md-region md-region2">영등포구</span>
					  				</div>
					  				<div class="md md3" style="margin-right:16px"> 
					  					<div class="md-div"><div class="md-img md-img3"></div></div>
					  					<p class="md-name md-name1">애플워치3 38미리</p>
					  					<span class="md-price md-price3">190,000원</span>
					  					<span class="md-region md-region3">영등포구</span>
					  				</div>	  				
					  				<div class="md md4">
					  					<div class="md-div"><div class="md-img md-img4"></div></div>
					  					<p class="md-name md-name1">스피드러너</p>
					  					<span class="md-price md-price4">100,000</span>
					  					<span class="md-region md-region4">영등포구</span>
					  				</div>
					  			</c:when>				  			
					  			<c:otherwise>
						  			<c:forEach items="${iList }" var="i" varStatus="s">
							  			<c:choose>
							  				<c:when test="${s.count eq 1 }" >
								  				<div class="md md1" style="margin-right:16px">
								  					<div class="md-div">
														<img class="md-img" src="/upload/product/${i.itemThumFilepath }" alt="사진1">
													</div>
								  					<p class="md-name md-name1">${i.itemName }</p>
								  					<span class="md-price md-price1">${i.itemPrice }원</span>
								  					<span class="md-region md-region1">${i.itemDealRegion }</span>
								  				</div> 
							  				</c:when>
							  				<c:when test="${s.count eq 2 }">
								  				<div class="md md2" style="margin-right:16px">
								  					<div class="md-div">
														<img class="md-img" src="/upload/product/${i.itemThumFilepath }" alt="사진2">
													</div>
								  					<p class="md-name md-name2">${i.itemName }</p>
								  					<span class="md-price md-price2">${i.itemPrice }원</span>
								  					<span class="md-region md-region2">${i.itemDealRegion }</span>
								  				</div> 
							  				</c:when>
							  				<c:when test="${s.count eq 3 }">
								  				<div class="md md3" style="margin-right:16px">
								  					<div class="md-div">
														<img class="md-img" src="/upload/product/${i.itemThumFilepath }" alt="사진3">
													</div>
								  					<p class="md-name md-name3">${i.itemName }</p>
								  					<span class="md-price md-price3">${i.itemPrice }원</span>
								  					<span class="md-region md-region3">${i.itemDealRegion }</span>
								  				</div> 
							  				</c:when>
							  				<c:when test="${s.count eq 4 }">
								  				<div class="md md4">
								  					<div class="md-div">
														<img class="md-img" src="/upload/product/${i.itemThumFilepath }" alt="사진4">
													</div>
								  					<p class="md-name md-name4">${i.itemName }</p>
								  					<span class="md-price md-price4">${i.itemPrice }원</span>
								  					<span class="md-region md-region4">${i.itemDealRegion }</span>
								  				</div> 
							  				</c:when>  
							  			</c:choose>
						  			</c:forEach>			  				
					  			</c:otherwise>
					  			
				  			</c:choose>	
			  			</div>
			  		</div>
  		
	  		</div> 
	  		
	  		<div class="con2">
	  			<div class="title" style="margin-top:40px"><span>카테고리별 인기 상품</span></div>
<!-- 1 여성의류 -->	  			
	  			<div class="cate1-title" class="cate-title" id="cate1"><h3 style="font-weight:bold; font-size:20px;">여성의류 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			
	  			<div class="cate1-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate1-md cate1-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md1-img"></div></div>
				  				<p class="cate-md-name cate1-md1-name">안녕</p>
				  				<span class="cate-md-price cate1-md1-price">50,000원</span>
				  				<span class="cate-md-time cate1-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate1-md cate1-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate1-md2-img"></div></div>
				  				<p class="cate-md-name cate1-md2-name"></p>
				  				<span class="cate-md-price cate1-md2-price"></span>
				  				<span class="cate-md-time cate1-md2-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md3-img"></div></div>
				  				<p class="cate-md-name cate1-md3-name"></p>
				  				<span class="cate-md-price cate1-md3-price"></span>
				  				<span class="cate-md-time cate1-md3-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md4-img"></div></div>
				  				<p class="cate-md-name cate1-md4-name"></p>
				  				<span class="cate-md-price cate1-md4-price"></span>
				  				<span class="cate-md-time cate1-md4-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md5-img"></div></div>
				  				<p class="cate-md-name cate1-md5-name"></p>
				  				<span class="cate-md-price cate1-md5-price"></span>
				  				<span class="cate-md-time cate1-md5-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md6-img"></div></div>
				  				<p class="cate-md-name cate1-md6-name"></p>
				  				<span class="cate-md-price cate1-md6-price"></span>
				  				<span class="cate-md-time cate1-md6-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md7-img"></div></div>
				  				<p class="cate-md-name cate1-md7-name"></p>
				  				<span class="cate-md-price cate1-md7-price"></span>
				  				<span class="cate-md-time cate1-md7-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md8-img"></div></div>
				  				<p class="cate-md-name cate1-md8-name"></p>
				  				<span class="cate-md-price cate1-md8-price"></span>
				  				<span class="cate-md-time cate1-md8-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md9-img"></div></div>
				  				<p class="cate-md-name cate1-md9-name"></p>
				  				<span class="cate-md-price cate1-md9-price"></span>
				  				<span class="cate-md-time cate1-md9-time"></span>
				  			</div>
				  			<div class="cate1-md cate1-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate1-md10-img"></div></div>
				  				<p class="cate-md-name cate1-md10-name"></p>
				  				<span class="cate-md-price cate1-md10-price"></span>
				  				<span class="cate-md-time cate1-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list1 }" var="l" varStatus="list1">
			  					<c:choose>
			  						<c:when test="${list1.count eq 5 }">
			  							<div class="cate1-md cate1-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate1-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate1-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list1.count eq 10 }">
			  							<div class="cate1-md cate1-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate1-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate1-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate1-md cate1-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate1-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate1-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate1-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>		  			
		  			
		  			
		  			
		  			
		  			

<!-- 2 남성의류 -->	  			
 	  			<div class="cate-title" class="cate-title" id="cate2"><h3>남성의류 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
 	  			
	  			<div class="cate2-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate2-md cate2-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md1-img"></div></div>
				  				<p class="cate-md-name cate2-md1-name">안녕</p>
				  				<span class="cate-md-price cate2-md1-price">50,000원</span>
				  				<span class="cate-md-time cate2-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate2-md cate2-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate2-md2-img"></div></div>
				  				<p class="cate-md-name cate2-md2-name"></p>
				  				<span class="cate-md-price cate2-md2-price"></span>
				  				<span class="cate-md-time cate2-md2-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md3-img"></div></div>
				  				<p class="cate-md-name cate2-md3-name"></p>
				  				<span class="cate-md-price cate2-md3-price"></span>
				  				<span class="cate-md-time cate2-md3-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md4-img"></div></div>
				  				<p class="cate-md-name cate2-md4-name"></p>
				  				<span class="cate-md-price cate2-md4-price"></span>
				  				<span class="cate-md-time cate2-md4-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md5-img"></div></div>
				  				<p class="cate-md-name cate2-md5-name"></p>
				  				<span class="cate-md-price cate2-md5-price"></span>
				  				<span class="cate-md-time cate2-md5-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md6-img"></div></div>
				  				<p class="cate-md-name cate2-md6-name"></p>
				  				<span class="cate-md-price cate2-md6-price"></span>
				  				<span class="cate-md-time cate2-md6-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md7-img"></div></div>
				  				<p class="cate-md-name cate2-md7-name"></p>
				  				<span class="cate-md-price cate2-md7-price"></span>
				  				<span class="cate-md-time cate2-md7-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md8-img"></div></div>
				  				<p class="cate-md-name cate2-md8-name"></p>
				  				<span class="cate-md-price cate2-md8-price"></span>
				  				<span class="cate-md-time cate2-md8-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md9-img"></div></div>
				  				<p class="cate-md-name cate2-md9-name"></p>
				  				<span class="cate-md-price cate2-md9-price"></span>
				  				<span class="cate-md-time cate2-md9-time"></span>
				  			</div>
				  			<div class="cate2-md cate2-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate2-md10-img"></div></div>
				  				<p class="cate-md-name cate2-md10-name"></p>
				  				<span class="cate-md-price cate2-md10-price"></span>
				  				<span class="cate-md-time cate2-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list2 }" var="l" varStatus="list2">
			  					<c:choose>
			  						<c:when test="${list2.count eq 5 }">
			  							<div class="cate2-md cate2-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate2-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate2-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate2-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list2.count eq 10 }">
			  							<div class="cate2-md cate2-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate2-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate2-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate2-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate2-md cate2-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate2-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate2-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate2-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>	






<!-- 3 뷰티/미용 --> 	  			
	  			<div class="cate-title" class="cate-title" id="cate3"><h3>뷰티/미용 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate3-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate3-md cate3-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md1-img"></div></div>
				  				<p class="cate-md-name cate3-md1-name">안녕</p>
				  				<span class="cate-md-price cate3-md1-price">50,000원</span>
				  				<span class="cate-md-time cate3-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate3-md cate3-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate3-md2-img"></div></div>
				  				<p class="cate-md-name cate3-md2-name"></p>
				  				<span class="cate-md-price cate3-md2-price"></span>
				  				<span class="cate-md-time cate3-md2-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md3-img"></div></div>
				  				<p class="cate-md-name cate3-md3-name"></p>
				  				<span class="cate-md-price cate3-md3-price"></span>
				  				<span class="cate-md-time cate3-md3-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md4-img"></div></div>
				  				<p class="cate-md-name cate3-md4-name"></p>
				  				<span class="cate-md-price cate3-md4-price"></span>
				  				<span class="cate-md-time cate3-md4-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md5-img"></div></div>
				  				<p class="cate-md-name cate3-md5-name"></p>
				  				<span class="cate-md-price cate3-md5-price"></span>
				  				<span class="cate-md-time cate3-md5-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md6-img"></div></div>
				  				<p class="cate-md-name cate3-md6-name"></p>
				  				<span class="cate-md-price cate3-md6-price"></span>
				  				<span class="cate-md-time cate3-md6-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md7-img"></div></div>
				  				<p class="cate-md-name cate3-md7-name"></p>
				  				<span class="cate-md-price cate3-md7-price"></span>
				  				<span class="cate-md-time cate3-md7-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md8-img"></div></div>
				  				<p class="cate-md-name cate3-md8-name"></p>
				  				<span class="cate-md-price cate3-md8-price"></span>
				  				<span class="cate-md-time cate3-md8-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md9-img"></div></div>
				  				<p class="cate-md-name cate3-md9-name"></p>
				  				<span class="cate-md-price cate3-md9-price"></span>
				  				<span class="cate-md-time cate3-md9-time"></span>
				  			</div>
				  			<div class="cate3-md cate3-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate3-md10-img"></div></div>
				  				<p class="cate-md-name cate3-md10-name"></p>
				  				<span class="cate-md-price cate3-md10-price"></span>
				  				<span class="cate-md-time cate3-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list3 }" var="l" varStatus="list3">
			  					<c:choose>
			  						<c:when test="${list3.count eq 5 }">
			  							<div class="cate3-md cate3-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate3-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate3-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate3-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list3.count eq 10 }">
			  							<div class="cate3-md cate3-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate3-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate3-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate3-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate3-md cate3-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate3-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate3-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate3-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>
				
				
<!-- 4 디지털/가전 -->	  			
				<div class="cate-title" class="cate-title" id="cate4"><h3>디지털/가전 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate4-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate4-md cate4-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md1-img"></div></div>
				  				<p class="cate-md-name cate4-md1-name">안녕</p>
				  				<span class="cate-md-price cate4-md1-price">50,000원</span>
				  				<span class="cate-md-time cate4-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate4-md cate4-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate4-md2-img"></div></div>
				  				<p class="cate-md-name cate4-md2-name"></p>
				  				<span class="cate-md-price cate4-md2-price"></span>
				  				<span class="cate-md-time cate4-md2-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md3-img"></div></div>
				  				<p class="cate-md-name cate4-md3-name"></p>
				  				<span class="cate-md-price cate4-md3-price"></span>
				  				<span class="cate-md-time cate4-md3-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md4-img"></div></div>
				  				<p class="cate-md-name cate4-md4-name"></p>
				  				<span class="cate-md-price cate4-md4-price"></span>
				  				<span class="cate-md-time cate4-md4-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md5-img"></div></div>
				  				<p class="cate-md-name cate4-md5-name"></p>
				  				<span class="cate-md-price cate4-md5-price"></span>
				  				<span class="cate-md-time cate4-md5-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md6-img"></div></div>
				  				<p class="cate-md-name cate4-md6-name"></p>
				  				<span class="cate-md-price cate4-md6-price"></span>
				  				<span class="cate-md-time cate4-md6-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md7-img"></div></div>
				  				<p class="cate-md-name cate4-md7-name"></p>
				  				<span class="cate-md-price cate4-md7-price"></span>
				  				<span class="cate-md-time cate4-md7-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md8-img"></div></div>
				  				<p class="cate-md-name cate4-md8-name"></p>
				  				<span class="cate-md-price cate4-md8-price"></span>
				  				<span class="cate-md-time cate4-md8-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md9-img"></div></div>
				  				<p class="cate-md-name cate4-md9-name"></p>
				  				<span class="cate-md-price cate4-md9-price"></span>
				  				<span class="cate-md-time cate4-md9-time"></span>
				  			</div>
				  			<div class="cate4-md cate4-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate4-md10-img"></div></div>
				  				<p class="cate-md-name cate4-md10-name"></p>
				  				<span class="cate-md-price cate4-md10-price"></span>
				  				<span class="cate-md-time cate4-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list4 }" var="l" varStatus="list4">
			  					<c:choose>
			  						<c:when test="${list4.count eq 5 }">
			  							<div class="cate4-md cate4-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate4-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate4-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate4-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list4.count eq 10 }">
			  							<div class="cate4-md cate4-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate4-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate4-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate4-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate4-md cate4-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate4-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate4-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate4-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>
				
				
<!-- 5 도서/티켓 -->		  			
 	  			<div class="cate-title" class="cate-title" id="cate5"><h3>도서/티켓 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate5-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate5-md cate5-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md1-img"></div></div>
				  				<p class="cate-md-name cate5-md1-name">안녕</p>
				  				<span class="cate-md-price cate5-md1-price">50,000원</span>
				  				<span class="cate-md-time cate5-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate5-md cate5-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate5-md2-img"></div></div>
				  				<p class="cate-md-name cate5-md2-name"></p>
				  				<span class="cate-md-price cate5-md2-price"></span>
				  				<span class="cate-md-time cate5-md2-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md3-img"></div></div>
				  				<p class="cate-md-name cate5-md3-name"></p>
				  				<span class="cate-md-price cate5-md3-price"></span>
				  				<span class="cate-md-time cate5-md3-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md4-img"></div></div>
				  				<p class="cate-md-name cate5-md4-name"></p>
				  				<span class="cate-md-price cate5-md4-price"></span>
				  				<span class="cate-md-time cate5-md4-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md5-img"></div></div>
				  				<p class="cate-md-name cate5-md5-name"></p>
				  				<span class="cate-md-price cate5-md5-price"></span>
				  				<span class="cate-md-time cate5-md5-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md6-img"></div></div>
				  				<p class="cate-md-name cate5-md6-name"></p>
				  				<span class="cate-md-price cate5-md6-price"></span>
				  				<span class="cate-md-time cate5-md6-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md7-img"></div></div>
				  				<p class="cate-md-name cate5-md7-name"></p>
				  				<span class="cate-md-price cate5-md7-price"></span>
				  				<span class="cate-md-time cate5-md7-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md8-img"></div></div>
				  				<p class="cate-md-name cate5-md8-name"></p>
				  				<span class="cate-md-price cate5-md8-price"></span>
				  				<span class="cate-md-time cate5-md8-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md9-img"></div></div>
				  				<p class="cate-md-name cate5-md9-name"></p>
				  				<span class="cate-md-price cate5-md9-price"></span>
				  				<span class="cate-md-time cate5-md9-time"></span>
				  			</div>
				  			<div class="cate5-md cate5-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate5-md10-img"></div></div>
				  				<p class="cate-md-name cate5-md10-name"></p>
				  				<span class="cate-md-price cate5-md10-price"></span>
				  				<span class="cate-md-time cate5-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list5 }" var="l" varStatus="list5">
			  					<c:choose>
			  						<c:when test="${list5.count eq 5 }">
			  							<div class="cate5-md cate5-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate5-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate5-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate5-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list5.count eq 10 }">
			  							<div class="cate5-md cate5-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate5-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate5-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate5-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate5-md cate5-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate5-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate5-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate5-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>
				
				
				
<!-- 6 스타굿즈 -->		  			
 	  			<div class="cate-title" class="cate-title" id="cate6"><h3>스타굿즈 <a href="#"><span class="go"> 바로가기></span></a></h3></div>

	  			<div class="cate6-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate6-md cate6-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md1-img"></div></div>
				  				<p class="cate-md-name cate6-md1-name">안녕</p>
				  				<span class="cate-md-price cate6-md1-price">50,000원</span>
				  				<span class="cate-md-time cate6-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate6-md cate6-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate6-md2-img"></div></div>
				  				<p class="cate-md-name cate6-md2-name"></p>
				  				<span class="cate-md-price cate6-md2-price"></span>
				  				<span class="cate-md-time cate6-md2-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md3-img"></div></div>
				  				<p class="cate-md-name cate6-md3-name"></p>
				  				<span class="cate-md-price cate6-md3-price"></span>
				  				<span class="cate-md-time cate6-md3-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md4-img"></div></div>
				  				<p class="cate-md-name cate6-md4-name"></p>
				  				<span class="cate-md-price cate6-md4-price"></span>
				  				<span class="cate-md-time cate6-md4-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md5-img"></div></div>
				  				<p class="cate-md-name cate6-md5-name"></p>
				  				<span class="cate-md-price cate6-md5-price"></span>
				  				<span class="cate-md-time cate6-md5-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md6-img"></div></div>
				  				<p class="cate-md-name cate6-md6-name"></p>
				  				<span class="cate-md-price cate6-md6-price"></span>
				  				<span class="cate-md-time cate6-md6-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md7-img"></div></div>
				  				<p class="cate-md-name cate6-md7-name"></p>
				  				<span class="cate-md-price cate6-md7-price"></span>
				  				<span class="cate-md-time cate6-md7-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md8-img"></div></div>
				  				<p class="cate-md-name cate6-md8-name"></p>
				  				<span class="cate-md-price cate6-md8-price"></span>
				  				<span class="cate-md-time cate6-md8-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md9-img"></div></div>
				  				<p class="cate-md-name cate6-md9-name"></p>
				  				<span class="cate-md-price cate6-md9-price"></span>
				  				<span class="cate-md-time cate6-md9-time"></span>
				  			</div>
				  			<div class="cate6-md cate6-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate6-md10-img"></div></div>
				  				<p class="cate-md-name cate6-md10-name"></p>
				  				<span class="cate-md-price cate6-md10-price"></span>
				  				<span class="cate-md-time cate6-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list6 }" var="l" varStatus="list6">
			  					<c:choose>
			  						<c:when test="${list6.count eq 5 }">
			  							<div class="cate6-md cate6-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate6-md5-name">${l.itemName }</p>
							  				<span class="cate-md-price cate6-md5-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate6-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list6.count eq 10 }">
			  							<div class="cate6-md cate6-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate6-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate6-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate6-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate6-md cate6-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate6-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate6-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate6-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>
		  		
		  		
		  		
<!-- 7 생활가구 -->		  			
 	  			<div class="cate-title" class="cate-title" id="cate7"><h3>생활/가구 <a href="#"><span class="go"> 바로가기></span></a></h3></div>

	  			<div class="cate7-md-div">
		  			<c:choose>
		  				<c:when test="${empty size }">
				  			<div class="cate7-md cate7-md1">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md1-img"></div></div>
				  				<p class="cate-md-name cate7-md1-name">안녕</p>
				  				<span class="cate-md-price cate7-md1-price">50,000원</span>
				  				<span class="cate-md-time cate7-md1-time">12시간 전</span>
				  			</div>
				  			<div class="cate7-md cate7-md2">
				  				<div class="cate-md-div">
				  				<div class="cate-md-img cate7-md2-img"></div></div>
				  				<p class="cate-md-name cate7-md2-name"></p>
				  				<span class="cate-md-price cate7-md2-price"></span>
				  				<span class="cate-md-time cate7-md2-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md3">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md3-img"></div></div>
				  				<p class="cate-md-name cate7-md3-name"></p>
				  				<span class="cate-md-price cate7-md3-price"></span>
				  				<span class="cate-md-time cate7-md3-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md4">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md4-img"></div></div>
				  				<p class="cate-md-name cate7-md4-name"></p>
				  				<span class="cate-md-price cate7-md4-price"></span>
				  				<span class="cate-md-time cate7-md4-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md5" style="margin-left:0px;">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md5-img"></div></div>
				  				<p class="cate-md-name cate7-md5-name"></p>
				  				<span class="cate-md-price cate7-md5-price"></span>
				  				<span class="cate-md-time cate7-md5-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md6">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md6-img"></div></div>
				  				<p class="cate-md-name cate7-md6-name"></p>
				  				<span class="cate-md-price cate7-md6-price"></span>
				  				<span class="cate-md-time cate7-md6-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md7">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md7-img"></div></div>
				  				<p class="cate-md-name cate7-md7-name"></p>
				  				<span class="cate-md-price cate7-md7-price"></span>
				  				<span class="cate-md-time cate7-md7-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md8">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md8-img"></div></div>
				  				<p class="cate-md-name cate7-md8-name"></p>
				  				<span class="cate-md-price cate7-md8-price"></span>
				  				<span class="cate-md-time cate7-md8-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md9">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md9-img"></div></div>
				  				<p class="cate-md-name cate7-md9-name"></p>
				  				<span class="cate-md-price cate7-md9-price"></span>
				  				<span class="cate-md-time cate7-md9-time"></span>
				  			</div>
				  			<div class="cate7-md cate7-md10">
				  				<div class="cate-md-div"><div class="cate-md-img cate7-md10-img"></div></div>
				  				<p class="cate-md-name cate7-md10-name"></p>
				  				<span class="cate-md-price cate7-md10-price"></span>
				  				<span class="cate-md-time cate7-md10-time"></span>
				  			</div>
			  			</c:when> 
			  			<c:otherwise>
			  				<c:forEach items="${list7 }" var="l" varStatus="list7">
			  					<c:choose>
			  						<c:when test="${list7.count eq 5 }">
			  							<div class="cate7-md cate7-md5" style="margin-left:0px;">
											<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진5">
							  				</div>							  				
							  				<p class="cate-md-name cate7-md5-name">${l.itemName }</p> 
							  				<span class="cate-md-price cate7-md5-price">${l.itemPrice }</span> 
							  				<span class="cate-md-time cate7-md5-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:when test="${list7.count eq 10 }">
			  							<div class="cate7-md cate7-md10">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진10">
							  				</div>		
							  				<p class="cate-md-name cate7-md10-name">${l.itemName }</p>
							  				<span class="cate-md-price cate7-md10-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate7-md10-time">로그인성공</span>
							  			</div>
			  						</c:when>
			  						<c:otherwise>
			  							<div class="cate7-md cate7-md1">
							  				<div class="cate-md-div">
												<img class="cate-md-img" src="/upload/product/${l.itemThumFilepath }" alt="사진">
							  				</div>		
							  				<p class="cate-md-name cate7-md1-name">${l.itemName }</p>
							  				<span class="cate-md-price cate7-md1-price">${l.itemPrice }</span>
							  				<span class="cate-md-time cate7-md1-time">로그인성공</span>
							  			</div>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</c:otherwise>
			  		</c:choose>	
				</div>

	  		</div><!-- /.con2 -->
	  		
	  		

	  		<c:if test="${empty sessionScope.member.memberNo}">
				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog modal-div">
	
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header" style="padding: 50px 50px; text-align:center; border:0px; padding-bottom:0px">
								<img src="/img/tomatoMarketLogo.png" width="30" height="34" >
								<!--<button type="button" class="close" data-dismiss="modal">&times;</button> -->
								<h2 style="font-size:20px; font-weight: 600; margin-bottom:15px;">토마토마켓으로 중고거래 시작하기</h2>
								<div style="margin-bottom:0px">15초만에 간편하게 가입하고<br>상품을 확인하세요!</div>
							</div>
							<div class="modal-body" style="padding: 40px 150px;">
								<div class="kakao-button-div button_input-div"><button class="kakao-button"><img src="/img/kakaoLogo.png" width="24" height="24"> 카카오로 로그인하기</button></div>
								<form role="form" action="/login">
									<div class="form-group">
										<label for="usrname" style="margin-top:30px;"><span class="glyphicon glyphicon-user"></span> User-email</label> 
										<input type="text" class="form-control" id="usrname" style="width:298px;"
											placeholder="Enter email" name="email">
									</div>
									<div class="form-group">
										<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> 
										<input type="password" class="form-control" id="psw" style="width:298px;"
											placeholder="Enter password" name="pw">
									</div>
									<button type="submit" class="btn btn-success btn-block">
										토마토마켓 이용하기
									</button>
									<div class="password"><a href="/member/searchPW.jsp">비밀번호 찾기</a></div>
								</form>
							</div>
							<div class="modal-footer">
								<!-- <button type="submit"
									class="btn btn-danger btn-default pull-left"
									data-dismiss="modal">
									<span class="glyphicon glyphicon-remove"></span> Cancel
								</button> -->
								<div class="joinMember">아직 계정이 없으세요? 
								<a href="/member/joinMember.jsp">회원가입하기</a></div>
							</div>
						</div>
					</div>
				</div>

			</c:if>
			<!-- Modal end -->
	  		
		</div><!-- /.container -->
	</section>   	
	<script>
		$(document).ready(function(){

			$('#myModal').modal(
					{ keyboard: false, backdrop: 'static' } 
					);
			$('#myModal').modal('show');

		});			
	</script>
	 <%@include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>