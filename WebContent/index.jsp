<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.tomato.search.model.service.testService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
   testService service = new testService();
   ArrayList<String> list = service.allTest();

   for(String s : list){
       System.out.println(s);
   }    
   %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>	
<link rel="stylesheet" href="/css/index.css"/>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>  
<link rel="stylesheet" href="/css/jquery/jquery.bxslider.css"/>
<script src="/js/jquery.bxslider.min.js"></script>   
	<section>
		<div class="container">
			<div class="bxslider">
	    			<div><img src="/img/slider/slider1.png"></div>
	    			<div><img src="/img/slider/slider2.png"></div>
	    			<div><img src="/img/slider/slider3.png"></div>
	    			<div><img src="/img/slider/slider4.png"></div>
	  		</div>
	  		<div class="con1">
	  			<span><h3>우리동네 인기매물</h3></span>
	  			<div class="item-slider1">
	  				<div class="item item1"></div>
	  				<div class="item item2"></div>
	  				<div class="item item3"></div>
	  				<div class="item item4"></div>
	  				<div class="item item5"></div>
	  				<div class="item item6"></div>
	  				<div class="item item7"></div>
	  				<div class="item item8"></div>
	  				<div class="item item9"></div>
	  				<div class="item item10"></div>
	  			</div>
	  		
		  		<div class="btn">
		  			<button class="prev" data-btn="0">이전</button>
		  			<button class="next" data-btn="1">다음</button>	  			
		  		</div>	
	  		</div>		
		</div>
	</section>
	<script>
	$(document).ready(function(){
	    $('.bxslider').bxSlider({ 
	    	pager: false,
	    	auto: true, 
	    	speed: 500, 
	    	pause: 2000, 
	    	mode:'fade',
	    	autoControls: false,
	    	tickerHover: false
	    	});
	    
	    init();
		
		$('.next').on('click',moveSlider);
		$('.prev').on('click',moveSlider);	
	});
		var $con1 = 1000;
		var $display = 5;
		var $item = $con1/$display;
		var $count = $('.item').length;
		var $slidebox = $item*$count;
		
		console.log($con1);
		console.log($display);
		console.log($item);
		console.log($count);
		console.log($slidebox);
		
		function init(){
			console.log('init함수 시작');
			$('.con1').css('width',$con1);
			$('.item-slider1').css('width',$slidebox);
			$('.item').css('width',$item);
		}
		
		function moveSlider(){
			var check = $(this).attr('data-btn');
			
			if(check == 0){
				$('.item-slider1').animate({left:'+='+$item+"px"},300,slideEnd);
			}else if(check==1){
				$('.item-slider1').animate({left:'-='+$item+'px'},300,slideEnd);
			}
		}
		function slideEnd(){
			var nowLeft = $('.item-slider1').position().left;
			
			var end = -($slidebox-$con1);
			console.log(nowLeft);
			console.log(end);
			
			if(nowLeft<=end){ 
				$('.item-slider1').animate({left:end});console.log('left:end');
			}else if(nowLeft>0){
				$('.item-slider1').animate({left:0});console.log('left:0');
			}
		}
	</script>
<%-- 	<%@include file="/WEB-INF/views/common/footer.jsp" %> --%>
<a href="/notice">공지사항</a> <a href="/notice">운영정책 </a> <a href="/notice">자주묻는 질문 </a>
</body>
</html>