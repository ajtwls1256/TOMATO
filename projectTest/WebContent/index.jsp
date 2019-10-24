<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>	
<link rel="stylesheet" href="/css/index.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">  
  
</head>
<body>

	

	<section action>
	<button class="btn btn-outline-info btn-sm" onclick="location.href='/sellPage?itemNo=1'">이동</button>
	</section> 
<%-- <%@include file="/WEB-INF/views/common/header.jsp" %>  
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
	  			<div class="title"><span>우리동네 인기 매물fgdfgdf</span></div>
	  			<div class="conSlider">
		  			<div class="mdSlider1">
		  				<div class="md md1">
		  					<div class="md-div"><div class="md-img md-img1"></div></div>
		  					<p class="md-name md-name1">토마토마토</p>
		  					<span class="md-price md-price1">10,000,000원</span>
		  					<span class="md-region md-region1">당산동</span>
		  				</div>   
		  				<div class="md md2">
		  					<div class="md-div"><div class="md-img md-img2"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price2"></span>
		  					<span class="md-region md-region2"></span>
		  				</div>
		  				<div class="md md3">
		  					<div class="md-div"><div class="md-img md-img3"></div></div>
		  					<p class="md-name md-name1">칼칼한칼국수</p>
		  					<span class="md-price md-price3">5,000원</span>
		  					<span class="md-region md-region3">임당동</span>
		  				</div>
		  				<div class="md md4">
		  					<div class="md-div"><div class="md-img md-img4"></div></div>
		  					<p class="md-name md-name1">알파카파카</p>
		  					<span class="md-price md-price4">30,000원</span>
		  					<span class="md-region md-region4">사당동</span>
		  				</div>
		  				<div class="md md5">
		  					<div class="md-div"><div class="md-img md-img5"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price5"></span>
		  					<span class="md-region md-region5"></span>
		  				</div>
		  				<div class="md md6">
		  					<div class="md-div"><div class="md-img md-img6"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price6"></span>
		  					<span class="md-region md-region6"></span>
		  				</div>
		  				<div class="md md7">
		  					<div class="md-div"><div class="md-img md-img7"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price7"></span>
		  					<span class="md-region md-region7"></span>
		  				</div>
		  				<div class="md md8">
		  					<div class="md-div"><div class="md-img md-img8"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price8"></span>
		  					<span class="md-region md-region8"></span>
		  				</div>
		  				<div class="md md9">
		  					<div class="md-div"><div class="md-img md-img9"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price9"></span>
		  					<span class="md-region md-region9"></span>
		  				</div>
		  				<div class="md md10">
		  					<div class="md-div"><div class="md-img md-img10"></div></div>
		  					<p class="md-name md-name1"></p>
		  					<span class="md-price md-price10"></span>
		  					<span class="md-region md-region10"></span>
		  				</div>
		  			</div>
		  		</div>
	  			
		  		<div class="md-btn">
		  			<button class="md-btn-prev" data-btn="0">
		  				<img src="/img/prev.png" class="md-btn-prev-img">
		  			</button>
		  			<button class="md-btn-next" data-btn="1">
		  				<img src="/img/next.png" class="md-btn-next-img">
		  			</button>	  			
		  		</div>	
	  		</div> 
	  		
	  		<div class="con2">
	  			<div class="title"><span>카테고리별 인기 상품</span></div>
<!-- 1 여성의류 -->	  			
	  			<div class="cate1-title" class="cate-title" id="cate1"><h3 style="font-weight:bold; font-size:20px;">여성의류 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate1-md-div">
		  			<div class="cate1-md cate1-md1">
		  				<div class="cate-md-div"><div class="cate-md-img cate1-md1-img"></div></div>
		  				<p class="cate-md-name cate1-md1-name">안녕</p>
		  				<span class="cate-md-price cate1-md1-price">50,000원</span>
		  				<span class="cate-md-time cate1-md1-time">12시간 전</span>
		  			</div>
		  			<div class="cate1-md cate1-md2">
		  				<div class="cate-md-div"><div class="cate-md-img cate1-md2-img"></div></div>
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
		  		</div>
<!-- 2 남성의류 -->	  			
 	  			<div class="cate-title" class="cate-title" id="cate2"><h3>남성의류 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
 	  			
	  			<div class="cate2-md-div">
		  			<div class="cate2-md cate2-md1">
		  				<div class="cate-md-div"><div class="cate-md-img cate2-md1-img"></div></div>
		  				<p class="cate-md-name cate2-md1-name">박보검패딩</p>
		  				<span class="cate-md-price cate2-md1-price">5,000</span>
		  				<span class="cate-md-time cate2-md1-time">20시간 전</span>
		  			</div>
		  			<div class="cate2-md cate2-md2">
		  				<div class="cate-md-div"><div class="cate-md-img cate2-md2-img"></div></div>
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
		  		</div>
<!-- 3 뷰티/미용 --> 	  			
	  			<div class="cate-title" class="cate-title" id="cate3"><h3>뷰티/미용 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate3-md-div">
			  			<div class="cate3-md cate3-md1">
			  				<div class="cate-md-div"><div class="cate-md-img cate3-md1-img"></div></div>
			  				<p class="cate-md-name cate3-md1-name"></p>
			  				<span class="cate-md-price cate3-md1-price"></span>
			  				<span class="cate-md-time cate3-md1-time"></span>
			  			</div>
			  			<div class="cate3-md cate3-md2">
			  				<div class="cate-md-div"><div class="cate-md-img cate3-md2-img"></div></div>
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
			  		</div>
<!-- 4 디지털/가전 -->	  			
				<div class="cate-title" class="cate-title" id="cate4"><h3>디지털/가전 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate4-md-div">
			  			<div class="cate4-md cate4-md1">
			  				<div class="cate-md-div"><div class="cate-md-img cate4-md1-img"></div></div>
			  				<p class="cate-md-name cate4-md1-name"></p>
			  				<span class="cate-md-price cate4-md1-price"></span>
			  				<span class="cate-md-time cate4-md1-time"></span>
			  			</div>
			  			<div class="cate4-md cate4-md2">
			  				<div class="cate-md-div"><div class="cate-md-img cate4-md2-img"></div></div>
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
			  		</div>
<!-- 5 도서/티켓 -->		  			
 	  			<div class="cate-title" class="cate-title" id="cate5"><h3>도서/티켓 <a href="#"><span class="go"> 바로가기></span></a></h3></div>
	  			
	  			<div class="cate5-md-div">
		  			<div class="cate5-md cate5-md1">
		  				<div class="cate-md-div"><div class="cate-md-img cate5-md1-img"></div></div>
		  				<p class="cate-md-name cate5-md1-name"></p>
		  				<span class="cate-md-price cate5-md1-price"></span>
		  				<span class="cate-md-time cate5-md1-time"></span>
		  			</div>
		  			<div class="cate5-md cate5-md2">
		  				<div class="cate-md-div"><div class="cate-md-img cate5-md2-img"></div></div>
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
			  	</div>
<!-- 6 스타굿즈 -->		  			
 	  			<div class="cate-title" class="cate-title" id="cate6"><h3>스타굿즈 <a href="#"><span class="go"> 바로가기></span></a></h3></div>

	  			<div class="cate6-md-div">
		  			<div class="cate6-md cate6-md1">
		  				<div class="cate-md-div"><div class="cate-md-img cate6-md1-img"></div></div>
		  				<p class="cate-md-name cate6-md1-name"></p>
		  				<span class="cate-md-price cate6-md1-price"></span>
		  				<span class="cate-md-time cate6-md1-time"></span>
		  			</div>
		  			<div class="cate6-md cate6-md2">
		  				<div class="cate-md-div"><div class="cate-md-img cate6-md2-img"></div></div>
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
		  		</div>
<!-- 7 생활가구 -->		  			
 	  			<div class="cate-title" class="cate-title" id="cate7"><h3>생활가구 <a href="#"><span class="go"> 바로가기></span></a></h3></div>

	  			<div class="cate7-md-div">
		  			<div class="cate7-md cate7-md1">
		  				<div class="cate-md-div"><div class="cate-md-img cate7-md1-img"></div></div>
		  				<p class="cate-md-name cate7-md1-name"></p>
		  				<span class="cate-md-price cate7-md1-price"></span>
		  				<span class="cate-md-time cate7-md1-time"></span>
		  			</div>
		  			<div class="cate7-md cate7-md2">
		  				<div class="cate-md-div"><div class="cate-md-img cate7-md2-img"></div></div>
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
		  		</div>

	  		</div><!-- /.con2 -->
		</div><!-- /.container -->
	</section>   	
	<script>
		$(document).ready(function(){
			init();
			
			$(".md-btn-prev").on("click",moveSlider);
			$(".md-btn-next").on("click",moveSlider);
		});			
		var $conSlider = 1020;
		var $display = 4;
		var $md = $conSlider/$display;
		var $count = $(".md").length;
		var $slidebox = $md*$count;
		
		console.log($conSlider);
		console.log($display);
		console.log($md);
		console.log($count);
		console.log($slidebox);
	
		function init(){ 
			console.log("init함수 시작");
			$(".conSlider").css("width",$conSlider);
			$(".mdSlider1").css("width",$slidebox);
			$('.md').css("width",'236px');
			$('.md').css('margin','0px 19px 0px 0px');
		}
		function moveSilder(){
			var check = $(this).attr("data-btn");
			
			if(check == 0){
				$(".mdSlider1").animate({left : "+="+$md+"px"},300,slideEnd)
			} else if (check == 1){
				$(".mdSlider1").animate({left : "-="+$md+"px"},300,slideEnd)
			}
		}
		function slideEnd(){
			var nowLeft = $(".mdSlider1").position().left;
			
			var end = -($slidebox-$conSlider);
			console.log(nowLeft);
			console.log(end);
			
			if(nowLeft<=end){
				$(".mdSlider1").animate({left:end});
			}else if (nowLeft>0){
				$(".mdSlider1").animate({left:0});
			} 
		}
	</script>
	 <%@include file="/WEB-INF/views/common/footer.jsp" %>
	 --%>
	

	
</body>
</html>