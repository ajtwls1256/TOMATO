<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/js/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="/js/jquery.bxslider.min.js"></script>

<script>
$(document).ready(function(){
	var main = $('.bxslider').bxSlider({
		mode: 'fade',
		auto: true,		//자동으로 슬라이드
		controls : true,	//좌우 화살표	
		autoControls: true,	//stop,play
		pager:true,	//페이징
		pause: 3000,
		autoDelay: 0,	
		slideWidth: 800,
		speed: 500,
		stopAutoOnclick:true
	});
  
	$(".bx-stop").click(function(){	// 중지버튼 눌렀을때
		main.stopAuto();
		$(".bx-stop").hide();
		$(".bx-start").show();
		return false;
	});

	$(".bx-start").click(function(){	//시작버튼 눌렀을때
	    main.startAuto();
		$(".bx-start").hide();
		$(".bx-stop").show();
		return false;
	});
	
	$(".bx-start").hide();	//onload시 시작버튼 숨김.
});
</script>
<style>
section{
	clear:left; 
	position: absolute; 
	z-index: -1;
	width:100%;
	margin:0 auto;
}
.container{
	width:1000px;
	margin:0 auto;
}
</style>

</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container">
			<h2 style="text-align:center;" style="margin:0 auto;">INDEX</h2>
		</div>
		<div class="bxslider">
    			<div><img src="/img/slider/slider1.png"></div>
    			<div><img src="/img/slider/slider2.png"></div>
    			<div><img src="/img/slider/slider3.png"></div>
    			<div><img src="/img/slider/slider4.png"></div>
  		</div>
	</section>

<%-- 	<%@include file="/WEB-INF/views/common/footer.jsp" %> --%>
</body>
</html>